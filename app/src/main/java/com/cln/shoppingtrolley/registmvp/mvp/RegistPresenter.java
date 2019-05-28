package com.cln.shoppingtrolley.registmvp.mvp;

import android.content.Context;

import com.cln.shoppingtrolley.net.CallBackPost;

/*
 *@Auther:cln
 *@Date: 2019/5/27
 *@Description:功能
 * */
public class RegistPresenter implements iRegistContract.iRegistPresenter {

    private iRegistContract.iRegistView regView;
    private iRegistContract.iRegistModel model;

    @Override
    public void attach(iRegistContract.iRegistView registView) {
        regView = registView;
        model = new RegistModel();
    }

    @Override
    public void dettach() {
        if (regView != null) {
            regView = null;
        }
        if (model != null) {
            model = null;
        }
    }

    @Override
    public void regist(Context context,String url, String phone, String pwd) {
        model.regist(url, new CallBackPost() {
            @Override
            public void onSuccess(String success) {
                regView.onRegistSuccess(success);
            }

            @Override
            public void onFail(String msg) {

            }
        }, phone, pwd);
    }
}
