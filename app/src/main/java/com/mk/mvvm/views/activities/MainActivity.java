package com.mk.mvvm.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.mk.mvvm.R;
import com.mk.mvvm.views.activities.viewmodel.MyActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(new Intent(this, MyActivity.class)));
    }
}
