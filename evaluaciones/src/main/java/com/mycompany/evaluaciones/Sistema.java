package com.mycompany.evaluaciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Sistema
{    

    private String seprador;
    private String ruta;
    public int aleatorio(int numMenor,int numMayor)
    {        
        int num = (int)Math.random()*(numMayor-numMenor+1);
        return num;
    }
    public void escribirArchivo(ArrayList arr, String ruta){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))){
            for (int i = 0; i < arr.size(); i++){
                
            }            
        }catch(Exception ex){            
        }
    }
    //filtrar las empresas
    public void getAllEmpresa(){
        try(BufferedReader bufferLectura = new BufferedReader(new FileReader(ruta))){//Este comando ayuda a acceder un archivo desde la ruta que le hemos asignado
            String linea = bufferLectura.readLine();
            while(linea != null)
            {
                String[] campos = new String[4];
                
                campos = linea.split(seprador);         
                /*this.folio = campos[0];
                lista.add(new Proyecto(this.folio));
                this.folio = campos[0];
                this.empresa = campos[1];
                this.proyecto = campos[2];
                this.monto = Float.parseFloat(campos[3]);*/
                linea = bufferLectura.readLine();//debe haber un fin del ciclo
            }
        }catch(Exception ex){            
        }
    }
}
