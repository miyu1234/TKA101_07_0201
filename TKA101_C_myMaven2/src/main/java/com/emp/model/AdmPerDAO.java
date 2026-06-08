package com.emp.model;

import java.util.List;

import org.hibernate.Session;

public class AdmPerDAO implements AdmPerDAO_interface {

	@Override
	public List<AdmPerVO> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction();
			List<AdmPerVO> list = session.createQuery("from AdmPerVO", AdmPerVO.class).getResultList();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 session.getTransaction().rollback(); 
			 throw new RuntimeException("查詢 權限列表 失敗", e);
		}
	}

	@Override
	public List<AdmPerVO> getByFunc(Integer funcNo) {
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction();
			List<AdmPerVO> list = session.createQuery("from AdmPerVO where funcNo = :funcNo", AdmPerVO.class).setParameter("funcNo", funcNo).getResultList();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback(); 
			 throw new RuntimeException("查詢 權限列表 失敗", e);
		}

	}


	
}
