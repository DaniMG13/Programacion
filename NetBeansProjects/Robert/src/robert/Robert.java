package robert;

import javax.swing.JOptionPane;
class Boleta
{
    Alumno a1=new Alumno();
    Materia m1=new Materia();
    Promedio p1=new Promedio();
    void leerDatos()
    {
        a1.leerDatos();
        m1.leerDatos();
        p1.leerDatos();
    }
    void calcular()
    {
        p1.calcular();
    }
    String mostrar()
    {
        String aux;
        aux=("BOLETA DE CALIFICACIONES\n"+a1.mostrar()+m1.mostrar()+p1.mostrar());
        return aux;
    }
}
class Alumno
{
    String nombre, numCtrl;
    byte semestre;
    void leerDatos()
    {
        nombre=JOptionPane.showInputDialog("Ingrese el nombre del alumno");
        numCtrl=JOptionPane.showInputDialog("Ingrese el numero de control del alumno");
        semestre=Byte.parseByte(JOptionPane.showInputDialog("Ingrese el semestre cursante del alumno"));
    }
    String mostrar()
    {
        String aux;
        aux=("Nombre del alumno: "+nombre+"\nNumero de control: "+numCtrl+"\nSemestre: "+semestre+"°");
        return aux;
    }
}

class Materia
{
    String nomMat, claveMat;
    byte creditos;
    void leerDatos()
    {
        nomMat=JOptionPane.showInputDialog("Ingrese el nombre de la materia");
        claveMat=JOptionPane.showInputDialog("Ingrese la clave de la materia");
        creditos=Byte.parseByte(JOptionPane.showInputDialog("Ingrese los creditos de la materia"));
    }
    String mostrar()
    {
        String aux;
        aux=("\nNombre de la materia: "+nomMat+"\nClave de la materia: "+claveMat+"\nCreditos de la materia: "+creditos);
        return aux;
    }
}
class Promedio
{
    String estatus, contenido;
    double cal1, cal2, cal3, cal4, Prom;
    void leerDatos()
    {
        cal1=Double.parseDouble(JOptionPane.showInputDialog("Ingrese la calificacion 1"));
        cal2=Double.parseDouble(JOptionPane.showInputDialog("Ingrese la calificacion 2"));
        cal3=Double.parseDouble(JOptionPane.showInputDialog("Ingrese la calificacion 3"));
        cal4=Double.parseDouble(JOptionPane.showInputDialog("Ingrese la calificacion 4"));
    }
    void calcular()
    {
        //Validacion del estatus del promedio
        Prom=(cal1+cal2+cal3+cal4)/4;
        if(Prom>=70)
        {
            estatus="ESTATUS DEL ALUMNO: APROBADO";
        }
        else
        {
            estatus="ESTATUS REPORBADO";
        }
        int decenas, unidades;
        //Asignacion para separar unidades y decenas en el Promedio
        decenas=(int)Prom/10;
        unidades=(int)Prom%10;
        
        switch (decenas)
        {
            case 1: contenido="Diez";
            break;
            case 2: contenido="Veinte";
            break;
            case 3: contenido="Treinta";
            break;
            case 4: contenido="Cuarenta";
            break;
            case 5: contenido="Cincuenta";
            break;
            case 6: contenido="Sesenta";
            break;
            case 7: contenido="Setenta";
            break;
            case 8: contenido="Ochenta";
            break;
            case 9: contenido="Noventa";
            break;
            case 10: contenido="Cien";
            break;
            default: contenido+="";
        }
        switch(unidades)
        {
            case 1: contenido+=" y Uno";
            break;
            case 2: contenido+=" y Dos";
            break;
            case 3: contenido+=" y Tres";
            break;
            case 4: contenido+=" y Cuatro";
            break;
            case 5: contenido+=" y Cinco";
            break;
            case 6: contenido+=" y Seis";
            break;
            case 7: contenido+=" y Siete";
            break;
            case 8: contenido+=" y Ocho";
            break;
            case 9: contenido+=" y Nueve";
            break;
            default: contenido+="";
        }
        if(Prom==0)
        {
            contenido="Cero";
        }
        if(Prom>0 && Prom<10)
        {
            switch ((int)Prom)
            {
                case 1: contenido="Uno";
                break;
                case 2: contenido="Dos";
                break;
                case 3: contenido="Tres";
                break;
                case 4: contenido="Cuatro";
                break;
                case 5: contenido="Cinco";
                break;
                case 6: contenido="Seis";
                break;
                case 7: contenido="Siete";
                break;
                case 8: contenido="Ocho";
                break;
                case 9: contenido="Nueve";
                break;
            }
        }
        if(Prom>10 && Prom<20)
        {
            switch((int)Prom)
            {
                case 11: contenido="Once";
                break;
                case 12: contenido="Doce";
                break;
                case 13: contenido="Trece";
                break;
                case 14: contenido="Catorce";
                break;
                case 15: contenido="Quince";
                break;
                case 16: contenido="Dieciseis";
                break;
                case 17: contenido="Diecisiete";
                break;
                case 18: contenido="Dieciocho";
                break;
                case 19: contenido="Diecinueve";
                break;
            }
        }
        if(Prom>20 && Prom<30)
        {
            switch((int)Prom)
            {
                case 21: contenido="Veintiuno";
                break;
                case 22: contenido="Veintidos";
                break;
                case 23: contenido="Veintitres";
                break;
                case 24: contenido="Veinticuatro";
                break;
                case 25: contenido="Veinitcinco";
                break;
                case 26: contenido="Veintiseis";
                break;
                case 27: contenido="Veintisiete";
                break;
                case 28: contenido="Veintiocho";
                break;
                case 29: contenido="Veintinueve";
                break;
            }
        }
    }
    String mostrar()
    {
        String aux;
        aux=("\nCalificacion 1: "+cal1+"\nCalificacion 2: "+cal2+"\nCalificacion 3: "+cal3+"\nCalificacion 4: "+cal4+"\nPROMEDIO: "+Prom+"\n"+contenido+"\nEstatus del estudiante: "+estatus);
        return aux;
    }
}
public class Robert {
    public static void main(String[] args){
        Boleta b1=new Boleta();
        b1.leerDatos();
        b1.calcular();
        JOptionPane.showMessageDialog(null, b1.mostrar());
        System.exit(0);
    }
}