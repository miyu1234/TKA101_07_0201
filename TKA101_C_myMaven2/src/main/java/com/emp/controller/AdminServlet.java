package com.emp.controller;

import java.io.IOException;
import java.util.List;

import com.emp.model.AdminVO;
import com.emp.service.AdminService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/admin.do")
public class AdminServlet extends HttpServlet {
		private AdminService  adminService;

		public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

			req.setCharacterEncoding("UTF-8"); //for 中文字
			String action = req.getParameter("action");
			
			/*getAll流程*/
			if("getAll".equals(action)) { 
				AdminService adminService = new AdminService();
				List<AdminVO> list = adminService.getAll();
				
				req.getSession().setAttribute("adminList", list); //把list塞進req
				
				String url ="/backend/member/ListAllAdmin.jsp" ; 
				RequestDispatcher successView = req.getRequestDispatcher(url); 
				successView.forward(req, res);
			}
			
			//用admId找人
			if("getOne_For_Display".equals(action)) {
				Integer admId = Integer.valueOf(req.getParameter("admId"));
				
				AdminService adminService = new AdminService();
				AdminVO adminVO = adminService.getOneAdmin(admId);
				
				req.setAttribute("adminVO", adminVO);
				String url = "/backend/member/listOneAdmin.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
			}
			//用admStatus
			if("getList_By_Status".equals(action)) {
				//先接收admStatus => 因為他是Byte 要用Byte
				Byte admStatus = Byte.valueOf(req.getParameter("admStatus"));
				
				AdminService adminService = new AdminService();
				List<AdminVO> list = adminService.getByStatus(admStatus);
				
				req.setAttribute("adminList", list); //把list塞進req
				
				String url ="/backend/member/ListAllAdmin.jsp" ; 
				RequestDispatcher successView = req.getRequestDispatcher(url); 
				successView.forward(req, res);			
				
			}
			//getOne_for_update
			if("getOne_For_update".equals(action)) {
				Integer admId = Integer.valueOf(req.getParameter("admId")); //跟getOne一樣
				
				AdminService adminService = new AdminService(); //跟getOne一樣
				AdminVO adminVO = adminService.getOneAdmin(admId); //跟getOne一樣
				
				req.setAttribute("adminVO", adminVO); 
			    String url = "/backend/member/update_admin_input.jsp"; // 跳去更改頁面
			    RequestDispatcher successView = req.getRequestDispatcher(url);
			    successView.forward(req, res);
			}
			//update_admin
			if("update_admin".equals(action)) {
			Integer admId = Integer.valueOf(req.getParameter("admId")); 
			String admAcc = req.getParameter("admAcc");
		    String admPw = req.getParameter("admPw");
		    String admName = req.getParameter("admName");
		    java.sql.Date hireDate = java.sql.Date.valueOf(req.getParameter("hireDate"));
		    Byte admStatus = Byte.valueOf(req.getParameter("admStatus"));	
		    
		    AdminService adminService = new AdminService();
		    AdminVO adminVO =  adminService.updateAdmin(admId, admAcc, admPw, admName, hireDate, admStatus);
				
		    	req.setAttribute("adminVO", adminVO);
				req.setAttribute("adminList", adminService.getAll()); 
			    String url = "/backend/member/ListAllAdmin.jsp"; // 更改完成 回去Listall
			    RequestDispatcher successView = req.getRequestDispatcher(url);
			    successView.forward(req, res);
			}
			
			//reset Admin PW  	public void resetAdminPw(Integer admId, String newPw) { dao.resetAdminPw(admId, newPw);
			//getOne_for_update
			if("getOne_For_password".equals(action)) {
				Integer admId = Integer.valueOf(req.getParameter("admId")); //跟getOne一樣
				
				AdminService adminService = new AdminService(); //跟getOne一樣
				AdminVO adminVO = adminService.getOneAdmin(admId); //跟getOne一樣
				
				req.setAttribute("adminVO", adminVO); 
			    String url = "/backend/member/update_AdminPw.jsp"; // 跳去更改頁面
			    RequestDispatcher successView = req.getRequestDispatcher(url);
			    successView.forward(req, res);
			}
			//reset_AdmPw
			if ("reset_AdmPw".equals(action)) {
				//拉資料
				Integer admId = Integer.valueOf(req.getParameter("admId")); 
				String newPw = req.getParameter("admPw");
				if (newPw == null || newPw.trim().length() == 0) {
				     throw new RuntimeException("新密碼不可為空！");
				    
				     }
				//做
				AdminService adminService = new AdminService();
				AdminVO adminVO =  adminService.resetAdminPw(admId, newPw);
			    //塞回去
			    req.setAttribute("adminVO", adminVO);
				req.setAttribute("adminList", adminService.getAll()); 
			    String url = "/backend/member/ListAllAdmin.jsp"; // 更改完成 回去Listall
			    RequestDispatcher successView = req.getRequestDispatcher(url);
			    successView.forward(req, res);
			    
			}
			//create_admin
			if ("create_admin".equals(action)) {
				String admAcc = req.getParameter("admAcc"); 
				String admPw = req.getParameter("admPw");
				String admName = req.getParameter("admName");
				java.sql.Date hireDate = java.sql.Date.valueOf(req.getParameter("hireDate"));
				Byte admStatus = Byte.valueOf(req.getParameter("admStatus"));
				
				AdminService adminService = new AdminService();
				if(adminService.isAccDuplicate(admAcc)) {
					req.setAttribute("errorMsg", "帳號 '" + admAcc + "' 已被使用，請更換！");
			        
			        // 「回填」
			        AdminVO adminVO = new AdminVO();
			        adminVO.setAdmAcc(""); // 帳號重複了所以空
			        adminVO.setAdmName(admName);
			        adminVO.setAdmPw(admPw);
			        adminVO.setHireDate(hireDate);
			        adminVO.setAdmStatus(admStatus);
			        req.setAttribute("adminVO", adminVO); 
			        
			        // 彈回
			        req.getRequestDispatcher("/backend/member/create_Admin.jsp").forward(req, res);
			        return; 
				}
				
		
				AdminVO adminVO = adminService.createAdmin(admAcc, admPw, admName, hireDate, admStatus);
			    
				req.setAttribute("adminVO", adminVO);
				req.setAttribute("adminList", adminService.getAll()); 
			    String url = "/backend/member/ListAllAdmin.jsp"; // 更改完成 回去Listall
			    RequestDispatcher successView = req.getRequestDispatcher(url);
			    successView.forward(req, res);
			    
			}
				
			//loginasadmin
			if("loginasadmin".equals(action)) {
				String admacc = req.getParameter("admacc").trim();
				String admPw = req.getParameter("admPw").trim();
				
				AdminService adminservice = new AdminService();
				AdminVO adminVO = adminservice.Loginasadmin(admacc, admPw);
				if (adminVO == null) {
					req.setAttribute("errorMsg", "帳號或密碼錯誤");
					req.getRequestDispatcher("/backend/login.jsp").forward(req, res);
				} else if (adminVO.getAdmStatus() == 0) {
					req.setAttribute("errorMsg", "帳號已被停權");
					req.getRequestDispatcher("/backend/login.jsp").forward(req, res);
				}else {
					req.setAttribute("adminVO", adminVO);
					String url = "/backend/member/admin_index.jsp"; 
				    RequestDispatcher successView = req.getRequestDispatcher(url);
				    successView.forward(req, res);
				}
				
			}
			
		
}//doPost
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		    doPost(req, res);
		}
}//c
