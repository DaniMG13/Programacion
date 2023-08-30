package robert;

import javax.swing.JOptionPane;

/**
 *
 * @author Duran Castillo Roberto Emmanuel
 */
class Arreglo {
int n, m;
int mat[][] = null;
int v[] = null;
    int[][] cargar() {
        
        n = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el numero de renglones"));
        m = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el numero de columnas"));
        mat = new int[n][m];
        
        v = new int[1000];
        int d=0,aux =1;
        for(int numx=1;numx<=100;numx++){
            d=0;
            for(int x=1;x<=numx;x++){
                if(numx % x == 0){
                    d++;
                } 
            }
            v[0]=1;
            if(d==2){
                if(aux<100){
                    v[aux] = numx;
                    aux++;        
                }
            }
        }
        int a=0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                mat[i][j]=v[a];
                a++;
            }

        }
       
        return mat;

    }

    String mostrar(int[][] arr) {
        String aux = "Matriz\n";
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                aux += "[" + arr[i][j] + "] ";
            }
            aux += "\n";
        }
        return aux;
    }
    int[][]reves()
    {
        int mat2[][] = new int[n][m];
        //int o = n-1;
        int ax = m-1;
        for (int i = 0; i<n; i++) {
            for (int j = 0,p=ax; j < m && p>=0; j++,p--) {
                //System.out.println("i: "+i+"\no:"+o+"\nj:"+j+"\np:"+p);
                mat2[i][j] = mat[i][p];
            }
        }
        return mat2;
    }

}

public class Main {

    public static void main(String[] args) {
        int[][] arr;
        Arreglo a = new Arreglo();
        arr = a.cargar();
        JOptionPane.showMessageDialog(null, a.mostrar(arr));
        arr = a.reves();
        JOptionPane.showMessageDialog(null, a.mostrar(arr));
    }

}