package dani;

import javax.swing.JOptionPane;

/* @author VGSG */
public class Main {

    public static void main(String[] args) {
        Arreglos obj=new Arreglos();
        int[] arr = null;
        obj.leer();
        int opc;
        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog(Menu()));
            
            switch(opc){
                case 1:arr = obj.cargarArr();break;
                case 2:obj.mostrarArr(arr);break;
                case 3:switch(Integer.parseInt(JOptionPane.showInputDialog("1.-Mayor a menor\n2.-Menor a mayor\nIngresa tu respuesta"))){
                         case 1:arr = obj.ordenarArrM(arr);break;
                         case 2:arr = obj.ordenarArrm(arr);break;
                       }
                        
                        break;
                case 4:arr = obj.buscarArr(arr);break;
            }
            
        }while(opc!=0);
        
    }
    
    static String Menu(){
        String s = "1.- Cargar arreglo\n2.-Imprimir arreglo\n3.-Ordenar arreglo\n4.-Buscar elemento en el arrreglo\n0.-Salir\nIngresa tu respuiesta";
        return s;
    }

    private static void ordenar(Arreglos obj) {
        
    }
}

class Arreglos {
    int n, pos, auxVec;
    boolean ban=true;
    
    int[] arr;
    
    void leer(){
        n=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño deseado del arreglo"));
    }
    
    int[] cargarArr(){
        arr = new int[n];
        for(int i=0; i<n;i++){
            arr[i]=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número deseado en la posición "+(i+1)));
            //pos=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número deseado en la posición "+(i+1)));
            //arr[i]=pos;
        }
        return arr;
    }   
    
    int[] ordenarArrm(int[] arr){
        ban = true;
        for(int i=1;ban;i++){
            ban=false;
            for(int k=1;k<=(n-1);k++){
                if(arr[k-1]>arr[k]){
                    ban=true;
                    auxVec=arr[k-1];
                    arr[k-1]=arr[k];
                    arr[k]=auxVec;
                }
            }
        }
        System.out.println("Arreglo Ordenado Menor");
        return arr;
    }
    
    int[] ordenarArrM(int[] arr){
        ban=true;
        for(int i=1;ban;i++){
            ban=false;
            for(int k=1;k<=(n-1);k++){
                if(arr[k-1]<arr[k]){
                    ban=true;
                    auxVec=arr[k-1];
                    arr[k-1]=arr[k];
                    arr[k]=auxVec;
                }
            }
        }
        System.out.println("Arreglo Ordenado MYOR");
        return arr;
    }
    
    int[] buscarArr(int[] arr){
        int num = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el elemento a buscar"));
        String cood ="";
        String s= "Elemento a buscar: ["+num+"]";
        for(int i =0; i<n; i++){
            if(arr[i]==num){
                cood += "["+i+"]\n";
            }
        }
        if(cood.equals("")){
            s += "\nElemento no encontrado";
        }else{
            s += "\nElemento encontrado en: \n";
            s+=cood;
        }
        JOptionPane.showMessageDialog(null, s);
        return arr;
    }
    
    int[] mostrarArr(int[] arr){
        String s= "Arreglo: [";
        for(int i =0; i<n; i++){
            s+= arr[i]+",";
        }
        s += "]";
        JOptionPane.showMessageDialog(null, s);
        s="";
        return arr;
    }
    
}
