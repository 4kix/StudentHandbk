<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student List</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}//css/style.css">
<link rel="stylesheet" href="css/bootstrap.css">
<style>
<
</style>
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
	<h4>Students</h4>
		<div style="border: thin solid #ccc;"class="pre-scrollable">
		<table class="table table-hover">
			<thead>
				<tr>
					<!-- <th>ID</th> -->
					<th>First Name</th>
					<th>Second Name</th>
					<th>Average Mark</th>
					<th>Group Number</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<jsp:useBean id="data" class="java.util.ArrayList" scope="request"/>
				
					<c:forEach items="${data}" var="student">
						<tr>
							<%-- <td>${student.id}</td> --%>
							<td>${student.firstName}</td>
							<td>${student.secondName}</td>
							<td>${student.avgMark}</td>
							<td>${student.groupNumber}</td>
							<td>
								<form action="StudentFormController" method="post" >
									<input class="btn btn-warning" type="submit" value="Edit"/>
									<input type="hidden" name="firstName" value="${student.firstName}">
									<input type="hidden" name="secondName" value="${student.secondName}">
									<input type="hidden" name="avgMark" value="${student.avgMark}">
									<input type="hidden" name="groupNumber" value="${student.groupNumber}">
								</form>
							</td>
						</tr>
					</c:forEach>
			</tbody>
		</table>
		</div>
	<br>
    
	<form class="forms" action="RecalcStudController">
    	<input class="btn" type="submit" value="Recalc AvgMark" />
	</form>	
	<c:if test="${user.role eq 'admin'}">	
	<form class="forms" action="StudentFormController">
    	<input class="btn btn-success" type="submit" value="Add" />
	</form>	
	</c:if>
</div>
</div>
</body>
</html>