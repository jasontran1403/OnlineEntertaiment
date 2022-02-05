package com.poly.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poly.constant.SessionAttribute;
import com.poly.entity.User;
import com.poly.service.MailService;
import com.poly.service.UserService;
import com.poly.service.impl.MailServiceImpl;
import com.poly.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/login", "/logout", "/register", "/forgotPass", "/changePass"})
public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4870893321160092815L;
	private UserService userService = new UserServiceImpl();
	private MailService mailService = new MailServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String path = req.getServletPath();
		switch (path) {
		case "/login":
			doGetLogin(req, resp);
			break;
		case "/register":
			doGetRegister(req, resp);
			break;
		case "/logout":
			doGetLogout(session, req, resp);
			break;
		case "/forgotPass":
			doGetForgotPass(req, resp);
			break;
		}
	}

	protected void doGetLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/user/login.jsp").forward(req, resp);
	}
	
	protected void doGetRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/user/register.jsp").forward(req, resp);
	}
	
	protected void doGetLogout(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		session.removeAttribute(SessionAttribute.CURRENT_USER);
		resp.sendRedirect("index");
	}
	
	protected void doGetForgotPass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/user/forgot-pass.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		String path = req.getServletPath();
		switch (path) {
		case "/login":
			doPostLogin(session, req, resp);
			break;
		case "/register":
			doPostRegister(session, req, resp);
			break;
		case "/forgotPass":
			doPostForgotPass(req, resp);
			break;
		case "/changePass":
			doPostChangePass(session, req, resp);
			break;
		}
	}

	protected void doPostLogin(HttpSession session, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		User user = userService.login(username, password);
		if (user != null) {
			session.setAttribute(SessionAttribute.CURRENT_USER, user);
			resp.sendRedirect("index");
		}else {
			resp.sendRedirect("login");
		}
	}
	
	protected void doPostForgotPass(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("application/json");
		String email = req.getParameter("email");

		User user = userService.resetPassword(email);
		if (user != null) {
			mailService.sendMail(getServletContext(), user, "forgot");
			req.setAttribute("user", user);
			resp.setStatus(204);
			req.getRequestDispatcher("/views/user/forgot-pass.jsp").forward(req, resp);
		}else {
			resp.setStatus(400);
		}
	}
	
	protected void doPostRegister(HttpSession session, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String fullname = req.getParameter("full-name");
		String email = req.getParameter("email");

		User user = userService.create(username, password, email, fullname);
		
		if (user != null) {
			mailService.sendMail(getServletContext(), user, "welcome");
			session.setAttribute(SessionAttribute.CURRENT_USER, user);
			resp.sendRedirect("login");
		}else {
			resp.sendRedirect("register");
		}
	}
	
	protected void doPostChangePass(HttpSession session, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("application/json");
		String currentPass = req.getParameter("currentPass");
		String newPas = req.getParameter("newPass");
		
		User currentUser = (User) session.getAttribute(SessionAttribute.CURRENT_USER);
		System.out.println(currentUser.getPassword());
		if (currentUser.getPassword().equals(currentPass)) {
			currentUser.setPassword(newPas);
			User updatedUser = userService.update(currentUser);
			if (updatedUser != null) {
				session.setAttribute(SessionAttribute.CURRENT_USER, updatedUser);
				System.out.println(updatedUser.getPassword());
				resp.setStatus(204);
			}else {
				resp.setStatus(400);
			}
			
		}else {
			resp.setStatus(400);
		}
	}
}
