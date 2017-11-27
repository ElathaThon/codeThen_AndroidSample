package com.topoinventari.sampleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //Layout is inflated
        initView();
    }

    private void initView() {

        TextView text = findViewById(R.id.text);//Troba elements de la vista a traves del id
        Button button = findViewById(R.id.button);

        button.setOnClickListener((v) -> {
            text.setText("Clicked!!!");
        });

    }


}
