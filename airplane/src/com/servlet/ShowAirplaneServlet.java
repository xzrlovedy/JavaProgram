package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.AirplaneService;
import com.service.impl.AirplaneServiceImpl;

@WebServlet("/showairplane")
public class ShowAirplaneServlet extends HttpServlet {
	private AirplaneService airplaneService = new AirplaneServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int takeid = 0;
		String takeIdStr = req.getParameter("takeid");
		if(takeIdStr!=null&&!takeIdStr.equals("")){
			takeid=Integer.parseInt(takeIdStr);
		}
		int landid = 0;
		String landIdStr = req.getParameter("landid");
		if(landIdStr!=null&&!"".equals(landIdStr)){
			landid = Integer.parseInt(landIdStr);
		}
		req.setAttribute("list", airplaneService.show(takeid, landid));
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
