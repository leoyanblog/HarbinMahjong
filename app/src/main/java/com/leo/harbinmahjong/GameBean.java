package com.leo.harbinmahjong;

import com.leo.harbinmahjong.bean.PlayerBean;

import java.util.List;

import cn.bmob.v3.BmobObject;

/**
 * Created by Leo on 2017/3/30.
 */

//必须要继承自BmobObject类
public class GameBean extends BmobObject {

    private String homeowner;
    private Integer thinkTime;
    private List<PlayerBean> playerList;

    public String getHomeowner() {
        return homeowner;
    }

    public void setHomeowner(String homeowner) {
        this.homeowner = homeowner;
    }

    public Integer getThinkTime() {
        return thinkTime;
    }

    public void setThinkTime(Integer thinkTime) {
        this.thinkTime = thinkTime;
    }

    public List<PlayerBean> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<PlayerBean> playerList) {
        this.playerList = playerList;
    }
}
