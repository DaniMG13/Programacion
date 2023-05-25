package tiendaherencia;

/* @author VGSG */
public class Main {

    public static void main(String[] args) {
        
    }

}

class Tienda{
    private String nombre,dueño,id;

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