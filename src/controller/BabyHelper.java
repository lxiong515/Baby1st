package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
}
