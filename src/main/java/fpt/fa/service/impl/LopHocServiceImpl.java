package fpt.fa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.fa.entities.LopHoc;
import fpt.fa.repository.LopHocRepository;
import fpt.fa.service.LopHocService;

@Service
public class LopHocServiceImpl implements LopHocService {
	@Autowired
	private LopHocRepository repository;

	@Override
	public void save(LopHoc lopHoc) {
		repository.save(lopHoc);
	}

	@Override
	public void update(LopHoc lopHoc) {
		repository.save(lopHoc);
	}

	@Override
	public LopHoc getLopHocById(String id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<LopHoc> getList() {
		// TODO Auto-generated method stub
		return (List<LopHoc>) repository.findAll();
	}

	@Override
	public void deleteById(String id) {
		repository.deleteById(id);
		
	}

}
