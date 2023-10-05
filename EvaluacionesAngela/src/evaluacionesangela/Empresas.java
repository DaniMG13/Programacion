package evaluacionesangela;
/* @author Angela */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
public class Empresas extends Empresa
{
    ArrayList<Empresa> lista = new ArrayList<>();
    public Empresas(){        
    }
    public Empresas(String v_folio){
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
                lista.add(new Empresa(this.folio));
                this.folio = campos[0];
                this.empresa = campos[1];
                linea = bufferLectura.readLine();//debe haber un fin del ciclo
            }
        }catch(Exception ex){            
        }
    }
    public void getAllEmpresa(String f){
        lista.clear();
         try(BufferedReader bufferedLectura = new BufferedReader(new FileReader(ruta))) {    //buscar archivo a leer
            String linea=bufferedLectura.readLine();
            while(linea!=null){
                String [] campos = new String[2];
                campos=linea.split(separador);
                
                if(f.equals(campos[0])){
                    this.folio=campos[0];
                    lista.add(new Empresa(this.folio));
                //linea=bufferedLectura.readLine();   //rompe el ciclo
                }
                linea=bufferedLectura.readLine(); 
            }
        }catch(Exception e){
            
        }
    }
}
