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
    
    public void Encolar(Proceso proceso){
        if(cola.isEmpty()){
           cola.add(proceso);
        }else{
            boolean banMenor = false;
            int ix = 0;
            for(int i=1;i<cola.size();i++){
                for(int j=1;j<cola.size();j++){
                    //System.out.println("Cola:"+cola.size());
                    System.out.println("ID: "+proceso.getId());
                    //System.out.println("Cola Prioridad: "+cola.get(i).getPrioridad()+"\nProceso Prioridad: "+proceso.getPrioridad());
                    if(cola.get(i).getPrioridad()<proceso.getPrioridad()){
                        banMenor = true;
                    }else{
                        banMenor = false;
                    }
                    ix = i;
                }
            }
            
            if(banMenor){
                cola.add(ix,proceso);
            }else{
                cola.add(proceso);
            }
        }
    }
    
    public void Imprimir(){
        for(int i=0;i<cola.size();i++){
            System.out.println(cola.get(i).getProceso());
        }
    }
    
}
