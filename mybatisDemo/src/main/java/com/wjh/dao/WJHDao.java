package com.wjh.dao;

import com.wjh.entity.WJH;

/**
 * Created by WJH on 2017年05月15日 19:22
 */
public interface WJHDao {
    /**
     * 根据id查询数据
     */
    WJH getWJH(int id);

    /**
     * 添加数据
     */
    int addWJH(WJH wjh);
}
