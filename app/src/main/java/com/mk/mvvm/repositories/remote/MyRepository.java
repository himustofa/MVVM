package com.mk.mvvm.repositories.remote;

import androidx.lifecycle.MutableLiveData;

import java.util.Random;

public class MyRepository {

    private String TAG = this.getClass().getSimpleName();

    private static MyRepository mInstance;
    //private String mRandomNumber;
    private MutableLiveData<String> mRandomNumber;

    public static MyRepository getInstance() {
        if (mInstance == null) {
            mInstance = new MyRepository();
        }
        return mInstance;
    }

    //===============================================| ViewModel with Lifecycle
    /*public String getNumber() {
        if (mRandomNumber == null) {
            createRandomNumber();
        }
        return mRandomNumber;
    }
    private void createRandomNumber() {
        mRandomNumber = ""+(new Random().nextInt(999999) + 1);
    }*/

    //===============================================| ViewModel with LiveData
    public MutableLiveData<String> getNumber() {
        if (mRandomNumber == null) {
            mRandomNumber = new MutableLiveData<>();
            createRandomNumber();
        }
        return mRandomNumber;
    }
    public void createRandomNumber() {
        mRandomNumber.setValue(String.valueOf((new Random().nextInt(999999) + 1)));
    }
}
