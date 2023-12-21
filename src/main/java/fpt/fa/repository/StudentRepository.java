package fpt.fa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fpt.fa.entities.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {
	@Query("Select s from Student s where s.lopHoc.maLop = :maLop")
	List<Student> getAllStudentByMaLop(@Param(value = "maLop") String maLop);
	
	@Query("Select s from Student s where s.lopHoc.maLop = :maLop and s.age = :age")
	List<Student> getAllStudentByMaLopAndAge(@Param(value = "maLop") String maLop,
			@Param(value = "age") int age);
}
