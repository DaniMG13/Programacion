package com.vgsg.myapplication.ui.home;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.navigation.NavigationView;
import com.vgsg.myapplication.R;
import com.vgsg.myapplication.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.Calendar;

public class HomeF extends Fragment {
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeVM homeVM =
                new ViewModelProvider(this).get(HomeVM.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        View v = binding.getRoot().getRootView();

        ArrayList<ListaEntrada> datos = new ArrayList<ListaEntrada>();
        datos.add(new ListaEntrada(R.drawable.hambsoya,"Hamburguesa de Soya","Hamburguesa de soya con papas",40));
        datos.add(new ListaEntrada(R.drawable.hambpollo,"Hamburguesa de Pollo","Hamburguesa de pollo con papas",50));
        datos.add(new ListaEntrada(R.drawable.gomitas_l,"Gomitas de Lombriz","Gomitas de lombrices de diferentes sabores",10));
        datos.add(new ListaEntrada(R.drawable.mango,"Gomitas de Mango","Gomitas de mango con chile",10));
        datos.add(new ListaEntrada(R.drawable.durazno,"Gomitas de Durazno","Gomitas de durazno circulares",10));
        datos.add(new ListaEntrada(R.drawable.manzana,"Gomitas de Manzana","Gomitas de manzana circulares",10));
        datos.add(new ListaEntrada(R.drawable.gallet,"Galletas con Chocolate","Galletas con Chocolate de Costco",8));
        datos.add(new ListaEntrada(R.drawable.donit,"Donitas de Canela","Donitas de canela de Costco",4));
        datos.add(new ListaEntrada(R.drawable.cafe,"Cafe del Dia","Vaso de cafe del dia 250ml",15));
        datos.add(new ListaEntrada(R.drawable.chicken,"Chicken Bake","Chicken bake estilo costco",40));
        datos.add(new ListaEntrada(R.drawable.brown,"Brownies de Chocolate","Browmnie de chocolate con chispas dentro",20));
        datos.add(new ListaEntrada(R.drawable.sk_r_s,"Skwinkles rellenos","Skwinkles de sandia rellenos",15));
        datos.add(new ListaEntrada(R.drawable.sk_r_p,"Skwinkles rellenos","Skwinkles de piña rellenos",15));
        datos.add(new ListaEntrada(R.drawable.salsag,"Skwinkles Salsagheti","Skwinkles salsagheti pequeños",12));
        datos.add(new ListaEntrada(R.drawable.molle,"Molletes","Molletes con frijoles, queso y salsa",45));

        ListView ltvHome;
        ltvHome = (ListView)v.findViewById(R.id.ltvHome);

        /*/TextView saludo,comida;

        saludo = (TextView)header.findViewById(R.id.lblsaludo);
        comida = (TextView)header.findViewById(R.id.lblcomida);

        Calendar cal = Calendar.getInstance();

        int hora =  cal.get(Calendar.HOUR_OF_DAY);
        try{
            if(hora<12) {
                saludo.setText("!Buenos dias Juan Manuel!");
                comida.setText("¿Qué vamos a desayunar?");
            }else{
                if(hora>=12 && hora<19){
                    saludo.setText("!Buenas tardes Juan Manuel!");
                    comida.setText("¿Qué vamos a comer?");
                }else{
                    saludo.setText("!Buenas noches Juan Manuel!");
                    comida.setText("¿Qué vamos a cenar?");
                }
            }
        }catch(Exception e){
            Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }*/

        ltvHome.setAdapter(new Lista_adaptador(getContext(), R.layout.listview, datos){
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

        ltvHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(),"Posicion: "+position,Toast.LENGTH_SHORT).show();
                
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

class ListaEntrada {
    private int idImagen;
    private String textoEncima;
    private String textoDebajo;
    private double precio;

    public ListaEntrada (int idImagen, String textoEncima, String textoDebajo,double precio) {
        this.idImagen = idImagen;
        this.textoEncima = textoEncima;
        this.textoDebajo = textoDebajo;
        this.precio = precio;
    }

    public String get_textoEncima() {
        return textoEncima;
    }

    public String get_textoDebajo() {
        return textoDebajo;
    }

    public int get_idImagen() {
        return idImagen;
    }

    public double getPrecio(){
        return precio;
    }
}

abstract class Lista_adaptador extends BaseAdapter {

    private ArrayList<?> entradas;
    private int R_layout_IdView;
    private Context contexto;

    public Lista_adaptador(Context contexto, int R_layout_IdView, ArrayList<?> entradas) {
        super();
        this.contexto = contexto;
        this.entradas = entradas;
        this.R_layout_IdView = R_layout_IdView;
    }

    @Override
    public View getView(int posicion, View view, ViewGroup pariente) {
        if (view == null) {
            LayoutInflater vi = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = vi.inflate(R_layout_IdView, null);
        }
        onEntrada (entradas.get(posicion), view);
        return view;
    }

    @Override
    public int getCount() {
        return entradas.size();
    }

    @Override
    public Object getItem(int posicion) {
        return entradas.get(posicion);
    }

    @Override
    public long getItemId(int posicion) {
        return posicion;
    }

    /** Devuelve cada una de las entradas con cada una de las vistas a la que debe de ser asociada
     * @param entrada La entrada que será la asociada a la view. La entrada es del tipo del paquete/handler
     * @param view View particular que contendrá los datos del paquete/handler
     */
    public abstract void onEntrada (Object entrada, View view);

}