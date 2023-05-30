package com.vgsg.myapplication.ui.metodos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MetodosVM extends ViewModel {

    private final MutableLiveData<String> mText;

    public MetodosVM() {
        mText = new MutableLiveData<>();

    }

    public LiveData<String> getText() {
        return mText;
    }
}