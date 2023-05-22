package cuentabancaria;

import java.util.Scanner;

/* @author VGSG */

public class Cuenta {
    private String nombres,apellidos;
    private int nCuenta,tipo;
    private double saldo;
    private boolean status;

    public Cuenta(String nombres, String apellidos, int tipo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipo = tipo;
        saldo = 0;
        status = false;
        nCuenta = (int)Math.floor(Math.random()*(100-0));
    }
    
    public void SetEstado(boolean status){
        this.status = status;
    }
    
    public boolean GetEstado(){
        return status;
    }
    
    public String GetNombreC(){
        return nombres+" "+apellidos;
    }
    
    public boolean Activar(double monto){
         if(Deposito(monto)){
             status = true;
             return true;
         }else{
             status = false;
             return false;
         }
    }

    public boolean Deposito(double monto) {        
        if(monto>0){
            saldo+=monto;
            return true;
        }else{
            return false;
        }
    }
    
    public boolean Retiro(double Monto){
        if(Monto<=saldo){
            saldo-=Monto;
            if(saldo==0){
                SetEstado(false);
            }
            return true;
        }else{
            System.out.println("No puedes retirar mas del monto disponible en tu cuenta, reintenta con una cantidad menor");
            return false;
        }
    }
    
    public void MostrarCuenta(){
        String tipoCuenta = "",txt = "",estado = "";
        if(tipo==1){
            tipoCuenta = "Cuenta de ahorros";
        }else{
            tipoCuenta = "Cuenta corriente";
        }
        
        if(GetEstado()){
            estado = "Activa";
        }else{
            estado = "Inactiva";
        }
        
        txt = " ------------------ Datos de la cuenta -----------------\nNumero de cuenta: "+nCuenta+"\nNombre Registrado: "+nombres+" "+apellidos+"\nTipo de cuenta: "+tipoCuenta
                +"\nSaldo actual: $ "+saldo+" MXN\nEstatus de cuenta: "+estado+"\n--------------------------------------------------------";
        System.out.println(txt);
    }
    
    public int getNoCuenta(){
        return nCuenta;
    }
    
    public double GetSaldo(){
        return saldo;
    }
    
    public boolean CompararSaldo(Cuenta cuentaCompa){
        if(cuentaCompa.GetSaldo()>=GetSaldo()){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean Transferir(Cuenta cuentaDest,double monto){
        if(Retiro(monto)){
            cuentaDest.Deposito(monto);
            return true;
        }else{
            return false;
        }
    }
}
