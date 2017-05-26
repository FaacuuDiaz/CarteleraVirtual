<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myapp">
<jsp:include page="head.jsp"/>
<body>
	<%String aux= (new File (".").getCanonicalPath()); %>
	<%int cont = 0; %>
	<h1>Hola Mundo de Java </h1> <%=cont %> <%=aux %>
	
	<jsp:include page="body.jsp"></jsp:include>
	
</body>
