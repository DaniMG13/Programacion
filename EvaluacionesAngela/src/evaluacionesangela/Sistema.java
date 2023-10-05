package evaluacionesangela;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
/* @author angy */
public class Sistema {
    public int aleatorio(int numMenor, int numMayor){
        int num=0;
        Random aleatorio = new Random();
        num=aleatorio.nextInt(numMayor-numMenor+1)+numMenor;
        return num;
    }
    
    public void escribirArchivo(ArrayList arr,String ruta){
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(ruta))){    //abrir archivo a escribir
            for(int i=0;i<arr.size();i++){
                
            }
        }catch(Exception e){
            
        }
    }
    
}
