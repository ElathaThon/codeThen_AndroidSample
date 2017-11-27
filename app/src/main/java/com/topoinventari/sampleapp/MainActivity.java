package com.topoinventari.sampleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int REQ_ENTER_TEXT = 1;


    private List<String> lines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lines = new ArrayList<>();

        setContentView(R.layout.activity_main);

        //Layout is inflated, sempre despres de setContentView perque sino no trobara les coses de la pantalla
        initView();
    }

    private void initView() {

        Button button = findViewById(R.id.button); //Troba elements de la vista a traves del id

        button.setOnClickListener((v) -> {
            //open new activity
            Intent intent = new Intent(this, EnterTextActivity.class); //On estem i on anem...
            startActivityForResult(intent,REQ_ENTER_TEXT);


        });

    }

    //This is called when coming from an activity started with startActivityForResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ_ENTER_TEXT) {

            String text = data.getStringExtra(EnterTextActivity.EXTRA_TEXT);
            lines.add(text);

            TextView textView = findViewById(R.id.text);
            textView.setText(lines.toString());

        }

    }
}
