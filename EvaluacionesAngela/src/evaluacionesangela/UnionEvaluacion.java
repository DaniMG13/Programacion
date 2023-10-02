package evaluacionesangela;

import java.util.ArrayList;

public class UnionEvaluacion 
{
    String folio,empresa,proyecto,claveL,montoEL,claveE,montoEE;
    float monto;
    Proyectos p = new Proyectos();
    Empresas e = new Empresas();
    Evaluadores ev = new Evaluadores();  
    
    public UnionEvaluacion()
    {
        for (int i = 0; i < p.lista.size(); i++) {
            folio = p.lista.get(i).getFolio();
            empresa = p.lista.get(i).getEmpresa();
            proyecto = p.lista.get(i).getProyecto();
            monto = p.lista.get(i).getMonto();
        }
    }
}
