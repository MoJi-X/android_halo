package com.example.myapplication.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private String homeurl="http://47.113.204.48/";
    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(homeurl);
    }

    public LiveData<String> geturl() {
        return mText;
    }
}