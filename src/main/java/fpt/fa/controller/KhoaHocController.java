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

import fpt.fa.entities.KhoaHoc;
import fpt.fa.service.KhoaHocService;

@Controller
@RequestMapping(value = "/khoahoc")
public class KhoaHocController {
	@Autowired
	private KhoaHocService service;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<KhoaHoc> khoahocs = service.getList();
		model.addAttribute("khoaHocs", khoahocs);
		return "khoahoc/list";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String displayCreate(Model model) {
		model.addAttribute("lopHoc", new KhoaHoc());
		return "khoahoc/create";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute KhoaHoc khoahoc, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "khoahoc/create";
		}
		service.save(khoahoc);
		return "redirect:/khoahoc/list";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String displayUpdate(@RequestParam String id, Model model) {
		model.addAttribute("updateKhoaHoc", service.getKhoaHocById(id));
		return "khoahoc/update";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute(name = "updateKhoaHoc") KhoaHoc khoahoc, Model model) {
		service.update(khoahoc);
		return "redirect:/khoahoc/list";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam String id, Model model) {
		service.deleteById(id);
		return "redirect:/khoahoc/list";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@RequestParam(name = "id") KhoaHoc khoahoc, Model model) {
		model.addAttribute("khoahoc", khoahoc);
		return "/khoahoc/detail";
	}
}
