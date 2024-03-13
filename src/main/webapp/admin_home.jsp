<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="model.Buyer"%>
<%@page import="database.BuyerDAO"%>
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
	
	<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
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
            <a class="nav-link" href="admin_home.jsp">View Buyer</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="add_product.html">Add Product</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="buyer_home.jsp">View Product</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="signup2.html">Log out</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  		<div class="container w-50 p-5 my-5 text-dark">
		<h1 style="text-align: center;">Buyer List</h1>

		<%
		BuyerDAO dao = new BuyerDAO();
			   	ArrayList<Buyer> blist = dao.getBuyers();
				if(blist.size()!=0){
				int count = 0;
		%>
		<table class="table table-danger table-striped table-bordered border-white border-5">
	
			<thead>
				<tr>
				<th>Sl.No</th>
				<th>Name</th>
				<th>Mail</th>
				<th>Mobile</th>
				</tr>
			</thead>
			<tbody>
			<%for (Buyer buyer:blist){
	  			count++;%>
    			<tr>
      <th scope="row"><%=count%></th>
   	  <td><%=buyer.getName()%></td>
   	  <td><%=buyer.getMail()%></td>
   	  <td><%=buyer.getMobile()%></td>
   	  </tr> 
		<%}%>
			
			</tbody>
		</table>
		<%
		}else{ %><p style="text-align: center;">No registered Buyers.</p><%} %>
    </div>
</div>
</body>
</html>