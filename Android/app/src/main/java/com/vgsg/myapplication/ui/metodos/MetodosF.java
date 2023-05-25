package com.vgsg.myapplication.ui.metodos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.vgsg.myapplication.databinding.FragmentMetodosBinding;

public class MetodosF extends Fragment {
//Metodos de pago
    private FragmentMetodosBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MetodosVM metodosVM =
                new ViewModelProvider(this).get(MetodosVM.class);

        binding = binding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}