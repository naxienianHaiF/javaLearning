package com.wjh.inter;

/**
 * Created by WJH on 2017年04月10日 11:05
 */
public class TestInterface {

    public static void main(String[] args) {
        AdvertisementBoard board=new AdvertisementBoard();
        board.show(new Acorp());
        board.show(new Bcorp());
    }
}
