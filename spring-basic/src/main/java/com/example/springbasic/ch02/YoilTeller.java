

package com.example.springbasic.ch02;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

@Controller
public class YoilTeller {
    @RequestMapping("/getYoil") // http://localhost:8080/getYoil?year=2021&month=10&day=1
//        public static void main(String[] args)
    public void getYoil(HttpServletRequest req, HttpServletResponse res) throws IOException {
            // 1. 입력
//        String year = args[0];
//        String month = args[1];
//        String day = args[2];

            System.out.println("breakpoint");

            System.out.println("breakpoint1");

            String year = req.getParameter("year");
            String month = req.getParameter("month");
            String day = req.getParameter("day");

            int yyyy = Integer.parseInt(year);
            int mm = Integer.parseInt(month);
            int dd = Integer.parseInt(day);

            // 2. 처리
            Calendar cal = Calendar.getInstance();
            cal.set(yyyy, mm - 1, dd);

            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
            char yoil = " 일월화수목금토".charAt(dayOfWeek);   // 일요일:1, 월요일:2, ...

            // 3. 출력
//        System.out.println(year + "년 " + month + "월 " + day + "일은 ");
//        System.out.println(yoil + "요일입니다.");
            res.setContentType("text/html");    // 응답의 형식을 html로 지정
            res.setCharacterEncoding("utf-8");  // 응답의 인코딩을 utf-8로 지정
            PrintWriter out = res.getWriter();  // 브라우저로의 출력 스트림(out)을 얻는다.
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");
            out.println("<body>");
            out.println(year + "년 " + month + "월 " + day + "일은 ");
            out.println(yoil + "요일입니다.");
            out.println("</body>");
            out.println("</html>");
            out.close();
//        }
    }
}