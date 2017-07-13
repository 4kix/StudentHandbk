<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mark List</title>
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
	<h4>Marks</h4>
		<div style="border: thin solid #ccc;"class="pre-scrollable">
		<table class="table table-hover">
			<thead>
				<tr>
					<!-- <th>ID</th> -->
					<th>Study ID</th>
					<th>Student ID</th>
					<th>Date</th>
					<th>Professor ID</th>
					<th>Mark</th>
					<th>Comments</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<jsp:useBean id="data" class="java.util.ArrayList" scope="request"/>
				
					<c:forEach items="${data}" var="mark">
						<tr>
							<%-- <td>${mark.id}</td> --%>
							<td>${mark.studyId}</td>
							<td>${mark.studentId}</td>
							<td>${mark.date}</td>
							<td>${mark.professorId}</td>
							<td>${mark.mark}</td>
							<td>${mark.comments}</td>
							<td>
								<form action="MarkFormController" method="post" >
									<input class="btn btn-warning" type="submit" value="Edit"/>
									<input type="hidden" name="studyId" value="${mark.studyId}">
									<input type="hidden" name="studentId" value="${mark.studentId}">
									<input type="hidden" name="date" value="${mark.date}">
									<input type="hidden" name="professorId" value="${mark.professorId}">
									<input type="hidden" name="mark" value="${mark.mark}">
									<input type="hidden" name="comments" value="${mark.comments}">
								</form>
							</td>
						</tr>
					</c:forEach>
			</tbody>
		</table>
		</div>
	<br>
	<c:if test="${user.role ne 'student'}">
		<form class="forms" action="MarkFormController">
    		<input class="btn btn-success" type="submit" value="Add" />
		</form>
	</c:if>
</div>
</div>
</body>
</html>