package evaluacionesangela;
/* @author Angela */
import java.io.BufferedReader;
import java.io.FileReader;

public class Proyecto extends Sistema
{
    String empresa, folio, proyecto;
    float monto;
    static String ruta = "C:\\rutanew\\proyectos.csv";
    static String ruta_salida = "C:\\rutanew\\proyectos_salida.csv";
    static String separador = "\\|";
    //Constructores
    public Proyecto(){ //recuperar proyectos       
    }
    public Proyecto(String v_folio,String v_empresa,String v_proyecto,float v_monto){//generar nuevos proyectos
        this.folio = v_folio;
        this.empresa = v_empresa;
        this.proyecto = v_proyecto;
        this.monto = v_monto;
    }
    //getOne recuperar los datos del origen de datos, en el archivo
    public Proyecto(String v_folio){
        try(BufferedReader bufferLectura = new BufferedReader(new FileReader(ruta))){//Este comando ayuda a acceder un archivo desde la ruta que le hemos asignado
            String linea = bufferLectura.readLine();
            while(linea != null)
            {
                String[] campos = new String[4];
                campos = linea.split(separador);
                if (campos[0].equals(v_folio)){
                    this.folio = campos[0];
                    this.empresa = campos[1];
                    this.proyecto = campos[2];
                    this.monto = Float.parseFloat(campos[3]);   
                }
                linea = bufferLectura.readLine();//debe haber un fin del ciclo
            }
        }catch(Exception ex){            
        }
    }
    //Getters
    public String getFolio(){
        return this.folio;
    }
    public String getEmpresa(){
        return this.empresa;
    }
    public String getProyecto(){
        return this.proyecto;
    }
    public float getMonto(){
        return this.monto;
    }
    //Setters
    public void setEmpresa(String v_empresa) {
        this.empresa = v_empresa;
    }
    public void setFolio(String v_folio) {
        this.folio = v_folio;
    }
    public void setProyecto(String v_proyecto) {
        this.proyecto = v_proyecto;
    }
    public void setMonto(float v_monto) {
        this.monto = v_monto;
    }
}


