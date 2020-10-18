package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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

	public EventDetails searchForEventById(Integer tempId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		EventDetails found = em.find(EventDetails.class, tempId);
		em.close();
		return found;

	}

	public void deleteEvent(EventDetails eventToDelete) {
		// TODO Auto-generated method stub
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<EventDetails> typedQuery = em.createQuery("select ed from EventDetails ed where ed.eventName = :selectedEventName", EventDetails.class);

		typedQuery.setParameter("selectedEventName", eventToDelete.getEventName());

		typedQuery.setMaxResults(1);

		EventDetails result = typedQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}

}
