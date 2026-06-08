package com.emp.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ADMIN")

public class AdminVO implements Serializable {
	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI
	@Column(name = "ADM_ID", updatable = false)
	private Integer admId;

	@Column(name = "ADM_ACC")
	private String admAcc;

	@Column(name = "ADM_PW")
	private String admPw;

	@Column(name = "ADM_NAME")
	private String admName;

	@Column(name = "HIREDATE")
	private Date hireDate;

	@Column(name = "ADM_STATUS")
	private Byte admStatus; // 0=Disable 1 = Enable

	// ------------------FK
	@OneToMany(mappedBy = "adminVO", fetch = FetchType.EAGER)
	private Set<AdmPerVO> admPerVO;
	// -----------------FK

	public AdminVO() {
		super();
	}

	public Integer getAdmId() {
		return admId;
	}

	public void setAdmId(Integer admId) {
		this.admId = admId;
	}

	public String getAdmAcc() {
		return admAcc;
	}

	public void setAdmAcc(String admAcc) {
		this.admAcc = admAcc;
	}

	public String getAdmPw() {
		return admPw;
	}

	public void setAdmPw(String admPw) {
		this.admPw = admPw;
	}

	public String getAdmName() {
		return admName;
	}

	public void setAdmName(String admName) {
		this.admName = admName;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;

	}

	public Byte getAdmStatus() {
		return admStatus;
	}

	public void setAdmStatus(Byte admStatus) {
		this.admStatus = admStatus;
	}

	public Set<AdmPerVO> getAdmPerVO() {
		return admPerVO;
	}

	public void setAdmPerVO(Set<AdmPerVO> admPerVO) {
		this.admPerVO = admPerVO;
	}

	@Override
	public String toString() {
		return "AdminVO [admId=" + admId + ", admAcc=" + admAcc + ", admPw=" + admPw + ", admName=" + admName
				+ ", hireDate=" + hireDate + ", admStatus=" + admStatus + ", admPerVOs=" + admPerVO+ "]";
	}

}
