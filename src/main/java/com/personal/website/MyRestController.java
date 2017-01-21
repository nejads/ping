package com.personal.website;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class MyRestController {

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String home() {
        return "Hello World!";
    }

}