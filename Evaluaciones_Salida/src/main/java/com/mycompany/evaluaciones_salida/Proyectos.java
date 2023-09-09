package com.mycompany.evaluaciones_salida;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/* @author VGSG */

public class Proyectos extends Proyecto{
    ArrayList<Proyecto> lista = new ArrayList<>();
    public Proyectos(){        
    }
    public Proyectos(String v_folio){
        super(v_folio);
    }
    public void getAll(){
        try(BufferedReader bufferLectura = new BufferedReader(new FileReader(rutaP))){//Este comando ayuda a acceder un archivo desde la ruta que le hemos asignado
            String linea = bufferLectura.readLine();
            while(linea != null)
            {
                String[] campos = new String[4];
                campos = linea.split(separador);         
                this.folio = campos[0];
                lista.add(new Proyecto(this.folio));
                this.folio = campos[0];
                this.empresa = campos[1];
                this.proyecto = campos[2];
                this.monto = Float.parseFloat(campos[3]);
                linea = bufferLectura.readLine();//debe haber un fin del ciclo
            }
        }catch(Exception ex){            
        }
    }
}
