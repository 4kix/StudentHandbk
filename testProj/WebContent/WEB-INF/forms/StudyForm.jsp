<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Study Form</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<div class="page">	
    <form class="forms form-group" action="StudyListController">
    	<input type="submit" value="Back" />
	</form>
	<form class="forms" action="Logout">
    	<input type="submit" value="Logout" />
	</form>
<div class="block">
	<h3>Study info</h3>
	<form class="form-horizontal" action="StudySaveController">
	<div class="form-group">
		<Font class="control-label" size="3"> Name: </Font>
		<div class="col-10">
			<Input class="form-control" type="text" name="name" value="${name}">
		</div>
	</div>
		<br>
		<br>
			<Font size="3"> Hours: </Font>
			<Input type="text" name="hours" value="${hours}">
		<br>
		<br>
			<Font size="3"> Professor ID: </Font>
			<Input type="text" name="professorId" value="${professorId}">
		<br>
		<br>
			<Font size="3"> Avg mark: </Font>
			<Input type="text" name="avgMark" value="${avgMark}" disabled>
		<br>
		<br>		
			<input type="submit" value="Save" />
			<input formaction="StudyDelController" type="submit" value="Delete" />
	</form>
	
</div>
</div>
</body>
</html>