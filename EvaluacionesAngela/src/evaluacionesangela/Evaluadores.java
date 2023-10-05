package evaluacionesangela;
/* @author Angela */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
public class Evaluadores extends Evaluador
{
    ArrayList<Evaluador> lista = new ArrayList<>();
    public Evaluadores(){        
    }
    public Evaluadores(String v_folio){
        super (v_folio);
    }
    public void getAll(){
        try(BufferedReader bufferLectura = new BufferedReader(new FileReader(ruta))){//Este comando ayuda a acceder un archivo desde la ruta que le hemos asignado
            String linea = bufferLectura.readLine();
            while(linea != null)
            {
                String[] campos = new String[4];
                campos = linea.split(separador);         
                this.folio = campos[0];
                lista.add(new Evaluador(this.folio));
                this.folio = campos[0];
                this.empresa = campos[1];
                this.evaluador = campos[2];
                this.apellidoP = campos[3];
                this.apellidoM = campos[4];
                linea = bufferLectura.readLine();//debe haber un fin del ciclo
            }
        }catch(Exception ex){            
        }
    }
    public void getAllEvaluadores(String e){
        lista.clear();
         try(BufferedReader bufferedLectura = new BufferedReader(new FileReader(ruta))) {    //buscar archivo a leer
            String linea=bufferedLectura.readLine();
            while(linea!=null){
                String [] campos = new String[5];
                campos=linea.split(separador);
                
                if(e.equals(campos[1])){
                    this.folio=campos[0];
                    lista.add(new Evaluador(this.folio));    //genera array list con los proyectos                   
                }
                linea=bufferedLectura.readLine(); //rompe el ciclo
            }
        }catch(Exception ex){
            
        }
    }
}
