package com.mk.mvvm.views.activities.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.TextView;

import com.mk.mvvm.R;
import com.mk.mvvm.viewmodels.MyViewModel;

public class MyActivity extends AppCompatActivity {

    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        //((TextView) findViewById(R.id.random_id)).setText(new MyRepository().getNumber());

        MyViewModel mViewModel = ViewModelProviders.of(this).get(MyViewModel.class); //Initialize view model
        ((TextView) findViewById(R.id.random_id)).setText(mViewModel.getNumber());
    }
}
