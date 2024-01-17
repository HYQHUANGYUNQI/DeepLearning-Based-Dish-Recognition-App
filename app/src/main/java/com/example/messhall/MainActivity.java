package com.example.messhall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

     Button start,register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        start = findViewById(R.id.start);
        //register = findViewById(R.id.register);
        start.setOnClickListener(new ButtonListener());
        //register.setOnClickListener(new ButtonListener());
    }

    private class ButtonListener implements View.OnClickListener {
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.start:
                    Intent intent = new Intent(MainActivity.this, takephotoactivity.class);
                    startActivity(intent);
                    break;
//                case R.id.register:
//                    Intent intent2 = new Intent(MainActivity.this, registerpage.class);
//                    startActivity(intent2);
//                    break;
                default:
                    break;
            }
        }

    }

}
