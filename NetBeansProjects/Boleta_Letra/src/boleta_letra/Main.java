package boleta_letra;

import javax.swing.JOptionPane;

/* @author VGSG */

public class Main {

    public static void main(String[] args) {
       
        Boleta bol=new Boleta();
        bol.leerdatos();
        bol.calcular();
        JOptionPane.showMessageDialog(null,bol.mostrar());
        System.exit(0);
        
    }
    
}

class Alumno{ //Clase Alumno
    
    String nombre; //Variable de Cadena de texto para el Nombre del alumno
    String noCtrl; //Variable de Cadena de texto para el Numero de control del alumno
    byte semestre; //Variable de tipo entera (byte) para el numero de semestre del alumno
    
    void Ingresar(){ //Metodo de la clase Alumno para registrar los datos del alumno que NO regresa datos (VOID)
        
        //Pedimos el Nombre del Alumno usando un JOptionPane.showInputDialog() que nos regresa una cadena de texto 
        nombre = JOptionPane.showInputDialog("Teclea nombre del Alumno"); 
        
        //Pedimos el Numero de control del Alumno usando un JOptionPane.showInputDialog() que nos regresa una cadena de texto 
        noCtrl = JOptionPane.showInputDialog("Teclea Número de Control del Alumno\n"+nombre);
        
        //Pedimos el Semestre del Alumno usando un JOptionPane.showInputDialog() que nos regresa una cadena de texto
        //Lo convertimos a byte con Byte.ParseByte()
        semestre = Byte.parseByte(JOptionPane.showInputDialog("Teclea semestre del Alumno\n"+nombre));
        
    }
    
    String Mostrar(){ //Metodo de la clase Alumno para mostrar los datos del alumno que SI nos regresa datos (String)[Cadena de texto]
        
        //Usamos un "return" para regresar una datos (en este caso String)
        //Rregresamos el texto a imprimir que incluye los datos del alumno
        return "Número de Control: "+noCtrl+"\nNombre: "+nombre+"\nSemestre:"+semestre;
        
    }

}

class Materia {
    String materia; //Variable de tipo cadena de caracteres para la materia
    String cMat; //Variable de tipo cadena de texto para la clave de la materia
    byte creditos; //Variable de tipo byte (entero) para los creditos de la materia

    void leerDatos(){
        //Damos valor a la variable materia usando un JOPtionPane... que nos regresa un String (cadena de caracteres)
        materia=JOptionPane.showInputDialog("Teclea nombre de la Materia");
        
        //Damos valor a la variable cMat usando un JOPtionPane... que nos regresa un String (cadena de caracteres)
        cMat=JOptionPane.showInputDialog("Teclea clave de la Materia\n"+materia);
        
        //Damos valor a la variable creditos usando un JOPtionPane... que nos regresa un String (cadena de caracteres)
        //Convertimos el String a byte con Byte.ParseByte()
        creditos=Byte.parseByte(JOptionPane.showInputDialog("Teclea créditos de la Materia\n"+materia));
    }

    String mostrar(){ //Metodo para mostrar lo obtenido de la materia donde regresamos un String (cadena de caracteres)
        
        //Regresamos una cadena de texto con la informacion obtenida
        return "\nClave de la Materia: "+cMat+"\nNombre de la materia:"+materia+"\nCreditos: "+creditos;
        
    }
}

class Promedio { //Clase de promedio para las clases del alumno
    double cal1,cal2,cal3,cal4; //Declaracion de variables de calificacion1,2,... de tipo doble (numero real)
    double promedio; // Declaracion de variable de promedio de tipo doble (numero real)
    String estado; // Declaracion de variable de estado (aprobado / reprobado) de tipo String (cadena de caracteres
    String texto; // Declaracion de variable de texto donde de guarda el promedio en forma de texto de tipo String (cadena de caracteres

    void leerDatos(){
        
        //Estas sentencias engloban la misma logica
        //Usamos un JOptionPane.showInputDialog() para pedir las calificaciones de los parciales
        //Y usamos un Double.parseDouble() para convertir el String obtenido del JOp.. en double (numero real)
        cal1=Double.parseDouble(JOptionPane.showInputDialog("Teclea caliificación 1"));
        cal2=Double.parseDouble(JOptionPane.showInputDialog("Teclea caliificación 2"));
        cal3=Double.parseDouble(JOptionPane.showInputDialog("Teclea caliificación 3"));
        cal4=Double.parseDouble(JOptionPane.showInputDialog("Teclea caliificación 4"));
    }

    String mostrar(){ //Metodo para mostrar los datos guardados de calificaciones y promedio que regresa un String (cadena de texto)
        
        return "\nCalificacion 1: "+cal1+"\nCalificacion 2: "+cal2+"\nCalificacion 3:"+cal3+"\nCalificacion 4: "+cal4+"\nEl Promedio de calificaciones es: "+promedio+"\n"+texto+"\n\nEstatus: "+estado;
        
    }

    void calcular(){
        //Se calcula el promedio sumando las calificaciones y dividiendo entre 4
        promedio=(cal1+cal2+cal3+cal4)/4;
        
        //Se valida si el promedio es mayor o igual a 70
        if(promedio>=70){
            
            //Si si lo es el estado es APROBADO
            estado = "APROBADO";
        }else{
            
            //Si no lo es el estado es REPROBADO
            estado = "REPROBADO";
        }
        
        //Delcaramos una variable te tipo entera (int) que sea igual a el promedio sobre 10 para obtener las decenas
        //Usamos el cast (int) para convertir lo obtenido (un valor real) a un valor entero, ignorando los decimales 
        int dece = (int)promedio/10;
        
        //Delcaramos una variable te tipo entera (int) que sea igual a el promedio modulo 10 para obtener las unidades
        //Usamos el cast (int) para convertir lo obtenido (un valor real) a un valor entero, ignorando los decimales 
        int uni = (int) promedio%10;
 
        //Se valida el valor de las decenas de 1 a 10
        switch(dece){
            //Si es 1 el texto se iguala a Diez
            case 1: texto = "Diez";break;
            //Si es 2 el texto se iguala a Veinte
            case 2: texto = "Veinte";break;
            //Si es 3 el texto se iguala a Treinta
            case 3: texto = "Treinta ";break;
            //Si es 4 el texto se iguala a ...
            case 4: texto = "Cuarenta ";break;
            //Si es n el texto se iguala a ...
            case 5: texto = "Cincuenta ";break;
            //Si es n el texto se iguala a ...
            case 6: texto = "Sesenta ";break;
            //Si es n el texto se iguala a ...
            case 7: texto = "Setenta ";break;
            //Si es n el texto se iguala a ...
            case 8: texto = "Ochenta ";break;
            //Si es n el texto se iguala a ...
            case 9: texto = "Noventa ";break;
            //Si es n el texto se iguala a ...
            case 10: texto = "Cien";
            //No es ninguna (alguna excepcion) el texto se deja en blanco
            default: texto = "";
        }
        
        //Se valida el valor de las unidades de 1 a 9
        switch(uni){
            //Si es 1 el texto se iguala a uno
            case 1: texto += "uno";break;
            //Si es 2 el texto se iguala a dos
            case 2: texto += "y dos ";break;
            //Si es 3 el texto se iguala a tres
            case 3: texto += "y tres";break;
            //Si es n el texto se iguala a ...
            case 4: texto += "y cuatro";break;
            //Si es n el texto se iguala a ...
            case 5: texto += "y cinco";break;
            //Si es n el texto se iguala a ...
            case 6: texto += "y seis";break;
            //Si es n el texto se iguala a ...
            case 7: texto += "y siete";break;
            //Si es n el texto se iguala a ...
            case 8: texto += "y ocho";break;
            //Si es n el texto se iguala a ...
            case 9: texto += "y nueve";break;
            //Si es algun otro valor (excepcional) se deja en blanco
            default: texto += "";
        }
        
        //Se valida si el promedio es 0 total
        if(promedio==0){
            
            //Si si lo es el texto de iguala a Cero
            texto = "Cero";
        }
        
        //Se validan las excepciones de promedios numeros que no siguen patron de (decenas) y (unidades) Ej: Once no es Diez y uno 
        //Estas se encuentran en los valores de 11 a 19 por eso validamos que sea mayor a 10 y menor a 20
        if(promedio>10 && promedio<20){ 
            
            //Usamos un switch para validar los casos excepcionales 
            //Usamos un (int)promedio para solo tomar en cuenta el promedio entero, ignorando los decimales
            switch((int)promedio){
                //Si el promedio es 11 entonces el texto se iguala a Once
                case 11: texto = "Once";break;
                //Si el promedio es n entonces el texto se iguala a ...
                case 12: texto = "Doce";break;
                //Si el promedio es n entonces el texto se iguala a ...
                case 13: texto = "Trece";break;
                //Si el promedio es n entonces el texto se iguala a ...
                case 14: texto = "Catorce";break;
                //Si el promedio es n entonces el texto se iguala a ...
                case 15: texto = "Quince";break;
                //Si el promedio es n entonces el texto se iguala a ...
                case 16: texto = "Dieciseis";break;
                //Si el promedio es n entonces el texto se iguala a ...
                case 17: texto = "Diecisiete";break;
                //Si el promedio es n entonces el texto se iguala a ...
                case 18: texto = "Dieciocho";break;
                //Si el promedio es n entonces el texto se iguala a ...
                case 19: texto = "Diecinueve";break;
            }
        }
        
        
        //Se validan las excepciones de promedios numeros que no siguen patron de (decenas) y (unidades) Ej: Vieintiuno no es Veinte y uno 
        //Estas se encuentran en los valores de 11 a 19 por eso validamos que sea mayor a 20 y menor a 30
        if(promedio>20 && promedio<30){
            switch((int)promedio){
                //Si el promedio es 21 entonces el texto se iguala a Veintiuno
                case 21: texto = "Veintiuno";break;
                //Si el promedio es n entonces el texto se iguala a ...
                case 22: texto = "Veintidos";break;
                //Si el promedio es n entonces el texto se iguala a ...
                case 23: texto = "Veintitres";break;
                //Si el promedio es n entonces el texto se iguala a ...
                case 24: texto = "Veinticuatro";break;
                //Si el promedio es n entonces el texto se iguala a ...
                case 25: texto = "Veinticinco";break;
                //Si el promedio es n entonces el texto se iguala a ...
                case 26: texto = "Veintiseis";break;
                //Si el promedio es n entonces el texto se iguala a ...
                case 27: texto = "Veintisiete";break;
                //Si el promedio es n entonces el texto se iguala a ...
                case 28: texto = "Veintiocho";break;
                //Si el promedio es n entonces el texto se iguala a ...
                case 29: texto = "Veintinueve";break;
                //Si el promedio es n entonces el texto se iguala a ...
            }
        }
    }
}

class Boleta { //Clase Boleta para guardar las instancias (creaciones) de Alumno,Materia,Promedio
    //Instancia = creacion
    //Objeto = variable
    
    //Se instancia una clase Alumno con un objeto llamado al
    Alumno al=new Alumno();
    //Se instancia una clase Materia con un objeto llamado ma
    Materia ma=new Materia();
    //Se instancia una clase Prmedio con un objeto llamado pr
    Promedio pr=new Promedio();

    void leerdatos(){
        al.Ingresar(); //Se llama al metodo Ingresar de la clase Alumno
        ma.leerDatos(); //Se llama al metodo leerDatos de la clase Materia
        pr.leerDatos(); //Se llama al metodo leerDatos de la clase Promedio
    }

    String mostrar(){
        
        return "Boleta de calificaciones\n"+al.Mostrar()+"\n"+ma.mostrar()+"\n"+pr.mostrar(); //Se regresa los valores obtenidos en la clase
    
    }

    void calcular(){
        pr.calcular(); //Se llama al metodo calcular de la clase Promedio
    }
}