package cuadromagico;

import java.util.Formatter;
import javax.swing.JOptionPane;

/* @author VGSG */

public class Main {

    public static void main(String[] args) {
        CuadroMagico cuadro = new CuadroMagico();
        cuadro.Crear();
        cuadro.Llenar();
        cuadro.Mostrar();
        
        CuadroMagico[][] matCuadro = new CuadroMagico[2][2];
        
        matCuadro[0][0] = new CuadroMagico();
        matCuadro[0][0].Crear();
        matCuadro[0][0].Llenar();
        matCuadro[0][0].Mostrar();
        
        //n=1
        
        /*matCuadro[1][0].Crear();
        matCuadro[1][1].Crear();*/
        
        
    }
}

class CuadroMagico {
    int n;
    int[][] mat;
    
    void Crear(){
       n = Validar(); 
       mat = new int[n][n];
    }
    
    void Llenar(){
        int c = (int)((n/2));
        mat[c][0] = 1;
        int ca,fa;
        ca=c;
        fa=0;
        int aux = n*n;
        for(int k=2;k<=aux;k++){
            float kaux = k, naux = n;
            int o2;
            double o1;
            o1 = (kaux-1.0)/naux;
            o2 = (int)(k-1)/n;
            if(o1 == o2){
                fa++;
                /*if(ca==n){
                    ca=0;
                }*/
                if(fa<0){
                    fa=n-1;
                }
                mat[ca][fa]=k;
            }else{
                fa--;
                ca++;
                if(ca==n){
                    ca=0;
                }
                if(fa<0){
                    fa=n-1;
                }
                mat[ca][fa]=k;
            }
        }
    }
        
    void Mostrar(){
        int resultado = (n*(n*n+1))/2;
        String salida = "Matriz de "+n+"x"+n+"\n";
        String v = ""+n*n;
        int f = v.length();
        String formato = "%0"+f+"d";
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                Formatter fmt = new Formatter();
                salida += fmt.format(formato,mat[j][i])+"  "; 
                fmt.close();
            }
            salida+="\n";
        }
        salida+="\nLa suma de:\n-Filas\n-Columas\n-Diagonales\n\nDe la matriz\ndebe ser de: "+resultado;
        JOptionPane.showMessageDialog(null, salida,"Cubo magico Resultado",JOptionPane.INFORMATION_MESSAGE);
    }
    
    private int Validar(){
        int v = 0;
        boolean ban = true;
        do{
            try{
                v = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la dimension de la matriz cuadrada (numeros impares solamente)"));
                if(v%2!=0){
                    ban = false;
                }else{
                    JOptionPane.showMessageDialog(null, "Ingresa un numero impar","Numero par",JOptionPane.ERROR_MESSAGE);
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Caracter inválido, reintenta","Error",JOptionPane.ERROR_MESSAGE);
            }
        }while(v<=0 || ban);
        return v;
    }
}