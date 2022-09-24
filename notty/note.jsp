<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    
    <title>Notty App</title>
</head>
<body>
<div class="col-lg-8 mx-auto p-4 py-md-5">
	<nav class="navbar style="background-color: #e3f2fd;"">
	  <div class="container-fluid">
	    <span class="navbar-brand mb-0 h1">Notty</span>
	  </div>
	   <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	        <li class="nav-item">
		  		<a href="/notty/SaveNoteServlet?whatsend=list">All Notes</a>
		  	</li>
	  	</ul>
	</nav>
	<form action="/notty/SaveNoteServlet" method="post">
		<input type="text" class="form-control" name="title"/>
		<textarea rows="15" cols="50" name="body" class="form-control"></textarea>
		<div class="d-grid gap-2">
			<input type="submit"  class="btn btn-primary btn-lg" value="Save"/>
			<!--TODO: disabiltare il bottone per il SAVE se la nota è vuota--> 
			<input type="reset" class="btn btn-danger btn-lg" value="Clear"/>
		</div>
		<input type="hidden" name="whatsend" value="note"/>
	</form>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</div>
</body>
</html>