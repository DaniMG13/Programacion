package mascotas;

/* @author VGSG */
public class Main {

    public static void main(String[] args) {
        Persona p1 = new Persona();
        p1.Llenar();
        p1.Mostrar();
        p1.mascota1.Imprimir();
        p1.mascota2.Imprimir();
                
        Persona per2 = new Persona();
        per2.Llenar();
        per2.Mostrar();
        per2.mascota1.Imprimir();
        per2.mascota2.Imprimir();
        
        Persona p3 = new Persona();
        p3.Llenar();
        p3.Mostrar();
        p3.mascota1.Imprimir();
        p3.mascota2.Imprimir();
        
        p1.getN();
        p1.mascota1.getN();
    }

}
