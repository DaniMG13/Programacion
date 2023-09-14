package com.mycompany.evaluaciones_salida;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/* @author VGSG */

public class Evaluadores extends Evaluador{
    ArrayList<Evaluador> lista = new ArrayList<>();
    public Evaluadores(){        
    }
    public Evaluadores(String v_folio){
        super(v_folio);
    }
    public void getAll(){
        try(BufferedReader bufferLectura = new BufferedReader(new FileReader(rutaEva))){//Este comando ayuda a acceder un archivo desde la ruta que le hemos asignado
            String linea = bufferLectura.readLine();
            while(linea != null)
            {
                String[] campos = new String[4];
                campos = linea.split(separador);         
                this.folio = campos[0];
                lista.add(new Evaluador(this.folio));
                this.folio = campos[0];
                this.empresa = campos[1];
                this.nombre = campos[2];
                this.ap = campos[3];
                this.am = campos[4];
                linea = bufferLectura.readLine();//debe haber un fin del ciclo
            }
        }catch(Exception ex){            
        }
    }
    public void getAllPorEmpresa(String empresa){
        try(BufferedReader bufferLectura = new BufferedReader(new FileReader(rutaEva))){//Este comando ayuda a acceder un archivo desde la ruta que le hemos asignado
            String linea = bufferLectura.readLine();
            while(linea != null)
            {
                String[] campos = new String[2];
                campos = linea.split(separador);  
                if(empresa.equals(campos[1])){
                    lista.add(new Evaluador(campos[0]));
                    this.folio = campos[0];
                    this.empresa = campos[1];
                }
                linea = bufferLectura.readLine();//debe haber un fin del ciclo
            }
        }catch(Exception ex){            
        }
    }
    public void getAllNoEmpresa(String empresa){
        try(BufferedReader bufferLectura = new BufferedReader(new FileReader(rutaEva))){//Este comando ayuda a acceder un archivo desde la ruta que le hemos asignado
            String linea = bufferLectura.readLine();
            while(linea != null)
            {
                String[] campos = new String[2];
                campos = linea.split(separador);  
                if(!campos[1].equals(empresa)){
                    this.folio = campos[0];
                    this.empresa = campos[1];
                    lista.add(new Evaluador(campos[0]));
                }
                linea = bufferLectura.readLine();//debe haber un fin del ciclo
            }
        }catch(Exception ex){            
        }
    }
}
