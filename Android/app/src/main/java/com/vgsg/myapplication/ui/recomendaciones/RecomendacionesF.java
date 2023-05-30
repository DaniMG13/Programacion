package com.vgsg.myapplication.ui.recomendaciones;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.vgsg.myapplication.R;
import com.vgsg.myapplication.databinding.FragmentSlideshowBinding;
import com.vgsg.myapplication.ListaEntrada;
import com.vgsg.myapplication.ListaAdaptador;

import java.util.ArrayList;

public class RecomendacionesF extends Fragment {

    ArrayList<ListaEntrada> datos = new ArrayList<ListaEntrada>();
    static int canti = 0;
    String titulos[];
    String desc[];
    int image[];
    TypedArray imagenes;

    int prec[];
    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RecomendacionesVM recomendacionesVM =
                new ViewModelProvider(this).get(RecomendacionesVM.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.lblrecomenda;
        //textView.setText("Recomendaciones del dia :)");

        titulos = root.getResources().getStringArray(R.array.Comida);
        desc = root.getResources().getStringArray(R.array.Desc);
        image = root.getResources().getIntArray(R.array.img);
        imagenes = root.getResources().obtainTypedArray(R.array.img);
        prec = root.getResources().getIntArray(R.array.prec);

        for(int i=0;i<titulos.length;i++){
            datos.add(new ListaEntrada(imagenes.getResourceId(i,i),titulos[i],desc[i],prec[i]));
            //System.out.println(prec[i]);
        }

        ListView ltvHome;
        ltvHome = (ListView)root.findViewById(R.id.ltvrecomenda);

        ltvHome.setAdapter(new ListaAdaptador(getContext(), R.layout.listview, datos){
            @Override
            public void onEntrada(Object entrada, View view) {
                TextView texto_superior_entrada = (TextView) view.findViewById(R.id.lblTitulo);
                texto_superior_entrada.setText(((ListaEntrada) entrada).get_textoEncima());

                TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.lblDesc);
                texto_inferior_entrada.setText(((ListaEntrada) entrada).get_textoDebajo());

                texto_inferior_entrada.setTextColor(Color.parseColor("#000000"));
                texto_superior_entrada.setTextColor(Color.parseColor("#000000"));

                ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imvImg);
                imagen_entrada.setImageResource(((ListaEntrada) entrada).get_idImagen());
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