// Source code is decompiled from a .class file using FernFlower decompiler.
package database;

import model.Buyer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BuyerDAO {
   private Connection conn = null;
   private PreparedStatement ps = null;
   private ResultSet rs = null;

   public BuyerDAO() {
   }

   public int registerBuyer(Buyer buyer) {
      String sql = "insert into buyer(Name,Mobile,Username,Password,Email) values (?,?,?,?,?)";
      int i = 0;

      try {
         this.conn = DBConnector.getConnection();
         this.ps = this.conn.prepareStatement(sql);
         this.ps.setString(1, buyer.getName());
         this.ps.setString(2, buyer.getMobile());
         this.ps.setString(3, buyer.getUsername());
         this.ps.setString(4, buyer.getPassword());
         this.ps.setString(5, buyer.getMail());   
         i = this.ps.executeUpdate();
      } catch (SQLException var8) {
         var8.printStackTrace();
      } finally {
         DBConnector.closeStatement(this.ps);
         DBConnector.closeConnection(this.conn);
      }

      return i;
   }
   
   public Buyer buyerVerify(String username,String password)

   {
	   String sql="select * from buyer where USERNAME='"+username+"' and password='"+password+"'";
	   
	   Buyer buyer = null;
	   
	   try {
		   conn = DBConnector.getConnection();
		   ps = conn.prepareStatement(sql);
		   rs = ps.executeQuery();
		   
		   if(rs.next()) {
			   buyer = new Buyer();
			   buyer.setId(rs.getInt("ID"));
			   buyer.setName(rs.getString("Name"));
			   buyer.setMail(rs.getString("email"));
			   buyer.setMobile(rs.getString("Mobile"));
		   }
			
		}catch (SQLException e) {
			   e.printStackTrace();
		}finally {
			try {
				rs.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			DBConnector.closeStatement(ps);
			DBConnector.closeConnection(conn);
		}
	   return buyer;
	
	
   }
   public ArrayList<Buyer> getBuyers() throws SQLException
	{
		String query="select * from buyer";
		Connection con=DBConnector.getConnection();
		PreparedStatement statement=con.prepareStatement(query);
		ResultSet rs=statement.executeQuery();
		ArrayList<Buyer> buyerList=new ArrayList<Buyer>();
		while (rs.next())
		{
			Buyer buyer=new Buyer();
			buyer.setName(rs.getString("name"));
			buyer.setMail(rs.getString("email"));
			buyer.setMobile(rs.getString("mobile"));
			buyer.setId(rs.getInt("id"));
			buyerList.add(buyer);
		}
		statement.close();
		DBConnector.closeConnection(con);
		return buyerList;
	}
}
   
   

