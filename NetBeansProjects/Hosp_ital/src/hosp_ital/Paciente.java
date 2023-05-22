package hosp_ital;

import javax.swing.JOptionPane;

/* @author VGSG */

public class Paciente {
    
    String nombre; //Nombre del paciente
    int costo; //Tarifa por tipo de enfermedad
    int dias; //Dias de hospedaje del paciente
    int enfermedad; //Tipo de enfermedad
    byte edad; //Edad del paciente
    double total; //Pago total 
    
    void Ingresar(){ //Metodo para ingresar los datos del paciente
        //Se pide el nombre del paciente en un JOptionPane que nos regresa un String
        nombre = JOptionPane.showInputDialog("Ingresa el nombre del paciente");
        
        //Se pide la edad del paciente con un JOptionPane que nos regresa un String
        //Entonces usamos un Byte.ParseByte para convertir String a byte
        edad = Byte.parseByte(JOptionPane.showInputDialog("Ingresa la edad del paciente"));
        
        //Se pide el tipo de enfermedad con un JO... y lo convertimos a int con Integer.ParseInt
        enfermedad = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el tipo de enfermedad"));
        
        //Se piden los dias hospedados con JOp... y se transforma a int con Integer.ParseInt
        dias = Integer.parseInt(JOptionPane.showInputDialog("Ingresa los dias hospedados"));
    }
    
    void Calcular(){ //Metodo para calcular el pago total del paciente
        //Validamos el tipo de enfermedad para dar la tarifa por dia
        switch(enfermedad){
            case 1: costo = 250; //En caso que la enfermedad sea tipo 1,2.. se da la tarifa de 250,160...
                    break; //El break se usa para que solo valide un caso y se salga del switch
            case 2: costo = 160;
                    break;
            case 3: costo = 200;
                    break;
            case 4: costo = 320;
                    break;
            default:break;
        }
        
        if(edad>=14 && edad<=22){ //Validamos que la edad del paciente este entre 14 y 22 para aplicar la tarifa adicional
            total = costo*dias*1.1; //Se usa el 1.1 para indicar que es el 110% del valor
        }else{ //En caso de no estar en ese rango de edad no se aplica la tarifa adicional
            total = costo*dias;
        }
        
        if(total>=1000 && total<=2000){ //Se valida que el total este entre 1000 y 2000 para un descuento del 3% 
           total -= total*0.3; //Se usa -= para evitar poner "total = total -" y se resta el 3% 
        }
        if(total>2000){ //Si el total es mayor a 2000 se hace un descuento de 5%
            total -= total*0.05;
        }   
    }
    
    String Mostrar(){ //Metodo que nos regresa un String con la informacion obtenida
        return "Paciente: "+nombre+"\nEdad: "+edad+"\nTipo de enfermedad: "+enfermedad+"\nDias hospedado: "+dias+"\n\nCosto total: "+total;
    }
}
