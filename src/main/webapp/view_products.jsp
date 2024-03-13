<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="model.Product"%>
<%@page import="database.ProductDAO"%>
<%@page import="java.util.ArrayList"%>
    

<!DOCTYPE html>
<html>
<head>
	<title></title>
	  <style type="text/css">
    body
    {
      background : url('reg_background.png');
      background-size: cover;
    }
  </style>
	
	<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body >
	<!-- Grey with black text -->
<nav class="navbar navbar-expand-sm " style="background-color: #D9E0EC ">
  <div class="container-fluid fw-bolder fs-5">
    <ul class="navbar-nav">

        <a class="navbar-brand" href="#">
      <img src="logo.jpg" alt="Logo" style="width:100px;" class="rounded-pill"> 
    </a>
        	    <a class="navbar-brand" href="#" style="color:white;">LAP LOOT</a>

	 <li class="nav-item ">
        <a class="nav-link" href="admin_home.jsp">View Buyers</a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link " href="add_product.html">Add Product</a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link active" href="#">View Products</a>
      </li>
      
    </ul>

    <ul class="navbar-nav ms-auto ">

      <li class="nav-item">
        <a class="nav-link " href="login.html">Logout</a>
      </li>
      
    </ul>
    
  </div>
</nav>

  		<div class="container w-50 p-5 my-5 text-dark">
		<h1 style="text-align: center;">Product List</h1>

		<% 
      	ProductDAO dao = new ProductDAO();
	   	ArrayList<Product> plist = (ArrayList<Product>)dao.getProducts();
		if(plist.size()!=0){
		int count = 0;
		%>
		<table class="table table-danger table-striped table-bordered border-white border-5">
	
			<thead>
				<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Description</th>
				<th>Price</th>
				<th class="action">&nbsp;</th>
				
				</tr>
			</thead>
			<tbody>
			<%for (Product product:plist){
	  			count++;%>
	  		<form method="post" action ="DeleteProductServlet">
	  			
    			<tr>
				<td>
                    <input type="text" name="id" value="<%= product.getId() %>" readonly/>
                </td>   	  
                <td><%=product.getProductname()%></td>
   	  <td><%=product.getdescription()%></td>
   	  <td><%=product.getPrice()%></td>   	 
   	  <td><input type="submit" name="actionCommand" value="Delete" /></td>
   	   
   	  </tr> 
   	  </form>
		<%}%>
			
			</tbody>
		</table>
		<%
		}else{ %><p style="text-align: center;">Admin has not added any products.</p><%} %>
    </div>
</div>
</body>
</html>