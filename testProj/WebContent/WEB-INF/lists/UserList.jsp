<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User List</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}//css/style.css">
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<div class="page">
    <form class="forms" action="ActMenuController">
    	<input class="btn" type="submit" value="Back" />
	</form>
	<form class="forms" action="Logout">
    	<input class="btn" type="submit" value="Logout" />
	</form>
<div class="block">
	<h4>Users</h4>
		<div style="border: thin solid #ccc;"class="pre-scrollable">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>User</th>
					<th>Password</th>
					<th>Role</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<jsp:useBean id="data" class="java.util.ArrayList" scope="request"/>

					<c:forEach items="${data}" var="user">
						<tr>
							<td>${user.user}</td>
							<td>*****</td>
							<td>${user.role}</td>
							<td>
								<form action="UserFormController" method="post" >
									<input class="btn btn-warning" type="submit" name="action" value="Edit"/>
									<input type="hidden" name="username" value="${user.user}">
									<input type="hidden" name="password" value="${user.password}">
									<input type="hidden" name="role" value="${user.role}">
								</form>
							</td>
						</tr>
					</c:forEach>
			</tbody>
		</table>
		</div>
	<br>   	
	<form class="forms" action="UserFormController" method="post">
    	<input class="btn btn-success" type="submit" name="action" value="Add" />
	</form>
	<br>
	<p style = "color: green">${msg}</p>
</div>
</div>
</body>
</html>