package Model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="event_details")
public class EventDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EVENT_ID")
	private int eventId;
	@Column(name="EVENT_NAME")
	private String eventName;
	@Column(name="EVENT_DATE")
	private LocalDate eventDate;
	@ManyToOne (cascade=CascadeType.PERSIST)
	@JoinColumn(name="BABY_ID")
	private int babyId;
	
	public EventDetails() {
		super();
	}
	
	public EventDetails(int eventId, String eventName, LocalDate eventDate, int babyId) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.babyId = babyId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	public int getBabyId() {
		return babyId;
	}

	public void setBabyId(int babyId) {
		this.babyId = babyId;
	}
	
	public EventDetails(String eventName, LocalDate eventDate, Baby jim) {
		super();
		this.eventName = eventName;
		this.eventDate = eventDate;
		//this.babyId = babyId; //need to figure out int ID vs string name
	}

	public EventDetails(String babyName, String event) {
		// TODO Auto-generated constructor stub
		//this constructor is for AddEventServlet
		super();
		//this.babyId = babyName;//need to figure out int ID vs string name
		this.eventName = event;
		
	}

	@Override
	public String toString() {
		return "EventDetails [eventId=" + eventId + ", eventName=" + eventName + ", eventDate=" + eventDate
				+ ", babyId=" + babyId + "]";
	}
	
	
}
