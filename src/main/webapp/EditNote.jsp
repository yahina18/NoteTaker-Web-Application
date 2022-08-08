<%@page import="com.Entites.NoteTaker"%>
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
  		 <%
  		    int noteid = Integer.parseInt(request.getParameter("note_id").trim());
  		    Session s = FactoryProvider.getFactory().openSession();
  		    NoteTaker note = (NoteTaker)s.get(NoteTaker.class,noteid); 
  		 
  		 %>
  <!--  Form started from here!! -->
  <form action="UpdateServlet" method="post">
  <input type="hidden" value=<%=note.getId()%> name="NoteID">
  <div class="form">
  <div class="form-group">
  <label for="title">Title</label>
  <input required type="text"  
  name = "title"
  class="form-control" 
  id="title" 
  placeholder="Enter your content title"
  value="<%=note.getTitle()%>" 
  >
  </div>
  
  
  <div class="form-group">
    <label for="Content">Content</label>
    <textarea required name = "Content"
    id="content"
    placeholder="Enter your Content Here!!!" 
    class="form-control" style="height: 300px;"><%=note.getContent()%>
    </textarea>
  </div>
  <div class="container text-center">
  <button type="submit" class="btn btn-primary">Update Note</button>
  
  </div>
  </div>
</form>
  		 
  		 		   
</div>

</body>
</html>