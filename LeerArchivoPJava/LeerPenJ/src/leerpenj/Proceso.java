package leerpenj;

import java.io.BufferedReader;
import java.io.FileReader;

/* @author VGSG */
public class Proceso {
    static String separador = "\\|";
    int id,cpu,prioridad;
    String hora;
    static final String rutaP = "C:\\Users\\sergi\\OneDrive\\Documentos\\GitHub\\Programacion\\PhytonProjects\\archivo.dat";

    public Proceso() {
    }

    public Proceso(int id, String hora,int cpu, int prioridad) {
        this.id = id;
        this.cpu = cpu;
        this.prioridad = prioridad;
        this.hora = hora;
    } 
    
    public void Leer(){
        try(BufferedReader bufferLectura = new BufferedReader(new FileReader(rutaP))){
            //Estecomando ayuda a acceder un archivo desde la ruta que le hemos asignado
            String linea = bufferLectura.readLine();
            while(linea != null){
                String[] campos = new String[4];
                campos = linea.split(separador);
                try{
                    this.id = Integer.parseInt(campos[0]);
                    this.hora = campos[1];
                    this.cpu = Integer.parseInt(campos[2]);
                    this.prioridad = Integer.parseInt(campos[3]);
                }catch(Exception e){
                    System.err.println("Error en casteo a int: "+e.getMessage());
                }
                linea = bufferLectura.readLine();//debe haber un fin del ciclo
            }
        }catch(Exception ex){
            System.err.println("Error del Buffered (Proceso): "+ex.getMessage());
        }
    }

    public String getProceso(){
        String aux = this.id+" "+this.hora+" "+this.cpu+" "+this.prioridad;
        return aux;
    }
    
    public static String getSeparador() {
        return separador;
    }

    public static void setSeparador(String separador) {
        Proceso.separador = separador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCpu() {
        return cpu;
    }

    public void setCpu(int cpu) {
        this.cpu = cpu;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
}
