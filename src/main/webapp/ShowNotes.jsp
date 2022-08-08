<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.Entites.NoteTaker"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.Helper.FactoryProvider"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <%@include file="All_css_js_.jsp"%>
</head>
<body>
<div class="container">
   
  		 <%@include file ="navbar.jsp" %>   		   
   </div>
<%
 
    Session s = FactoryProvider.getFactory().openSession();
    Query Q =  s.createQuery("from NoteTaker");
    List<NoteTaker> list = Q.list();
   
    for(NoteTaker note : list)
    {  
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd");
    	String date =sdf.format(note.getAddDate());
%>   
  
  <div class="card mt-4" style="width:80%; margin-left:10%;">
  <img class="card-img-top pl-4 pt-4" style="max-width:100px"src="image/note_icon.png" alt="Card image cap">
  <div class="card-body">
  <h5 class="card-title"><%=note.getTitle() %></h5>
  <p class="card-text"><%=note.getContent()%></p>
  <p><b class="text-primary"><%=date%></b></p>
  <div class="container text-center">
  <a href="DeleteServlet?note_id=<%=note.getId()%>" class="btn btn-danger">Delete</a>
  <a href="EditNote.jsp?note_id=<%=note.getId()%>" class="btn btn-success">Edit</a>
  </div>
  </div>
  </div>  
<%
}
    		 
    s.close();
%>
</body>
</html>