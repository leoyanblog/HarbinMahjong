package com.leo.harbinmahjong.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Leo on 2017/3/30.
 */

public class PlayerBean extends BmobObject {
    private String mobile;
    private Integer direction;// 1.东 2.南 3.西 4.北

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }
}
