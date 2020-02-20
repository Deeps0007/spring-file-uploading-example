package com.example.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class UploadFileController {

	private String folderFile= "D://Files//";
	
	
	@GetMapping("/")
	public String info()
	{
		return "Please Upload a file";
	}
	
	
	@PostMapping("/upload")
	public String fileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes )     
	{
		if(file.isEmpty())
		{
			 redirectAttributes.addFlashAttribute("msg","Please select a to upload");
			 return "redirect:/status";
			 
		}
		
		try {
			byte[] byteFile=file.getBytes();
			Path path=Paths.get(folderFile, file.getOriginalFilename());
			Files.write(path, byteFile);
			
			redirectAttributes.addFlashAttribute("msg", "File name as :"+file.getOriginalFilename()+"successfully uploaded");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "redirect:/status";
	}
	
	
	@GetMapping("/status")
	public String fileStatus()
	{
		return "Ok ";
		
	}
	
	
}
