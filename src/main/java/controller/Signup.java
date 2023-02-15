


package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.User;

@WebServlet(urlPatterns="/Signup",initParams= {
@WebInitParam(name="cbranch",value="rajajinagar")
})
public class Signup extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	String cname=getServletContext().getInitParameter("cname");
	String cbranch=getServletConfig().getInitParameter("cbranch");
	User user=new User();
	user.setAddress(req.getParameter("address"));
	user.setPassword(req.getParameter("password"));
	user.setEmail(req.getParameter("email"));
	user.setGender(req.getParameter("gender"));
	user.setName(req.getParameter("name"));
	user.setNumber(Long.parseLong(req.getParameter("number")));
	
	UserDao userDao=new UserDao();
	userDao.send(user);
	resp.getWriter().print("<h1>Account Created Successfully in"+" "+cname+" "+cbranch+"</h1>");
	req.getRequestDispatcher("login.html").include(req, resp);
	}


}
