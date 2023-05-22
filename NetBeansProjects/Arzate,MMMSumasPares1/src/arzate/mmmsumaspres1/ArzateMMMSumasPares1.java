/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arzate.mmmsumaspres1;

import java.util.Scanner;

/**
 *
 * @author sergi
 */
public class ArzateMMMSumasPares1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a=0;
        int b=0;
        int n=0;
        int suma=0;
        boolean ban = true;
        System.out.println("--- Bienvenido ---");
        Scanner teclado = new Scanner(System.in);
        do{
           System.out.println("Ingresa el numero a (no numeros negativos) ");
           a = teclado.nextInt();
           
           System.out.println("Ingresa el numero b (recuerda que debe ser mayor a 'a') ");
           b = teclado.nextInt();
           
           if(a<b && a>=0 && b>=0){
               ban = false;
           }else{
               System.out.println("ERROR de datos, vuelve a ingresarlos");;
           }
        }while(ban);
        
        for(int i=a;i<=b;i++){
            if(i%2==0){
                n++;
                suma+=i;
            }
        }
        
        System.out.println("La cantidad de numeros pares entre "+a+" y "+b+" es: "+n);
        System.out.println("La suma de estos numeros es: "+suma);
        
    }
    
}
