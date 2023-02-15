<%@page import="dto.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.17.0/xlsx.full.min.js"></script>
<script type="text/javascript">
function export_data(){
	let data=document.getElementById('data');
	var fp=XLSX.utils.table_to_book(data,{sheet:'sheet1'});
	XLSX.write(fp,{
		bookType:'xlsx',
		type:'base64'
	});
	XLSX.writeFile(fp, 'test.xlsx');
}
</script>
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
<% List <User>list=(List<User>)request.getAttribute("list"); %>
<table border="10px" style="color: black;" id="data">
<tr>
<th>UserName</th>
<th>PhoneNumber</th>
<th>Email</th>
<th>password</th>
<th>Gender</th>
<th>Address</th>
<th>Delete</th>
<th>Edit</th>
</tr>
<% 
for(User user:list)
{%>
<tr>
<td><%=user.getName() %></td>
<td><%=user.getNumber() %></td>
<td><%=user.getEmail() %></td>
<td><%=user.getPassword() %></td>
<td><%=user.getGender() %></td>
<td><%=user.getAddress() %></td>
<td>
<a href="delete?email=<%=user.getEmail() %>"><button type="reset">Delete</button>
</a>
</td>
<td>
<a href="edit.jsp?email=<%=user.getEmail() %>"><button>Edit</button>
</a>
</td>
</tr>
<%} %>

</table>
<button onclick="window.print()">print</button>
<button onclick="export_data()">Export</button><br>
<a href="logout"><button>Logout</button></a>


<%} %>
</body>
</html>