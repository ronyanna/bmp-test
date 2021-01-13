package com.bmp.controller;

import com.bmp.service.TextProcessorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
public class UserController {

    private Logger log= LoggerFactory.getLogger(UserController.class);

    private PasswordEncoder passwordEncoder;

    @Autowired
    private TextProcessorService textProcessor;


    public UserController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping({"/hello"})
    public String hello(){
        return "Hello World";
    }


    @PostMapping(path="/searchText",consumes = "application/json")
    public ResponseEntity<Map>searchText(@RequestBody Map<String,Object> dataTask){
         Map<String,Object> textCountMap=textProcessor.findTextCount(dataTask);
        return ResponseEntity.ok(textCountMap);

    }

    @PostMapping(path="/searchText/{count}",consumes = "application/json",produces = "application/pdf")
    public ResponseEntity<byte[]>searchTopCountedText(HttpServletResponse response, @PathVariable int count, @RequestBody Map<String,Object>dataTask) throws IOException {
        Map<String,Object> mp=new HashMap<>();
        byte[] bytes=textProcessor.findWordCountAndWriteInCsv(dataTask);
        response.setHeader("Expires", "0");
        response.setHeader("Cache-Control",
                "must-revalidate, post-check=0, pre-check=0");
        response.setHeader("Pragma", "public");
        // setting the content type
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        // the contentlength
        response.setContentLength(bytes.length);
        response.setHeader("Content-Disposition", "attachment; filename=\"" + "word Count.xlsx" + "\"");
        return new ResponseEntity(bytes, HttpStatus.OK);

    }

}
