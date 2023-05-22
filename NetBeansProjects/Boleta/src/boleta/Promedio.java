package boleta;

/*VGSG*/

import javax.swing.JOptionPane;

public class Promedio {
    double cal1,cal2,cal3,cal4,promedio;
    String estatus,texto;
    int rest;

    void leerDatos(){
        cal1=Double.parseDouble(JOptionPane.showInputDialog("Teclea caliificación 1"));
        cal2=Double.parseDouble(JOptionPane.showInputDialog("Teclea caliificación 2"));
        cal3=Double.parseDouble(JOptionPane.showInputDialog("Teclea caliificación 3"));
        cal4=Double.parseDouble(JOptionPane.showInputDialog("Teclea caliificación 4"));
    }

    String mostrar(){
        String aux;
        aux="\nCalificacion 1: "+cal1+"\nCalificacion 2: "+cal2+"\nCalificacion 3:"+cal3+"\nCalificacion 4: "+cal4+"\nEl Promedio de calificaciones es: "+promedio+"\n"+texto+"\n\nEstatus: "+estatus;
        return (aux);
    }

    void calcular(){
        promedio=(cal1+cal2+cal3+cal4)/4;
        
        if(promedio>=70){
            estatus= "APROBADO";
        }else{
            estatus= "REPROBADO";
        }
        
        int dece = (int)((promedio/10));
        int uni = (int) promedio-(dece*10);
 
        switch(dece){
            case 1: texto = "Diez";break;
            case 2: texto = "Veinte";break;
            case 3: texto = "Treinta ";break;
            case 4: texto = "Cuarenta ";break;
            case 5: texto = "Cincuenta ";break;
            case 6: texto = "Sesenta ";break;
            case 7: texto = "Setenta ";break;
            case 8: texto = "Ochenta ";break;
            case 9: texto = "Noventa ";break;
            case 10: texto = "Cien";
            default: texto = "";
        }
        
        switch(uni){
            case 1: texto += "uno";break;
            case 2: texto += "y dos ";break;
            case 3: texto += "y tres";break;
            case 4: texto += "y cuatro";break;
            case 5: texto += "y cinco";break;
            case 6: texto += "y seis";break;
            case 7: texto += "y siete";break;
            case 8: texto += "y ocho";break;
            case 9: texto += "y nueve";break;
            default: texto += "";
        }
        if(promedio==0){
            texto = "Cero";
        }
        
        if(promedio>10 && promedio<20){
            switch((int)promedio){
                case 11: texto = "Once";break;
                case 12: texto = "Doce";break;
                case 13: texto = "Trece";break;
                case 14: texto = "Catorce";break;
                case 15: texto = "Quince";break;
                case 16: texto = "Dieciseis";break;
                case 17: texto = "Diecisiete";break;
                case 18: texto = "Dieciocho";break;
                case 19: texto = "Diecinueve";break;
            }
        }
        if(promedio>20 && promedio<30){
            switch((int)promedio){
                case 21: texto = "Veintiuno";break;
                case 22: texto = "Veintidos";break;
                case 23: texto = "Veintitres";break;
                case 24: texto = "Veinticuatro";break;
                case 25: texto = "Veinticinco";break;
                case 26: texto = "Veintiseis";break;
                case 27: texto = "Veintisiete";break;
                case 28: texto = "Veintiocho";break;
                case 29: texto = "Veintinueve";break;
            }
        }
        
        texto += " punto ";
        double aux = promedio - (int)promedio;
        aux *=100;
        rest = (int) aux;
        
        int dece_deci = (int)((rest/10));
        int uni_deci = (int) rest-(dece*10);
 
        String aux2 = "";
        
        switch(dece_deci){
            case 1: aux2 = "diez";break;
            case 2: aux2 = "veinte";break;
            case 3: aux2 = "treinta ";break;
            case 4: aux2 = "cuarenta ";break;
            case 5: aux2 = "cincuenta ";break;
            case 6: aux2 = "sesenta ";break;
            case 7: aux2 = "setenta ";break;
            case 8: aux2 = "ochenta ";break;
            case 9: aux2 = "noventa ";break;
            case 10: aux2 = "cien";
            default: aux2 = "";
        }
        
        switch(uni_deci){
            case 1: aux2 += "uno";break;
            case 2: aux2 += "y dos ";break;
            case 3: aux2 += "y tres";break;
            case 4: aux2 += "y cuatro";break;
            case 5: aux2 += "y cinco";break;
            case 6: aux2 += "y seis";break;
            case 7: aux2 += "y siete";break;
            case 8: aux2 += "y ocho";break;
            case 9: aux2 += "y nueve";break;
            default: aux2 += "";
        }
        
        if(rest==0){
            aux2 = "cero";
        }
        
        if(rest>10 && rest<20){
            switch((int)promedio){
                case 11: aux2 = "once";break;
                case 12: aux2 = "doce";break;
                case 13: aux2 = "trece";break;
                case 14: aux2 = "catorce";break;
                case 15: aux2 = "quince";break;
                case 16: aux2 = "dieciseis";break;
                case 17: aux2 = "diecisiete";break;
                case 18: aux2 = "dieciocho";break;
                case 19: aux2 = "diecinueve";break;
            }
        }
        if(rest>20 && rest<30){
            switch((int)rest){
                case 21: aux2 = "veintiuno";break;
                case 22: aux2 = "veintidos";break;
                case 23: aux2 = "veintitres";break;
                case 24: aux2 = "veinticuatro";break;
                case 25: aux2 = "veinticinco";break;
                case 26: aux2 = "veintiseis";break;
                case 27: aux2 = "veintisiete";break;
                case 28: aux2 = "veintiocho";break;
                case 29: aux2 = "veintinueve";break;
            }
        }
        
        texto += aux2;
        
    }
}