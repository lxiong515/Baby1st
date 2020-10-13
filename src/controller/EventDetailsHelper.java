package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.EventDetails;

public class EventDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UserBabyEvents");
	
	public void insertNewEventDetails(EventDetails s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<EventDetails> getEvents(){
		EntityManager em = emfactory.createEntityManager();
		List<EventDetails> allDetails = em.createQuery("SELECT d from EventDetails d").getResultList();
		return allDetails;
	}

}
