<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="notty.bean.NoteBean" %>
<%
ArrayList<NoteBean> noteList=new ArrayList<NoteBean>();
if(request.getAttribute("NOTES")!=null){
	noteList=(ArrayList<NoteBean>)request.getAttribute("NOTES");
}

%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    
<title>NOTTY - ALL NOTES</title>
</head>
<body>
<table class="table table-striped">
<tr>
<th>Title</th>
<th>Body</th>
</tr>
<%
for(NoteBean note:noteList){
	String title=note.getTitle();
	String body=note.getBody();
%>
<tr>
<td><%=title %></td>
<td><%=body %></td>

</tr>
<% } %>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>

</body>
</html>