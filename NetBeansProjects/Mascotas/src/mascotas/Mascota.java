package mascotas;

import javax.swing.JOptionPane;

/* @author VGSG */
public class Mascota {
    private static int n;
    private int id;
    private String nombre;
    private String clase;
    private String raza;
    private int edad;
    
    void Llenar(){
        n++;
        id=n;
        nombre = JOptionPane.showInputDialog("Ingresa el nombre de tu mascota");
        try{
            clase = JOptionPane.showInputDialog("Ingresa su especie");
            raza = JOptionPane.showInputDialog("Ingresa su raza");
            edad = Integer.parseInt(JOptionPane.showInputDialog("Ingresa su edad"));
            
            JOptionPane.showMessageDialog(null, "Datos registrados correctamente");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error en la obtencion de datos");
        }
    }

    String Imprimir(){
        String salida = "Mascota\nNombre: "+nombre+"\nEspecie: "+clase+"\nRaza: "+raza+"\nEdad: "+edad+" años";
        return salida;
    }
    
    public int getN() {
        return n;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
}
