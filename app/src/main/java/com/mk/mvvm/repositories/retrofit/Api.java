package com.mk.mvvm.repositories.retrofit;

import com.mk.mvvm.models.news.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    /*@FormUrlEncoded
    @POST //@POST("create"): Url end point
    Call<ResponseBody> mCreate(
            @Field("name") String name,
            @Field("author") String author,
            @Field("title") String title,
            @Field("description") String description,
            @Field("url") String url,
            @Field("urlToImage") String urlToImage,
            @Field("publishedAt") String publishedAt,
            @Field("content") String content
    );*/;

    @GET("everything")
    Call<ResponseModel> getNews(@Query("q") String q, @Query("from") String from, @Query("sortBy") String sortBy, @Query("apiKey") String apiKey);
}
