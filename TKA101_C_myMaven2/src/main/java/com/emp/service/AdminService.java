package com.emp.service;

import java.util.List;

import com.emp.model.AdminDAO;
import com.emp.model.AdminDAO_interface;
import com.emp.model.AdminVO;

public class AdminService {
	

	private AdminDAO_interface dao;
	
	public AdminService() {
		dao =  new AdminDAO ();
	}
	
	
	public List<AdminVO> getAll() {
		return dao.getAll();
	}

	public AdminVO getOneAdmin(Integer admId) {
		return dao.findByPrimaryKey(admId);
	}
	
	public List<AdminVO> getByStatus(Byte admStatus) {
		return dao.getByStatus(admStatus) ;
	}
	
	public AdminVO updateAdmin(Integer admId, String admAcc, String admPw, String admName, java.sql.Date hireDate, Byte admStatus) {
		AdminVO adminVO = new AdminVO();
	    adminVO.setAdmId(admId);
	    adminVO.setAdmAcc(admAcc);
	    adminVO.setAdmPw(admPw);
	    adminVO.setAdmName(admName);
	    adminVO.setHireDate(hireDate);
	    adminVO.setAdmStatus(admStatus);
	    
	    dao.update(adminVO);
	    return adminVO;
	}
	
	public AdminVO resetAdminPw(Integer admId, String newPw) {
		dao.resetAdminPw(admId, newPw);
		return dao.findByPrimaryKey(admId);
	}
	
	public boolean isAccDuplicate(String admAcc) {
		return dao.findByAcc(admAcc) != null;
		
	}
	
	public AdminVO createAdmin( String admAcc, String admPw, String admName, java.sql.Date hireDate, Byte admStatus) {
		AdminVO adminVO = new AdminVO();
	    // adminVO.setAdmId(admId); //沒有setID啦
	    adminVO.setAdmAcc(admAcc);
	    adminVO.setAdmPw(admPw);
	    adminVO.setAdmName(admName);
	    adminVO.setHireDate(hireDate);
	    adminVO.setAdmStatus(admStatus);
	    
	    dao.insert(adminVO);
	    return adminVO;
	}
	
	
	
}
