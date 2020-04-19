package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;

import android.widget.*;

import android.view.View;

public class MainActivity extends AppCompatActivity {
    ImageButton imagebutton1;
    ImageButton imagebutton2;
    ImageButton imagebutton3;
    ImageButton imagebutton4;
    ImageButton imagebutton5;
    ImageButton imagebutton6;
    ImageButton imagebutton7;
    ImageButton imagebutton8;
    Intent intent1, intent2, intent3, intent4, intent5, intent6, intent7, intent8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagebutton1 = findViewById(R.id.imageButton_intercept);
        imagebutton1.setOnClickListener(new ButtonListener());

        imagebutton2 = findViewById(R.id.imageButton_virus);
        imagebutton2.setOnClickListener(new ButtonListener());

        imagebutton3 = findViewById(R.id.imageButton_lock);
        imagebutton3.setOnClickListener(new ButtonListener());

        imagebutton4 = findViewById(R.id.imageButton_flow);
        imagebutton4.setOnClickListener(new ButtonListener());

        imagebutton5 = findViewById(R.id.imageButton_progress);
        imagebutton5.setOnClickListener(new ButtonListener());

        imagebutton6 = findViewById(R.id.imageButton_rubbish);
        imagebutton6.setOnClickListener(new ButtonListener());

        imagebutton7 = findViewById(R.id.imageButton_scan);
        imagebutton7.setOnClickListener(new ButtonListener());

        imagebutton8 = findViewById(R.id.imageButton_setting);
        imagebutton8.setOnClickListener(new ButtonListener());
    }
    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.imageButton_intercept:
                    intent1 = new Intent(MainActivity.this, InterceptActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.imageButton_virus:
                    intent2 = new Intent(MainActivity.this, VirusActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.imageButton_lock:
                    intent3 = new Intent(MainActivity.this, LockActivity.class);
                    startActivity(intent3);
                    break;
                case R.id.imageButton_flow:
                    intent4 = new Intent(MainActivity.this, FlowActivity.class);
                    startActivity(intent4);
                    break;
                case R.id.imageButton_progress:
                    intent5 = new Intent(MainActivity.this, ProgressActivity.class);
                    startActivity(intent5);
                    break;
                case R.id.imageButton_rubbish:
                    intent6 = new Intent(MainActivity.this, RubbishActivity.class);
                    startActivity(intent6);
                    break;
                case R.id.imageButton_scan:
                    intent7 = new Intent(MainActivity.this, ScanActivity.class);
                    startActivity(intent7);
                    break;
                case R.id.imageButton_setting:
                    intent8 = new Intent(MainActivity.this, SettingActivity.class);
                    startActivity(intent8);
                    break;
                default:
                    break;
            }
        }
    }

}
