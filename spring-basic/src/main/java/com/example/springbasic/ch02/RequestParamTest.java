package com.example.springbasic.ch02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class RequestParamTest {
    @RequestMapping("/requestParam")
    public String main(HttpServletRequest request) {
        String year = request.getParameter("year");
        System.out.printf("[%s]year=[%s]%n", new Date(), year);
        return "yoil";
    }

    @RequestMapping("/rqeustParam2")
    public String main2(String year) {
        System.out.printf("[%s]year=[%s]%n", new Date(), year);
        return "yoil";
    }

    @RequestMapping("/requestParam3")
    public String main3(@RequestParam String year) {
        System.out.printf("[%s]year=[%s]%n", new Date(), year);
        return "yoil";
    }

    @RequestMapping("/requestParam4")
    public String main4(@RequestParam(required = false) String year) {
        System.out.printf("[%s]year=[%s]%n", new Date(), year);
        return "yoil";
    }

    @RequestMapping("/requestParam5")
    public String main5(@RequestParam(required=false, defaultValue="1") String year) {
        System.out.printf("[%s]year=[%s]%n", new Date(), year);
        return "yoil";
    }

    @RequestMapping("/requestParam6")
    public String main6(int year) {
//		http://localhost/ch2/requestParam6        ---->> 500 java.lang.IllegalStateException: Optional int parameter 'year' is present but cannot be translated into a null value due to being declared as a primitive type. Consider declaring it as object wrapper for the corresponding primitive type.
//		http://localhost/ch2/requestParam6?year   ---->> 400 Bad Request, nested exception is java.lang.NumberFormatException: For input string: ""
        System.out.printf("[%s]year=[%s]%n", new Date(), year);
        return "yoil";
    }

    @RequestMapping("/requestParam7")
    public String main7(@RequestParam int year) {
//		http://localhost/ch2/requestParam7        ---->> 400 Bad Request, Required int parameter 'year' is not present
//		http://localhost/ch2/requestParam7?year   ---->> 400 Bad Request, nested exception is java.lang.NumberFormatException: For input string: ""
        System.out.printf("[%s]year=[%s]%n", new Date(), year);
        return "yoil";
    }

    @RequestMapping("/requestParam8")
    public String main8(@RequestParam(required=false) int year) {
        //	http://localhost/ch2/requestParam8        ---->> 500 java.lang.IllegalStateException: Optional int parameter 'year' is present but cannot be translated into a null value due to being declared as a primitive type. Consider declaring it as object wrapper for the corresponding primitive type.
        //	http://localhost/ch2/requestParam8?year   ---->> 400 Bad Request, nested exception is java.lang.NumberFormatException: For input string: ""
        System.out.printf("[%s]year=[%s]%n", new Date(), year);
        return "yoil";
    }

    @RequestMapping("/requestParam9")
    public String main9(@RequestParam(required=true) int year) {
        //	http://localhost/ch2/requestParam9        ---->> 400 Bad Request, Required int parameter 'year' is not present
        //	http://localhost/ch2/requestParam9?year   ---->> 400 Bad Request, nested exception is java.lang.NumberFormatException: For input string: ""
        System.out.printf("[%s]year=[%s]%n", new Date(), year);
        return "yoil";
    }

    @RequestMapping("/requestParam10")
    public String main10(@RequestParam(required=true, defaultValue="1") int year) {
        //	http://localhost/ch2/requestParam10        ---->> year=1
        //	http://localhost/ch2/requestParam10?year   ---->> year=1
        System.out.printf("[%s]year=[%s]%n", new Date(), year);
        return "yoil";
    }

    @RequestMapping("/requestParam11")
    public String main11(@RequestParam(required=false, defaultValue="1") int year) {
//		http://localhost/ch2/requestParam11        ---->> year=1
//		http://localhost/ch2/requestParam11?year   ---->> year=1
        System.out.printf("[%s]year=[%s]%n", new Date(), year);
        return "yoil";
    }
}
