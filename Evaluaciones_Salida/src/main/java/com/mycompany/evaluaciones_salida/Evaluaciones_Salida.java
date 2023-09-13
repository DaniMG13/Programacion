package com.mycompany.evaluaciones_salida;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* @author VGSG */

public class Evaluaciones_Salida {

    public static void main(String[] args) {
        //Instancia de los proyectos
        Proyectos p = new Proyectos();
        p.getAll();
        //Instancia de las empresas
        Empresas e = new Empresas();
        e.getAll();
        //Instancia de los evaluadores
        Evaluadores ev = new Evaluadores();
        ev.getAll();
        //Metodo para generar los datos de la evaluacion
        evaluar(p,e,ev);
    }

    private static void evaluar(Proyectos p, Empresas e, Evaluadores ev) {
        int nP = p.lista.size();
        int nEmp = e.lista.size();
        int nEva = ev.lista.size();
        //Arreglo donde se almacenaran las evaluaciones ya completas
        String[] evaluados = new String[nP];
        String externo = "";
        for(int i=0;i<nP;i++){
            String nomEmp = ev.lista.get(i).getFolio().substring(0,1);
            String fEva = ev.lista.get(i).getFolio().substring(0,1);
            evaluados[i] = p.lista.get(i).getFolio()+ " | "+p.lista.get(i).getEmpresa()+ " | " + p.lista.get(i).getProyecto() + " | "
                        + p.lista.get(i).getMonto() + " | LOCAL | " ;
            //Se evalua si la inicial del folio es igual a la inicial del nombre de la empresa para validar si es local la evaluacion
            if(fEva.equals(nomEmp)){
                evaluados[i] += ev.lista.get(i).getFolio();
            }
            //Se busca si la inicial del folio es diferente a la inicial del nombre de la empresa para validar si es externa la evaluacion
            for(int j=0;j<nEmp;j++){
                if(!(ev.lista.get(j).getFolio().substring(0,1).equals(nomEmp))){
                    externo = ev.lista.get(j).getFolio();
                }
            }   
            //Se agrega la evaluacion externa y se agrega la cantidad aleatoria de la evaluacion
            evaluados[i] += " | " + cantidad(p,i) + " | EXTERNA | " + externo + " | " + cantidad(p,i)+"\n";
        }
        System.out.println("Proyectos evaluados\n");
        for(int i=0;i<evaluados.length;i++){
            System.out.print(evaluados[i]);
        }
        generarArchivo(evaluados);
    }
    //Metodo para generar la cantidad aleatoria en los parametros de 0 hasta un 20% mas del propuesto
    private static int cantidad(Proyectos p,int i) {
        return (int)Math.floor(Math.random()*(p.lista.get(i).monto+(p.lista.get(i).getMonto()*20)/100-0+1+0));
    }

    private static void generarArchivo(String[] evaluados) {
        String ruta = "D:\\EvaluacionesTerminado.csv";
        File archivo = new File(ruta);
        try {
            FileWriter writer = new FileWriter(archivo);
            for(int i=0;i<evaluados.length;i++){
                writer.write(evaluados[i]);
            }
            writer.close();
            System.out.println("\nArchivo generado en: "+ruta);
        } catch (IOException ex) {
            Logger.getLogger(Evaluaciones_Salida.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
