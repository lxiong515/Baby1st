import java.time.LocalDate;
import java.util.List;

import Model.Baby;
import Model.EventDetails;
import Controller.BabyHelper;
import Controller.EventDetailsHelper;

public class BabyTester {
	
	public static void main(String[] args) {
		
		Baby jim = new Baby("Jim");
		
		BabyHelper bh = new BabyHelper();
		
		bh.insertBaby(jim);
		
		EventDetailsHelper edh = new EventDetailsHelper();
		EventDetails jimList = new EventDetails("Jim's List", LocalDate.now(), jim);
		
		edh.insertNewEventDetails(jimList);
		
		List<EventDetails>allLists = edh.getEvents();
		
		for(EventDetails a: allLists) {
			System.out.println(a.toString());
		}
		/*
		List<Baby> allBabies = bh.showAllBabies();
		for(Baby a: allBabies) {
			System.out.println(a.toString());
		} */
	}

}
