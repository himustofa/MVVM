package com.mk.mvvm.repositories.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.mk.mvvm.models.Customer;

import java.util.List;

@Dao
public interface IDaoAccess {

    @Query("SELECT * FROM customers")
    LiveData<List<Customer>> getAll();

    @Query("SELECT * FROM customers WHERE id=:customerId")
    LiveData<Customer> get(String customerId);

    @Insert
    long insert(Customer customer);

    @Insert
    long[] insertAll(Customer... customers);

    @Update
    int update(Customer customer);

    @Delete
    int delete(Customer customer);

}
