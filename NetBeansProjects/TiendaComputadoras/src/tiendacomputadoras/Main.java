package tiendacomputadoras;

import javax.swing.JOptionPane;

/* @author VGSG */

public class Main {

    public static void main(String[] args) {
        Tienda t1 = new Tienda(JOptionPane.showInputDialog("Ingresa el nombre de la tienda"), JOptionPane.showInputDialog("Ingresa el nombre del propietario"), JOptionPane.showInputDialog("Ingresa el identificador de la tienda"));
        t1.AgregarCompu();
        t1.AgregarCompu();
        t1.BuscarComp("190");
        t1.Eliminar("190");
        t1.BuscarComp("190");
    }

}

class Tienda{
    Computadora com[];
    static int conta = 0;
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
    
    public void AgregarCompu(){
        conta++;
        if(conta==1){
            com = new Computadora[conta];
            com[conta-1] = new Computadora();
            com[conta-1].AgregarCompu();
        }else{
            Computadora temp[] = new Computadora[conta];
            for(int i=0;i<conta-1;i++){
                temp[i] = com[i];
            }
            temp[conta-1] = new Computadora();
            temp[conta-1].AgregarCompu();
            com = new Computadora[conta];
            for(int j=0;j<conta;j++){
                com[j] = temp[j];
            }
        }
                
    }
    
    public void BuscarComp(String id){
        String txt = "No se han encontrado datos con ese ID";
        for(int i=0;i<conta;i++){
            if(com[i].getIdC().equals(id)){
                txt = "Detalles del producto\n";
                txt += "Identificador: "+com[i].getIdC()+"\n";
                txt += "Marca del equipo: "+com[i].getMarca()+"\n";
                txt += "Memoria de almacenamiento: "+com[i].getMem()+" GB\n";
                txt += "Modelo del procesador: "+com[i].getProc()+"\n";
                txt += "Sistema Operativo: "+com[i].getSo()+"\n";
                txt += "Pecio: $"+com[i].getPrec()+" MXN\n";
                break;
            }
        }
        JOptionPane.showMessageDialog(null, txt,"Resultado de busqueda",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void Eliminar(String id){
        String txt = "No se han encontrado datos con ese ID";
        for(int i=0;i<conta;i++){
            if(com[i].getIdC().equals(id.trim())){
                com[i] = com[conta-1];
                txt = "Eliminacion exitosa";
                break;
            }
        }
        conta--;
        Computadora temp[] = new Computadora[conta];
        for(int i=0;i<conta;i++){
            temp[i] = com[i];
        }
        com = new Computadora[conta];
        for(int j=0;j<conta;j++){
            com[j] = temp[j];
        }
        
        JOptionPane.showMessageDialog(null, txt,"Resultado de eliminacion",JOptionPane.INFORMATION_MESSAGE);
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
        idC = JOptionPane.showInputDialog("Ingresa el identificador del equipo").trim();
        marca = JOptionPane.showInputDialog("Ingresa la marca del equipo").trim();
        mem = JOptionPane.showInputDialog("Ingresa la memoria de alacenamiento del equipo (en Gb)").trim();
        proc = JOptionPane.showInputDialog("Ingresa el modelo del procesador del equipo").trim();
        so = JOptionPane.showInputDialog("Ingresa el Sistema Operativo del equipo").trim();
        prec = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el precio del equipo").trim());
    }
}