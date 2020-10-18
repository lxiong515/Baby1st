package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Baby;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
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
		/*
		BabyHelper dao = new BabyHelper();
		String act = request.getParameter("doThisToBaby");
		
		String path = "/viewAllBabiesServlet";
		
		if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("babyId"));
				Baby babyToDelete = dao.searchForBabyById(tempId);
				dao.deleteBaby(babyToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a baby");
			}
		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("babyId"));
				Baby babyToEdit = dao.searchForBabyById(tempId);
				request.setAttribute("babyToEdit", babyToEdit);
				path = "/edit-baby.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a baby");
			}
		} else if (act.equals("add")) {
			path = "/index.html";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	*/
		BabyHelper dao = new BabyHelper();
		String act = request.getParameter("doThisToBaby");

		if(act == null) {
		//no button has been selected
		getServletContext().getRequestDispatcher("/viewAllBabiesServlet").forward(request, response);
		} else if (act.contentEquals("delete")) {
		try {
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Baby babyToDelete = dao.searchForBabyById(tempId);
		dao.deleteBaby(babyToDelete);
		} catch (NumberFormatException e) {
		System.out.println("Forgot to click a button");
		} finally {
		getServletContext().getRequestDispatcher("/viewAllBabiesServlet").forward(request, response);
		}
		} else if (act.contentEquals("edit")) {
		try {
		getServletContext().getRequestDispatcher("/edit-baby.jsp").forward(request, response);
		} catch (NumberFormatException e) {
		getServletContext().getRequestDispatcher("/editBabyServlet").forward(request, response);
		}
		} else if (act.contentEquals("add")) {
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}
		
	}

}
