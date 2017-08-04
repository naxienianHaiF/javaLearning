package com.wjh.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by WJH on 2017年07月30日 20:07
 */

@RestController
@EnableAutoConfiguration
public class DataBinding {

    /*
    传入的参数值要和url中的参数名一致，当其参数类型为基本类型的时候，参数值必须有，
    否则会报错
    localhost:8080/int.do?x=10
     */
    @RequestMapping("/int.do")
    public String intdemo(int x){
        return "传入类型为int的参数x值为："+x;
    }
    /*
    url中的参数名为value中的值
    localhost:8080/intparam.do?x1=10
     */
    @RequestMapping("/intparam.do")
    public String intdemotwo(@RequestParam(value = "x1",required = false) int x){
        return "传入类型为int的参数x值为："+x;
    }
    /*
    localhost:8080/integer.do?a=10
     */
    @RequestMapping("/integer.do")
    public String integerdemo(Integer a){
        return  "传入类型为Integer的参数a值为："+a;
    }
    /*
    localhost:8080/array.do?name=wjh&name=xcf
     */
    @RequestMapping("/array.do")
    public String array(String[] name){
        StringBuilder sb=new StringBuilder();
        for(String str:name){
            sb.append(str).append(" ");
        }
        return sb.toString();
    }
    /*
    localhost:8080/object.do?name=wjh&age=25
     */
    @RequestMapping("/object.do")
    public String object(User user){
        Integer age=user.getAge();
        System.out.println(age);
        return user.toString();
    }

    /*
    localhost:8080/contactinfo.do?user.name=wjh&user.age=25&phone=10080&address=sh
     */
    @RequestMapping("/contactinfo.do")
    public String contactinfo(ContactInfo info){
        return info.toString();
    }
    /*
    localhost:8080/samepro.do?user.name=wjh&admin.name=xcf&age=25
     */
    @RequestMapping("/samepro.do")
    public String same(User user,Admin admin){
        return user.toString()+" "+admin.toString();
    }

    @InitBinder("user")
    public void initUser(WebDataBinder binder){
        binder.setFieldDefaultPrefix("user.");
    }
    @InitBinder("admin")
    public void initAdmin(WebDataBinder binder){
        binder.setFieldDefaultPrefix("admin.");
    }

    /*
    http://localhost:8080/list.do?list[0].name=wjh&list[1].age=25
     */
    @RequestMapping("/list.do")
    public String list(UserForm form){
        return form.toString();
    }
    /*
    //TODO Set和List类似，也需要绑定在对象上，而不能直接写在Controller方法的参数中。
    //TODO 但是，绑定Set数据时，必须先在Set对象中add相应的数量的模型对象。
    http://localhost:8080/set.do?set[0].name=wjh&set[1].name=weh
     */
    @RequestMapping("/set.do")
    public String set(UserSet set){
        return set.toString();
    }
}
