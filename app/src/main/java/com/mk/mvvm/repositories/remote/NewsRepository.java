package com.mk.mvvm.repositories.remote;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.mk.mvvm.models.news.ArticleModel;
import com.mk.mvvm.models.news.ResponseModel;
import com.mk.mvvm.repositories.retrofit.RetrofitClient;
import com.mk.mvvm.utils.ConstantKey;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//Singleton pattern
public class NewsRepository {

    private static final String TAG = "NewsRepository";
    private static NewsRepository mInstance;

    public static NewsRepository getInstance() {
        if (mInstance == null) {
            mInstance = new NewsRepository();
        }
        return mInstance;
    }

    //Pretend to get data from a webservice or online source
    public MutableLiveData<ArrayList<ArticleModel>> getNews() {
        MutableLiveData<ArrayList<ArticleModel>> data = new MutableLiveData<>();

        Call<ResponseModel> call = RetrofitClient.getInstance().getApi().getNews(ConstantKey.COIN, ConstantKey.DATE, ConstantKey.SORT, ConstantKey.API);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(@NonNull Call<ResponseModel> call, @NonNull Response<ResponseModel> response) {
                if (response.body() != null && response.body().getStatus().equals("ok")) {
                    ArrayList<ArticleModel> list = response.body().getArticles();
                    Log.d(TAG, new Gson().toJson(response.body().getArticles()));
                    data.setValue(list);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseModel> call, @NonNull Throwable t) {
                Log.e(TAG, t.getMessage());
            }
        });

        return data;
    }
}
