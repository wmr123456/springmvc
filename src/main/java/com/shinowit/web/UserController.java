package com.shinowit.web;

import com.shinowit.entity.UserEntity;
import com.shinowit.framework.dao.BaseDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2014/12/16.
 */
@Controller
@RequestMapping(value = "/hello")
public class UserController {
    @Resource
    private BaseDAO<UserEntity> userDao;

    @RequestMapping("/test")
    public ModelAndView displayAll(){
        List<UserEntity> list=userDao.listAll(UserEntity.class);
        ModelAndView result=new ModelAndView();
        result.addObject("list",list);
        return result;
    }

    @RequestMapping("/test1")
    public String test1(Model model){
        model.addAttribute("name","张三");
        return "success";
    }

    @RequestMapping("/test2")
    public ModelAndView test2(){
        ModelAndView result = new ModelAndView();
        result.setViewName("success");
        result.addObject("name","张三1");
        return result;
    }

    @RequestMapping( value = "/testLogin")
    public String login(UserEntity user,Map map){
        if(("admin".equals(user.getName()))&&("132456".equals(user.getPassword()))){
            map.put("name","成功");
        }else{
            map.put("name","失败");
        }
        return "success";
    }
    @RequestMapping(value = "testjson")
    @ResponseBody
    public Map<String,Object> testjson(){
        Map<String,Object> map = new ModelMap();
         map.put("user",userDao.listAll(UserEntity.class));
        return map;
    }

    @RequestMapping(value = "/method1")
    public void test3(HttpServletRequest request ,HttpServletResponse response,Model model){
        model.addAttribute("data",request.getRemoteAddr());
        response.setCharacterEncoding("utf-8");
        try{
            response.getWriter().print("hehe");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/method2")
    public String test4(Model model){
        List<UserEntity> users = userDao.listAll(UserEntity.class);
        model.addAttribute("users",users);
        model.addAttribute("user",new UserEntity());
        return "input1";
    }

    @RequestMapping(value = "/method4")
    public String test6(UserEntity user,RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("error_msg","错误！");
        return "redirect:/hello/method2";
    }

    @RequestMapping(value = "/method3")
    public String test5(Map map,Model model,ModelMap modelMap){
        map.put("data1","map data");
        model.addAttribute("data2","model data2");
        modelMap.addAttribute("data3","modelMap data3");
        return "disp";
    }
}
