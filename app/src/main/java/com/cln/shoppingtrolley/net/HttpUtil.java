package com.cln.shoppingtrolley.net;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.cln.shoppingtrolley.application.MyApplication;

import java.util.Map;

/*
 *@Auther:cln
 *@Date: 2019/5/27
 *@Description:功能
 * */
public class HttpUtil {
    private static final HttpUtil ourInstance = new HttpUtil();
    private StringRequest stringRequest;
    private StringRequest request;

    public static HttpUtil getInstance() {
        return ourInstance;
    }

    private HttpUtil() {
    }

    public void doHttpGet(String surl, final CallBackPost post) {
        stringRequest = new StringRequest(Request.Method.GET, surl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                post.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                post.onFail(error.getMessage());
            }
        });
        MyApplication.getRequestQueue().add(stringRequest);
    }

    public void doHttpPost(String surl, final CallBackPost post, final Map<String, String> map) {
        request = new StringRequest(Request.Method.POST, surl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                post.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                post.onFail(error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };
        MyApplication.getRequestQueue().add(request);
    }
}
