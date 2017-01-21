package com.personal.website;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class MyRestController {

    private final String response = "<html>\n" +
            "<header><title>This is title</title></header>\n" +
            "<body>\n" +
            "Hello world\n" +
            "</body>\n" +
            "</html>";

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return response;
    }

}