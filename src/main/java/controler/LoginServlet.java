package controler;

import java.io.IOException;


import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import database.BuyerDAO;
import model.Buyer;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        
        BuyerDAO buyerDAO = new BuyerDAO();
        
        Buyer buyer = buyerDAO.buyerVerify(name, password);
		
		if (name.equals("admin")&& password.equals("admin")) {
		    // Credentials are valid
		    // Print welcome message to console
		    RequestDispatcher rd = request.getRequestDispatcher("admin_home.jsp");
		    rd.forward(request, response);
		    
		    // Redirect the user to the dashboard or another page
		} else {
		    // Credentials are invalid
		    // Display an error message
			RequestDispatcher rd = request.getRequestDispatcher("buyer_home.jsp");
			rd.forward(request, response);
			
		}
    }
}
