package mat;

import java.util.Formatter;
import javax.swing.JOptionPane;

/* @author VGSG */

public class Matrices {
    int m = 0,n = 0;
    int[][] matriz = null;
    
    void Crear(){
        m = Validar(m ,"renglones"); 
        n = Validar(n ,"columnas");
        
        matriz = new int[m][n];
    }
    
    int Validar(int v,String text){
        do{
            try{
                v = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el numero de "+text+" de la matriz (MAYOR a 0)"));
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Ingresa caracter numerico mayor a 0","Caracter invalido",JOptionPane.ERROR_MESSAGE);
            }
        }while(v<0);
        return v;
    }
    
    void Llenar(){
        boolean ban = true;
        int base = 3, aux = 1;
        for(int j = 0; j<m ;j++){
            if(ban){ //Iqz a Der
                ban = false;
                for(int i = n-1 ; i>=0 ; i--){
                    matriz[j][i] = base*aux;
                    aux++;
                } 
            }else{ //Der a Izq
                ban = true;
                for(int i = 0 ; i<n ; i++){
                    matriz[j][i] = base*aux;
                    aux++;
                }
            }
        }
    }
    
    void Mostrar(){
        String text = "Matriz\n";
        String v = ""+matriz[m-1][n-1];
        int f = v.length();
        String formato = "%0"+f+"d";
        for(int j = 0; j<m ;j++){
            for(int i = 0 ; i<n ; i++){
                Formatter fmt = new Formatter();
                text += fmt.format(formato,matriz[j][i])+"  "; 
                fmt.close();
            }
            text += "\n";
        }
        JOptionPane.showMessageDialog(null, text);
        
        int mayor=0,menor=matriz[0][0];
        for(int j = 0; j<m ;j++){
            for(int i = 0 ; i<n ; i++){
                if(matriz[j][i]>mayor){
                    mayor=matriz[j][i];
                }
                if(matriz[j][i]<menor){
                    menor=matriz[j][i];
                }
            } 
        }
        JOptionPane.showMessageDialog(null,"El mayor numero es : "+mayor+"\nEl menor: "+menor);
    }
}


