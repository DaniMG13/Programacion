package boleta;

/*VGSG*/

public class Boleta {
    Alumno al=new Alumno();
    Materia ma=new Materia();
    Promedio pr=new Promedio();

    void leerdatos(){
        al.leerDatos();
        ma.leerDatos();
        pr.leerDatos();
    }

    String mostrar(){
        String aux;
        aux="Boleta de calificaciones\n"+al.mostrar()+"\n"+ma.mostrar()+"\n"+pr.mostrar();
        return aux;
    }

    void calcular(){
        pr.calcular();
    }
}
