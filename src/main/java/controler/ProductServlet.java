package controler;

import java.io.IOException;
import model.Product;
import database.ProductDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ProductServlet
 */
@WebServlet({"/ProductServlet"})
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
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
		String name = request.getParameter("pname");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		
		Product product = new Product();
		
		product.setProductname(name);
		product.setPrice(price);
		product.setdescription(description);
		
		ProductDAO productdao = new ProductDAO();
		
		int addprod_result = productdao.addProduct(product);
		if (addprod_result > 0) {
			System.out.println("Product Added Succesfully");
		}
		else {
			System.out.println("Product Added Failed");
		}
		
	}

}
