package com.example.messhall;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

public class dishlistactivity extends AppCompatActivity {
    private ImageView picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.takephoto);

        picture = (ImageView) findViewById(R.id.imageIV);

    }
}
