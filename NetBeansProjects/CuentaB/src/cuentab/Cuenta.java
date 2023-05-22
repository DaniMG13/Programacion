package cuentab;

import javax.swing.JOptionPane;


/* @author VGSG */
public class Cuenta {
     private String nombres,apellidos,tipo;
     private int cuenta;
     private static int nC;
     private static int genCuenta;
     private double saldo;
     private boolean status;
     private boolean activando;
     private static Cuenta[] cuentas;

    Cuenta(String nombres, String apellidos, String tipo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipo = tipo;
        genCuenta = (int) (Math.floor(Math.random()*(100-0+1))+0);
        this.cuenta = genCuenta;
        saldo = 0;
        status = false;
        Anadir();
    }
    
    private void Cuenta(){
        
    }
    
    public void Imprimir() {
        String s = "Datos de la cuenta\n"+"Nombre: "+nombres+" "+apellidos+"\nNumero de cuenta: "+cuenta+
                "\nTipo de cuenta: "+tipo+"\n"+"Saldo: $"+saldo+" MXN";
        
        JOptionPane.showMessageDialog(null, s);
    }
    
    public double ConsultaSaldo(){
        return saldo;
    }
    
    public void Activar(){
        activando=true;
        Deposito();
    }
    
    public boolean Deposito(){
        boolean ban = true;
        do{
            try{
                double m = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el monto a depositar"));
                if(m>0){
                    if(activando){
                        status=true;
                    }
                    if(status){
                        saldo += m;
                    }else{
                        JOptionPane.showMessageDialog(null, "Activa tu cuenta primero");
                    }
                    ban=false;
                }else{
                    JOptionPane.showMessageDialog(null, "No puedes hacer un deposito negativo");
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Ingresa una cantidad valida");
            }
        }while(ban);
        return !ban;
    }
    
    public boolean Retiro(){
         boolean ban = true;
        do{
            try{
                double m = Double.parseDouble(JOptionPane.showInputDialog("Monto disponible: $: "+saldo+"MXN\nIngresa el monto a retirar"));
                if(m<saldo){
                    saldo -= m;
                    if(saldo==0){
                        status=false;
                    }
                    ban=false;
                }else{
                    JOptionPane.showMessageDialog(null, "No puedes hacer un retiro de mas de lo disponible en tu cuenta");
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Ingresa una cantidad valida");
            }
        }while(ban);
        return !ban;
    }
    
    public boolean CompararSaldos(Cuenta cuentaComp){
        if(cuentaComp.ConsultaSaldo()>=saldo){
            return true;
        }else{
            return false;
        }
    }
    
    public void Transferir(int c, double m){
        if(Retiro()){
            for(int i = 0; i<nC; i++){
                if(cuentas[i].cuenta == c){
                    cuentas[i].saldo += m;
                    JOptionPane.showMessageDialog(null, "Transferencia Exitosa\nCuenta de origen: "+cuenta+"\nMonto: $"+m+" MXN\nCuenta destino: "+cuentas[i].cuenta);
                }
            }
        }
    }
    
    private void Anadir() {
        if(nC==0){
            nC++;
            System.out.println(nC);
            cuentas = new Cuenta[nC];
            for(int i=0;i<nC;i++){
                cuentas[i] = new Cuenta();
                cuentas[i].nombres=nombres;
                cuentas[i].apellidos=apellidos;
                cuentas[i].cuenta=cuenta;
                cuentas[i].tipo=tipo;
                cuentas[i].saldo=saldo;
                cuentas[i].status=status;
            }
        }else{
            nC++;
            int aux = nC-1;
            System.out.println(nC+"-"+aux);
            Cuenta[] cAux = new Cuenta[aux];
            for(int i=0;i<aux;i++){
                cAux[i]=cuentas[i];
            }
            cuentas = new Cuenta[nC];
            for(int i=0;i<nC;i++){
                System.out.println("Tamanio cuentas: "+cuentas.length+"\nTamanio cAux: "+cAux.length);
                
                if(i>=aux-1){
                    cuentas[i] = new Cuenta();
                    cuentas[i].nombres=nombres;
                    cuentas[i].apellidos=apellidos;
                    cuentas[i].cuenta=cuenta;
                    cuentas[i].tipo=tipo;
                    cuentas[i].saldo=saldo;
                    cuentas[i].status=status;
                }else{
                    cuentas[i] = cAux[i];
                }
            }
        }
    }
    
    
}
