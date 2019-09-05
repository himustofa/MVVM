package com.mk.mvvm.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "customers")
public class Customer {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")

    private String customerId;

    @ColumnInfo(name = "name")
    private String customerName;

    @NonNull
    @ColumnInfo(name = "phone")

    private String customerPhoneNumber;

    @ColumnInfo(name = "description")
    private String customerDescription;

    //String.valueOf(new Timestamp(System.currentTimeMillis()))


    public Customer() {
    }

    @NonNull
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @NonNull
    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getCustomerDescription() {
        return customerDescription;
    }

    public void setCustomerDescription(String customerDescription) {
        this.customerDescription = customerDescription;
    }
}
