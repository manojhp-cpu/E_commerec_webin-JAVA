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
    .logo {
      max-width: 150px;
      height: auto;
    }
     .navbar {
            background-color: #333;
            padding: 15px;
        }
        .navbar-brand {
            color: #333;
            font-weight: bold;
            font-size: 1.5rem;
        }
        .nav-link {
            color: #ffffff;
            font-weight: bold;
            margin-right: 15px;
        }
        .nav-link:hover {
            color: #666;
        }
        .nav-link.active {
            color: #007bff;
        }
        .navbar-nav .nav-link:last-child {
            margin-right: 0;
        }
  </style>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	
	<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body >
	<!-- Grey with black text -->
<nav class="navbar navbar-expand-lg navbar-dark">
    <div class="container">
      <a class="navbar-brand" href="index.html">
        <img src="l3.png" alt="Your Logo" class="logo">
      </a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="index.html">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="about.html">About</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">View Product</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="profile.jsp">View Profile</a>
          </li>

          <li class="nav-item">
            <a class="nav-link" href="Login.html">Log out</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  		<div class="container w-50 p-5 my-5 text-dark">
		<h1 style="text-align: center;">Product List</h1>

		<% 
      	ProductDAO dao = new ProductDAO();
	   	ArrayList<Product> plist = (ArrayList<Product>)dao.getProducts();
		if(plist.size()!=0){
		%>
		<table class="table table-danger table-striped table-bordered border-white border-5">
	
			<thead>
				<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Description</th>
				<th>Price</th>
				<th>&nbsp;</th>
				</tr>
			</thead>
			<tbody>
			<%for (Product product:plist){
	  			%>
	  					<form method="post" action ="product_details.jsp">
	  			
    			<tr>
    			<td>
                    <input type="text" name="id" value="<%= product.getId() %>" readonly/>
                </td>
                
                
   	  <td><%=product.getProductname()%></td>
   	  <td><%=product.getdescription()%></td>
   	  <td><%=product.getPrice()%></td>   
   	  <td><input type="submit" value="Buy" /></td>
   	  	  
   	  </tr> 
   	  		</form>
   	  
		<%}%>
			
			</tbody>
		</table>
		<%
		}else{ %><p style="text-align: center;">Admin has not added any products.</p><%} %>
    </div>




</body>
</html>