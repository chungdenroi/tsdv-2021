package spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping(value = "/")
    public String index() {
        return "index";  //render ra file view index.jsp
    }
    @RequestMapping(value = "/hello")
    public String hello() {
        return "hello";
    }
}
