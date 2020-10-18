package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.EventDetails;

/**
 * Servlet implementation class EventNavigationServlet
 */
@WebServlet("/eventNavigationServlet")
public class EventNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		EventDetailsHelper dao = new EventDetailsHelper();
		String act = request.getParameter("doThisToEvent");

		if(act == null) {
		//no button has been selected
		getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
		} else if (act.contentEquals("delete")) {
		try {
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		EventDetails listToDelete = dao.searchForEventById(tempId);
		dao.deleteEvent(listToDelete);
		} catch (NumberFormatException e) {
		System.out.println("Forgot to click a button");
		} finally {
		getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
		}
		} else if (act.contentEquals("add")) {
		 {
		getServletContext().getRequestDispatcher("/add-event.jsp").forward(request, response);
		} //finally {
		//if (act.contentEquals("add")) {
		//getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		} 
	}

		
}
