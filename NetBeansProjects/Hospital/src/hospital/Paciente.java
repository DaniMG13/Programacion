package hospital;

import javax.swing.JOptionPane;

/*VGSG*/

public class Paciente {
    
    String name,desc,totalsd;
    int dias,edad,costo,tipo;
    double total;
    
    
    void Ingresar(){
        name = JOptionPane.showInputDialog("Ingresa el nombre del paciente");
        edad = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la edad del paciente"));
        tipo = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el tipo de enfermedad de 1-4"));
        dias = Integer.parseInt(JOptionPane.showInputDialog("Ingresa los dias de hospejdaje"));
    }
    
    void Calcular(){    
        boolean ban = false;
        
        if(edad>=14 && edad<=22){
            ban = true;
        }
        desc="";
        switch(tipo){
            case 1: costo = 250;
                    if(ban){
                        total = (costo*dias)*0.1 + (costo*dias);
                    }else{
                        total = costo*dias;
                    }
                    
                    if(total>1000 && total<=2000){
                        total -= total*0.03;
                        desc = "Descuento de 3%";
                    }
                    if(total>2000){
                        total -= total*0.05;
                        desc = "Descuento de 5%";
                    }
                    break;
            case 2: costo = 160;
                    if(ban){
                        total = (costo*dias)*0.1 + (costo*dias);
                    }else{
                        total = costo*dias;
                    }
                    
                    if(total>1000 && total<=2000){
                        total -= total*0.03;
                        desc = "Descuento de 3%";
                    }
                    if(total>2000){
                        total -= total*0.05;
                        desc = "Descuento de 5%";
                    }break;
            case 3: costo = 200;
                    if(ban){
                        total = (costo*dias)*0.1 + (costo*dias);
                    }else{
                        total = costo*dias;
                    }
                    
                    if(total>1000 && total<=2000){
                        total -= total*0.03;
                        desc = "Descuento de 3%";
                    }
                    if(total>20000){
                        total -= total*0.05;
                        desc = "Descuento de 5%";
                    }break;
            case 4: costo = 320;
                    if(ban){
                        total = (costo*dias)*0.1 + (costo*dias);
                    }else{
                        total = costo*dias;
                    }
                    
                    if(total>1000 && total<=2000){
                        total -= total*0.03;
                        desc = "Descuento de 3%";
                    }
                    if(total>2000){
                        total -= total*0.05;
                        desc = "Descuento de 5%";
                    }break;
            default:JOptionPane.showMessageDialog(null,"Numero Invalido");break;
        }
        
    }
    
    String Motrar(){
        String aux = "Hospital VGSG\nPaciente: "+name+"\nEdad: "+edad+"\nTipo de enfermedad: "+tipo+"\nDias hospedado: "+dias+"\n\n"+desc+"\nTotal a pagar: "+total;
        return aux;
    }
    
}
