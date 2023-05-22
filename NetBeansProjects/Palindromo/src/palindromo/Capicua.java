package palindromo;

import javax.swing.JOptionPane;

public class Capicua {
    int numero,inversa,tamanio,residuo;
    String numeroTexto,Salida;
    void IngresarNumero(){
        numero = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa un numero entero positivo"));
        numeroTexto = String.valueOf(numero);
        tamanio = numeroTexto.length();
        
    }
    
    void Invertir(){
        while(numero>0){
            residuo = numero%10;
            inversa = inversa * 10 + residuo;
            numero = numero/10;
        }
        numero = Integer.parseInt(numeroTexto);
        if(numero==inversa){
            Salida = "El numero SI es Capicua";
        }else{
            Salida = "El numero NO es Capicua";
        }
    }
    
    void Mostrar(){
        JOptionPane.showMessageDialog(null,"Numero de caracteres del numero: "+tamanio+"\nNumero: "+numero+"  Invertido: "+inversa+"\n"+Salida);
    }
}
