package seveneleven;

import javax.swing.JOptionPane;

/* @author VGSG */

public class Random {
    int n1,n2,suma,sumaAnt;
    double saldo,bet;
    boolean ban = true,exi=true,rep = true;
    String nombre,salida;

    void Init() {
        nombre = JOptionPane.showInputDialog("Ingresa tu nombre jugador");
        saldo = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el saldo inicial de "+nombre));
        
        String text = "Las reglas son las siguientes:\nSe Juega con 2 dados\n"
                + "°Si en la primera tirada la suma de los dados es 7 u 11, Ganas el juego\n"
                + "°Si en la primera tirada la suma de los dados es 2, 3 o 12, Pierdes el juego\n"
                + "°Si en la primera tirada la suma de los dados es diferente a los puntos anteriores, se vuelven a tirar los dados\n"
                + "°Gana si la suma de los dados es la misma de la primer tirada\n"
                + "°Pierde si la suma de los dados es 7 u 11\n"
                + "°Si no es ninguno de los casos anteriores, sigue tirando, hasta que gane o pierda\n";
        
        JOptionPane.showMessageDialog(null, text ,"Reglas",JOptionPane.INFORMATION_MESSAGE);
        
    }
    
    int Generate(){
        
         do{
             
             if(saldo<=0){
                 ban = false;
                 continue;
             }
             
             n1 = (int)Math.floor(Math.random()*(6)+1);
             n2 = (int)Math.floor(Math.random()*(6)+1);
             
             if(rep){
                int opc=0;
                do{
                    try{
                        String aux = "Menu\n1.- Apostar\n2.- Aumentar saldo\n3.- Salir";
                        opc = Integer.parseInt(JOptionPane.showInputDialog(null, aux));
                        switch(opc){
                            case 1: bet = Double.parseDouble(JOptionPane.showInputDialog("Ingresa tu apuesta "+nombre+"\nSaldo actual: "+saldo));
                                    if(!compruebaApuesta()){
                                        JOptionPane.showMessageDialog(null,"Tu apuesta no puede ser mayor a tu saldo actual, haz una apuesta mas baja");
                                        opc = 4;
                                    }
                                    break;
                            case 2: boolean ban2 = false;
                                    do{
                                        try{
                                            saldo += Double.parseDouble(JOptionPane.showInputDialog("Saldo actual: "+saldo+"\nIngresa el saldo a aumentar "));
                                            JOptionPane.showMessageDialog(null,"Saldo nuevo: "+saldo);
                                            break;
                                        }catch(Exception e){
                                            JOptionPane.showMessageDialog(null,"Ingresa un monto numerico");
                                            ban2 = true;
                                        }break;
                                    }while(ban2);break;
                            case 3: ban=false;break;
                        }
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Caracteres de textos no validos, reintente");
                    }
                }while(opc!=1 && opc!=3);
                if(!ban){
                    continue;
                }
                suma = n1+n2;
                salida = "Jugador: "+nombre+"\nSaldo: $"+saldo+"   Apuesta: $"+bet+"\nDado 1:"+n1+"\nDado 2:"+n2+"\nSuma: "+suma;
             
                if(suma == 7 || suma == 11){
                    saldo += bet;
                    salida += "\n!!!Ganó¡¡¡ Felicidades\nSaldo nuevo: $"+saldo;
                    rep = true;
                    JOptionPane.showMessageDialog(null,salida);
                    continue;
                }
                if(suma == 2 || suma==3 || suma==12){
                    saldo -=bet;
                    salida += "\nPerdió, Suerte para la proxima\nSaldo nuevo: $"+saldo;
                    rep = true;
                    JOptionPane.showMessageDialog(null,salida);
                    continue;
                }
                sumaAnt = suma;
             }else{
                 suma = n1+n2;
                 salida = "Jugador: "+nombre+"\nSaldo: $"+saldo+"   Apuesta: $"+bet+"\nNumero anterior: "+sumaAnt+"\nDado 1:"+n1+"\nDado 2:"+n2+"\nSuma: "+suma;
                 if(suma == 7 || suma == 11){
                    saldo -= bet;
                    salida += "\nPerdió, Suerte para la proxima\nSaldo nuevo: $"+saldo;
                    rep = true;
                    JOptionPane.showMessageDialog(null,salida);
                    continue;
                }
                if(suma == sumaAnt){
                    saldo +=bet;
                    salida += "\n!!!Ganó¡¡¡ Felicidades\nSaldo nuevo: $"+saldo;
                    rep = true;
                    JOptionPane.showMessageDialog(null,salida);
                    continue;
                }
             }
             
             salida += "\nTire otra vez";
             rep = false;
             JOptionPane.showMessageDialog(null, salida);
             
         }while(ban);
         
         if(exi){
             JOptionPane.showMessageDialog(null,nombre+" Gracias por jugar!!\nSaldo final: "+saldo);
         }else{
             JOptionPane.showMessageDialog(null,salida);
         }
         
         return suma;
    }

    private boolean compruebaApuesta() {
        boolean ban=true;
        if(bet>saldo){
            ban = false;
        }
        return ban;
    }
    
}
