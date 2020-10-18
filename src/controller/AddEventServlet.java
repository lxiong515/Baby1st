package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Baby;
import Model.EventDetails;

/**
 * Servlet implementation class AddEventServlet
 */
@WebServlet("/addEventServlet")
@MultipartConfig //added to help with errors
public class AddEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEventServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		EventDetailsHelper dao = new EventDetailsHelper();
		
		//int eventId = Integer.parseInt(request.getParameter("eventId"));
		String eventName = request.getParameter("eventName");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		LocalDate ld;
		//int babyId = Integer.parseInt(request.getParameter("babyId"));
		String babyName = request.getParameter("babyName");
		//Baby baby = new Baby();

		LocalDate eventDate = LocalDate.now();
		
		/*
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
			//ld = LocalDate.now();
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		//dont use this try/catch*/
		

		/*
		Baby baby = new Baby(babyName);
		//EventDetails ed = new EventDetails(eventId, eventName, ld, baby);
		EventDetails ed = new EventDetails( eventName, eventDate, baby);
		dao.insertEventDetails(ed);
		*/
		
		request.setAttribute("allDetails", dao.getEvents());
		
		if(dao.getEvents().isEmpty()) {
			request.setAttribute("allDetails", " ");
		}
		
		//getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
		getServletContext().getRequestDispatcher("/add-event.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * */
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		String eventName = request.getParameter("eventName");
		//String eventDate = request.getParameter("eventDate");
		//public static LocalDate now();
		LocalDate eventDate = LocalDate.now();
		//String baby = request.getParameter("baby");
		Baby baby = new Baby();
		
		//LocalDate today = LocalDate.parse(eventDate1);
		//LocalDate eventDate = today;
		
		//Instant instant =Instant.parse(eventDate);
		
		//LocalDate result = LocalDate.ofInstant(instant, null);
		
		if (eventName.isEmpty() || eventName == null ) {
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		} else {
			EventDetails ed = new EventDetails(eventName, eventDate, baby);
			EventDetailsHelper dao = new EventDetailsHelper();
			dao.insertEventDetails(ed);

		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

	}
}
