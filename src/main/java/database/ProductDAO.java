package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Product;

public class ProductDAO {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	public int addProduct(Product product) {
	    String query = "INSERT INTO product (NAME, PRICE, DESCRIPTION) VALUES (?, ?, ?)";
	    int i = 0;
	    try {
	        conn = DBConnector.getConnection();
	        ps = conn.prepareStatement(query);
	        ps.setString(1, product.getProductname());
	        ps.setString(2, product.getPrice());
	        ps.setString(3, product.getdescription());
	        i = ps.executeUpdate();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBConnector.closeConnection(conn);
	        DBConnector.closeStatement(ps);
	    }
	    return i;
	}

	public ArrayList<Product> getProducts() throws SQLException
	{
		String query = "select * from products";
		Connection con = DBConnector.getConnection();
		PreparedStatement statement = con.prepareStatement(query);
		ResultSet rs = statement.executeQuery();
		ArrayList<Product> productList = new ArrayList<Product>();
		while (rs.next())
		{
			Product product = new Product();
			product.setProductname(rs.getString("name"));
			product.setdescription(rs.getString("description"));
			product.setPrice(rs.getString("price"));
			product.setId(rs.getInt("id"));
			productList.add(product);
		}
		statement.close();
		DBConnector.closeConnection(con);
		return productList;
	}
	
	public Product getProductWithId(int id) throws SQLException
	{
		String query = "select * from products where ID='"+id+"'";
		Connection con = DBConnector.getConnection();
		PreparedStatement statement = con.prepareStatement(query);
		ResultSet rs = statement.executeQuery();
		Product product=null;
		if (rs.next())
		{
			product = new Product();
			product.setProductname(rs.getString("name"));
			product.setdescription(rs.getString("description"));
			product.setPrice(rs.getString("price"));
			product.setId(rs.getInt("id"));
		}
		statement.close();
		DBConnector.closeConnection(con);
		return product;
	}
	
	public int deleteProductWithId(int id) throws SQLException
	{
		String query = "delete from products where ID='"+id+"'";
		Connection con = DBConnector.getConnection();
		PreparedStatement statement = con.prepareStatement(query);
		int result = statement.executeUpdate();
		
		statement.close();
		DBConnector.closeConnection(con);
		return result;
	}
}

	
