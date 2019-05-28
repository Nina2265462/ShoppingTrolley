package com.cln.shoppingtrolley.login.mvp;

import com.cln.shoppingtrolley.net.CallBackPost;

/*
 *@Auther:cln
 *@Date: 2019/5/27
 *@Description:功能
 * */
public class LoginPresenter implements iLoginContract.iLoginPresenter {

    private iLoginContract.iLoginView logView;
    private iLoginContract.iLoginModel model;

    @Override
    public void attach(iLoginContract.iLoginView loginView) {
        logView = loginView;
        model = new LoginModel();
    }

    @Override
    public void dettach() {
        if (logView != null) {
            logView = null;
        }
        if (model != null) {
            model = null;
        }
    }

    @Override
    public void loginShow(String url, final String phone, String pwd) {
        model.login(url, new CallBackPost() {
            @Override
            public void onSuccess(String success) {
                logView.onLoginSuccess(success);
            }

            @Override
            public void onFail(String msg) {

            }
        }, phone, pwd);
    }
}
