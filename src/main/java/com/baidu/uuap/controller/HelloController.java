package com.baidu.uuap.controller;

import com.baidu.uuap.pojo.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

//    @RequestMapping("/")
//    public String index() {
//        return "Greetings from Spring Boot!";
//    }


    @RequestMapping("/hello")
    public String index(Model model) {
        Msg msg = new Msg("title", "content", "msg");
        model.addAttribute("msg", msg);

        return "hello";
    }
}