package fpt.fa.validated;


import java.util.Date;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fpt.fa.entities.Student;

public class StudentValided implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		Student student = (Student) target;
		Date birthday = student.getBirthday();
		if (birthday == null) {
			errors.rejectValue("birthday", "error.birthday", null, "Nhập sai format ngày");
		} else if (birthday.after(new Date())) {
			errors.rejectValue("birthday", "error.birthday", null, "Ngày sinh lớn hơn hiện tại");
		}
	}

}
