package controler;

import java.io.IOException;

import java.sql.SQLException;

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
		
		if (buyer != null) {
		    // Credentials are valid
		    // Print welcome message to console
		    System.out.println("Welcome, " + buyer.getName() + "!");
		    
		    // Redirect the user to the dashboard or another page
		} else {
		    // Credentials are invalid
		    // Display an error message
			System.out.println("Invalid email or password");
		}
    }
}
