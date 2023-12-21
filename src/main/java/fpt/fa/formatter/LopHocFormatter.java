package fpt.fa.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import fpt.fa.entities.LopHoc;
import fpt.fa.service.LopHocService;

@Component
public class LopHocFormatter implements Formatter<LopHoc>{
	@Autowired
	private LopHocService lopHocService;
	
	@Override
	public String print(LopHoc object, Locale locale) {
		// TODO Auto-generated method stub
		return object.toString();
	}

	@Override
	public LopHoc parse(String text, Locale locale) throws ParseException {
		// TODO Auto-generated method stub
		return lopHocService.getLopHocById(text);
	}
	

}
