

package com.example.springbasic.ch02;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

@Controller
public class YoilTellerMVC {
        @RequestMapping("/getYoilMVC") // http://localhost:8080/getYoilMVC?year=2021&month=10&day=1
        public String Yoil(int year, int month, int day, Model model) {

                // 1. 유효성 검사
                if(!isValid(year, month, day))
                        return "yoilError";  // 유효하지 않으면, /WEB-INF/views/yoilError.jsp로 이동

                // 2. 요일 계산
                char yoil = getYoil(year, month, day);

                // 3. 계산한 결과를 Model 에 작업 결과 저장
                model.addAttribute("year", year);
                model.addAttribute("month", month);
                model.addAttribute("day", day);
                model.addAttribute("yoil", yoil);

                // 4. 작업 결과를 보여줄 View의 이름을 반환
                return "yoil"; // /WEB-INF/views/yoil.jsp
        }

        private char getYoil(int year, int month, int day) {
                Calendar cal = Calendar.getInstance();
                cal.set(year, month - 1, day);

                int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
                return " 일월화수목금토".charAt(dayOfWeek);
        }

        private boolean isValid(int year, int month, int day) {
                if(year==-1 || month==-1 || day==-1)
                        return false;

                return (1<=month && month<=12) && (1<=day && day<=31); // 간단히 체크
        }
}