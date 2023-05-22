package pruebas;

import javax.swing.JOptionPane;
//Clase empleado
class Empleado 
{
    String Nombre;
    byte Sueldo;
    double Total;
    int Horas;
    //Metodo para leer datos
    void leerDatos()
    {
        Nombre = JOptionPane.showInputDialog("Ingrese el nombre del trabajador: ");
        Sueldo = Byte.parseByte(JOptionPane.showInputDialog("Ingrese el sueldo por hora del trabajador: "));
        Horas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las horas trabajadas: "));
    }
    //Metodo calcular
    void calcular()
    {
        if(Horas<=40)
        {
            Total = Horas*Sueldo;
        }
        else
        {
            if(Horas<=50)
            {
                Total = (40*Sueldo)+(Horas-40)*1.5*Sueldo;
            }
            else
            {
                Total = 40*Sueldo+10*1.5*Sueldo+(Horas-50)*2*Sueldo;
            }
        }
    }
    //Metodo mostrar
    String mostrar()
    {
        String aux;
        aux="Nombre del empleado: "+Nombre+"\nSueldo base por hora: $"+Sueldo+"\nHoras trabajadas: "+Horas+"\nSueldo total: $"+Total;
        return aux;
    }
}
//Clase main
public class Main
{
    public static void main(String[] args)
    {
        Empleado e1 = new Empleado();
        e1.leerDatos();
        e1.calcular();
        JOptionPane.showMessageDialog(null, e1.mostrar());
    }
}