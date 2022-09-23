<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Notty App</title>
</head>
<body>
<form action="/notty/SaveNoteServlet" method="post">
	<input type="text" name="title"/>
	<textarea rows="15" cols="50" name="body"></textarea>
	<input type="submit" value="Save"/>
	<input type="reset" value="Clear"/>
	<input type="hidden" name="whatsend" value="note"/>
</form>
</body>
</html>