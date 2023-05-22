package tiendacomputadoras;

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
    
}