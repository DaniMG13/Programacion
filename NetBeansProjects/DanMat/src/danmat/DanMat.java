/*
 * 
 * 
 */

package danmat;

import javax.swing.JOptionPane;

/* @author sergi */
public class DanMat {

    public static void main(String[] args) {
        int[][] arr1, arr2, arrOrd, trans, arrSumaPr, arrSumaIn, arrSumaRen;
        Metodos obj=new Metodos();
        arr1=obj.cargarMat();
        arr2=obj.cargarMat();
        trans=obj.arrTrans(arr1);
        
        int[][] suma = new int[arr1.length][arr1[0].length];
        obj.sumaMat(arr1, arr2, suma);
        int[][] resta = new int[arr1.length][arr1[0].length];
        obj.restaMat(arr1, arr2, resta);
        
        JOptionPane.showMessageDialog(null, "Matriz 1\n"+obj.mostrarMat(arr1)+"\nSuma por renglones de la Matríz 1\n"+obj.sumaRen(arr1)+"\nSuma de diagonal princiapl e invertida de la Matríz 1\n"+obj.sumaDiagP(arr1)+"\n\nMatríz 2\n"+obj.mostrarMat(arr2)+"\nSuma de Matrices\n"+obj.mostrarMat(suma)+"\nResta de Matrices\n"+obj.mostrarMat(resta));
        JOptionPane.showMessageDialog(null, "Matríz Transpuesta\n"+obj.mostrarMat(trans));
        
        int dec=Integer.parseInt(JOptionPane.showInputDialog("Para ordenar Matríz 1, ingrese el número 1.\nPara ordenar Matríz 2, ingrese el número 2.\nPara ordenar la Matriz 3, ingrese el número 3"));
        switch(dec){
            case 1: 
                arrOrd=obj.ordenarMat(arr1);
                JOptionPane.showMessageDialog(null, "Matríz ordenada \n"+obj.mostrarMat(arrOrd));
                break;
            case 2:
                arrOrd=obj.ordenarMat(arr2);
                JOptionPane.showMessageDialog(null, "Matríz ordenada \n"+obj.mostrarMat(arrOrd));
                break;
            case 3:
                arrOrd=obj.ordenarMat(suma);
                JOptionPane.showMessageDialog(null, "Matríz ordenada \n"+obj.mostrarMat(arrOrd));
                break;
        }
        System.exit(0);
    }
}

class Metodos{
    int r, c;
    int [][] arr;
    
    int [][] cargarMat(){
        r=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de renglones"));
        c=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de columnas"));
        
        arr=new int[r][c];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                arr[i][j]=(int) (Math.random()*100+1);
            }
        }
        return arr;
    } 
    
    String mostrarMat(int[][]arr){
        String s=" ";
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                s+="["+arr[i][j]+"]";
            }
            s+="\n";
        }
        return s;
    }
    
    void sumaMat(int[][]arr1, int[][]arr2, int[][]res){
        if(arr1.length!=arr2.length||arr1[0].length!=arr2[0].length){
            JOptionPane.showMessageDialog(null,"ERROR.\nNo se puede sumar porque son nmatrices de diferente orden.");
        }
        else{
            for(int i=0; i<arr1.length; i++){
                for(int j=0; j<arr1[i].length; j++){
                    res[i][j]=arr1[i][j]+arr2[i][j];
                }
            }
        }
        //JOptionPane.showMessageDialog(null, "La suma es:\n"+mostrarMat(res));
    }
    
    void restaMat(int[][]arr1, int[][]arr2, int[][]res){
        if(arr1.length!=arr2.length||arr1[0].length!=arr2[0].length){
            JOptionPane.showMessageDialog(null,"ERROR.\nNo se puede sumar porque son nmatrices de diferente orden.");
        }
        else{
            for(int i=0; i<arr1.length; i++){
                for(int j=0; j<arr1[i].length; j++){
                    res[i][j]=arr1[i][j]-arr2[i][j];
                }
            }
        }
        //JOptionPane.showMessageDialog(null, "La suma es:\n"+mostrarMat(res));
    }
    
    int [][] ordenarMat(int[][]x){
        int[] vec = new int[(x.length)*(x[0].length)];
        int auxVec=0;
        boolean ban=true;
        
        for(int i=0; i<x.length; i++){
            for(int j=0; j<x[i].length; j++){
                vec[auxVec]=x[i][j];
                auxVec++;
            }
        }
        
        for(int i=1;ban;i++){
            ban=false;
            for(int k=1;k<=(vec.length-1);k++){
                if(vec[k-1]>vec[k]){
                    ban=true;
                    auxVec=vec[k-1];
                    vec[k-1]=vec[k];
                    vec[k]=auxVec;
                }
            }
        }
        
        
        auxVec=0; 
        for(int i=0; i<x.length; i++){
            for(int j=0; j<x[i].length; j++){
                x[i][j]=vec[auxVec];
                auxVec++;
            }
        }
        
     return x;   
    }
    
    int[][] arrTrans(int[][]x){
        int[][] resTrans = new int[x[0].length][x.length];
        for(int i=0; i<x.length; i++){
            for(int j=0; j<x[0].length; j++){
                resTrans[j][i]=x[i][j];
            }
        }
        return resTrans;
    }
    
    /*int[][] multi(int[][]x, int[][]y, int[][]z){
        int[][] res = new int [x.length][x[0].length];
        if(x[0].length==y.length){
        JOptionPane.showMessageDialog(null, "Las matrices no se pueden multiplicar");
        }
        else{
            for(int i=0; i<x.length; i++){
                for(int j=0; j<y[0].length; j++){
                    z[i][j]=0;
                    for(int k=0; k<x[0].length; k++){
                        z[i][j]=z[i][j]+x[i][k]*y[k][j];
                    }
                }
            }
        }
        return res;
    } MULTIPLICACIÓN*/
    
    String sumaDiagP(int [][] x){
        int sdp=0, sdi=0;
        String s="";
        if(x.length==x[0].length){
            for(int i=0; i<x.length; i++){
                sdp+=x[i][i];
            }
            for(int j=x.length-1,i=0;j>=0;j--,i++){
                sdi+=x[j][i];
            }
            s="La suma de la diagonal principal es: "+sdp+"\nLa suma de la diagonal invertida es: "+sdi;
        }
        return s;
    }
    
    String sumaRen(int [][] x){
        int [][] arrSumaRen = new int[x.length][x[0].length];
        int suma=0;
        String s="";
        for(int i=0; i<arrSumaRen.length; i++){
            suma=0;
            for(int j=0; j<x[i].length; j++){
                suma+=x[i][j];
            }
            s+=suma+"\n";
        }   
        return s;
    }
    
    //Método para llenar matríz de abajo derecha hacia izquierda arriba como en zigzag con múltiplos de 3
    int [][] llenarMatMult3(int[][] x){
        int mult=3;
        int[][] arrMult3 = new int [x.length][x[0].length];
        boolean ban=true;
        
        for(int i=arrMult3.length;i>=0; i--){
            if(ban){
                ban=false;
                for(int j=arrMult3[i].length; j>=0; j--){
                arrMult3[i][j]=mult;
                mult+=3;
                }
            }
            else{
                ban=true;
                for(int j=0; j<arrMult3[i].length; j++){
                arrMult3[i][j]=mult;
                mult+=3;
                }
            }
        }
        return arrMult3; 
    }

}
