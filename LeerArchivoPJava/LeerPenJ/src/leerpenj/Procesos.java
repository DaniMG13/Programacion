package leerpenj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/* @author VGSG */
public class Procesos extends Proceso{
    ArrayList<Proceso> lista = new ArrayList<>();
    ArrayList<Proceso> cola = new ArrayList<>();
    
    public void getAll(){
        try(BufferedReader bufferLectura = new BufferedReader(new FileReader(rutaP))){

            String linea = bufferLectura.readLine();
            while(linea != null){
                String[] campos = new String[4];
                Proceso paux = null;
                campos = linea.split(separador);
                try{
                    this.id = Integer.parseInt(campos[0]);
                    this.hora = campos[1];
                    this.cpu = Integer.parseInt(campos[2]);
                    this.prioridad = Integer.parseInt(campos[3]);
                    paux = new Proceso(this.id,this.hora,this.cpu,this.prioridad);
                    lista.add(paux);
                }catch(NumberFormatException e){
                    System.err.println("Error en casteo a int: "+e.getMessage());
                }
                Encolar(paux);
                linea = bufferLectura.readLine();//debe haber un fin del ciclo
            }
            
        }catch(Exception ex){
            System.err.println("Error en Buffered (Procesos): "+ex.getMessage());
        }
    }
    
    public void Encolar(Proceso paux){
        if(cola.isEmpty()){
           cola.add(paux);
        }else{
            System.out.println("Cola:"+cola.size());
            for(int i=0;i<cola.size();i++){
                if(cola.get(i).getPrioridad()<paux.getPrioridad()){
                    cola.add(i,paux);
                }
                if(cola.get(i).getPrioridad()>paux.getPrioridad()){
                    cola.add(paux);
                }
            }
        }
        for(int i=0;i<cola.size();i++){
                System.out.println(cola.get(i).getProceso());
        }
    }
    
    public void Imprimir(){
        for(int i=0;i<lista.size();i++){
            System.out.println(lista.get(i).getProceso());
        }
    }
    
}
