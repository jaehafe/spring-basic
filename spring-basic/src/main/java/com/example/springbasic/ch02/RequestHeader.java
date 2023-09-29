package com.example.springbasic.ch02;

import java.util.Enumeration;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestHeader {
    @RequestMapping("/requestHeader")
    public void Main(HttpServletRequest request) {

        Enumeration<String> e = request.getHeaderNames();

        while (e.hasMoreElements()) {
            String name = e.nextElement();
            System.out.println(name + ":" + request.getHeader(name));
        }
    }
}