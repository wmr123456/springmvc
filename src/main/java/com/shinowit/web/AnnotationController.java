package com.shinowit.web;

import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2014/12/19.
 */
@Controller
@RequestMapping("/annotionControl")
public class AnnotationController {
    @RequestMapping("/test1")
    public @ResponseBody String test1(){
        return "hello test1";
    }

    @RequestMapping()
    public @ResponseBody String test2(){
        return "hello test2";
    }

    @RequestMapping(value = "test3")
    public @ResponseBody String test3(){
        return "hello test3";
    }

    @RequestMapping(value = "test4",method = RequestMethod.GET)
    public String test4(){
        return "annotionControl/AnnotationController";
    }

    @RequestMapping(value = "test4",method = RequestMethod.POST)
    public @ResponseBody String test5(){
        return "hello test5";
    }

    @RequestMapping(value = "/test6${value}}")
    public @ResponseBody String test6(@PathVariable("value") String value){
        return value;
    }

    @RequestMapping(value = "/test7")
    public @ResponseBody String test7(@RequestParam("key") String inputKey,@RequestParam(value = "age",required = false,defaultValue = "20") int age){
        System.out.println(age);
        return inputKey;
    }
}
