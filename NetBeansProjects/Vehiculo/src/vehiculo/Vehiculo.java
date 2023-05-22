package vehiculo;

import javax.swing.JOptionPane;

/* @author VGSG */
public class Vehiculo {
    private String marca,modelo,color;
    private int anio,version;
    
    void Crear(){
        marca = JOptionPane.showInputDialog("Ingresa la marca  del vehiculo");
        modelo = JOptionPane.showInputDialog("Ingresa el modelo  del vehiculo");
        color = JOptionPane.showInputDialog("Ingresa el color del vehiculo");
        anio = Verify("Ingresa el año del vehiculo");
        version = Verify("Ingresa la version del vehiculo");
    }
    
    void Mostrar(){
        String salida = "Datos del vehiculo\nMarca: "+marca+"\nModelo: "+modelo+"\nColor: "+color+"\nAño: "+anio+"\nVersion: "+version;
        JOptionPane.showMessageDialog(null, salida);
        
    }
    
    private int Verify(String cadena){
        int ret=0;
        boolean ban= true;
        do{
            try{
                ret = Integer.parseInt(JOptionPane.showInputDialog(cadena));
                ban = false;
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Caracter unvalido, reitenta");
            }
        }while(ban);
        return ret;
    }
    
}
