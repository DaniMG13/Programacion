package arreglosclases;

import javax.swing.JOptionPane;

/* @author VGSG */
public class ArreglosClases {
public static String empresa;
public static int est,n = 0,nE = 0;
public static Empleados emp[];
    public static void main(String[] args) {
        
        nombrar();
        
        int opc = 10;
        do{
            opc = menu();
            if(est==0 && (opc>1 && opc<7)){
                opc = 10;
            }
            switch(opc){
                case 1:noEmp();
                       opc=10;
                       est=1;break;
                case 2:ingAuto();
                       opc = 10;break;
                case 3:ingMan();
                       opc = 10;break;
                case 4:int n = listar();
                       JOptionPane.showMessageDialog(null, emp[n].mostrar());
                       opc = 10;break;
                case 5:nomina();
                       opc = 10;break;
                case 6:est();
                       opc = 10;break;
                case 7:nombrar();
                       opc = 10;break;
                case 8:break;
                default:JOptionPane.showMessageDialog(null,"Ingresa una opcion valida");break;
            }
        }while(opc<1 || opc>8);
        
    }

    public static int menu() {
        String salida = "";
        if(est==0){
            salida = "Bienvenido a "+empresa+"\nSeleccione la accion deseada\n1.-Ingresar la capacidad de empleados\n6.-Cambiar nombre de la empresa\n8.-Salir";
        }else{
            salida = "Bienvenido a "+empresa+"\nSeleccione la accion deseada\n1.-Ingresar la capacidad de empleados (Capacidad de empleados actual: "+n+")\n2.-Ingresar los empleados (Seguidos)\n3.-Ingresar los empleados (De uno en uno) "+nE+" ocupados de "+n+"\n4.-Listar empleados\n5.-Calcular nomina\n6.-Estadisticas\n7.-Cambiar nombre de la empresa\n8.-Salir";
        }
        
        int ret = 9;
        boolean ban=true;
        do{
            try{
                ret = Integer.parseInt(JOptionPane.showInputDialog(null, salida, "Empresa "+empresa, JOptionPane.INFORMATION_MESSAGE));
                ban = false;
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Ingresa un caracter valido");
                ban = true;
            }
        }while(ban);    
        return ret;
    }

    private static void noEmp() {
        
        if(est!=0){
            boolean ban=true;
            while(ban){
                String salida = "Ya has ingresado una capacidad de empleados anteriormente, al continuar se eliminaran los datos anteriores\n¿Continuar? (Y/N)";
                String aux = JOptionPane.showInputDialog(salida);
                if(aux.equals("Y") || aux.equals("y")){
                    ing();
                    ban = false;
                }else{
                    if(aux.equals("N") || aux.equals("n")){
                        ban = false;
                    }else{
                        JOptionPane.showMessageDialog(null, "Ingresa una respuesta valida");
                    }
                }
            }
        }else{
            ing();
        }
    }
    
    public static void ing(){
        String TEXT = "Bienvenido a "+empresa+"\nIngresa el numero de empleados";
        
            boolean ban = true;
        
            do{
                try{
                    n = Integer.parseInt(JOptionPane.showInputDialog(TEXT));
                    emp = new  Empleados[n];
                    ban=false;
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Dato invalido, ingresa un numero");
                    ban = true;
                }   
            }while(ban);
    }

    private static void ingAuto() {
        for(int i=0;i<n;i++){
            emp[i] = new Empleados();
            emp[i].Init(i);
        }
    }

    private static void ingMan() {
        
        if(nE==n){
            JOptionPane.showMessageDialog(null, "Todos los espacios de nuevos empleados han sido ocupados");
        }else{
            emp[nE] = new Empleados();
            emp[nE].Init(nE);
            nE++;
        }
    }

    private static void nomina() {
        boolean ban = true;
        int opc = 0;
        String text = "Selecciona\n1.-Generar Nomina de todos los empleados\n2.-Generar Nomina por empleado\n3.-Visualizar Nominas\n4.-Salir";
        do{
            try{
                opc = Integer.parseInt(JOptionPane.showInputDialog(text));
                switch(opc){
                    case 1:nomiAll();break;
                    case 2:nomiPer();break;
                    case 3:Vnomis();break;
                    case 4:ban=false;break;
                    default:break;
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Ingresa un caracter valido","Error de caracter",JOptionPane.ERROR_MESSAGE);
            }
        }while(ban);
    }

    private static void nomiAll() {
        for(int i=0;i<n;i++){
            emp[i].Sueldos(emp[i].nombre);
        }
    }

    private static void nomiPer() {
        boolean ban = true;
        do{
            try{
                int i = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el numero del empleado a generar su nomina"));
                emp[i].Sueldos(emp[i].nombre);
                ban = false;
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Por favor ingresa un caracter valido","Caracter invalido",JOptionPane.ERROR_MESSAGE);
            }
        }while(ban);
    }

    private static void Vnomis() {
        JOptionPane.showMessageDialog(null, emp[listar()].Nomina(),"Nomina ",JOptionPane.INFORMATION_MESSAGE);
    }

    private static int listar() {
        String texto = ""; 
        for(int i=0;i<nE;i++){
            texto += ""+i+".-"+emp[i].nombre+"\n";
        }
        String e = JOptionPane.showInputDialog(null, "Empleados\n"+texto+"\n\nIngresa el empleado para ver detalles");
        
        int em = Integer.parseInt(e);
        
        return em;
    }

    private static void nombrar() {
        empresa = JOptionPane.showInputDialog("Ingresa el nombre de tu empresa");
    }

    private static void est() {
        String menu = "Selecciona la opcion deseada\n1.-Estadisticas de edad\n2.-Estadisticas de genero\n3.-Estadisticas de nomina\n4.-Estadisticas de experiencia\n5.-Salir";
        boolean ban = true;
        do{
            int opc = 0;
            try{
                opc = Integer.parseInt(JOptionPane.showInputDialog(menu));
                switch(opc){
                    case 1:EE();break;
                    case 2:EG();break;
                    case 3:EN();break;
                    case 4:EEx();break;
                    case 5:ban = false;break;
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Caracter invalido");
            }
        }while(ban);
        
    }

    private static void EE() {
        //Edad
    }

    private static void EG() {
        ///Genero
    }

    private static void EN() {
        //Nomina
    }

    private static void EEx() {
        //Experiencia
    }

}
