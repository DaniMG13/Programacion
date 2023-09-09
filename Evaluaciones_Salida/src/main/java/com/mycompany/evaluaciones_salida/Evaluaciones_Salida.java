package com.mycompany.evaluaciones_salida;

/* @author VGSG */

public class Evaluaciones_Salida {

    public static void main(String[] args) {
        Proyectos p = new Proyectos();
        p.getAll();
        System.out.println("Proyectos\n");
        for(int i=0;i<p.lista.size();i++){
            System.out.println((p.lista.get(i).getProyecto()));
        }
        Empresas e = new Empresas();
        e.getAll();
        
        System.out.println("\nEmpresas\n");
        
        for(int i=0;i<e.lista.size();i++){
            System.out.println((e.lista.get(i).getEmpresa()));
        }
        
        Evaluadores ev = new Evaluadores();
        ev.getAll();
        
        System.out.println("\nEvaluadores\n");
        
        for(int i=0;i<ev.lista.size();i++){
            System.out.println((ev.lista.get(i).getNombre()+" "+ev.lista.get(i).getApellidoP()+" "+ev.lista.get(i).getApellidoM()));
        }
        
        evaluar(p,e,ev);
        
    }

    private static void evaluar(Proyectos p, Empresas e, Evaluadores ev) {
        int nP = p.lista.size();
        int nEmp = e.lista.size();
        int nEva = ev.lista.size();
        
        String[] evaluados = new String[nP];
        String local = "",externo = "";
        for(int i=0;i<nP;i++){
            String nomEmp = p.lista.get(i).getEmpresa().substring(0,1);
            String fEva = ev.lista.get(i).getFolio().substring(0,1);
            evaluados[i] = p.lista.get(i).getFolio()+ "| "+p.lista.get(i).getEmpresa()+ " | " + p.lista.get(i).getProyecto() + " | "
                        + p.lista.get(i).getMonto() + " | LOCAL |" ;
            if(fEva.equals(nomEmp)){
                evaluados[i] += ev.lista.get(i).getFolio();
            }else{
                evaluados[i+1] += ev.lista.get(i).getFolio();
                externo = ev.lista.get(i).getFolio();
            }
            
            evaluados[i] += " | " + cantidad(p,i) + " | EXTERNA | " + externo + " | " + cantidad(p,i);
        }
        
        for(int i=0;i<evaluados.length;i++){
            System.out.println(evaluados[i]);
        }
        
    }

    private static int cantidad(Proyectos p,int i) {
        return (int)Math.floor(Math.random()*(p.lista.get(i).monto-0+1+0));
    }
}
