package com.emp.model;

import java.util.List;

public interface AdmPerDAO_interface {
	public List<AdmPerVO>getAll();
	public List<AdmPerVO> getByFunc(Integer funcNo);
}
