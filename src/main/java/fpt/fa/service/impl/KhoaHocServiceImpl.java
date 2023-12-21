package fpt.fa.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.fa.entities.KhoaHoc;
import fpt.fa.repository.KhoaHocRepository;
import fpt.fa.service.KhoaHocService;

@Service
public class KhoaHocServiceImpl implements KhoaHocService {
	@Autowired
	private KhoaHocRepository repository;

	@Override
	public void save(KhoaHoc khoaHoc) {
		repository.save(khoaHoc);
	}

	@Override
	public void update(KhoaHoc khoaHoc) {
		repository.save(khoaHoc);
	}

	@Override
	public KhoaHoc getKhoaHocById(String id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<KhoaHoc> getList() {
		return (List<KhoaHoc>) repository.findAll();
	}

	@Override
	public void deleteById(String id) {
		repository.deleteById(id);
	}

	@Override
	public List<String> findAllMaKhoa() {
		// TODO Auto-generated method stub
		return repository.findAllMaKhoa();
	}

	@Override
	public List<KhoaHoc> getKhoaHocByName(String name) {
		// TODO Auto-generated method stub
		return repository.findByTenKhoaContaining(name);
	}

	@Override
	public Set<KhoaHoc> getAllKhoaHocByLopHoc(String maLop) {
		// TODO Auto-generated method stub
		return repository.getAllKhoaHocByLopHoc(maLop);
	}

}
