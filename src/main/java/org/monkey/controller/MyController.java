package org.monkey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by monkey on 2017/1/5.
 */
@Controller
public class MyController {

    @RequestMapping("/hi")
    public @ResponseBody String hiThere(){
        return "hello world!";
    }
}