package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Baby;

/**
 * Servlet implementation class EditBabyServlet
 */
@WebServlet("/editBabyServlet")
public class EditBabyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBabyServlet() {
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
		BabyHelper dao = new BabyHelper();
		
		String babyName = request.getParameter("babyName");
		Integer tempId = Integer.parseInt(request.getParameter("babyId"));
		
		Baby babyToUpdate = dao.searchForBabyById(tempId);
		babyToUpdate.setBabyName(babyName);
		
		dao.updateBaby(babyToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllBabiesServlet").forward(request, response);
	}

}
