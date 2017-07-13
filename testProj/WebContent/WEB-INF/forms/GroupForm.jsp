<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Group Form</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<div class="page">
    <form class="forms" action="GroupListController">
    	<input type="submit" value="Back" />
	</form>
	<form class="forms" action="Logout">
    	<input type="submit" value="Logout" />
	</form>
<div class="block">
	<h3>Group info</h3>
	<form action="GroupSaveController">
		<Font size="3"> Group Number: </Font>
			<Input type="text" name="groupNumber" value="${groupNumber}">
		<br>
		<br>
			<Font size="3"> Avg Mark: </Font>
			<Input type="text" name="avgMark" value="${avgMark}" disabled>
		<br>
		<br>		
			<input type="submit" value="Save" />
			<input formaction="GroupDelController" type="submit" value="Delete"/>
	</form>
	
</div>
</div>
</body>
</html>