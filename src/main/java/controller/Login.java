package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import dao.UserDao;
import dto.User;

@WebServlet(urlPatterns="/Login",initParams= {
@WebInitParam(name="cbranch",value="Hebal")
})
public class Login extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 String cname=getServletContext().getInitParameter("cname");
	 String cbranch=getServletConfig().getInitParameter("cbranch");
	 String Email=req.getParameter("email");
	 String Password=req.getParameter("password");
	 UserDao userDao=new UserDao();
	 User user=userDao.find(Email);
	 if(user==null)
	 {
		 resp.getWriter().print("<h1>Invalid Email</h1>");
		 req.getRequestDispatcher("login.html").include(req, resp);
	 }
	 else
	 {
		 if(user.getPassword().equals(Password))
		 {
			 req.getSession().setAttribute("id", "123456");
//			 resp.getWriter().print("<h1> Login sucess in"+" "+cname+" "+cbranch+"</h1>");
//			 List<User> list=userDao.fetchAll();
//			for (User user2 : list) {
//				resp.getWriter().print("<h1>UserAddress :"+" "+user2.getAddress()+"</h1>");
//				resp.getWriter().print("<h1>UserEmail :"+" "+user2.getEmail()+"</h1>");
//				resp.getWriter().print("<h1>UserGender :"+" "+user2.getGender()+"<h1>");
//				resp.getWriter().print("<h1>UserName :"+" "+user2.getName()+"<h1>");
//				resp.getWriter().print("<h1>UserNumber :"+" "+user2.getNumber()+"</h1>");
//				resp.getWriter().print("<h1>UserPassword :"+" "+user2.getPassword()+"</h1>");
//				resp.getWriter().print("-------------------------");
//				
//				
//			}
//			resp.getWriter().print("<h1>----------------------</h1>");
//			resp.getWriter().print("<table border=\"1\">"
//					+"<tr>"
//					+"<th>User Name</th>"
//					+"<th>User Email</th>"
//					+"<th>User Mobile</th>"
//					+"<th>User Password</th>"
//					+"<th>User Address</th>"
//					+"<th>User Gender</th>"
//					+"</tr>");
//			for (User u : list)
//			{
//			resp.getWriter().print("<tr><th>"+u.getName()+"</th>"
//					+"<th>"+u.getEmail()+"</th>"
//					+"<th>"+u.getNumber()+"</th>"
//					+"<th>"+u.getPassword()+"</th>"
//					+"<th>"+u.getAddress()+"</th>"
//					+"<th>"+u.getGender()+"</th>"
//					+"</tr>");
//			}
//			resp.getWriter().print("</table>");
//				
			 
			 List<User> list=userDao.fetchAll();
			 req.setAttribute("list", list);
			 req.getRequestDispatcher("result.jsp").forward(req, resp);
			}
		 else
		 {
			 resp.setContentType("text/html");
			 resp.getWriter().print("<h1>Invalid Password</h1>");
			 req.getRequestDispatcher("login.html").include(req, resp);
		 }
	 }
}
}
