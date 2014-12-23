package com.shinowit.entity;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


/**
 * Created by Administrator on 2014/12/22.
 */
public class StuEntityValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == StuEntity.class;
    }

    @Override
    public void validate(Object target, Errors errors) {
        StuEntity stu1 = (StuEntity)target;
        if(stu1==null){
            return;
        }
        if((stu1.getName()==null) || (stu1.getName().trim().length()<3)){
            errors.rejectValue("name",null,"用户名应大于3个字符");
        }
        if ((stu1.getPassword().trim().length()<3)||(stu1.getPassword().trim().length()>9)){
            errors.rejectValue("password",null,"密码长度应大于3个字符并且小于9个字符");
        }
    }
}
