/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arzate.mmmserie2;

import java.util.Scanner;

/**
 *
 * @author sergi
 */
public class ArzateMMMSerie2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double n=0;
        double d=1;
        double nu=0;
        double r=0;
        boolean ban = true;
        Scanner teclado = new Scanner(System.in);
        System.out.println("--- Bienvenido ---");
        do{
            System.out.println("Ingresa el numero de terminos deseados (debe ser entero positivo) ");
            n = teclado.nextDouble();
            if(n>=1 && n%2!=0){
                ban=false;
            }else{
                System.out.println("Error de numero ");
            }
        }while(ban);
        
        for(int i=1;i<=n;i++){
            nu = Math.sin(Math.toRadians(i));
            d *=2;
            
            if(i%2==0){
                r -= nu/d;
            }else{
                r += nu/d;
            }
        }
        
        System.out.println("El valor del numero w con "+(int)n+" terminos de la serie es igual a "+Math.round(r * 10000d) / 10000d);
    }
    
}
