package controller;

import java.io.IOException;
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
		
		int eventId = Integer.parseInt(request.getParameter("eventId"));
		String eventName = request.getParameter("eventName");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		LocalDate ld;
		int babyId = Integer.parseInt(request.getParameter("babyId"));
		String babyName = request.getParameter("babyName");
		
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		Baby baby = new Baby(babyId, babyName);
		EventDetails ed = new EventDetails(eventId, eventName, ld, baby);
		dao.insertEventDetails(ed);
		
		getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
//		String baby = request.getParameter("baby");
//		String event = request.getParameter("event");
//		
//		if (baby.isEmpty() || event.isEmpty() || baby == null || event == null) {
//			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
//		} else {
//			EventDetails ed = new EventDetails(baby, event);
//			EventDetailsHelper dao = new EventDetailsHelper();
//			dao.insertEventDetails(ed);
//
//		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
//	}
//
	}
}
