package com.mk.mvvm.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mk.mvvm.models.User;
import com.mk.mvvm.repositories.remote.UserRepository;

import java.util.ArrayList;

public class UserViewModel extends ViewModel {

    private MutableLiveData<ArrayList<User>> mUsers;
    private UserRepository mUserRepository;

    public UserViewModel() {
        this.mUserRepository = UserRepository.getInstance();
    }

    public LiveData<ArrayList<User>> getUsers() {
        mUsers = mUserRepository.getUsers();
        return mUsers;
    }
}
