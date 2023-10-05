package com.example.springbasic.ch02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;

@Controller
public class RegisterController {
//    @RequestMapping("/register/add")
    @GetMapping("/register/add")
    public String register() {
        return "registerForm"; // WEB-INF/views/registerForm.jsp
    }

    @PostMapping("/register/save")
//    @RequestMapping(value = "/register/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("user") User user, Model m) {
        // 1. 유효성 검사
//        if(!isValid(user)) {
//            String msg = URLEncoder.encode("id를 잘못입력하셨습니다.", "utf-8");
//
//            m.addAttribute("msg", msg);
//            return "redirect:/register/add"; // 신규회원 가입화면으로 이동(redirect)
//        }

        return "registerInfo";
    }
}
