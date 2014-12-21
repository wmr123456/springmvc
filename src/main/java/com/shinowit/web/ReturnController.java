package com.shinowit.web;

import com.shinowit.entity.UserEntity;
import com.shinowit.framework.dao.BaseDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.annotation.Resource;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 * Created by Administrator on 2014/12/19.
 */
@Controller
public class ReturnController {
    @Resource
    private BaseDAO<UserEntity> userdao;
    @RequestMapping(value = "ok")
    public ModelAndView test1(@ModelAttribute UserEntity userEntity){
        userEntity.setName("王茂瑞");
        ModelAndView result = new ModelAndView();
        result.setViewName("ok");
        result.addObject("key", "value of key");
        return result;
    }
    @RequestMapping(value="/test2")
    public View test2(Model model){
        List<UserEntity> userlist =userdao.listAll(UserEntity.class);
        model.addAttribute("data",userlist);
        UserEntityExcelView result = new UserEntityExcelView();
        return result;
    }
    @RequestMapping(value = "/test3")
    public String test3(Model model){
        model.addAttribute("key","hehehhehehhehehehh");
        return "return";
    }

    @RequestMapping(value = "test4")
    public void test4(Writer writer){
        try{
            writer.write("hello!");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "test5")
    public @ResponseBody UserEntity test5(){
        UserEntity user = new UserEntity();
        user.setName("Bob");
        return user;
    }
    @RequestMapping(value = "test6")
    public UserEntity test6(){
        UserEntity user = new UserEntity();
        user.setName("alice");
        return user;
    }
}
