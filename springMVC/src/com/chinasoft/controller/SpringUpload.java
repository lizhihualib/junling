package com.chinasoft.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("/upload")
public class SpringUpload {
	@RequestMapping("/toFile")
	public String toFile(){
		
		return "view/file";
	}
	
	@RequestMapping("/uploadFile")
	public void uploadFile(@RequestParam(required=false) CommonsMultipartFile file,HttpServletRequest req ,String name) throws IOException{
		String fileName=file.getOriginalFilename();
		
		File dirPath=new File(req.getServletContext().getRealPath("/")+
						"/upload/");
		if(!dirPath.exists())
			dirPath.mkdir();
		
		File filePath=new File(dirPath, fileName);
		if(!filePath.exists())
			filePath.createNewFile();
		//保存文件
		file.transferTo(filePath);
		
//		System.out.println(dirPath.getPath());
//		FileOutputStream fos=new FileOutputStream(dirPath.getPath()+"/"+fileName);
//		InputStream in=file.getInputStream();
//		int temp=0;
//		while((temp=in.read())!=-1){
//			fos.write(temp);
//		}
//		fos.close();
		//
	
	}
	@RequestMapping("/downLoad")
	public void downLoad(String filePath,HttpServletRequest req , HttpServletResponse response, boolean isOnLine) throws Exception {
	    File f = new File(req.getServletContext().getRealPath("/")+filePath);
	    if (!f.exists()) {
	      response.sendError(404, "File not found!");
	      return;
	    }
	    BufferedInputStream br = new BufferedInputStream(new FileInputStream(f));
	    byte[] buf = new byte[1024];
	    int len = 0;
	 
	    response.reset(); // 非常重要
	    if (isOnLine) { // 在线打开方式
	      URL u = new URL("file:///" + filePath);
	      response.setContentType(u.openConnection().getContentType());
	      response.setHeader("Content-Disposition", "inline; filename=" + f.getName());
	      // 文件名应该编码成UTF-8
	    } else { // 纯下载方式
	      response.setContentType("application/x-msdownload");
	      response.setHeader("Content-Disposition", "attachment; filename=" + f.getName());
	    }
	    OutputStream out = response.getOutputStream();
	    while ((len = br.read(buf)) > 0)
	      out.write(buf, 0, len);
	    br.close();
	    out.close();
	  }
}
