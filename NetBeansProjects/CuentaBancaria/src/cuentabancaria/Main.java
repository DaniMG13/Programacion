package cuentabancaria;

/* @author VGSG  */

public class Main {

    static String n,a;
    static int t;
    public static void main(String[] args) {
        n = "Sergio Guadalupe";
        a = "Vazquez Guzman";
        t = 1;
        Cuenta c1 = new Cuenta(n, a, t);
        ReciboActivar(c1,2000);
        c1.MostrarCuenta();
        ReciboRetirar(c1,100);
        c1.MostrarCuenta();
        ReciboDepositar(c1,2000);
        c1.MostrarCuenta();
        ReciboRetirar(c1,3900);
        c1.MostrarCuenta();
        ReciboRetirar(c1,100);
        ReciboActivar(c1,2000);
        c1.MostrarCuenta();
        ReciboActivar(c1, 2000);
        
        n = "Juan Manuel";
        a = "Ramirez Mata";
        t = 2;
        Cuenta c2 = new Cuenta(n, a, t);
        ReciboActivar(c2,500);
        c2.MostrarCuenta();
        ReciboRetirar(c2,100);
        c2.MostrarCuenta();
        ReciboDepositar(c2,1000);
        c2.MostrarCuenta();
        
        ReciboConsul(c1);
        ReciboConsul(c2);
        
        ReciboTransfer(c1, c2, 100);
        
        ReciboConsul(c1);
        ReciboConsul(c2);
        
    }

    public static void ReciboRetirar(Cuenta cuentaH,double monto){
        if(cuentaH.GetEstado()){
            String estatus = "";
            if(cuentaH.Retiro(monto)){
                estatus = "Retiro autorizado";
            }else{
                estatus = "Retiro no autorizado";
            }
            System.out.println("------------------- Retiro de Efectivo -----------------");
            System.out.println(" Numero de cuenta: "+cuentaH.getNoCuenta());
            System.out.println(" Monto a retirar: $ "+monto+" MXN");
            System.out.println(" Estatus del retiro: "+estatus);
            System.out.println(" Nuevo saldo despues del retiro: $ "+cuentaH.GetSaldo()+" MXN");
            System.out.println("--------------------------------------------------------");
        }else{
            System.out.println("----------------- Retiro de Efectivo -------------------");
            System.out.println("Cuenta Inactiva, activala con un deposito, por favor");
            System.out.println("--------------------------------------------------------");
        }
        
    }
    
    public static void ReciboDepositar(Cuenta cuentaH,double monto){
        String estatus = "";
        if(cuentaH.Deposito(monto)){
            estatus = "Deposito autorizado";
        }else{
            estatus = "Deposito no autorizado";
        }
        System.out.println("----------------- Deposito de Efectivo -----------------");
        System.out.println(" Numero de cuenta: "+cuentaH.getNoCuenta());
        System.out.println(" Monto a depositar: $ "+monto+" MXN");
        System.out.println(" Estatus del deposito: "+estatus);
        System.out.println(" Nuevo saldo despues del deposito: $ "+cuentaH.GetSaldo()+" MXN");
        System.out.println("--------------------------------------------------------");
    }

    public static void ReciboActivar(Cuenta cuentaH, double monto) {
        if(!cuentaH.GetEstado()){
            String estatus = "";
            if(cuentaH.Activar(monto)){
                estatus = "Activa";
            }else{
                estatus = "Inactiva";
            }
            System.out.println("----------------- Activacion de Cuenta -----------------");
            System.out.println(" Numero de cuenta: "+cuentaH.getNoCuenta());
            System.out.println(" Nombre registrado: "+cuentaH.GetNombreC());
            System.out.println(" Monto abonado para activar: $ "+monto+" MXN");
            System.out.println(" Estatus de cuenta: "+estatus);
            System.out.println("--------------------------------------------------------");
        }else{
            System.out.println("---------------- Activacion de Cuenta ------------------");
            System.out.println("La cuenta esta activa, no necesita activarse");
            System.out.println("--------------------------------------------------------");
        }
    }
    
    public static void ReciboTransfer(Cuenta cuentaHO,Cuenta cuentaHD,double monto){
        String estatus = "";
        if(cuentaHO.Transferir(cuentaHD, monto)){
            estatus = "Trasferencia exitosa";
        }else{
            estatus = "Trasferencia rechazada";
        }
        System.out.println("------------- Trasnferencia entre cuentas --------------");
        System.out.println(" Numero de cuenta emisora: "+cuentaHO.getNoCuenta());
        System.out.println(" Nombre registrado: "+cuentaHO.GetNombreC());
        System.out.println(" Numero de cuenta receptora: "+cuentaHD.getNoCuenta());
        System.out.println(" Nombre registrado: "+cuentaHD.GetNombreC());
        System.out.println(" Monto a transferir: $ "+monto+" MXN");
        System.out.println(" Estatus de transferencia: "+estatus);
        System.out.println("--------------------------------------------------------");
    }

    public static void ReciboConsul(Cuenta cuentaH) {
        System.out.println("------------------ Consulta de saldo -------------------");
        System.out.println(" Numero de cuenta : "+cuentaH.getNoCuenta());
        System.out.println(" Nombre registrado: "+cuentaH.GetNombreC());
        System.out.println(" Saldo disponible: $ "+cuentaH.GetSaldo()+" MXN");
        System.out.println("--------------------------------------------------------");
    }
    
}
