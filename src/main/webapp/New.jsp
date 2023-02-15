<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% %>
<h1>Hello Madhu</h1>
<% int a=10; %>
<h1><%out.print(a); %></h1>
<h1> First:<%=a %></h1>
<%! int a=9; %>
<h1>Second: <%=this.a %></h1>

<%List list=new ArrayList();
list.add(1);
list.add(2);
%>

<%=list %>


</body>
</html>