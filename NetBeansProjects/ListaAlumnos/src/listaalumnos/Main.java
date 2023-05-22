package listaalumnos;

import java.util.Scanner;
import javax.swing.JOptionPane;
/* @author VGSG */

public class Main {
static Alumnos alu[] = new Alumnos[10];
static int nA = 0;
static Scanner tecla;
    public static void main(String[] args) {
        tecla = new Scanner(System.in);
        for(int i=0;i<10;i++){
            if(MenuInterno()==1){
                String n,a,nc;
                nA++;
                alu[i] = new Alumnos();
                nc = JOptionPane.showInputDialog("Ingresa el No. de control del alumno");
                n = JOptionPane.showInputDialog("Ingresa el nombre del alumno");
                a = JOptionPane.showInputDialog("Ingresa los apellidos del alumno");
                
                alu[i].setNoControl(nc);
                alu[i].setNombre(n);
                alu[i].setApellidos(a);
            }else{
                break;
            }
        }
        int opc = 0;
        do{
            opc = MenuInit();
            switch(opc){
                case 1:Listar();break;
                case 2:Buscar();break;
            }
        }while(opc!=0);
    }

    public static int MenuInterno(){
        int opc = 0;
        do{
            try{
                String txt = " ------ Bienvenido ------\n";
                txt += " 1.- Registrar Alumno\n";
                txt += " 0.- Salir\n";
                txt += " -------------------------------\n";
                txt += "Ingresa tu respuesta: ";
                opc = Integer.parseInt(JOptionPane.showInputDialog(txt));
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Caracter invalido, reintenta","error de respuesta",JOptionPane.ERROR_MESSAGE);
            }
        }while(!(opc>=0 && opc<=1));
        return opc;
    }
    
    public static int MenuInit(){
        int opc = 0;
        do{
            try{
                String txt = " ------ Bienvenido ------\n";
                txt += " 1.- Listar Alumnos\n";
                txt += " 2.- Buscar Alumno\n";
                txt += " 0.- Salir\n";
                txt += " -------------------------------\n";
                txt += "Ingresa tu respuesta: ";
                opc = Integer.parseInt(JOptionPane.showInputDialog(txt));
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Caracter invalido, reintenta","error de respuesta",JOptionPane.ERROR_MESSAGE);
            }
        }while(!(opc>=0 && opc<=2));
        return opc;
    }

    private static void Listar() {
        String txt = "Lista de Alumnos\n";
        for(int i=0;i<nA;i++){
            txt += "---------------------------------------------------\n";
            txt += "Numero de Control: "+alu[i].getNoControl()+"\n";
            txt += "Nombre(s) del Alumno: "+alu[i].getNombre()+"\n";
            txt += "Apellidos del Alumno: "+alu[i].getApellidos()+"\n";
            txt += "---------------------------------------------------\n";
        }
        JOptionPane.showMessageDialog(null, txt);
    }

    private static void Buscar() {
        String txt = "El Numero de Control no esta asociado a ningun alumno";
        String nC = JOptionPane.showInputDialog("Ingresa el Numero de Control a buscar");
        for(int i=0;i<nA;i++){
            if(alu[i].getNoControl().equals(nC)){
                txt = "------------- Datos del alumno --------------\n";
                txt += "Numero de Control: "+alu[i].getNoControl()+"\n";
                txt += "Nombre(s) del Alumno: "+alu[i].getNombre()+"\n";
                txt += "Apellidos del Alumno: "+alu[i].getApellidos()+"\n";
                txt += "-----------------------------------------------------\n";
            }
        }
        JOptionPane.showMessageDialog(null, txt);
    }
}
