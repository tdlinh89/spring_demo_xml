package fpt.fa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.fa.entities.KhoaHoc;
import fpt.fa.entities.Student;
import fpt.fa.form.DangKyKhoaHocForm;
import fpt.fa.repository.StudentRepository;
import fpt.fa.service.KhoaHocService;
import fpt.fa.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	KhoaHocService khoaHocService;
	
	private StudentRepository repository; 

	// constructor injection
	@Autowired
	public StudentServiceImpl(StudentRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void save(Student student) {
		this.repository.save(student);
	}

	@Override
	public void update(Student student) {
		this.repository.save(student);
	}

	@Override
	public Student getStudentById(String id) {
		return this.repository.findById(id).orElse(null);
	}

	@Override
	public List<Student> getList() {
		return (List<Student>) this.repository.findAll();
	}

	@Override
	public void deleteById(String id) {
		this.repository.deleteById(id);
	}

	@Override
	public void dangKyKhoaHoc(DangKyKhoaHocForm form) {
		Student student = this.getStudentById(form.getStudentId());
		KhoaHoc khoaHoc = this.khoaHocService.getKhoaHocById(form.getMaKhoa());
		student.getKhoaHocs().add(khoaHoc);
		this.save(student);
	}

	@Override
	public List<Student> getAllStudentByMaLop(String maLop) {
		// TODO Auto-generated method stub
		return this.repository.getAllStudentByMaLop(maLop);
	}

	@Override
	public List<Student> getAllStudentByMaLopAndAge(String maLop, int age) {
		// TODO Auto-generated method stub
		return this.repository.getAllStudentByMaLopAndAge(maLop, age);
	}

}
