package com.emp.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ADM_FUNCTION")

public class AdmFuncVO  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id //PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AI
	@Column(name = "FUNC_ID" , updatable = false )
	private Integer funcNo;
	
	@Column(name = "FUNC_NAME" )
	private String funcName;

	public AdmFuncVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getFuncNo() {
		return funcNo;
	}

	public void setFuncNo(Integer funcNo) {
		this.funcNo = funcNo;
	}

	public String getFuncName() {
		return funcName;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

	@Override
	public String toString() {
		return "AdmFuncVO [funcNo=" + funcNo + ", funcName=" + funcName + "]";
	}


	
	
	
}
