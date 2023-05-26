package tiendaherencia;

import javax.swing.JOptionPane;

/* @author VGSG */
public class Main {
static Tienda t;
    public static void main(String[] args) {
        t = new Tienda(JOptionPane.showInputDialog("Ingresa el nombre de la tienda"),JOptionPane.showInputDialog("Ingresa el nombre del dueño") , JOptionPane.showInputDialog("Ingresa el identificador de la tienda"));
        
    }

}

class Tienda{
    private String nombre,dueño,id;

    private Articulos arts[];
    //comentsrio

    public Tienda(String nombre, String dueño, String id) {
        this.nombre = nombre;
        this.dueño = dueño;
        this.id = id;
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
    
}

class Articulos{
    private String noArt,nombre,marca;
    private float precio;
    private int estado;

    public Articulos(String noArt, String nombre, String marca, float precio) {
        this.noArt = noArt;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
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
        String t = "No. de Articulo: "+getNoArt()+"\nNombre de Articulo: "+getNombre()+"\nMarca: "+getMarca()+
                "\nPrecio: "+getPrecio()+"\nEstado: "+disp;
        return t;
    }
    
}

class Computadoras extends Articulos{
    private int men;
    private String proc,so;

    public Computadoras(String noArt, String nombre, String marca, float precio,int men, String proc, String so) {
        super(noArt, nombre, marca, precio);
        this.men = men;
        this.proc = proc;
        this.so = so;
    }
    
    @Override
    public String Imprimir(){
        String t = Imprimir();
        t += "\nMemoria: "+men+"\nProcesador: "+proc+"\nS.O: "+so;
        return t;
    }
    
    
}

class Accesorios extends Articulos{
    private String carac;

    public Accesorios(String noArt, String nombre, String marca, float precio, String carac) {
        super(noArt, nombre, marca, precio);
        this.carac = carac;
    }

    public String getCarac() {
        return carac;
    }

    public void setCarac(String carac) {
        this.carac = carac;
    }
    
}

class Textiles extends Articulos{
    private float talla;
    private String color;

    public Textiles(String noArt, String nombre, String marca, float precio, float talla, String color) {
        super(noArt, nombre, marca, precio);
        this.talla = talla;
        this.color = color;
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
    
    
}