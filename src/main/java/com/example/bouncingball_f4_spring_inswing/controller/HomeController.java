package com.example.bouncingball_f4_spring_inswing.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
public class HomeController {

    @GetMapping("/index")
    public String index() {
        return ("templates/index.html");
    }
   //downlowd video file from template
    @GetMapping("/download_file")
    public void download(HttpServletResponse response) throws IOException {
        File file = new File("src/main/resources/templates/balls.mp4");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
        response.setContentLength((int) file.length());
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }
//open zip file from template
    @GetMapping("/open_file")
    public void open(HttpServletResponse response) throws IOException {
        File file = new File("src/main/resources/templates/DvdBall.jar");
        response.setContentType("application/jar");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
        response.setContentLength((int) file.length());
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }

}








