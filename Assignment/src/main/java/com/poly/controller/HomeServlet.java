package com.poly.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poly.constant.SessionAttribute;
import com.poly.entity.History;
import com.poly.entity.User;
import com.poly.entity.Video;
import com.poly.service.HistoryService;
import com.poly.service.VideoService;
import com.poly.service.impl.HistoryServiceImpl;
import com.poly.service.impl.VideoServiceImpl;

@WebServlet(urlPatterns = { "/index", "/favorite", "/history" })
public class HomeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 761822134729030614L;
	private VideoService videoService = new VideoServiceImpl();
	private HistoryService historyService = new HistoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		HttpSession session = req.getSession();

		switch (path) {
		case "/index":
			doGetIndex(req, resp);
			break;
		case "/favorite":
			doGetFavorite(session, req, resp);
			break;
		case "/history":
			doGetHistory(session, req, resp);
			break;
		}

	}

	private void doGetIndex(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Video> videos = videoService.findAll();
		req.setAttribute("videos", videos);
		req.getRequestDispatcher("/views/user/index.jsp").forward(req, resp);
	}

	private void doGetFavorite(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) session.getAttribute(SessionAttribute.CURRENT_USER);
		List<History> histories = historyService.findByUserAndIsLiked(user.getUsername());
		List<Video> videos = new ArrayList<>();
		histories.forEach(item -> videos.add(item.getVideo()));
		
		req.setAttribute("videos", videos);
		req.getRequestDispatcher("/views/user/favorite.jsp").forward(req, resp);
	}

	private void doGetHistory(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) session.getAttribute(SessionAttribute.CURRENT_USER);
		List<History> histories = historyService.findByUser(user.getUsername());
		List<Video> videos = new ArrayList<>();
		histories.forEach(item -> videos.add(item.getVideo()));
		
		req.setAttribute("videos", videos);
		req.getRequestDispatcher("/views/user/history.jsp").forward(req, resp);
	}

}
