package com.etc.utils;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class UploadUtil {
    public static List<String> doUpload(HttpServletRequest request, MultipartFile[] files) throws IOException {
        String savePath = request.getServletContext().getRealPath("/WEB-INF/upload");
        List<String> filePaths=new ArrayList<>();
        File dir = new File(savePath);
        if(!dir.exists()){
            dir.mkdir();
        }
        for(MultipartFile file:files){
            if(!file.isEmpty()){
                System.out.println("file.getName:" + file.getName() + ",file.getOriginalFilename():"
                        + file.getOriginalFilename());
                File file1=new File(savePath + File.separator + file.getOriginalFilename());
                file.transferTo(file1);
                String filename=file1.getName();
                filePaths.add(filename);
            }
        }
        return filePaths;
    }

    public static ResponseEntity<byte[]> doDownload(HttpServletRequest request,String filename) throws IOException{
        String path = request.getServletContext().getRealPath("/WEB-INF/upload");
        File file = new File(path + File.separator + filename);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", URLEncoder.encode(filename,"UTF-8"));
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);
    }
}
