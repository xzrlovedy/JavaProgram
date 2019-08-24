package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.AirportService;
import com.service.impl.AirportServiceImpl;

@WebServlet("/showtake")
public class ShowTakeServlet extends HttpServlet{
	private AirportService airService = new AirportServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("takeport", airService.showTakePort());
		req.getRequestDispatcher("showland").forward(req, resp);
	}
}
