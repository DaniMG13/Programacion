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
    
}

class Accesorios extends Articulos{
    
}

class Textiles extends Articulos{
    
}