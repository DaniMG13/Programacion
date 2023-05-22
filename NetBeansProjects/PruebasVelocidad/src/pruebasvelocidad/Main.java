package pruebasvelocidad;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/* @author VGSG */

public class Main {

    public static void main(String[] args) {
        Automovil autos[] = new Automovil[5];
        
        for(int j=0;j<autos.length;j++){
            autos[j] = new Automovil();
            autos[j].setNombre(JOptionPane.showInputDialog("Ingresa el nombre del auto"));
            autos[j].Pruebas();
        }
        
        Resultados(autos);
        
    }

    private static void Resultados(Automovil[] autos) {
        String salida = " --------------------------------------- Tabla de Resultados -------------------------------------- \n";
        salida +=     " Nombre     Prueba 1     Prueba 2     Prueba 3    Prueba 4     Prueba 5     Min     Max     Promedio\n";
        double prom=0;
        for(int i = 0; i < autos.length;i++){
            double mm[] = autos[i].minMax();
            prom = autos[i].Promedio();
            DecimalFormat df = new DecimalFormat("#.00");
            salida += autos[i].getNombre()+"   "+df.format(autos[i].getPrueba1())+"    "+df.format(autos[i].getPrueba2())+"          "+df.format(autos[i].getPrueba3())+"        "+df.format(autos[i].getPrueba4())
                    +"        "+df.format(autos[i].getPrueba5())+"           "+"     "+df.format(mm[0])+"         "+df.format(mm[1])+"        "+df.format(prom)+"\n";
            salida +=    "----------------------------------------------------------------------------------------------------- \n";
            
        }
        
        JOptionPane.showMessageDialog(null, salida);
    }

}

class Automovil{
    double prueba1,prueba2,prueba3,prueba4,prueba5;
    double p[] = new double[5];
    String nombre;
    
    void setNombre(String name){
        this.nombre = name;
    }
    
    String getNombre(){
        return this.nombre;
    }
    
    void Pruebas(){
        prueba1=Double.parseDouble(JOptionPane.showInputDialog("Ingresa el valor obtendido en la prueba 1"));
        prueba2=Double.parseDouble(JOptionPane.showInputDialog("Ingresa el valor obtendido en la prueba 2"));
        prueba3=Double.parseDouble(JOptionPane.showInputDialog("Ingresa el valor obtendido en la prueba 3"));
        prueba4=Double.parseDouble(JOptionPane.showInputDialog("Ingresa el valor obtendido en la prueba 4"));
        prueba5=Double.parseDouble(JOptionPane.showInputDialog("Ingresa el valor obtendido en la prueba 5"));
        p[0]=prueba1;
        p[1]=prueba2;
        p[2]=prueba3;
        p[3]=prueba4;
        p[4]=prueba5;
    }

    public double getPrueba1() {
        return prueba1;
    }

    public double getPrueba2() {
        return prueba2;
    }

    public double getPrueba3() {
        return prueba3;
    }

    public double getPrueba4() {
        return prueba4;
    }

    public double getPrueba5() {
        return prueba5;
    }

    public double[] minMax(){
        double min = p[0],max=p[0];
        for(int i=0;i<5;i++){
            if(p[i]<min){
                min = p[i];
            }
            if(p[i]>max){
                max = p[i];
            }
        }
        double[] mm={min,max};
        return mm;
    }
    
    public double Promedio(){
        double prom=0;
        prom+=getPrueba1()+getPrueba2()+getPrueba3()+getPrueba4()+getPrueba5();
        prom/=5;
        return prom;
    }
}
