package com.example.springbasic.ch02;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class TwoDice {
    @RequestMapping("/rollDice")
    public void getDice(HttpServletResponse res) throws IOException {
        int idx1 = (int) (Math.random() * 6 + 1);
        int idx2 = (int) (Math.random() * 6 + 1);

        res.setContentType("text/html");
        res.setCharacterEncoding("utf-8");
        PrintWriter out = res.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<img src='resources/img/dice"+idx1+".jpg'>");
        out.println("<img src='resources/img/dice"+idx2+".jpg'>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
