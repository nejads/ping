package com.personal.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class RestController {

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String home() {
        return "Hello World!";
    }

}