<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ page import="java.io.*,java.util.*,java.sql.*" %>
    <%@ page import="javax.servlet.http.*,javax.servlet.*" %>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Admin Page</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<body>


<nav class="navbar navbar-expand-lg bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.html">HOME</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
      
       
         

      
        
      </ul>
      <form class="d-flex" role="search">
     
         <a href="logout.html" class="btn btn-info btn-lg">
          <span class="glyphicon glyphicon-log-out" ></span> Log out
        </a>
      
        
      </form>
    </div>
  </div>
</nav>





	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver" 

url="jdbc:mysql://localhost:3306/grocery" user="root" password="1234"

></sql:setDataSource>


<sql:query dataSource="${db}" var="rs">select * from book;</sql:query>


<center>
ORDER DETAILS
</center>


<table class="table table-dark table-striped">
    <tr>
      <th>Order id</th>
      <th>First name</th>
      <th>Last name</th>
      <th>Email id</th>
      <th>Address</th>
      <th>Pincode</th>
      <th>Product Name</th>
      <th>Quantity</th>
      <th>Mobile Number</th>
      <th>Other Operation</th>
      <th>Cancle Orders</th>
    </tr>
  
  
  <c:forEach var="table" items="${rs.rows}">
  
  <tr>
  
  <td><c:out value="${table.id }" /></td>
  <td><c:out value="${table.firstname }"/></td>
  <td><c:out value="${table.lastname }"/></td>
  <td><c:out value="${table.email }"/></td>
  <td><c:out value="${table.address }"/></td>
  <td><c:out value="${table.pincode }"/></td>
  <td><c:out value="${table.product_name}"/></td>
  <td><c:out value="${table.quantity}"/></td>
  <td><c:out value="${table.mobilenumber }"/></td>
  <td><a href="update.html" class="btn btn-warning">Update</a></td>
  <td><a href="cancle.html" class="btn btn-danger">CancleOrder</a></td>
  </tr>
  </c:forEach>
</table>


</body>
</html>