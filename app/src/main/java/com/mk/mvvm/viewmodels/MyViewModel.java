package com.mk.mvvm.viewmodels;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.mk.mvvm.repositories.remote.MyRepository;

public class MyViewModel extends ViewModel {

    private String TAG = this.getClass().getSimpleName();
    private MyRepository mRepository;

    public MyViewModel() {
        this.mRepository = MyRepository.getInstance();
    }

    public String getNumber() {
        return mRepository.getNumber();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "onCleared");
    }
}

/*
* Note:
* ----
* Store and manage UI related data and large data
* Destroyed only if the owner Activity is completely destroyed, in onCleared()
* Communication layer between DB and UI
* */