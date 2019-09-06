package com.mk.mvvm.views.activities.viewmodel.newsapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mk.mvvm.R;
import com.mk.mvvm.models.news.ArticleModel;
import com.mk.mvvm.viewmodels.NewsViewModel;
import com.mk.mvvm.views.adapters.NewsRecyclerAdapter;

import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity {

    private static final String TAG = "NewsActivity";
    private RecyclerView mRecyclerView;
    private NewsRecyclerAdapter mAdapter;
    private NewsViewModel mNewsViewModel;
    private ArrayList<ArticleModel> mArticles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        mRecyclerView = (RecyclerView) findViewById(R.id.news_recycler);

        //Receive the data and observe the data from view model
        mNewsViewModel = ViewModelProviders.of(this).get(NewsViewModel.class); //Initialize view model
        mNewsViewModel.getUsers().observe(this, new Observer<ArrayList<ArticleModel>>() {
            @Override
            public void onChanged(ArrayList<ArticleModel> arrayList) {
                mArticles.addAll(arrayList);
                mAdapter.notifyDataSetChanged();
            }
        });

        initRecyclerView();
    }

    private void initRecyclerView() {
        mAdapter = new NewsRecyclerAdapter(this, mArticles); //mUserViewModel.getUsers().getValue()
        //mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        //mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
        //mAdapter.notifyDataSetChanged();
    }
}
