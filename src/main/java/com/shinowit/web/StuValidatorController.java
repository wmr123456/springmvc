package com.shinowit.web;

import com.shinowit.entity.StuEntity;
import com.shinowit.entity.StuEntityValidator;
import com.shinowit.framework.dao.BaseDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by Administrator on 2014/12/22.
 */
@Controller
@RequestMapping(value = "stu")
public class StuValidatorController {
    @Resource
    private BaseDAO<StuEntity> stuDao;
//
//    @InitBinder
//    private void initBinder(DataBinder binder){
//        binder.setValidator(new StuEntityValidator());
//    }

    @RequestMapping(value = "/new",method =RequestMethod.GET)
    public String perparnew(@ModelAttribute("stu1") StuEntity stuEntity){
        return "/login";
    }


    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String perpareNew(@Valid @ModelAttribute("stu1") StuEntity stuEntity,BindingResult bindingResult,RedirectAttributes redirectAttributes,Model model){

        if(bindingResult.hasErrors()){
            return "/login";
        }
        Integer id = null;
        try{
            id = (Integer)stuDao.insert(stuEntity) ;
        }catch (Exception e){
            e.printStackTrace();
        }
        if(null!=id){
            redirectAttributes.addFlashAttribute("msg","保存成功！");
            return "redirect:/stu/new";
        }else {
            model.addAttribute("msg","保存失败！");
            return "/login";
        }
    }

//    @RequestMapping(value = "/new",method = RequestMethod.POST)
//    public String prepareNew(@Valid @ModelAttribute("stu1") StuEntity stuEntity,BindingResult bindingResult,RedirectAttributes redirectAttributes,Model model){
//        if (bindingResult.hasErrors()){
//            return "/login";
//        }
//        Integer new_user_id=null;
//        try{
//            new_user_id=(Integer)stuDao.insert(stuEntity);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        if (null!=new_user_id){
//            redirectAttributes.addFlashAttribute("msg","保存成功!");
//            return "redirect:/stu/new";
//        }else{
//            model.addAttribute("msg","保存失败!");
//            return "/stu/new";
//        }
//    }


}
