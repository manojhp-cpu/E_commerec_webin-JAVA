// Source code is decompiled from a .class file using FernFlower decompiler.
package controler;

import database.BuyerDAO;


import model.Buyer;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/SignUpServlet"})
public class SignUpServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public SignUpServlet() {
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.getWriter().append("Served at: ").append(request.getContextPath());
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String name = request.getParameter("Name");
      String mobile = request.getParameter("mobile");
      String email = request.getParameter("email");
      String username = request.getParameter("Username");
      String password = request.getParameter("password");
      
      Buyer buyer = new Buyer();
      
      buyer.setName(name);
      buyer.setMobile(mobile);
      buyer.setMail(email);
      buyer.setUsername(username);
      buyer.setPassword(password);
      BuyerDAO dao = new BuyerDAO();
      int result = dao.registerBuyer(buyer);
      if (result > 0) {
         System.out.println("Registration is successful");
         
      } else {
         System.out.println("Registration failed");
      }

   }
}
