<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Action Menu</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.css">
</head>

<body style="background-color: #18BC9C">
	<div class="page">
		<form class="forms" action="Logout">
	    	<input class="btn" type="submit" value="Logout" />
		</form>
		<div class="block">
			<h3>Choose action:</h3>
			<div class="list-group">
				<a class="list-group-item" href="GroupListController">Groups</a>				
				<a class="list-group-item" href="StudListController">Students</a>
				<a class="list-group-item" href="ProfListController">Professors</a>
				<a class="list-group-item" href="MarkListController">Marks</a>
				<a class="list-group-item" href="StudyListController">Studies</a>
				<c:if test="${user.role eq 'admin'}">
					<a class="list-group-item" href="UserListController">Users</a>
				</c:if>
			</div>
				<br>
				<c:if test="${user.role ne 'admin'}">
					<form class="forms" action="SendMsg">
			    		<input class="btn btn-info" type="submit" value="Send Message" />
					</form>
				</c:if>
				<c:if test="${user.role eq 'admin'}">
					<form class="forms" action="ReadMsg">
			    		<input class="btn btn-info" type="submit" value="Read Message" />
					</form>
				</c:if>		
		</div>
	</div>
</body>
</html>