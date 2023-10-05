package evaluacionesangela;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
/* @author Angela */
public class Proyectos extends Proyecto
{
    ArrayList<Proyecto> lista = new ArrayList<>();
    public Proyectos(){        
    }
    public Proyectos(String v_folio){
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
                lista.add(new Proyecto(this.folio));
                this.folio = campos[0];
                this.empresa = campos[1];
                this.proyecto = campos[2];
                this.monto = Float.parseFloat(campos[3]);
                linea = bufferLectura.readLine();//debe haber un fin del ciclo
            }
        }catch(Exception ex){            
        }
    }
    public void getAllEmpresa(String p){
        lista.clear();
         try(BufferedReader bufferedLectura = new BufferedReader(new FileReader(ruta))) {    //buscar archivo a leer
            String linea=bufferedLectura.readLine();
            while(linea!=null){
                String [] campos = new String[4];
                campos=linea.split(separador);
                
                if(p.equals(campos[1])){
                    this.folio=campos[0];
                    lista.add(new Proyecto(this.folio));    //genera array list con los proyectos
                //linea=bufferedLectura.readLine();   //rompe el ciclo
                }
                linea=bufferedLectura.readLine(); 
            }
        }catch(Exception e){            
        }
    }   
    public void writeAll(){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta_salida))) {
         for (int i=0;i< lista.size(); i++) {
                 String s =  String.format("%s|%s|%s|%s\n",
                 lista.get(i).getFolio(),
                 lista.get(i).getEmpresa(),
                 lista.get(i).getProyecto(),
                 String.valueOf(lista.get(i).getMonto()));
                 bw.write(s);
             }
         }
        catch (Exception e) {
             e.printStackTrace();
        }
    }
}