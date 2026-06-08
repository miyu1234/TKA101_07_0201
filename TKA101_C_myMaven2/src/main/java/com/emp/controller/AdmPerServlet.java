package com.emp.controller;

import java.io.IOException;
import java.util.List;

import com.emp.model.AdmPerVO;
import com.emp.service.AdmPerService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/adminPer.do")
public class AdmPerServlet extends HttpServlet{
	private AdmPerService admPerService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    doPost(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8"); //for 中文字
		String action = req.getParameter("action");
		
		if("getAllPer".equals(action)){
			AdmPerService admPerService = new AdmPerService();
			List<AdmPerVO> list = admPerService.getall();
			
			req.getSession().setAttribute("admPerList", list);
			String url ="/backend/member/ListAllPer.jsp" ;  //未建/backend/member/ListAllPer.jsp
			RequestDispatcher successView = req.getRequestDispatcher(url); 
			successView.forward(req, res);
		}

		
		
	}
	
	
	
}
