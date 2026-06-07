package com.emp.model;

import java.util.List;

import org.hibernate.Session;

public class AdmFuncDAO implements AdmFuncDAO_interface {

	
	
	@Override
	public List<AdmFuncVO> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction();
			List<AdmFuncVO> list = session.createQuery("from AdmFuncVO", AdmFuncVO.class).getResultList();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			 session.getTransaction().rollback(); 
			 throw new RuntimeException("查詢 管理員權限功能 失敗", e);
		}

	}

}
