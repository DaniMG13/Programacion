package tiendacomputadoras;

import javax.swing.JOptionPane;

/* @author VGSG */

public class Main {

    public static void main(String[] args) {
        
    }

}

class Tienda{
    Computadora com[];
    private String nombreT,prop,id;

    public Tienda(String nombreT, String prop, String id) {
        this.nombreT = nombreT;
        this.prop = prop;
        this.id = id;
    }

    public String getNombreT() {
        return nombreT;
    }

    public void setNombreT(String nombreT) {
        this.nombreT = nombreT;
    }

    public String getProp() {
        return prop;
    }

    public void setProp(String prop) {
        this.prop = prop;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}

class Computadora{
    private String idC,marca,mem,proc,so;
    private double prec;

    public String getIdC() {
        return idC;
    }

    public void setIdC(String idC) {
        this.idC = idC;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMem() {
        return mem;
    }

    public void setMem(String mem) {
        this.mem = mem;
    }

    public String getProc() {
        return proc;
    }

    public void setProc(String proc) {
        this.proc = proc;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public double getPrec() {
        return prec;
    }

    public void setPrec(double prec) {
        this.prec = prec;
    }
    
    void AgregarCompu(){
        idC = JOptionPane.showInputDialog("Ingresa el identificador del equipo");
        marca = JOptionPane.showInputDialog("Ingresa la marca del equipo");
        mem = JOptionPane.showInputDialog("Ingresa la memoria de alacenamiento del equipo");
        proc = JOptionPane.showInputDialog("Ingresa el modelo del procesador del equipo");
        so = JOptionPane.showInputDialog("Ingresa el Sistema Operativo del equipo");
        prec = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el identificador del equipo"));
    }
}