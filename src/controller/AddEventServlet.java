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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * */
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String eventName = request.getParameter("eventName");
		LocalDate eventDate = LocalDate.now();
		Baby baby = new Baby();

		if (eventName.isEmpty() || eventName == null ) {
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		} else {
			EventDetails ed = new EventDetails(eventName);
			EventDetailsHelper dao = new EventDetailsHelper();
			dao.insertEventDetails(ed);

		getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
	}

	}
}
