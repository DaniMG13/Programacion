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
        //Instancia de los evaluadores
        Evaluadores ev = new Evaluadores();
        ev.getAll();
        //Metodo para generar los datos de la evaluacion
        evaluar(p,ev);
    }

    private static void evaluar(Proyectos p, Evaluadores ev) {
        Evaluadores eTemp = ev;
        int NoProyec = p.lista.size();;
        int nP = 0;
        //Arreglo donde se almacenaran las evaluaciones ya completas
        String[] evaluados = new String[NoProyec];
        for(int i=0;i<NoProyec;i++){
            eTemp.lista.clear();
            evaluados[i] = p.lista.get(i).getFolio()+ " | "+p.lista.get(i).getEmpresa()+ " | " + p.lista.get(i).getProyecto() + " | "
                        + p.lista.get(i).getMonto() + " | LOCAL | " ;
            //Se evalua si la inicial del folio es igual a la inicial del nombre de la empresa para validar si es local la evaluacion
            eTemp.getAllPorEmpresa(p.lista.get(i).getEmpresa());
            nP = eTemp.lista.size();
            evaluados[i] += eTemp.lista.get(randomN(nP)).getFolio();
            eTemp.lista.clear();
            nP=0;
            eTemp.getAllNoEmpresa(p.lista.get(i).getEmpresa());
            nP = eTemp.lista.size();
            //Se agrega la evaluacion externa y se agrega la cantidad aleatoria de la evaluacion
            evaluados[i] += " | " + cantidad(p,i) + " | EXTERNA | " + eTemp.lista.get(randomN(nP)).getFolio() + " | " + cantidad(p,i)+"\n";
            nP = 0;
            eTemp.lista.clear();
        }
        System.out.println("Proyectos evaluados\n");
        for(int i=0;i<evaluados.length;i++){
            System.out.print(evaluados[i]);
        }
        eTemp.lista.clear();
        generarArchivo(evaluados);
    }
    //Metodo para generar la cantidad aleatoria en los parametros de 0 hasta un 20% mas del propuesto
    private static int cantidad(Proyectos p,int i) {
        return (int)Math.floor(Math.random()*(p.lista.get(i).monto+(p.lista.get(i).getMonto()*20)/100-0+1+0));
    }
    
    private static int randomN(int superior){
        int r = 0;
        r = (int)Math.random()*(superior+1);
        return r;
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
