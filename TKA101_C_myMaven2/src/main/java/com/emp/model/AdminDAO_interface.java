package com.emp.model;

import java.util.List;

public interface AdminDAO_interface {
		
	public List<AdminVO> getAll(); //1.先做getAll List all
	public AdminVO findByPrimaryKey(Integer admId );  //用admID找人
	public List<AdminVO> getByStatus(Byte admStatus); //用admStatus找出請單
	
	public void insert (AdminVO adminVo); //加人
	public void update (AdminVO adminVo); //更新
	
	public void resetAdminPw(Integer admId, String newPw); //更改密碼
	public AdminVO findByAcc(String admAcc) ;
	public AdminVO Loginasadmin(String admAcc, String admPw);
	
}
