package com.vgsg.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.vgsg.myapplication.databinding.ActivityMainBinding;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
String titulo,precios,cantidades,sub;
float preciot;
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Abrir Carrito de Compras", Snackbar.LENGTH_LONG)
                        .setAction("Carrito", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                carrito();
                            }
                        }).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_met_pago, R.id.nav_recom,R.id.nav_pedidos)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    private void carrito() {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
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

        b.setTitle("Carrito de compra\n");

        DB db = new DB(this);
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

            b.setPositiveButton("Limpiar carrito", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    DB db = new DB(getApplicationContext());
                    SQLiteDatabase base = db.getReadableDatabase();
                    db.Eliminar(base);
                    Snackbar.make(vi,"Carrito Vaciado Correctamente", BaseTransientBottomBar.LENGTH_LONG).show();
                }
            });
            b.setNegativeButton("Realizar Pedido", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                    Date date = new Date();

                    String fecha = dateFormat.format(date);

                    DBPedidos db = new DBPedidos(getApplicationContext());
                    SQLiteDatabase data = db.getWritableDatabase();
                    String sql = "INSERT INTO pedidos VALUES (null,'"+titulo+"','"+fecha+"','"+cantidades+"','"+precios+"'" +
                            ",'"+preciot+"')";
                    data.execSQL(sql);
                    DB d = new DB(getApplicationContext());
                    data = d.getWritableDatabase();
                    d.Eliminar(data);
                }
            });

        }else{
            //Toast.makeText(getContext(),"No se encontraron registros",Toast.LENGTH_LONG).show();
            b.setNegativeButton("Regresar a comprar",null);
        }



        b.show();

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}