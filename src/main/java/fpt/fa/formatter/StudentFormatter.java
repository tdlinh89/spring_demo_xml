package fpt.fa.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import fpt.fa.entities.Student;
import fpt.fa.service.StudentService;

@Component
public class StudentFormatter implements Formatter<Student>{
	@Autowired
	private StudentService studentService;
	
	@Override
	public String print(Student object, Locale locale) {
		// TODO Auto-generated method stub
		return object.toString();
	}

	@Override
	public Student parse(String text, Locale locale) throws ParseException {
		// TODO Auto-generated method stub
		return studentService.getStudentById(text);
	}
	

}
