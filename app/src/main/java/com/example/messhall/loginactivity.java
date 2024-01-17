package com.example.messhall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class loginactivity extends AppCompatActivity{
    private MyDatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        ButterKnife.bind(this);
        db = new MyDatabaseHelper(this);
    }
    @BindView(R.id.tv_loginactivity_register)
    TextView mTvLoginactivityRegister;
    @BindView(R.id.rl_loginactivity_top)
    RelativeLayout mRlLoginactivityTop;
    @BindView(R.id.User_phone)
    EditText mEtLoginactivityUsername;
    @BindView(R.id.User_pwd)
    EditText mEtLoginactivityPassword;Gradle project sync failed. Please fix your project and try again.
    @BindView(R.id.ll_loginactivity_two)
    LinearLayout mLlLoginactivityTwo;

    @OnClick({
            // R.id.iv_loginactivity_back,
            R.id.tv_loginactivity_register,
            //R.id.tv_loginactivity_forget,
            //R.id.tv_loginactivity_check,
            //R.id.bt_loginactivity_login,
            //R.id.tv_loginactivity_else
            R.id.lp_login,
    })

    public void onClick(View view) {
        switch (view.getId()) {
            //case R.id.iv_loginactivity_back:
            //TODO 返回箭头功能
            //    finish();//销毁此Activity
            //    break;
            case R.id.tv_loginactivity_register:
                //TODO 注册界面跳转
                startActivity(new Intent(loginactivity.this, registerpage.class));
                finish();
                break;
            //case R.id.tv_loginactivity_forget:   //忘记密码
            //TODO 忘记密码操作界面跳转
            //    startActivity(new Intent(this, FindPasswordActivity.class));
            //    break;
            //case R.id.tv_loginactivity_check:    //短信验证码登录
            // TODO 短信验证码登录界面跳转
            //    startActivity(new Intent(this, MessageLoginActivity.class));
            //    finish();
            //    break;

            case R.id.lp_login:
                String name = mEtLoginactivityUsername.getText().toString().trim();
                String password = mEtLoginactivityPassword.getText().toString().trim();
                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password)) {
                    ArrayList<user> data = db.getAllData();
                    boolean match = false;
                    for(int i=0;i<data.size();i++) {
                        user user = data.get(i);
                        if (name.equals(user.getUser_phone()) && password.equals(user.getUser_pwd())){
                            match = true;
                            break;
                        }
                        else{
                            match = false;
                        }
                    }
                    if (match) {
                        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(this, takephotoactivity.class);
                        startActivity(intent);
                        finish();//销毁此Activity
                    }else {
                        Toast.makeText(this, "用户名或密码不正确，请重新输入", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "请输入你的用户名或密码", Toast.LENGTH_SHORT).show();
                }
                break;
            //case R.id.tv_loginactivity_else:
            //TODO 第三方登录，时间有限，未实现
            //    break;
        }
    }
}
