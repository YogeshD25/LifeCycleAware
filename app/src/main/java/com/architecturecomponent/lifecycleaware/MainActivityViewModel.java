package com.architecturecomponent.lifecycleaware;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class MainActivityViewModel extends ViewModel {
    private String TAG = this.getClass().getSimpleName();
    private MutableLiveData<String> myRandomNumber;

    MutableLiveData<String> getNumber() {
        Log.i(TAG, "get Number");
        if (myRandomNumber == null) {
            myRandomNumber = new MutableLiveData<>();
            createNumber();
        }
        return myRandomNumber;
    }

    void createNumber() {
        Log.i(TAG, "create new number");
        Random random = new Random();
        myRandomNumber.setValue("Number: " + (random.nextInt(10 - 1) + 1));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG, "On Cleared called");
    }
}
