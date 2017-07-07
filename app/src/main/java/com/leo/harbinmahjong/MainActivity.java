package com.leo.harbinmahjong;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.leo.harbinmahjong.bean.PlayerBean;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //第一：默认初始化
//        Bmob.initialize(this, "Your Application ID");
        Bmob.initialize(this, "29b2ee46e291803c2f26e876a07c7d46");


        //第二：自v3.4.7版本开始,设置BmobConfig,允许设置请求超时时间、文件分片上传时每片的大小、文件的过期时间(单位为秒)，
        BmobConfig config = new BmobConfig.Builder(this)
                //设置appkey
//            .setApplicationId("Your Application ID")
                .setApplicationId("29b2ee46e291803c2f26e876a07c7d46")
                //请求超时时间（单位为秒）：默认15s
                .setConnectTimeout(30)
                //文件分片上传时每片的大小（单位字节），默认512*1024
                .setUploadBlockSize(1024 * 1024)
                //文件的过期时间(单位为秒)：默认1800s
                .setFileExpiration(2500)
                .build();
        Bmob.initialize(config);

        List<PlayerBean> playerList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            PlayerBean player = new PlayerBean();
            player.setMobile("1314646561" + i);
            player.setDirection(i + 1);
            playerList.add(player);
        }
        GameBean game = new GameBean();
        game.setHomeowner("13146465612");
        game.setThinkTime(15);
        game.setPlayerList(playerList);
        game.save(new SaveListener<String>() {
            @Override
            public void done(String objectId, BmobException e) {
                if (e == null) {
                    Toast.makeText(MainActivity.this, "添加数据成功，返回objectId为：" + objectId, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "创建数据失败：" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
