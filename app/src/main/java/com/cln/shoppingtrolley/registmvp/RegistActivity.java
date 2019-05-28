package com.cln.shoppingtrolley.registmvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.cln.shoppingtrolley.R;
import com.cln.shoppingtrolley.login.MainActivity;
import com.cln.shoppingtrolley.login.mvp.LoginPresenter;
import com.cln.shoppingtrolley.login.mvp.iLoginContract;
import com.cln.shoppingtrolley.registmvp.mvp.RegistPresenter;
import com.cln.shoppingtrolley.registmvp.mvp.iRegistContract;

public class RegistActivity extends AppCompatActivity implements iRegistContract.iRegistView {
    private EditText phone;
    private EditText pwd;
    private CheckBox cb;
    private Button regist;
    private iRegistContract.iRegistPresenter presenter;
    private String reg = "http://172.17.8.100/small/user/v1/register";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        phone = findViewById(R.id.phone);
        pwd = findViewById(R.id.pwd);
        cb = findViewById(R.id.cb);
        regist = findViewById(R.id.regist);
        presenter = new RegistPresenter();
        presenter.attach(this);
        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.regist(RegistActivity.this, reg, phone.getText().toString(), pwd.getText().toString());
            }
        });
    }

    @Override
    public void onRegistSuccess(String result) {
        startActivity(new Intent(RegistActivity.this, MainActivity.class));
    }
}
