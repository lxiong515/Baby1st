package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.EventDetails;

public class EventDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Baby1st");
	
	public void insertEventDetails(EventDetails s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<EventDetails> getEvents(){
		EntityManager em = emfactory.createEntityManager();
		List<EventDetails> allDetails = em.createQuery("SELECT s from EventDetails s").getResultList();
		return allDetails;
	}
/*
	public  List<EventDetails> showAllItems() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		
		List<EventDetails>allItems = em.createNamedQuery("SELECT i from EventDetails i").getResultList();
		return allItems;
	}
	*/

}
