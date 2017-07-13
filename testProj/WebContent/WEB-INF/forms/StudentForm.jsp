<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Form</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<div class="page">
    <form class="forms" action="StudListController">
    	<input type="submit" value="Back" />
	</form>
	<form class="forms" action="Logout">
    	<input type="submit" value="Logout" />
	</form>
<div class="block">
	<h3>Student info</h3>
	<form action="StudSaveController">
		<Font size="3"> First name: </Font>
			<Input type="text" name="firstName" value="${firstName}">
		<br>
		<br>
			<Font size="3"> Second name: </Font>
			<Input type="text" name="secondName" value="${secondName}">
		<br>
		<br>
			<Font size="3"> Average mark: </Font>
			<Input type="text" name="avgMark" value="${avgMark}" disabled>
		<br>
		<br>
			<Font size="3"> Group number: </Font>
			<Input type="text" name="groupNumber" value="${groupNumber}">
		<br>
		<br>		
			<input type="submit" value="Save" />
			<input formaction="StudDelController" type="submit" value="Delete" />
	</form>
	
</div>
</div>
</body>
</html>