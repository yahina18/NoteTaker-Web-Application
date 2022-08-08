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
  
  <%@include file="navbar.jsp"%>
   
  <!--  Form started from here!! -->
  <form action="SaveNotes" method="post">
  <div class="form">
  <div class="form-group">
  <label for="title">Title</label>
  <input required type="text"  name = "title"
  class="form-control" 
  id="title" 
  placeholder="Enter your content title">
  </div>
  
  
  <div class="form-group">
    <label for="Content">Content</label>
    <textarea required name = "Content"
    id="content"
    placeholder="Enter your Content Here!!!" 
    class="form-control" style="height: 300px;"
    ></textarea>
  </div>
  <div class="container text-center">
  <button type="submit" class="btn btn-success">Add Note</button>
  
  </div>
  </div>
</form>
</div>
</body>
</html>