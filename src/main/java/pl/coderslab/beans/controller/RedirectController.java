package pl.coderslab.beans.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

    @GetMapping("/first")
    public String first() {
        return "first.jsp";
    }

    @GetMapping("/third")
    public String third(){
        return "third.jsp";
    }

    @GetMapping("/second")
    public String toThird(){
        return "third";
    }
}
