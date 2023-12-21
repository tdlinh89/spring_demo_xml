package fpt.fa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fpt.fa.entities.LopHoc;
import fpt.fa.service.LopHocService;

@Controller
@RequestMapping(value = "/lophoc")
public class LopHocController {
	@Autowired
	private LopHocService service;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<LopHoc> lophocs = service.getList();
		System.out.println("Call Lop hoc list");
		model.addAttribute("lopHocs", lophocs);
		return "lophoc/list";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String displayCreate(Model model) {
		model.addAttribute("lopHoc", new LopHoc());
		return "lophoc/create";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute LopHoc lophoc, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "lophoc/create";
		}
		service.save(lophoc);
		return "redirect:/lophoc/list";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String displayUpdate(@RequestParam String id, Model model) {
		model.addAttribute("updateLopHoc", service.getLopHocById(id));
		return "lophoc/update";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute(name = "updateLopHoc") LopHoc lophoc, Model model) {
		service.update(lophoc);
		return "redirect:/lophoc/list";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam String id, Model model) {
		service.deleteById(id);
		return "redirect:/lophoc/list";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@RequestParam(name = "id") LopHoc lophoc, Model model) {
		model.addAttribute("lophoc", lophoc);
		return "/lophoc/detail";
	}
}
