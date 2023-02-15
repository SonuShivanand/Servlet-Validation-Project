package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.User;

@WebServlet("/delete")
public class Delete extends HttpServlet
{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	if(req.getSession().getAttribute("id")==null)
	{
		resp.getWriter().print("<h1>Invalid Session Login again</h1>");
		req.getRequestDispatcher("login.html").include(req, resp);
	}
	else {
	String email = req.getParameter("email");
	UserDao userDao=new UserDao();
	User user=userDao.find(email);
	userDao.delete(user);
	}
}
}