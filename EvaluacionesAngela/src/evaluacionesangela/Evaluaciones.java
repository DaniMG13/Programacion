package evaluacionesangela;
/* @author Angela  */
public class Evaluaciones {
    public static void main(String[] args) {
        Proyecto p1 = new Proyecto();
        Proyectos p4 = new Proyectos();
        Empresas p5 = new Empresas();
        Evaluadores p6 = new Evaluadores();
        p5.getAllEmpresa("H");
        p4.getAllEmpresa("Cie Automotive"); 
        p4.writeAll();
        p6.getAllEvaluadores("Cie Automotive");
        for (int i = 0; i < p4.lista.size(); i++) {
         System.out.println(p4.lista.get(i).getFolio());         
        } 
        for (int i = 0; i < p5.lista.size(); i++) {
         System.out.println(p5.lista.get(i).getEmpresa());         
        }   
        for (int i = 0; i < p6.lista.size(); i++) {
         System.out.println(p6.lista.get(i).getEvaluador());         
        }
    }
}
