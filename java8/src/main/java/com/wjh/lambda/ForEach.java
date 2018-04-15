package com.wjh.lambda;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WJH on 2017年08月17日 23:03
 */
public class ForEach {
    public static void main(String[] args) {
        List<String> list= Arrays.asList("wjh","hg","sh");
        list.forEach(s-> System.out.println(s));
        System.out.println("========================");
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"wjh");
        map.put(2,"hg");
        map.forEach((key,value) -> System.out.println(key+","+value));
    }
}
