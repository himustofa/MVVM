package com.mk.mvvm.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mk.mvvm.models.ArticleModel;
import com.mk.mvvm.repositories.remote.NewsRepository;

import java.util.ArrayList;

public class NewsViewModel extends ViewModel {

    private MutableLiveData<ArrayList<ArticleModel>> mUsers;
    private NewsRepository mNewsRepository;

    public NewsViewModel() {
        this.mNewsRepository = NewsRepository.getInstance();
    }

    public LiveData<ArrayList<ArticleModel>> getUsers() {
        mUsers = mNewsRepository.getNews();
        return mUsers;
    }
}
