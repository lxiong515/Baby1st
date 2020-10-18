package controller;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Baby;
import Model.EventDetails;

/**
 * Servlet implementation class AddBabyServlet
 */
@WebServlet("/addBabyServlet")
public class AddBabyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBabyServlet() {
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
		String babyName = request.getParameter("babyName");
		
		if (babyName.isEmpty() || babyName == null ) {
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		} else {
		Baby b = new Baby(babyName);
		BabyHelper dao = new BabyHelper();
		dao.insertBaby(b);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}
	}

}
