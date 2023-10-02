package evaluacionesangela;
/* @author Angela */
import java.io.BufferedReader;
import java.io.FileReader;
public class Empresa extends Sistema
{
    String folio,empresa;
    static String ruta = "C:\\rutanew\\empresas.csv";
    static String separador = "\\|";
    public Empresa(){
    }
    public Empresa(String v_folio,String v_empresa){
        this.folio = v_folio;
        this.empresa = v_empresa;
    }
    public Empresa(String v_folio){
        try(BufferedReader bufferLectura = new BufferedReader(new FileReader(ruta))){//Este comando ayuda a acceder un archivo desde la ruta que le hemos asignado
            String linea = bufferLectura.readLine();
            while(linea != null)
            {
                String[] campos = new String[4];
                campos = linea.split(separador);
                if (campos[0].equals(v_folio)){
                    this.folio = campos[0];
                    this.empresa = campos[1];   
                }
                linea = bufferLectura.readLine();//debe haber un fin del ciclo
            }
        }catch(Exception ex){            
        }
    }
    public String getFolio() {
        return folio;
    }
    public void setFolio(String folio) {
        this.folio = folio;
    }
    public String getEmpresa() {
        return empresa;
    }
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}
