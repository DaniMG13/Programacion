package com.vgsg.myapplication.ui.home;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.vgsg.myapplication.DB;
import com.vgsg.myapplication.DBPedidos;
import com.vgsg.myapplication.R;
import com.vgsg.myapplication.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.Calendar;

public class HomeF extends Fragment {
    AlertDialog.Builder dialog;
    private FragmentHomeBinding binding;
    static int canti = 0;
    String titulos[];
    String desc[];
    int image[];
    TypedArray imagenes;

    int prec[];

    String titulo = "";
    String precios = "";
    String cantidades = "";
    String sub = "";

    float preciot = 0;
    ArrayList<ListaEntrada> datos = new ArrayList<ListaEntrada>();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeVM homeVM =
                new ViewModelProvider(this).get(HomeVM.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        View v = binding.getRoot().getRootView();

        titulos = v.getResources().getStringArray(R.array.Comida);
        desc = v.getResources().getStringArray(R.array.Desc);
        image = v.getResources().getIntArray(R.array.img);
        imagenes = v.getResources().obtainTypedArray(R.array.img);
        prec = v.getResources().getIntArray(R.array.prec);

        for(int i=0;i<titulos.length;i++){
            datos.add(new ListaEntrada(imagenes.getResourceId(i,i),titulos[i],desc[i],prec[i]));
            //System.out.println(prec[i]);
        }

        ListView ltvHome;
        ltvHome = (ListView)v.findViewById(R.id.ltvHome);

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
                //Toast.makeText(getContext(),"Posicion: "+position,Toast.LENGTH_SHORT).show();
                View vi = getLayoutInflater().inflate( R.layout.detalles_producto, null);

                dialog  = new AlertDialog.Builder(getContext());
                dialog.setView(vi);
                //dialog.setTitle(titulos[position]);

                ImageView imgAux = (ImageView)vi.findViewById(R.id.imvDeta);

                dialog.setNegativeButton("Ver Carrito", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        carrito();
                    }
                });

                imgAux.setImageResource(imagenes.getResourceId(position,position));

                TextView lblT = (TextView)vi.findViewById(R.id.lblDeT);
                lblT.setText(titulos[position]);
                lblT.setTextSize(20);

                TextView lblDesc = (TextView)vi.findViewById(R.id.lblDeD);
                lblDesc.setText(desc[position]);

                TextView lbPrec = (TextView)vi.findViewById(R.id.lblprec);
                lbPrec.setText("$ "+prec[position]);

                TextView lblcant = (TextView)vi.findViewById(R.id.lblcanti);

                Button btnadd = (Button)vi.findViewById(R.id.btnADD);
                btnadd.setEnabled(false);

                lblcant.setTextSize(19);
                lblcant.setText(""+canti);
                if(canti>0){
                    btnadd.setEnabled(true);
                }

                TextView lblmenos = (TextView)vi.findViewById(R.id.lblmenos);
                lblmenos.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(canti>0){
                            canti--;
                            lblcant.setText(""+canti);
                        }
                        if(canti==0){
                            btnadd.setEnabled(false);
                        }
                    }
                });

                TextView lblmas = (TextView)vi.findViewById(R.id.lblmas);
                lblmas.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(canti>=0){
                            canti++;
                            lblcant.setText(""+canti);
                            btnadd.setEnabled(true);
                        }
                    }
                });

                btnadd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DB db = new DB(getContext());
                        SQLiteDatabase data = db.getWritableDatabase();
                        if(data != null){
                            float precio = 0;
                            int cantidad = 0;
                            try{
                                cantidad = Integer.parseInt(lblcant.getText().toString());
                                precio = Float.parseFloat(lbPrec.getText().toString().substring(1));
                            }catch (Exception e){
                                Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                            }

                            float total = precio*cantidad;
                            //Toast.makeText(getContext(),"Base creada",Toast.LENGTH_LONG).show();
                            String sql = "INSERT INTO CARRITO VALUES (null,'"+lblT.getText()+"','"+lblDesc.getText()+"" +
                                    "',"+cantidad+","+precio+"" +
                                    ","+total+")";

                            try{
                                data.execSQL(sql);
                                canti=0;
                                Snackbar snack = Snackbar.make(view,"Agregado Al Carrito", BaseTransientBottomBar.LENGTH_SHORT).setAction("Ver Pedidos", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                            carrito();
                                    }
                                });
                                snack.show();

                            }catch(SQLException e){
                                Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                });

                dialog.show();
            }
        });

        return root;
    }

    private void carrito() {
        AlertDialog.Builder b = new AlertDialog.Builder(getContext());
        View vi = getLayoutInflater().inflate( R.layout.carrito_inf, null);
        b.setView(vi);

        TextView lblcarrito = (TextView)vi.findViewById(R.id.lblcarrito);
        lblcarrito.setText("No tienes nada agregado al carrito");

        TextView lblprec = (TextView)vi.findViewById(R.id.lbl_precio);
        TextView lblcanti = (TextView)vi.findViewById(R.id.lblcanticar);
        TextView lblsub = (TextView)vi.findViewById(R.id.lblsubt);
        TextView lbltotal = (TextView)vi.findViewById(R.id.lbltotalapaga);
        TextView lblaux = (TextView)vi.findViewById(R.id.lblauxtap);

        lblaux.setText("");
        lblsub.setText("");
        lblcanti.setText("");
        lblsub.setText("");
        lbltotal.setText("");
        lblprec.setText("");

        DB db = new DB(getContext());
        SQLiteDatabase data = db.getReadableDatabase();
        Cursor c = data.rawQuery("select * from carrito",null);
        if(c.moveToFirst()){
            titulo = "";
            precios = "";
            cantidades = "";
            sub = "";
            int cantidad = 0;
            float preciouni = 0;
            float pta = 0;
            preciot = 0;
            do{
                cantidad = c.getInt(3);
                preciouni = c.getFloat(4);
                pta += (cantidad*preciouni);
                preciot += pta;

                titulo += c.getString(1)+"\n";
                lblcarrito.setText(titulo);

                precios += "$ "+preciouni+"\n";
                lblprec.setText(precios);

                cantidades += " x "+String.format("%02d",cantidad)+"\n";
                lblcanti.setText(cantidades);

                sub += "$ "+pta+"\n";
                lblsub.setText(sub);
                pta = 0;

                lbltotal.setText("$ "+preciot);

            }while(c.moveToNext());

        }else{
            //Toast.makeText(getContext(),"No se encontraron registros",Toast.LENGTH_LONG).show();
        }

        b.setPositiveButton("Limpiar carrito", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DB db = new DB(getContext());
                SQLiteDatabase base = db.getReadableDatabase();
                db.Eliminar(base);
                Snackbar.make(getView(),"Carrito Vaciado Correctamente",BaseTransientBottomBar.LENGTH_LONG).show();
            }
        });
        b.setNegativeButton("Realizar Pedido", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DBPedidos db = new DBPedidos(getContext());
                SQLiteDatabase data = db.getWritableDatabase();
                String sql = "INSERT INTO pedidos VALUES (null,'"+titulo+"','"+cantidades+"','"+precios+"'" +
                        ",'"+preciot+"')";
                data.execSQL(sql);
                DB d = new DB(getContext());
                data = d.getWritableDatabase();
                d.Eliminar(data);
            }
        });
        b.show();
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