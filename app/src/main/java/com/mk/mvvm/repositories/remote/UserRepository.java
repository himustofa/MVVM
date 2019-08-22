package com.mk.mvvm.repositories.remote;

import androidx.lifecycle.MutableLiveData;

import com.mk.mvvm.models.User;

import java.util.ArrayList;

//Singleton pattern
public class UserRepository {

    private static UserRepository mInstance;

    public static UserRepository getInstance() {
        if (mInstance == null) {
            mInstance = new UserRepository();
        }
        return mInstance;
    }

    //Pretend to get data from a webservice or online source
    public MutableLiveData<ArrayList<User>> getUsers() {
        MutableLiveData<ArrayList<User>> data = new MutableLiveData<>();
        data.setValue(getData());
        return data;
    }

    private ArrayList<User> getData() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("mojombo", "MDQ6VXNlcjE=", "https://avatars0.githubusercontent.com/u/1?v=4", "User"));
        users.add(new User("defunkt", "MDQ6VXNlcjI=", "https://avatars0.githubusercontent.com/u/2?v=4", "User"));
        return users;
    }
}
