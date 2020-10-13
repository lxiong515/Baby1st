package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.Baby;

//package and import statements
public class BabyHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UserBabyEvents");
	
	public void insertBaby(Baby b) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		em.close();
	}

	public List<Baby> showAllBabies(){
		EntityManager em = emfactory.createEntityManager();
		List<Baby> allBabies = em.createQuery("SELECT b from Baby b").getResultList();
		return allBabies;
	}

	public Baby searchForBabyById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Baby found = em.find(Baby.class, tempId);
		em.close();
		return found;
	}

	public void deleteBaby(Baby babyToDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Baby> typedQuery = em.createQuery("select b from Baby b where b.babyName = :selectedBabyName", Baby.class);
		
		typedQuery.setParameter("selectedBabyName", babyToDelete.getBabyName());
		
		typedQuery.setMaxResults(1);
		
		Baby result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public void updateBaby(Baby babyToUpdate) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(babyToUpdate);
		em.getTransaction().commit();
		em.close();
	}
}
