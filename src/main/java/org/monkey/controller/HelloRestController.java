package org.monkey.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by monkey on 2017/1/5.
 */
@RestController
public class HelloRestController {

    @RequestMapping(value = "/")
    public String Index(){

        return "hello";
    }


}
