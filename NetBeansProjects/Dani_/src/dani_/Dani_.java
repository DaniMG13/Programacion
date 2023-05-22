package dani_;

import javax.swing.JOptionPane;

/* @author sergi */
public class Dani_ {
    static int size;
    static int n;
    static Alumno[] arrA;
    public static void main(String[] args) {
        int opc;
        n=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de alumnos"));
        arrA = new Alumno[n];
        for(int i=0; i<n; i++){
            arrA[i] = new Alumno();
            arrA[i].setNombre();
            arrA[i].setNumCtrl();
        }
        
        do{
           opc=Integer.parseInt(JOptionPane.showInputDialog(menu()));
           switch(opc){
               case 1: 
                   String aux="";
                   for(int i=0; i<n; i++){
                       aux+=arrA[i].getNombre()+" - "+arrA[i].getNumCtrl();
                       aux+="\n";
               }
                   JOptionPane.showMessageDialog(null,aux);
                   break;
               case 2:
                   int res;
                   res=Integer.parseInt(JOptionPane.showInputDialog("1. Mayor a menor\n2. Menor a mayor"));
                   if(res==1){
                       ordenarNumMay();
                   }
                   else {
                       if(res==2){
                           ordenarNumMen();
                       }
                   }
                   
                   break;
               case 3:ordenarNombre();
                   break;
               case 4:
                   break;
               case 5:
                   break;
           }
        } while(opc!=5);
        System.exit(0);
    }
    
    static String menu(){
        String s="MENÚ\n1. Mostrar Tabla\n2. Ordenar arreglo por número de control\n3. Ordenar arreglo por nombre\n4. Consulta de datos\n5. Salir\nIngrese su respuesta";
        return s;
    }
    
    static void ordenarNumMay(){
        int ncT;
        String nomT;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<(n-1); j++){
                if(arrA[j].getNumCtrl()<arrA[j+1].getNumCtrl()){
                   ncT=arrA[j].getNumCtrl();
                   nomT=arrA[j].getNombre();
                   arrA[j].numCtrl=arrA[j+1].getNumCtrl();
                   arrA[j].nombre=arrA[j+1].getNombre();
                   arrA[j+1].numCtrl=ncT;
                   arrA[j+1].nombre=nomT;
                }
            }
        }
    }
    
    static void ordenarNumMen(){
        int ncT;
        String nomT;
        
        for(int i=0; i<n; i++){
            for(int j=0; j>(n-1); j++){
                if(arrA[j].getNumCtrl()>arrA[j+1].getNumCtrl()){
                   ncT=arrA[j].getNumCtrl();
                   nomT=arrA[j].getNombre();
                   arrA[j].numCtrl=arrA[j+1].getNumCtrl();
                   arrA[j].nombre=arrA[j+1].getNombre();
                   arrA[j+1].numCtrl=ncT;
                   arrA[j+1].nombre=nomT;
                }
            }
        }
    }
    
    static void ordenarNombre(){
        Alumno a;
        a = new Alumno();
        for(int i=0; i<n; i++){
            for(int j=0; j<(n-1); j++){
                
                if((arrA[j].nombre.compareToIgnoreCase(arrA[j+1].nombre))>0){
                   System.out.println(arrA[j].getNombre().compareToIgnoreCase(arrA[j+1].getNombre()));
                   a = arrA[j];
                   arrA[j] = arrA[j+1];
                   arrA[j+1] = a;
                }
            }
        }
        
        System.out.println(arrA[0].getNombre().compareToIgnoreCase(arrA[1].getNombre()));
    }
    
}
