package com.mk.mvvm.views.activities.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mk.mvvm.R;
import com.mk.mvvm.viewmodels.MyViewModel;

public class MyActivity extends AppCompatActivity {

    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        //===============================================| Normal
        //((TextView) findViewById(R.id.random_number)).setText(new MyRepository().getNumber());

        //===============================================| ViewModel with Lifecycle
        //MyViewModel mViewModel = ViewModelProviders.of(this).get(MyViewModel.class); //Initialize view model
        //((TextView) findViewById(R.id.random_number)).setText(mViewModel.getNumber());

        //===============================================| ViewModel with LiveData
        MyViewModel mViewModel = ViewModelProviders.of(this).get(MyViewModel.class); //Initialize view model
        mViewModel.getNumber().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                ((TextView) findViewById(R.id.random_number)).setText(s);
            }
        });

        ((Button) findViewById(R.id.generate_number)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.createRandomNumber();
            }
        });
    }
}
