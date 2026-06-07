package com.emp.model;

import java.util.List;

import org.hibernate.Session;

public class AdminDAO implements AdminDAO_interface {

	@Override
	public List<AdminVO> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction(); //開交易
			List<AdminVO> list = session.createQuery("from AdminVO", AdminVO.class).getResultList();
			//宣告一個會放好多AdminVO的List
			//這是HQL => SELECT * FROM ADMIN;
			session.getTransaction().commit(); //有get到就commit~
			return list; // 這就是我們拿回來的list
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 session.getTransaction().rollback(); 
			 throw new RuntimeException("查詢 Admin 失敗", e);
		} 
		
	}

	@Override
	public AdminVO findByPrimaryKey(Integer admId) {
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		    try {
		        session.beginTransaction();
		        // 使用 session.get 直接從資料庫抓取對應主鍵的資料
		        AdminVO adminVO = session.get(AdminVO.class, admId);
		        session.getTransaction().commit();
		        return adminVO;
		    } catch (Exception e) {
		        session.getTransaction().rollback();
		        throw new RuntimeException("查詢 Admin by admID 失敗", e);
		    }
	}

	@Override
	public List<AdminVO> getByStatus(Byte admStatus) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<AdminVO> list = session.createQuery("from AdminVO where admStatus = :admstatus", AdminVO.class).setParameter("admstatus", admStatus).getResultList();
			session.getTransaction().commit();
			return list;
		}catch(Exception e) {
			session.getTransaction().rollback(); 
			 throw new RuntimeException("查詢 Admin by 狀態 失敗", e);
		}
	}
	
	@Override
	public void insert(AdminVO adminVo) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.persist(adminVo);
			session.getTransaction().commit();
		}catch(Exception e) {
			session.getTransaction().rollback(); 
			 throw new RuntimeException("新增 Admin 失敗", e);
		}
		
	}

	@Override
	public void update(AdminVO adminVo) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.merge(adminVo);
			session.getTransaction().commit();
		}catch(Exception e) {
			session.getTransaction().rollback(); 
			 throw new RuntimeException("更新 Admin 失敗", e);
		}
	}

	@Override
	public void resetAdminPw(Integer admId, String newPw) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();

			AdminVO adminVO = session.get(AdminVO.class, admId);
			if(adminVO != null) {
					adminVO.setAdmPw(newPw);
			}
			
			session.getTransaction().commit();
			}catch(Exception e) {
			session.getTransaction().rollback(); 
			 throw new RuntimeException("更改密碼 失敗", e);
		}
		
	}

	@Override
	public AdminVO findByAcc(String admAcc) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			AdminVO adminVO = session.createQuery("from AdminVO where admAcc = :admAcc", AdminVO.class).setParameter("admAcc", admAcc).uniqueResult();
			//Returns:			the single result or null if there is no result to return
			session.getTransaction().commit();
			
			return adminVO;
		} catch (Exception e) {
			session.getTransaction().rollback(); 
			 throw new RuntimeException("更改密碼 失敗", e);
		}	
	}

	@Override
	public AdminVO Loginasadmin(String admAcc, String admPw) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 try {
			session.beginTransaction();
			AdminVO adminVO = session.createQuery("from AdminVO where admAcc =:admAcc and admPw = :admPw", AdminVO.class) //這行已經 查帳密是否正確
					.setParameter("admAcc", admAcc)
					.setParameter("admPw", admPw)
					.uniqueResult();
			//寫個觀念HQL裡面的 :admPw = setParameter裡面的"admPw" 
			session.getTransaction().commit();;
			
					return adminVO;
		} catch (Exception e) {
			session.getTransaction().rollback();
			 throw new RuntimeException("登入 失敗", e);
		}

	}


	
        
	
}
