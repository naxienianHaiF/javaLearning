package com.wjh.optional;

import java.util.Optional;

/**
 * Created by WJH on 2017年08月17日 22:41
 */
public class OptionalDemoOne {
    public static void main(String[] args) {
        Optional<String> optional=Optional.of("wjh");
        System.out.println(optional.get());
        System.out.println("of method:"+optional.isPresent());
        Optional<Integer> empty=Optional.empty();
        System.out.println(empty.orElse(12));
        System.out.println(empty.orElse(null));
        System.out.println(optional.orElse("如果有值则将其返回，否则返回指定的其它值。"));
//        System.out.println(empty.get());
        //如果Optional实例有值则为其调用consumer，否则不做处理
        optional.ifPresent(s -> System.out.println("consumer:"+s));
        empty.ifPresent(s -> System.out.println("is null"));
        System.out.println(1);
    }
}
