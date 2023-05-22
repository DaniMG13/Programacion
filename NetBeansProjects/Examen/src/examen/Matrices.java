package examen;

import java.util.Formatter;
import javax.swing.JOptionPane;

/* @author VGSG */
public class Matrices {
    int[][] mat1,mat2,matR;
    int f,c;
    
    void Crear(){
        f = Validar("filas");
        c = Validar("columnas");
        
        mat1 = new int[f][c];
        mat2 = new int[c][f];
        matR = new int[f][c];
    }
    
    private int Validar(String cadena){
        int variable = 0;
        boolean ban = true;
        do{
            try{
                variable = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el numero de "+cadena));
                if(variable>0){
                    ban = false;
                }else{
                    JOptionPane.showMessageDialog(null, "No pueden ser numeros menores a 1");
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Caracter invalido, reintenta","Error de conversion",JOptionPane.ERROR_MESSAGE);
            }
        }while(ban);
        
        return variable;
    }
    
    void Llenar(){
        for(int i = 0; i<f ; i++){
            for(int j = 0; j<c; j++){
                mat1[i][j] = (int)(Math.random()*(100)+1);
                mat2[j][i] = (int)(Math.random()*(100)+1);
            }
        }
    }
    
    void Sumar(){
        for(int i = 0; i < f; i++){
            for(int j = 0; j < c ; j++){
                matR[i][j] = mat1[i][j] + mat2[j][i];
            }
        }
    }
    
    void Mostrar(/*int[][] mat, int[][] mat2*/){
        String texto = "Matrices\n";
        
        texto += "Matriz 1\n";
        for(int i = 0; i < f; i++){
            for(int j = 0; j < c ; j++){
                Formatter ftm = new Formatter();
                texto += ftm.format("%03d", mat1[i][j])+"   ";
                ftm.close();
            }
            texto += "\n";
        }
        
        texto += "\nMatriz 2\n";
        for(int i = 0; i < c; i++){
            for(int j = 0; j < f ; j++){
                Formatter ftm = new Formatter();
                texto += ftm.format("%03d", mat2[i][j])+"   ";
                ftm.close();
            }
            texto += "\n";
        }
        
        texto += "\nMatriz resultante\n";
        for(int i = 0; i < f; i++){
            for(int j = 0; j < c ; j++){
                Formatter ftm = new Formatter();
                Formatter ftm2 = new Formatter();
                Formatter ftm3 = new Formatter();
                texto += ftm2.format("%03d", mat1[i][j])+" + "+ftm3.format("%03d", mat2[j][i])+" = "+ftm.format("%03d", matR[i][j])+"      ";
                ftm.close();
                ftm2.close();
                ftm3.close();
            }
            texto += "\n";
        }
        
        JOptionPane.showMessageDialog(null, texto);
    }
    
}
