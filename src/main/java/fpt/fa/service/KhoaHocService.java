package fpt.fa.service;

import java.util.List;
import java.util.Set;

import fpt.fa.entities.KhoaHoc;

public interface KhoaHocService {
	void save(KhoaHoc khoaHoc);
	void update(KhoaHoc khoaHoc);
	KhoaHoc getKhoaHocById(String id);
	List<KhoaHoc> getList();
	void deleteById(String id);
	List<String> findAllMaKhoa();
	List<KhoaHoc> getKhoaHocByName(String name);
	Set<KhoaHoc> getAllKhoaHocByLopHoc(String maLop);
}
