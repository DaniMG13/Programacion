package generararchivo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/* @author VGSG */
public class Proceso {
    static String ruta = "C:\\Users\\sergi\\OneDrive\\Documentos\\GitHub\\Programacion\\NetBeansProjects\\GenerarArchivo\\archivo.dat";
    static int id = 1;
    String procesos[];
    static String ht;
    int vsleep;
    int p,pmin = 20,pmax = 100;
    
    public void Crear(){
        File archivo = new File(ruta);
        try{
            String aux = "";
            p = random(pmin,pmax);
            procesos = new String[p-pmin];
            FileWriter writer = new FileWriter(archivo);
            writer.write("ID_TRABAJO|HORA_LLEGADA|TIEMPO_CPU|PRIORIDAD");
            for(int i=0;i<procesos.length;i++){
                //Obtenemos el ID del proceso
                aux += "\n"+String.format("%02d", id)+"|";
                //Obtenemos la hora del sistema
                aux += hora()+"|";
                vsleep = random(1,4)*1000;
                aux += String.format("%02d", random(1, 15))+"|";
                aux += String.format("%02d", random(1,5))+"|";
                procesos[i] = aux;
                aux = "";
                id++;
                try{
                    Thread.sleep(vsleep);
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

    private int random(int pmin, int pmax) {
        return (int)(Math.floor(Math.random()*(pmax-pmin+1)+pmin));
    }
    
    private String hora(){
        DateFormat dF = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        ht = dF.format(date);
        return ht;
    }
}
