package com.wjh.inter;

/**
 * Created by WJH on 2017年04月10日 11:00
 */
public class AdvertisementBoard {
    public void show (Advertisement adver){
        System.out.println(adver.getCorpName()+"广告词");
        adver.showAdvertisement(); //接口回调
    }
}
