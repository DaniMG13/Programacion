package nomina;

import javax.swing.JOptionPane;

/* @author VGSG */
public class Nominas {
    int n;
    double total = 0,compM = 0,compMe = 0;
    String nMay,nMen,texto = "\nEmpleados:\n";
    
    Empleado emp = new Empleado();
    
    void Leer(){
        n = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el numero de empleados"));
        Ciclo(n);
    }
    
    void Ciclo(int n){
        for(int i=1;i<=n;i++){
            emp.LeerDatos();
            emp.Calcular();
            
            texto += emp.nombre+"    Sueldo por hora: "+emp.sueldo+"     Horas trabajadas: "+emp.hrs+"   Sueldo total: "+emp.total+"\n";
            
            if(i == 1){
                compM = emp.total;
                compMe = emp.total;
            }
            
            if(emp.total >= compM){
                compM = emp.total;
                nMay = emp.nombre;
            }
            
            if(emp.total <= compMe){
                compMe = emp.total;
                nMen = emp.nombre;
            }
            
            total += emp.total;
            
            Mayor();
        }
    }
    
    String Mayor(){
        return "Cantidad de empleados: "+n+texto+"\nTotal de nomina a pagar: $"+total+"\nEmpleado con sueldo mas bajo: "+nMen+", Sueldo: $"+compMe+"\nEmpleado con el salario mas alto: "+nMay+", Sueldo: $"+compM; 
    }
    
}
