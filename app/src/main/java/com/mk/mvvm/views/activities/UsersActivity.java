package com.mk.mvvm.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mk.mvvm.R;
import com.mk.mvvm.models.User;
import com.mk.mvvm.viewmodels.UserViewModel;
import com.mk.mvvm.views.adapters.UserAdapter;

import java.util.ArrayList;

//Help: CodingWithMitch
public class UsersActivity extends AppCompatActivity {

    private static final String TAG = "UsersActivity";
    private RecyclerView mRecyclerView;
    private UserAdapter mAdapter;
    private UserViewModel mUserViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        mRecyclerView = (RecyclerView) findViewById(R.id.user_list_recycler_view);

        //Receive the data and observe the data from view model
        mUserViewModel = ViewModelProviders.of(this).get(UserViewModel.class); //Initialize view model
        mUserViewModel.getUsers().observe(this, new Observer<ArrayList<User>>() {
            @Override
            public void onChanged(ArrayList<User> users) {
                mAdapter.notifyDataSetChanged();
            }
        });

        initRecyclerView();
    }

    private void initRecyclerView() {
        mAdapter = new UserAdapter(this, mUserViewModel.getUsers().getValue());
        //mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        //mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
        //mAdapter.notifyDataSetChanged();
    }
}
