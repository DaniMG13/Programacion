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
    
}

class Computadoras extends Articulos{
    
}

class Accesorios extends Articulos{
    
}

class Textiles extends Articulos{
    
}