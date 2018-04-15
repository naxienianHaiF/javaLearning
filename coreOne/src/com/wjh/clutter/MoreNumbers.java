package com.wjh.clutter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WJH on 2018年03月13日 22:06
 */
public class MoreNumbers {

    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,1,2,1,3,3);
        System.out.println(majorityNumber(list));
        int i=0;
        System.out.println(++i);
    }
    public static int majorityNumber(List<Integer> nums) {
        // write your code here
        if(nums == null || nums.size() == 0){
            return 0;
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.size();i++){
            Integer temp=nums.get(i);
            if(map.containsKey(temp)){
                Integer v=map.get(temp)+1;
                map.put(temp,v);
            }else{
                map.put(nums.get(i),new Integer(1));
            }
        }
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            int value=m.getValue();
            if(value>nums.size()/3){
                return m.getKey();
            }
        }
        return 0;
    }
}
