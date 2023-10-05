package leerpenj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/* @author VGSG */
public class Procesos extends Proceso{
    ArrayList<Proceso> lista = new ArrayList<>();
    ArrayList<Proceso> cola = new ArrayList<>();
    String ht;
    
    public void getAll(){
        try(BufferedReader bufferLectura = new BufferedReader(new FileReader(rutaP))){
            Proceso paux = null;
            String linea = bufferLectura.readLine();
            while(linea != null){
                String[] campos = new String[4];
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
        int[] priorid = new int[proceso.size()];
        int[] id = new int[proceso.size()];
        for(int k=0;k<priorid.length;k++){
            priorid[k] = proceso.get(k).getPrioridad();
            id[k] = proceso.get(k).getId();
        }
        for(int i=0;i<priorid.length;i++){
            for(int j=0;j<priorid.length-1;j++){
                if(priorid[j]>priorid[j+1]){
                    int auxiliar = priorid[j+1];
                    int idaux = id[j+1];
                    priorid[j+1] = priorid[j];
                    id[j+1] = id[j];
                    priorid[j] = auxiliar;
                    id[j] = idaux;
                }
            }
        }
        for(int i=0;i<id.length;i++){
            //System.out.println("ID: "+id[i]+" Prioridad :"+priorid[i]);
            cola.add(proceso.get(0).getID(id[i]));
        }
        
    }
    
    public void Procesar(){
        File archivo = new File(rutaS);
        try{
            String aux = "";
            FileWriter writer = new FileWriter(archivo);
            String[] procesos = new String[cola.size()];
            writer.write("ID|HLLEGADA|H_SALIDA|CPU|PRIORIDAD\n");
            for(int i=0;i<procesos.length;i++){
                aux+=String.format("%02d", cola.get(i).getId())+"|";
                aux+=cola.get(i).getHora()+"|";
                aux+=hora()+"|";
                aux+=String.format("%02d",cola.get(i).getCpu())+"|";
                aux+=String.format("%02d",cola.get(i).getPrioridad())+"\n";
                procesos[i] = aux;
                System.out.println(aux);
                aux="";
                try{
                    Thread.sleep(cola.get(i).getCpu()*1000);
                }catch(Exception e){
                    System.out.println("Error Thread: "+e.getMessage());
                }    
            }
            for(int j=0;j<procesos.length;j++){
                writer.append(procesos[j]);
            }
            writer.close();
        }catch(IOException e){
            System.err.println("Error archivo: "+e.getMessage());
        } 
    }
    
    public void Imprimir(){
        System.out.println("ID|HLLEGADA|CPU|PRIORIDAD\n");
        for(int i=0;i<cola.size();i++){
            String aux = "";
            aux+=String.format("%02d",cola.get(i).getId())+"|";
            aux+=cola.get(i).getHora()+"|";
            aux+=String.format("%02d",cola.get(i).getCpu())+"|";
            aux+=String.format("%02d",cola.get(i).getPrioridad())+"\n";
            System.out.print(aux);
        }
    }
    
    private String hora(){
        DateFormat dF = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        ht = dF.format(date);
        return ht;
    }
    
}
