package com.kanishk.SpringBootWeb1;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @ModelAttribute("course")
    public String courseName(){
        return "Java";
    }

    @RequestMapping("/home")
    public String home(){
        System.out.println("Home method called...");
        return "index";
    }

    @RequestMapping("/add")
    public ModelAndView add(@RequestParam("num1") int num1, @RequestParam("num2") int num2, ModelAndView mv){
        System.out.println("In Add method...");

        int result = num1 + num2;

        mv.addObject("result", result);
        mv.setViewName("result");

        System.out.println(result);

        return mv;
    }

    @RequestMapping("/addAlien")
    public String add(Alien alien){
        System.out.println("In Add Alien method...");
        return "result";
    }

}
