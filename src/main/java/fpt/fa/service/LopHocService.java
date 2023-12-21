package fpt.fa.service;

import java.util.List;

import fpt.fa.entities.LopHoc;

public interface LopHocService {
	void save(LopHoc lopHoc);
	void update(LopHoc lopHoc);
	LopHoc getLopHocById(String id);
	List<LopHoc> getList();
	void deleteById(String id);
}
