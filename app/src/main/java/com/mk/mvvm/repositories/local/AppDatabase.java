package com.mk.mvvm.repositories.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.mk.mvvm.models.Customer;
import com.mk.mvvm.utils.ConstantKey;

@Database(entities = {Customer.class}, version = ConstantKey.DATABASE_VERSION)
public abstract class AppDatabase extends RoomDatabase {

    public abstract IDaoAccess daoAccess();

    private static volatile AppDatabase mInstance;

    public static AppDatabase getDatabase(final Context context) {
        if (mInstance == null) {
            synchronized (AppDatabase.class) {
                if (mInstance == null) {
                    mInstance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, ConstantKey.DATABASE_NAME)
                            .build();
                }
            }
        }
        return mInstance;
    }

}
