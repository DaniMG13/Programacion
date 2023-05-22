package matrizmultiplodetres;

import javax.swing.JOptionPane;

public class MatrizMultiplo {
    int m = 0,n = 0;
    int[][] mat;
    
    void IngresarDatos(){
        m = Integer.parseInt(JOptionPane.showInputDialog("Renglones de la matriz"));
        n = Integer.parseInt(JOptionPane.showInputDialog("Columnas de la matriz"));
        mat = new int[m][n];
    }
    
    void Datos(){
        boolean ban = true;
        int base = 3;
        int multiplo = 1;
        for(int i = 0; i<m ;i++){
            if(ban){
                ban = false;
                for(int j = n-1; j>=0 ; j--){
                    mat[i][j] = base*multiplo;
                    multiplo = multiplo+1;
                } 
            }else{
                ban = true;
                for(int j = 0 ; j<n ; j++ ){
                    mat[i][j] = base*multiplo;
                    multiplo = multiplo+1;
                }
            }
        }
    }
    
    void Salida(){
        String mensaje = "Matriz con multiplos de tres\n";
        for(int i = 0; i<m ;i++){
            for(int j = 0 ; j<n ; j++){
                mensaje = mensaje + +mat[i][j]+" "; 
            }
            mensaje += "\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
