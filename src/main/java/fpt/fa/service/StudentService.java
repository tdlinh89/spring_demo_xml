package fpt.fa.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import fpt.fa.entities.Student;
import fpt.fa.form.DangKyKhoaHocForm;

public interface StudentService {
	void save(Student student);
	void update(Student student);
	Student getStudentById(String id);
	List<Student> getList();
	void deleteById(String id);
	void dangKyKhoaHoc(DangKyKhoaHocForm form);
	List<Student> getAllStudentByMaLop(String maLop);
	List<Student> getAllStudentByMaLopAndAge(String maLop, int age);
}
