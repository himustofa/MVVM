package com.mk.mvvm.repositories.remote;

import java.util.Random;

public class MyRepository {

    private String TAG = this.getClass().getSimpleName();

    private static MyRepository mInstance;
    private String mRandomNumber;

    public static MyRepository getInstance() {
        if (mInstance == null) {
            mInstance = new MyRepository();
        }
        return mInstance;
    }

    public String getNumber() {
        if (mRandomNumber == null) {
            createRandomNumber();
        }
        return mRandomNumber;
    }

    private void createRandomNumber() {
        mRandomNumber = ""+(new Random().nextInt(999999) + 1);
    }
}
