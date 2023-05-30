package com.vgsg.myapplication.ui.metodos;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.vgsg.myapplication.R;
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

        View v = binding.getRoot().getRootView();

        Button btnAddm = (Button)v.findViewById(R.id.btnaddmetpa);

        btnAddm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder b = new AlertDialog.Builder(getContext());
                b.setTitle("Agregar Metodo de Pago")
                        .setMessage("Esta opcion no esta disponible por el momento, espera futuras versiones")
                        .setCancelable(false)
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                btnAddm.setEnabled(false);
                            }
                        })
                        .show();
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}