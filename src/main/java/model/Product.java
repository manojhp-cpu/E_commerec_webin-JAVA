package model;

public class Product {
	private int Id;
	private String Productname;
	private String price;
	private String description;
	
	public Product() {
		
	}
	
	public int getId() {
		return this.Id;
	}
	
	public void setId(int Id) {
		this.Id = Id;
	}
	
	public String getProductname() {
		return this.Productname;
		
	}
	
	public void setProductname(String Product_name) {
		this.Productname = Product_name;
	}
	
	public String getPrice() {
		return this.price;
	}
	
	public void setPrice(String i) {
		this.price = i;
	}
	
	public String getdescription() {
		return this.description;
	}
	
	public void setdescription(String description) {
		this.description = description;
	}
}
