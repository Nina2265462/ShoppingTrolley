package com.cln.shoppingtrolley.registmvp.mvp;

import com.cln.shoppingtrolley.net.CallBackPost;
import com.cln.shoppingtrolley.net.HttpUtil;

import java.util.HashMap;
import java.util.Map;

/*
 *@Auther:cln
 *@Date: 2019/5/27
 *@Description:功能
 * */
public class RegistModel implements iRegistContract.iRegistModel {

    private  HttpUtil util;
    private Map<String, String> map;

    public RegistModel() {
        util = HttpUtil.getInstance();
    }


    @Override
    public void regist(String url, final CallBackPost post, String phone, String pwd) {
        map = new HashMap<>();
        map.put("phone", phone);
        map.put("pwd", pwd);
        util.doHttpPost(url, post, map);
    }
}
