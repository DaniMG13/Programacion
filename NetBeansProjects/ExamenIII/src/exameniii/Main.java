package exameniii;

import java.util.Scanner;

/* @author VGSG */

public class Main {
static int n,m;
static int matriz[][];
static Scanner tecla = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Ingresa el ancho de la matriz");
        m = tecla.nextInt();
        System.out.println("Ingresa el largo de la matriz");
        n = tecla.nextInt();
        System.out.println("\n");
        
        matriz = new int[n][m];
        
        for(int i=0; i<n;i++){
            for(int j=0;j<m;j++){
                System.out.println("Ingresa un numero del 0 al 9");
                matriz[i][j] = tecla.nextInt();
            }
        }
        
        String salida = "Matriz\n";
        for(int i=0; i<n;i++){
            
            for(int j=0;j<m;j++){
                salida += matriz[i][j]+"  ";
            }
            System.out.println(salida);
            salida = "";
        }
        
        int matR[][] = new int[10][2];
        int contad[] = new int[10];
        int conta=0;
        
        for(int i=0; i<n;i++){
            for(int j=0;j<m;j++){
                switch(matriz[i][j]){
                    case 0:contad[0]+=1;break;
                    case 1:contad[1]+=1;break;
                    case 2:contad[2]+=1;break;
                    case 3:contad[3]+=1;break;
                    case 4:contad[4]+=1;break;
                    case 5:contad[5]+=1;break;
                    case 6:contad[6]+=1;break;
                    case 7:contad[7]+=1;break;
                    case 8:contad[8]+=1;break;
                    case 9:contad[9]+=1;break;
                }
            }
        }
        
        for(int i=0; i<10;i++){
            for(int j=0;j<2;j++){
                if(j==0){
                    matR[i][j]=i;
                }else{
                    matR[i][j] = contad[i];
                }
                
            }
        }
        
        String out = "Matriz\n";
        for(int i=0; i<10;i++){
            for(int j=0;j<2;j++){
                out += matR[i][j]+"  ";
            }
            System.out.println(out);
            out = "";
        }
        
    }

}
