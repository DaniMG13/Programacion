package arreglosclases;

import javax.swing.JOptionPane;

/* @author VGSG */
public class Empleados {
    String nombre,puesto,calle,numero,colonia,municipio,estado,pais;
    int edad,gender,horasT,horasE = 0,exp,i;
    double sueldoB,sueldoN,sueldoT,IVA;
    double estatura,peso;  
    
    
    public int xd(){
        return 1;
    }
    void Init(int i){
        //Datos personales
        i++;
        this.i = i;
        nombre = JOptionPane.showInputDialog("Ingresa el nombre del empleado "+i);
        
        edad = ValidarI("Ingresa la edad del empleado "+i);
        
        String text = "Ingresa el genero\n1.-Hombre\n2.-Mujer";
        
        do{
            gender = ValidarI(text);
        }while(gender<1 || gender>2);
        
        estatura = ValidarD("Ingresa la estatura del empleado en Centimetros"+i);
        
        peso = ValidarD("Ingresa el peso del empleado en Kilogramos"+i);
        
        //Direcciones
        calle = JOptionPane.showInputDialog("Ingresa el nombre de la calle donde vive el empleado "+i);
        numero = JOptionPane.showInputDialog("Ingresa el numero de casa donde vive el empleado "+i);
        colonia = JOptionPane.showInputDialog("Ingresa el nombre de la colonia donde vive el empleado "+i);
        municipio = JOptionPane.showInputDialog("Ingresa el nombre del municipio donde vive el empleado "+i);
        estado = JOptionPane.showInputDialog("Ingresa el nombre del estado donde vive el empleado "+i);
        pais = JOptionPane.showInputDialog("Ingresa el nombre del pais donde vive el empleado "+i);
        
        //Datos profesionales
        puesto = JOptionPane.showInputDialog("Ingresa el puesto del empleado "+i);
        exp = ValidarI("Ingresa el los años de experiencia del empleado "+i);
        sueldoB = ValidarD("Ingresa el sueldo base por hora del empleado "+i);
        IVA = ValidarD("Ingresa el porcentaje de retencion de impuestos del empleado "+i);
      
    }
    
    void Sueldos(String name){
        horasT = ValidarI("Ingresa la horas (enteras) trabajadas en horario regular de "+name);
        horasE = ValidarI("Ingresa la horas (enteras) trabajadas en horario extraordinario de "+name);
        //Horas trabajadas regular * sueldo base + (horas trabajadas extraor.. * sueldo base * 2) = sueldo neto
        
        if(horasE==0){
            sueldoN = horasT*sueldoB;
            sueldoT = (sueldoN*IVA)*100;
        }else{
            sueldoN = (horasT*sueldoB) + (horasE*sueldoB*2);
            sueldoT = sueldoN-((sueldoN*IVA)/100);
        }
    }
    
    String mostrar(){
        String aux = "Nombre: "; 
        
        //nombre,edad,gender,estatura,peso,puesto,exp,sueldoB,IVA
            aux += nombre;
            aux += "\nEdad:"+edad;
            aux += "\nGenero:"+gender;
            aux += "\nEstatura:"+estatura;
            aux += " cm\nPeso:"+peso;
            aux += " kg\nPuesto:"+puesto;
            aux += "\nExperiencia:"+exp;
            aux += " años\nSueldo base por hora: $"+sueldoB;
            aux += " MXN\nIVA retenido:"+IVA;
            aux += "%";
 
        
        return aux;
    }
    
    String Nomina(){
        String texto = "Empleado: "+nombre+"\nSueldo base por hora: $"+sueldoB+"\n";
        texto += "Horas ordinarias laboradas: "+horasT+"\nHoras extraordinarias laboradas: "+horasE;
        texto += "\nSueldo Neto: $"+sueldoN+" MXN\nIVA: "+IVA+"%\nSueldo Total: $"+sueldoT+" MXN";
        return texto;
    }
    
    int ValidarI(String text){
        boolean ban = true;
        int aux = 0;
        do{ 
            try{
                aux = Integer.parseInt(JOptionPane.showInputDialog(text));
                ban = false;
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Ingresa un numero entero");
                ban = true;
            }
        }while(ban);
        return aux;
    }
    
    double ValidarD(String text){
        boolean ban = true;
        double aux = 0;
        do{ 
            try{
                aux = Double.parseDouble(JOptionPane.showInputDialog(text));
                ban = false;
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Ingresa un numero");
                ban = true;
            }
        }while(ban);
        return aux;
    }
}
