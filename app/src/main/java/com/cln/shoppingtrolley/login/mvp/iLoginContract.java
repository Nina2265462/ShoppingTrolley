package com.cln.shoppingtrolley.login.mvp;

import com.cln.shoppingtrolley.net.CallBackPost;

/*
 *@Auther:cln
 *@Date: 2019/5/27
 *@Description:功能
 * */
public interface iLoginContract {
    public interface iLoginView {
        void onLoginSuccess(String result);

    }

    public interface iLoginModel {
        void login(String url, CallBackPost post, String phone, String pwd);
    }

    public interface iLoginPresenter {
        void attach(iLoginView loginView);

        void dettach();

        void loginShow(String url, String phone, String pwd);

    }
}
