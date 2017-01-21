package com.personal.website;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class MyRestController {

    public MyRestController(){}

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "Hello World!";
    }

}