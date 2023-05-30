package com.vgsg.myapplication.ui.recomendaciones;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RecomendacionesVM extends ViewModel {

    private final MutableLiveData<String> mText;

    public RecomendacionesVM() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}