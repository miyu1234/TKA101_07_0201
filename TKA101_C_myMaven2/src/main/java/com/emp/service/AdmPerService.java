package com.emp.service;

import java.util.List;

import com.emp.model.AdmPerDAO;
import com.emp.model.AdmPerDAO_interface;
import com.emp.model.AdmPerVO;

public class AdmPerService {

	private AdmPerDAO_interface dao;

	public AdmPerService() {
		dao = new AdmPerDAO();
	}
	
	public List<AdmPerVO> getall(){
		return dao.getAll();
	}
	
	public List<AdmPerVO> getByFunc(Integer funcNo){
		return dao.getAll();
	}
	
	
}
