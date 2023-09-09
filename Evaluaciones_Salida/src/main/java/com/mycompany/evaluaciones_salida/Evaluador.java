package com.mycompany.evaluaciones_salida;

import java.io.BufferedReader;
import java.io.FileReader;

/* @author sergi */
public class Evaluador {
    String empresa, folio,nombre,ap,am;
    static String rutaEva = "C:\\Users\\sergi\\Documents\\ED_CVS\\evaluadores.csv";
    static String separador = "\\|";
    //Constructores
    public Evaluador(){ //recuperar proyectos       
    }
    public Evaluador(String v_folio,String v_empresa,String v_nombre,String v_ap,String v_am){//generar nuevos proyectos
        this.folio = v_folio;
        this.empresa = v_empresa;
        this.nombre = v_nombre;
        this.ap = v_ap;
        this.am = v_am;
    }
    //getOne recuperar los datos del origen de datos, en el archivo
    public Evaluador(String v_folio){
        try(BufferedReader bufferLectura = new BufferedReader(new FileReader(rutaEva))){//Este comando ayuda a acceder un archivo desde la ruta que le hemos asignado
            String linea = bufferLectura.readLine();
            while(linea != null)
            {
                String[] campos = new String[5];
                campos = linea.split(separador);
                if (campos[0].equals(v_folio)){
                    this.folio = campos[0];
                    this.empresa = campos[1];
                    this.nombre = campos[2];
                    this.ap = campos[3];
                    this.am = campos[4];
                }
                linea = bufferLectura.readLine();//debe haber un fin del ciclo
            }
        }catch(Exception ex){            
        }
    }
    //Getters
    public String getFolio(){
        return this.folio;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getApellidoP(){
        return this.ap;
    }
    public String getApellidoM(){
        return this.am;
    }
    //Setters
    public void setFolio(String v_folio) {
        this.folio = v_folio;
    }
    public void setNombre(String v_nombre) {
        this.nombre = v_nombre;
    }
    public void setApellidoP(String v_apellidoP) {
        this.ap = v_apellidoP;
    }
    public void setApellidoM(String v_apellidoM) {
        this.am = v_apellidoM;
    }
}
