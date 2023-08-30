package tiendaherencia;

import javax.swing.JOptionPane;

/* @author VGSG */
public class TiendHere {
static Tienda tienda;
static Articulos art[];
    public static void main(String[] args) {
        tienda = new Tienda(JOptionPane.showInputDialog("Ingresa el nombre de la tienda"),JOptionPane.showInputDialog("Ingresa el nombre del dueño") , JOptionPane.showInputDialog("Ingresa el identificador de la tienda"));
        art = new Articulos[2];
        for(int i=0;i<art.length;i++){
            switch(Integer.parseInt(JOptionPane.showInputDialog("1.-Agregar computadora\n2.-Agregar accesorio\n3.-Agregar Textil"))){
                case 1:art[i] = new Computadoras(JOptionPane.showInputDialog("Ingresa el ID de la computadora"), 
                        JOptionPane.showInputDialog("Ingresa el modelo de la computadora"), JOptionPane.showInputDialog("Ingresa la marca de la computadora"), 
                        Float.parseFloat(JOptionPane.showInputDialog("Ingresa el precio de la computadora")),Integer.parseInt(JOptionPane.showInputDialog("Ingresa la cantidad de memoria RAM en Gigas")),
                        JOptionPane.showInputDialog("Ingresa el modelo del procesador"),JOptionPane.showInputDialog("Ingresa el Sistema Operativo instalado"));break;
                case 2:art[i] = new Accesorios(JOptionPane.showInputDialog("Ingresa el ID del accesorio"), 
                        JOptionPane.showInputDialog("Ingresa el modelo del accesorio"), JOptionPane.showInputDialog("Ingresa la marca del accesorio"),
                        Float.parseFloat(JOptionPane.showInputDialog("Ingresa el precio del accesorio")), 
                        JOptionPane.showInputDialog("Ingresa las caracteristicas"));break;
                case 3:art[i] = new Textiles(JOptionPane.showInputDialog("Ingresa el ID del textil"), 
                        JOptionPane.showInputDialog("Ingresa el modelo del textil"), JOptionPane.showInputDialog("Ingresa la marca del textil"), 
                        Float.parseFloat(JOptionPane.showInputDialog("Ingresa el precio del textil")),
                        Float.parseFloat(JOptionPane.showInputDialog("Ingresa la talla del textil")), JOptionPane.showInputDialog("Ingresa el color del textil"));break;
            }
        }
        String t = tienda.Imprimir();
        t += "\nArticulos\n";
        for(int i=0;i<art.length;i++){
            t += art[i].Imprimir();
        }
        JOptionPane.showMessageDialog(null, t);
    }

}

class Tienda{
    private String nombre,dueño,id;
    String t;

    public Tienda(String nombre, String dueño, String id) {
        this.nombre = nombre;
        this.dueño = dueño;
        this.id = id;
        t = Imprimir();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDueño() {
        return dueño;
    }

    public void setDueño(String dueño) {
        this.dueño = dueño;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String Imprimir(){
        t = "Tienda: "+getNombre()+"\nID: "+getId()+"\nDueño: "+getDueño();
        return t;
    }
    
}

class Articulos{
    private String noArt,nombre,marca;
    private float precio;
    private int estado;
    String texto;

    public Articulos(String noArt, String nombre, String marca, float precio) {
        this.noArt = noArt;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        String disp;
        if(getEstado()==0){
            disp = "Disponible";
        }else{
            if(getEstado()==1){
                disp = "Apartado";
            }else{
                disp = "Vendido";
            }
        }
        texto = "\nNo. de Articulo: "+getNoArt()+"\nNombre de Articulo: "+getNombre()+"\nMarca: "+getMarca()+
                "\nPrecio: "+getPrecio()+"\nEstado: "+disp;
    }

    public String getNoArt() {
        return noArt;
    }

    public void setNoArt(String noArt) {
        this.noArt = noArt;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }
//
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    public String getT(){
        return texto;
    } 
    
    public String Imprimir(){
        String disp;
        if(getEstado()==0){
            disp = "Disponible";
        }else{
            if(getEstado()==1){
                disp = "Apartado";
            }else{
                disp = "Vendido";
            }
        }
        
        texto = "\nNo. de Articulo: "+getNoArt()+"\nNombre de Articulo: "+getNombre()+"\nMarca: "+getMarca()+
                "\nPrecio: "+getPrecio()+"\nEstado: "+disp;
        return texto;
    }
    
}

class Computadoras extends Articulos{
    private int men;
    private String proc,so;
    String t;

    public Computadoras(String noArt, String nombre, String marca, float precio,int men, String proc, String so) {
        super(noArt, nombre, marca, precio);
        this.men = men;
        this.proc = proc;
        this.so = so;
        t = getT();
        t += "\nMemoria: "+men+"\nProcesador: "+proc+"\nS.O: "+so;
    }
    
    
    public String Imprimir(){
        t = getT();
        t += "\nMemoria: "+men+"\nProcesador: "+proc+"\nS.O: "+so;
        return t;
    }
    
    
}

class Accesorios extends Articulos{
    private String carac;
    String t;

    public Accesorios(String noArt, String nombre, String marca, float precio, String carac) {
        super(noArt, nombre, marca, precio);
        this.carac = carac;
        t +=getT()+ "\nCaracteristicas: "+getCarac();
    }

    public String getCarac() {
        return carac;
    }

    public void setCarac(String carac) {
        this.carac = carac;
    }
    
    @Override
    public String Imprimir(){
        t = getT();
        t += "\nCaracteristicas: "+getCarac();
        return t;
    }
    
}

class Textiles extends Articulos{
    private float talla;
    private String color;
    String t;

    public Textiles(String noArt, String nombre, String marca, float precio, float talla, String color) {
        super(noArt, nombre, marca, precio);
        this.talla = talla;
        this.color = color;
        t = getT() + "\nTalla: "+getTalla()+"\nColor: "+getColor();
    }

    public float getTalla() {
        return talla;
    }

    public void setTalla(float talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
    public String Imprimir(){
        t = getT();
        t += "\nTalla: "+getTalla()+"\nColor: "+getColor();
        return t;
    }
    
}