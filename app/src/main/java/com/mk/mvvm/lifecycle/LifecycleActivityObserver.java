package com.mk.mvvm.lifecycle;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class LifecycleActivityObserver implements LifecycleObserver {

    private final String TAG = this.getClass().getCanonicalName();

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreateEvent() {
        Log.d(TAG, "onCreateEvent");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    protected void onStartEvent() {
        Log.d(TAG, "onStartEvent");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    protected void onPauseEvent() {
        Log.d(TAG, "onPauseEvent");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    protected void onResumeEvent() {
        Log.d(TAG, "onResumeEvent");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    protected void onStopEvent() {
        Log.d(TAG, "onStopEvent");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    protected void onDestroyEvent() {
        Log.d(TAG, "onDestroyEvent");
    }

    /*
    Note:
    ----
    Lifecycle class holds info about lifecycle of LifecycleOwner/Activity
    LifecycleOwner provides Lifecycle status to Lifecycle-aware components
    LifecycleObserver registers the Lifecycle status to respond and perform actions
     */

}
