/*
 * 
 * 
 */

package fecha;

import java.util.Scanner;

/* @author sergi */
public class Main{
static String fch;
static int dia,mes,anio;

    public static void main(String[] args){
        
    
       Scanner tecla = new Scanner(System.in);
       Fecha fecha1 = new Fecha();

       System.out.println("Ingresa una fecha en formato Dd/Mm/Aaaa");
       fch = tecla.next();

       int subDia = Integer.parseInt(fch.substring(0,2));
       //System.out.println(subDia);
       int subMes = Integer.parseInt(fch.substring(3,5));
       //System.out.println(subMes);
       int subAnio = Integer.parseInt(fch.substring(6,10));
       //System.out.println(subAnio);
       if(fecha1.setFecha(subDia, subMes, subAnio)){
           System.out.println("Fecha establecida correctamente");
       }else{
           System.err.println("Error de fecha");
       }
          
   } 
}

class Fecha{

    private int dia,mes,anio;

    public boolean setFecha(int d,int m,int a){
        boolean ban,b2,b3;
        
        if(((m>0)&&(m<=12))){
          this.mes = m;
          ban = true;
        }else{
            System.err.println("Mes Invalido (1-12)");
            ban = false;
        }   
        
        switch (m){
            case 2:b2=ValidarMax(28,d);break; 
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:b2=ValidarMax(31,d);break; 
            default:b2=ValidarMax(30,d);break;   
        }
        
        if(!(a<1000)){
          this.anio = a;
          b3 = true;
        }else{
            System.err.println("Año invalido (Ej: 1900)");
            b3 = false;
        }
        
        if(ban && b2 && b3){
            return true;
        }else{
            return false;
        }
    }

     private boolean ValidarMax(int max,int d){
        if(d>0 && d<=max){
           this.dia = d;
           return true;
        }else{
            System.err.println("Error de dia (Feb Max 28; 30 o 31)");
            return false;
        }
     }
    
    public int getDia(){
        return dia;
    }

    public int getMes(){
        return mes;
    }

    public int getAnio(){
        return anio;
    }

}
