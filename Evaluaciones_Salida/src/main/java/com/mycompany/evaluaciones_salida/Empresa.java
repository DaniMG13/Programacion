package com.mycompany.evaluaciones_salida;

import java.io.BufferedReader;
import java.io.FileReader;

/* @author VGSG */

public class Empresa {
    String folio, empresa;
    static String rutaE = "C:\\Users\\sergi\\Documents\\ED_CVS\\empresas.csv";
    static String separador = "\\|";
    //Constructores
    public Empresa(){ //recuperar proyectos       
    }
    public Empresa(String v_folio,String v_empresa){//generar nuevos proyectos
        this.folio = v_folio;
        this.empresa = v_empresa;
    }
    //getOne recuperar los datos del origen de datos, en el archivo
    public Empresa(String v_folio){
        try(BufferedReader bufferLectura = new BufferedReader(new FileReader(rutaE))){//Este comando ayuda a acceder un archivo desde la ruta que le hemos asignado
            String linea = bufferLectura.readLine();
            while(linea != null)
            {
                String[] campos = new String[2];
                campos = linea.split(separador);
                if (campos[0].equals(v_folio)){
                    this.folio = campos[0];
                    this.empresa = campos[1];
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
    public String getEmpresa(){
        return this.empresa;
    }
    //Setters
    public void setEmpresa(String v_empresa) {
        this.empresa = v_empresa;
    }
    public void setFolio(String v_folio) {
        this.folio = v_folio;
    }
}
