package com.cln.shoppingtrolley.login.mvp;

import com.cln.shoppingtrolley.net.CallBackPost;
import com.cln.shoppingtrolley.net.HttpUtil;

import java.util.HashMap;
import java.util.Map;

/*
 *@Auther:cln
 *@Date: 2019/5/27
 *@Description:功能
 * */
public class LoginModel implements iLoginContract.iLoginModel {

    private HttpUtil util;
    private Map<String, String> map;

    public LoginModel() {
        util = HttpUtil.getInstance();
    }

    @Override
    public void login(String url, CallBackPost post, String phone, String pwd) {
        map = new HashMap<>();
        map.put("phone", phone);
        map.put("pwd", pwd);
        util.doHttpPost(url, post, map);

    }
}
