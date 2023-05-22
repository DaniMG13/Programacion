/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inv;

import java.util.Scanner;

/**
 *
 * @author sergi
 */
public class Inv {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double inv,ii;
        // TODO code application logic here
        int m;
        Scanner teclado;
        teclado = new Scanner(System.in);
        
        System.out.println("Ingresa la cantidad a invertir mensual");
        ii = teclado.nextDouble();
        
        System.out.println("Ingresa la cantidad de meses");
        m = teclado.nextInt();
        inv=ii;
        double interes;
        for(int i = 1;i<=m;i++){
            interes = inv*0.05;
            inv+=interes;
            
            System.out.println("Mes: "+i+" Cantidad: "+inv);
            inv+=ii;
        }
        
        System.out.println("La cantidad total de "+ii+" a "+m+" meses es: "+inv);
        
        
    }
    
}
