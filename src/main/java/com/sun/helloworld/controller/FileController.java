package com.sun.helloworld.controller;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/file")
public class FileController {
	
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);
	
	
	@RequestMapping(value = "/upload")
	public String upload(@RequestParam("roncooFile") MultipartFile file) {
		
		String msg = "";
		
		if(file.isEmpty()) {
			return "文件为空";
		}
		
		//获取文件名
		String fileName = file.getOriginalFilename();
		logger.info("上传的文件名为：" + fileName);
		
		String suffixName = fileName.substring(fileName.lastIndexOf("."));
		logger.info("上传的后缀名为：" + suffixName);
		
		//解决中文问题，liunx下中文路径，图片显示
		String filePath = "D:\\Edu\\ROOT";
		
		File dest = new File(filePath + fileName); 
		
		//检测是否存在目录
		if(!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}
		
		try {
			
			file.transferTo(dest);
			msg =  "上传成功";
			
		} catch (Exception e) {
			e.printStackTrace();
			
			msg = "上传失败：" + e.getMessage();
		}
		
		return msg;
	}
	
}
















