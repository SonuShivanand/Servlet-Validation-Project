<%@page import="dto.User"%>
<%@page import="dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
if(request.getSession().getAttribute("id")==null)
{
	response.getWriter().print("<h1>Invalid Session Login again</h1>");
	request.getRequestDispatcher("login.html").include(request, response);
}
else
{
%>
<%String email=request.getParameter("email");
UserDao userDao=new UserDao();
User user=userDao.find(email);
%>
<form action="update" method="post">
Name:<input name="name" type="text" value="<%=user.getName()%>"><br>
Email:<input name="email" type="email" value="<%=user.getEmail()%>" readonly="readonly"><br>
Password:<input name="password" type="password" value="<%=user.getPassword()%>"><br>
Number:<input type="number" name="number" value="<%=user.getNumber()%>"><br>
Address:<textarea rows="10" cols="10" name="address"><%=user.getAddress() %></textarea><br>
Gender:
<%if(user.getGender().equals("male")) {%>
Gender:Female<input name="gender" type="radio" value="female">
Male<input name="gender" type="radio" value="male" checked="checked"><br>
<%}else{ %>
Female<input name="gender" type="radio" value="female" checked="checked">
Male<input name="gender" type="radio" value="male" ><br>
<%} %>
<button>Update</button>
<button type="reset">cancel</button>
</form>
<%} %>
</body>
</html>