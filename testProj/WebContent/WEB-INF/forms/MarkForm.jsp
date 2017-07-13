<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mark Form</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<div class="page">
    <form class="forms" action="MarkListController">
    	<input type="submit" value="Back" />
	</form>
	<form class="forms" action="Logout">
    	<input type="submit" value="Logout" />
	</form>
<div class="block">
	<h3>Mark info</h3>
	<form action="MarkSaveController">
		<Font size="3"> Study ID: </Font>
			<Input type="text" name="studyID" value="${studyId}">
		<br>
		<br>
			<Font size="3"> Student ID: </Font>
			<Input type="text" name="studentId" value="${studentId}">
		<br>
		<br>
			<Font size="3"> Date: </Font>
			<Input type="text" name="date" value="${date}">
		<br>
		<br>
			<Font size="3"> Professor ID: </Font>
			<Input type="text" name="professorId" value="${professorId}">
		<br>
		<br>
			<Font size="3"> Mark: </Font>
			<Input type="text" name="mark" value="${mark}">
		<br>
		<br>
			<Font size="3"> Comments: </Font>
			<Input type="text" name="comments" value="${comments}">
		<br>
		<br>		
			<input type="submit" value="Save" />
			<input formaction="MarkDelController" type="submit" value="Delete" />
	</form>
	
</div>
</div>
</body>
</html>