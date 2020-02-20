package com.example.demo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

	public String handleError(MultipartException exception, RedirectAttributes redirectAttributes)
	{
		redirectAttributes.addFlashAttribute("msg", exception.getCause().getMessage());
		
		return " redirect:/status";		
	}
	


}
