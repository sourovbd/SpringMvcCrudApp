<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container row d-flex justify-content-center">
	<div class="text-center">
		<h3>Vb User List</h3>
	</div>
	<table class="table table-striped" border="2" width="70%" cellpadding="2">
	<tr>		
		<th>User Name</th>
		<th>Password</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Phone no</th>
		<th>Account no</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
    <c:forEach var="user" items="${userLists}"> 
    <tr>
	    <td>${user.userName}</td>
	    <td>${user.password}</td>
	    <td>${user.firstName}</td>
	    <td>${user.lastName}</td>
	    <td>${user.phoneNo}</td>
	    <td>${user.accNo}</td>
	    <td><a href="fetchVbUser/${user.id}">Edit</a></td>
	    <td><a href="deleteVbUser/${user.id}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    
    <div class="text-center">
    <a href="addVbUser">Add New Vb User</a>
    </div>
</div>
</body>
</html>