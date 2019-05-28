package com.cln.shoppingtrolley.registmvp.mvp;

import android.content.Context;

import com.cln.shoppingtrolley.net.CallBackPost;

/*
 *@Auther:cln
 *@Date: 2019/5/27
 *@Description:功能
 * */
public interface iRegistContract {
    public interface iRegistView {
        void onRegistSuccess(String result);
    }

    public interface iRegistModel {
        void regist(String url, CallBackPost post, String phone, String pwd);
    }

    public interface iRegistPresenter {
        void attach(iRegistView registView);

        void dettach();

        void regist(Context context,String url, String phone, String pwd);
    }
}
