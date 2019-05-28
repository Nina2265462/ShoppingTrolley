package com.cln.shoppingtrolley.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cln.shoppingtrolley.Main2Activity;
import com.cln.shoppingtrolley.R;
import com.cln.shoppingtrolley.login.mvp.LoginPresenter;
import com.cln.shoppingtrolley.login.mvp.iLoginContract;
import com.cln.shoppingtrolley.registmvp.RegistActivity;

public class MainActivity extends AppCompatActivity implements iLoginContract.iLoginView {

    private EditText phone;
    private EditText pwd;
    private CheckBox cb;
    private TextView tv;
    private Button login;
    private iLoginContract.iLoginPresenter presenter;
    private String log = "http://172.17.8.100/small/user/v1/login";
    private ImageView eye;
    private boolean isHideFirst = true;// 输入框密码是否是隐藏的，默认为true

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phone = findViewById(R.id.phone);
        pwd = findViewById(R.id.pwd);
        cb = findViewById(R.id.cb);
        eye = findViewById(R.id.eye);
        tv = findViewById(R.id.tv);
        login = findViewById(R.id.login);
        presenter = new LoginPresenter();
        presenter.attach(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loginShow(log, phone.getText().toString(), pwd.getText().toString());
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegistActivity.class));
            }
        });
        //眼睛点击
        eye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isHideFirst == true) {
                    eye.setImageResource(R.drawable.ic_remove_red_eye_black_24dp);
                    //密文
                    HideReturnsTransformationMethod method1 = HideReturnsTransformationMethod.getInstance();
                    pwd.setTransformationMethod(method1);
                    isHideFirst = false;
                } else {
                    eye.setImageResource(R.drawable.eye);
                    //密文
                    TransformationMethod method = PasswordTransformationMethod.getInstance();
                    pwd.setTransformationMethod(method);
                    isHideFirst = true;

                }
                // 光标的位置
                int index = pwd.getText().toString().length();
                pwd.setSelection(index);
            }
        });
    }


    @Override
    public void onLoginSuccess(String result) {
        //判断输入框是否为空
        if (TextUtils.isEmpty(phone.getText().toString()) && TextUtils.isEmpty(pwd.getText().toString())) {
            Toast.makeText(this, "输入框不能为空", Toast.LENGTH_SHORT).show();
        } else {
            startActivity(new Intent(MainActivity.this, Main2Activity.class));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dettach();
    }
}
