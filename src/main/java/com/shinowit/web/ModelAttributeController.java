package com.shinowit.web;

import com.shinowit.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org. springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.Binding;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2014/12/17.
 */
@Controller
@RequestMapping(value = "modelAttr")
public class ModelAttributeController {
    @ModelAttribute
    public UserEntity initUser(){
        System.out.println("initUser method invoked>>>>>>>>>>>>>>>>>>>>>>");
        UserEntity u = new UserEntity();
        u.setName("abc");
        return u;
    }

    @RequestMapping(value = "test1")
    public String test1(){
     return "/model/ok";
    }

    @RequestMapping(value = "test2")
    public String test2(){
        return "/model/ok";
    }

    @RequestMapping(value = "test3")
    public String test3(@ModelAttribute UserEntity user){
        user.setName("abcd");
        return "/model/ok";
    }

    @RequestMapping(value = "test4")
    public String test4(HttpServletRequest request){
       UserEntity u = new UserEntity();
        u.setName("aaaaaaa");
        request.getSession(true).setAttribute("userEntity",u);
        return "/model/ok";
    }

    @RequestMapping(value = "test5")
    public String test5(@ModelAttribute UserEntity user,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:/html/login1.html";
        }
        return "success";
    }
}
