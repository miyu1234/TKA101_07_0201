package com.emp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AdminJDBCDAO implements AdminDAO_interface {
	//Connection 相關
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/xxxx";
	String userid= "root";
	String passwd = "123456";
	
	
	
	
	//prepareSTMT 系列 CURD>
	private static final String INSERT_STMT =  "INSERT INTO ADMIN(ADM_ACC, ADM_PW, ADM_NAME,  HIREDATE, ADM_STATUS)  VALUES(?, ?, ?, ?, ?)";
	private static final String UPDATE_STMT = "UPDATE ADMIN SET ADM_ACC=? , ADM_PW=? ADM_NAME=?, HIREDATE = ? , ADM_STATUS=? WHERE ADM_ID=?"; //用ADM_ID 去更新資料
	private static final String GETALL_STMT = " SELECT ADM_ACC, ADM_PW, ADM_NAME,  HIREDATE, ADM_STATUS FROM ADMIN OBER BY ADM_ID"; //GET ALL
	private static final String GETONE_STMT = " SELECT ADM_ID , ADM_ACC, ADM_PW, ADM_NAME,  HIREDATE, ADM_STATUS FROM ADMIN WHERE ADM_ID = ?"; //GET ALL
	private static final String GETUSERLISTBYSTATUS_STMT = " SELECT ADM_ID, ADM_ACC, ADM_PW, ADM_NAME,  HIREDATE, ADM_STATUS FROM ADMIN WHERE ADM_STATUS = ?"; //GET ALL
	
	
	
	@Override
	public List<AdminVO> getAll() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid , passwd);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
		return null;
	}

	@Override
	public AdminVO findByPrimaryKey(Integer admId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdminVO> getByStatus(Byte admStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(AdminVO adminVo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(AdminVO adminVo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetAdminPw(Integer admId, String newPw) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AdminVO findByAcc(String admAcc) {
		// TODO Auto-generated method stub
		return null;
	}

}
