package com.hongyi.web;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class FileUpLoadController {
    @RequestMapping("/fileupload1")
    public String fileupload1(HttpServletRequest request) throws Exception{
        String path = request.getSession().getServletContext().getRealPath("/images/");
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        //创建磁盘文件项工厂
        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
        //利用servlet文件上传对象解析请求对象
        ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
        List<FileItem> items = fileUpload.parseRequest(request);
        //遍历文件项
        for (FileItem item:items) {
            if(item.isFormField()){
                String name = item.getString();
                System.out.println(name);
            }else{
                String filename = item.getName();
                String s = UUID.randomUUID().toString().replaceAll("-", "");
                item.write(new File(path,s+filename));
            }
        }

        return "success";
    }
    @RequestMapping("/fileupload2")
    public String fileupload2(HttpServletRequest request, MultipartFile file) throws Exception{
        String path = request.getSession().getServletContext().getRealPath("/images/");
        File f = new File(path);
        if(!f.exists()){
            f.mkdirs();
        }
        String filename = file.getOriginalFilename();
        String s = UUID.randomUUID().toString().replaceAll("-", "");
        file.transferTo(new File(path,s+filename));
        return "success";
    }
    @RequestMapping("/fileupload3")
    public String fileupload3(HttpServletRequest request, MultipartFile[] files) throws Exception{
        /*String path = request.getSession().getServletContext().getRealPath("/images/");
        File f = new File(path);
        if(!f.exists()){
            f.mkdirs();
        }*/
        for (MultipartFile file:files) {
            String filename = file.getOriginalFilename();
            String s = UUID.randomUUID().toString().replaceAll("-", "");
            file.transferTo(new File("D:\\softWarePath\\java\\apache-tomcat-9.0.20\\webapps\\files\\images",s+filename));
        }
        return "success";
    }

    @RequestMapping("/fileupload4")
    public String fileupload4(HttpServletRequest request, MultipartFile[] files) throws Exception{
        String path = "http://localhost:9999/image_files_war/";
        for (MultipartFile file:files) {
            String filename = file.getOriginalFilename();
            String suffix = filename.substring(filename.lastIndexOf("."));
            filename = UUID.randomUUID().toString().replaceAll("-", "")+suffix;
            Client client = new Client();
            WebResource resource = client.resource(path+filename);
            resource.put(file.getBytes());
        }
        return "success";
    }
}
