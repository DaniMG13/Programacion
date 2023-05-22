package mascotas;

import javax.swing.JOptionPane;

/* @author VGSG */
public class Persona {
    private static int n;
    private int id;
    private String nombre;
    private int edad;
    private float estatura;
    private int peso;
    Mascota mascota1;
    Mascota mascota2;
    
    
    void Llenar(){
        n++;
        id = n;
        nombre = JOptionPane.showInputDialog("Ingresa tu nombre");
        try{
            edad = Integer.parseInt(JOptionPane.showInputDialog("Ingresa tu edad"));
            estatura = Float.parseFloat(JOptionPane.showInputDialog("Ingresa tu estatura"));
            peso = Integer.parseInt(JOptionPane.showInputDialog("Ingresa tu peso"));
            int respuesta = Integer.parseInt(JOptionPane.showInputDialog("¿Tienes mascotas?\n1.- Si\n2.-No"));
            if(respuesta==1){
                mascota1 = new Mascota();
                mascota1.Llenar();
                
                respuesta = Integer.parseInt(JOptionPane.showInputDialog("¿Tienes otra mascota?\n1.- Si\n2.-No"));
                if(respuesta==1){
                    mascota2 = new Mascota();
                    mascota2.Llenar();
                }
            }
            JOptionPane.showMessageDialog(null, "Datos registrados correctamente");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error en la obtencion de datos");
        }
        
    }
    
    void Mostrar(){
        String aux = "Persona\nID: "+id+"\nNombre: "+nombre+"\nEdad: "+edad+"\nEstatura: "+estatura+" m\nPeso: "+peso+" kg";
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getEstatura() {
        return estatura;
    }

    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Mascota getMascota1() {
        return mascota1;
    }

    public void setMascota1(Mascota mascota1) {
        this.mascota1 = mascota1;
    }

    public Mascota getMascota2() {
        return mascota2;
    }

    public void setMascota2(Mascota mascota2) {
        this.mascota2 = mascota2;
    }
}
