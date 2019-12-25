<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
	<div class="container">
	<h3 class="col-6">User Login Form</h3>
	<form:form id="vbUser" method="post" action="login" modelAttribute="vbUser">
		<div class="form-group col-6">
			<form:label path="userName">User name</form:label>
			<form:input class="form-control" id="userName" name="userName" path="" /><br>
		</div>
		<div class="form-group col-6">
			<form:label path="password">Password</form:label>
			<form:password class="form-control" id="password" name="password" path="" /><br>
		</div>
		<div class="col-6">
			<!-- <input type="submit" value="Submit" /> -->
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</form:form>
	</div>
<font color="red">${message}</font>
</body>
</html>