package evaluacionesangela;
/* @author Angela */
import java.io.BufferedReader;
import java.io.FileReader;

public class Evaluador 
{
    String folio,empresa,evaluador,apellidoP,apellidoM;
    static String ruta = "C:\\rutanew\\evaluadores.csv";
    static String separador = "\\|";
    public Evaluador(){        
    }
    public Evaluador(String v_folio, String v_empresa, String v_evaluador, String v_apellidoP, String v_apellidoM) {
        this.folio = v_folio;
        this.empresa = v_empresa;
        this.evaluador = v_evaluador;
        this.apellidoP = v_apellidoP;
        this.apellidoM = v_apellidoM;
    }    
    public Evaluador(String v_folio){
        try(BufferedReader bufferLectura = new BufferedReader(new FileReader(ruta))){//Este comando ayuda a acceder un archivo desde la ruta que le hemos asignado
            String linea = bufferLectura.readLine();
            while(linea != null)
            {
                String[] campos = new String[5];
                campos = linea.split(separador);
                if (campos[0].equals(v_folio)){
                    this.folio = campos[0];
                    this.empresa = campos[1]; 
                    this.evaluador = campos[2]; 
                    this.apellidoP = campos[3]; 
                    this.apellidoM = campos[4];
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
    public String getEvaluador() {
        return evaluador;
    }
    public void setEvaluador(String evaluador) {
        this.evaluador = evaluador;
    }
    public String getApellidoP() {
        return apellidoP;
    }
    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }
    public String getApellidoM() {
        return apellidoM;
    }
    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }    
}
