package com.wjh.clutter;

/**
 * Created by WJH on 2018年03月24日 19:23
 */
public class PrimeNumber {

    private void test(){
        for (int i=0;i<Integer.MAX_VALUE;i++){

        }
    }

    private boolean prime(int a){
        for (int i=2;i<=Math.sqrt(a);i++){
            if (a%i == 0){
                return false;
            }
        }
        return true;
    }
}
