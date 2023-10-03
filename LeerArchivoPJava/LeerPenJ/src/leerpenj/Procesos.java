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
                linea = bufferLectura.readLine();//debe haber un fin del ciclo
            }
            Encolar(lista);
        }catch(Exception ex){
            System.err.println("Error en Buffered (Procesos): "+ex.getMessage());
        }
    }
    
    public void Encolar(ArrayList<Proceso> proceso){
        if(cola.isEmpty()){
           cola.add(proceso.get(0));
        }else{
            System.out.println("Cola:"+cola.size());
            for(int i=0;i<proceso.size();i++){
                if(cola.get(i).getPrioridad()<proceso.get(i).getPrioridad()){
                    cola.add(i,proceso.get(i));
                }
                if(cola.get(i).getPrioridad()>proceso.get(i).getPrioridad()){
                    cola.add(proceso.get(i));
                }
            }
        }
        for(int i=0;i<lista.size();i++){
                System.out.println(lista.get(i).getProceso());
        }
    }
    
    public void Imprimir(){
        for(int i=0;i<lista.size();i++){
            System.out.println(lista.get(i).getProceso());
        }
    }
    
}
