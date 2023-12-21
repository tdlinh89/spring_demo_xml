package fpt.fa.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fpt.fa.entities.KhoaHoc;
import fpt.fa.entities.Student;
import fpt.fa.form.DangKyKhoaHocForm;
import fpt.fa.service.KhoaHocService;
import fpt.fa.service.LopHocService;
import fpt.fa.service.StudentService;
import fpt.fa.validated.StudentValided;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
	@Autowired
	StudentService studentService;
	@Autowired
	LopHocService lopHocService;
	@Autowired
	KhoaHocService khoaHocService;
	
//	@InitBinder
//	private void initBinder(WebDataBinder binder) {
//		binder.setValidator(validator);
//	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model, @RequestParam(value = "maLop", required = false) String maLop,
			@RequestParam(value = "age", required = false, defaultValue = "0") int age) {
		List<Student> students;
		if (maLop != null && !maLop.isEmpty()) {
			if (age != 0) {
				students = studentService.getAllStudentByMaLopAndAge(maLop, age);
			} else {
				students = studentService.getAllStudentByMaLop(maLop);
			}
		} else {
			students = studentService.getList();
		}
		

		Set<String> ages = new HashSet();
		ages.add("");
		studentService.getList().stream().forEach(st -> ages.add(st.getAge()+""));
		model.addAttribute("listStudents", students);
		model.addAttribute("lopHocs", lopHocService.getList());
		model.addAttribute("ages", ages);
		return "student/list";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String displayCreate(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("lopHocs", lopHocService.getList());
		return "student/create";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@Validated @ModelAttribute Student student, BindingResult bindingResult, Model model) {
		StudentValided valided = new StudentValided();
		valided.validate(student, bindingResult);
		if (bindingResult.hasErrors()) {
			model.addAttribute("lopHocs", lopHocService.getList());
			return "student/create";
		}
		studentService.save(student);
		return "redirect:/student/list";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String displayUpdate(@RequestParam String id, Model model) {
		model.addAttribute("updateStudent", studentService.getStudentById(id));
		return "student/update";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute(name = "updateStudent") Student student, Model model) {
		studentService.update(student);
		return "redirect:/student/list";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam String id, Model model) {
		studentService.deleteById(id);
		return "redirect:/student/list";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@RequestParam(name = "id") Student student, Model model) {
		model.addAttribute("student", student);
		return "/student/detail";
	}
	
	@RequestMapping(value = "/createKhoaHoc", method = RequestMethod.GET)
	public String displayCreateKhoaHoc(Model model) {
		model.addAttribute("students", studentService.getList());
		model.addAttribute("khoaHocs", khoaHocService.getList());
		model.addAttribute("dangKyKhoaHoc", new DangKyKhoaHocForm());
		Set<KhoaHoc> khoaHocs = khoaHocService.getAllKhoaHocByLopHoc("Lop001");
		return "student/dangkykhoahoc";
	}
	
	@RequestMapping(value = "/createKhoaHoc", method = RequestMethod.POST)
	public String createKhoaHoc(@ModelAttribute(name = "dangKyKhoaHoc")DangKyKhoaHocForm form, Model model) {
		model.addAttribute("dangKyKhoaHoc", new DangKyKhoaHocForm());
		
		studentService.dangKyKhoaHoc(form);
		return "student/dangkykhoahoc";
	}
}
