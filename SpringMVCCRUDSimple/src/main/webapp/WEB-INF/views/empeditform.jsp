<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   

<h1>Edit Employee</h1>
<form:form method="POST" action="/SpringMVCCRUDSimple/updateVbUser" modelAttribue="vbUser">  
 	<table >  
	 	<tr>
	    	<td><form:hidden  path="id" /></td>
	    </tr> 
	    <tr>  
		    <td>Name : </td> 
		    <td><form:input path="userName" /></td>
	    </tr>  
	    <tr>  
		    <td>Password :</td>  
		    <td><form:input path="password" /></td>
	    </tr> 
	    <tr>  
		    <td>First Name :</td>  
		    <td><form:input path="firstName" /></td>
	    </tr> 
	    <tr>  
		    <td>Last Name :</td>  
		    <td><form:input path="lastName" /></td>
	    </tr> 
	    <tr>  
		    <td>Phone No :</td>  
		    <td><form:input path="phoneNo" /></td>
	    </tr> 
	    <tr>  
		    <td>Account No :</td>  
		    <td><form:input path="accNo" /></td>
	    </tr> 
	    
	    <tr>   
	    	<td><input type="submit" value="Edit Save" /></td>  
	    </tr>  
   </table>  
  </form:form>  
