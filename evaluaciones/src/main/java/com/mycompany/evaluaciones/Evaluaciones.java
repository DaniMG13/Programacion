package com.mycompany.evaluaciones;
public class Evaluaciones
{
    public static void main(String[] args)
    {
        Proyecto p1 = new Proyecto();
        Proyecto p2 = new Proyecto("Z","Cookiefy","Produccion de galletas",100000);
        Proyecto p3 = new Proyecto("C");
        Proyectos p4 = new Proyectos();
        p4.getAll();             
        for (int i = 0; i < p4.lista.size(); i++) {
         System.out.println(p4.lista.get(i).getProyecto());         
        }          
    }
}
