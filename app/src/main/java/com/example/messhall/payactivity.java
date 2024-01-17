package com.example.messhall;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class payactivity extends AppCompatActivity{
    private RadioButton payButtonAli;
    private RadioButton payButtonWechat;
    private RadioButton payButtonCard;
    private Button pay;
    private RadioGroup payWay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settleaccount);
        //获取id
        payWay=findViewById(R.id.payway);//获取单选按钮组
        //为单选按钮组添加事件监听
        payWay.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton RB=(RadioButton) findViewById(i);//获取被选择的单选按钮
                Log.i("单选按钮","你的选择是："+RB.getText());
            }
        });
        payButtonAli = findViewById(R.id.payButtonAli);
        payButtonWechat = findViewById(R.id.payButtonWechat);
        payButtonCard = findViewById(R.id.payButtonCard);
        pay = findViewById(R.id.payButton);
        //点击事件

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //通过for循环遍历单选按钮组
                for(int i=0;i<payWay.getChildCount();i++){
                    RadioButton RB=(RadioButton) payWay.getChildAt(i);
                    if(RB.isChecked())
                    {
                        if(RB == payButtonAli){
                            try {
                                //利用Intent打开支付宝
                                // 支付宝跳过开启动画打开扫码和付款码的urlscheme分别是：
                                //alipayqr://platformapi/startapp?saId=10000007
                                // alipayqr://platformapi/startapp?saId=20000056
                                Uri uri = Uri.parse("alipayqr://platformapi/startapp?saId=10000007");
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                startActivity(intent);
                            } catch (Exception e) {
                                //若无法正常跳转，在此进行错误处理
                                Toast.makeText(getApplicationContext(), "打开失败，请检查是否安装了支付宝", Toast.LENGTH_SHORT).show();
                            }

                        }
                        else  if(RB == payButtonWechat){
                            try {
                                //利用Intent打开微信
                                Uri uri = Uri.parse("weixin://");
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                startActivity(intent);
                            } catch (Exception e) {
                                //若无法正常跳转，在此进行错误处理
                                Toast.makeText(getApplicationContext(), "无法跳转到微信，请检查是否安装了微信", Toast.LENGTH_SHORT).show();
                            }

                        }
                        break;
                    }
                }
            }
        });
    }
}
