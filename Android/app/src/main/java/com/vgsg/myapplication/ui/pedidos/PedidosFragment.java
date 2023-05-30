package com.vgsg.myapplication.ui.pedidos;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.vgsg.myapplication.DBPedidos;
import com.vgsg.myapplication.R;

import java.util.ArrayList;

public class PedidosFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;

    ArrayList<String> names;
    ArrayList<String> ids;
    private String mParam2;

    DBPedidos db;
    SQLiteDatabase data;
    Cursor c;
    public PedidosFragment() {

    }

    public static PedidosFragment newInstance(String param1, String param2) {
        PedidosFragment fragment = new PedidosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_pedidos, container, false);

        ListView ltvPedidos = (ListView)v.findViewById(R.id.lvtpedidosrealiza);

        db = new DBPedidos(getContext());
        data = db.getReadableDatabase();
        c = data.rawQuery("select * from pedidos",null);

        names = new ArrayList<String>();
        ids = new ArrayList<String>();

        if(c.moveToFirst()){
               do{
                   names.add("ID: "+c.getInt(0)+" - Pedido del "+c.getString(2));
                   ids.add(""+c.getInt(0));
               }while(c.moveToNext());
        }
        c.close();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, names);
        ltvPedidos.setAdapter(adapter);

        ltvPedidos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //int posit = position+1;
                //Toast.makeText(getContext(),names.get(0)+" ID: "+ids.get(0),Toast.LENGTH_SHORT).show();
                db = new DBPedidos(getContext());
                data = db.getReadableDatabase();
                c = data.rawQuery("select * from pedidos where id="+ids.get(position),null);
                if(c.moveToFirst()){
                    AlertDialog.Builder b = new AlertDialog.Builder(getContext());
                    View vi = getLayoutInflater().inflate( R.layout.carrito_inf, null);
                    b.setView(vi);

                    TextView lblcarrito = (TextView)vi.findViewById(R.id.lblcarrito);
                    lblcarrito.setText(c.getString(1));

                    TextView lblprec = (TextView)vi.findViewById(R.id.lbl_precio);
                    TextView lblcanti = (TextView)vi.findViewById(R.id.lblcanticar);
                    TextView lblsub = (TextView)vi.findViewById(R.id.lblsubt);
                    TextView lbltotal = (TextView)vi.findViewById(R.id.lbltotalapaga);
                    TextView lblaux = (TextView)vi.findViewById(R.id.lblauxtap);

                    lblaux.setText("Total pagado");
                    lblcanti.setText(c.getString(3));
                    lblsub.setText(c.getString(5));
                    lbltotal.setText("$ "+c.getString(6));
                    lblprec.setText(c.getString(4));

                    b.setTitle("Detalles del pedido del "+c.getString(2)+"\n");

                    b.setNegativeButton("OK",null);
                    b.show();
                }else{
                    Toast.makeText(getContext(),"Error mio xd",Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;
    }
}