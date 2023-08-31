package com.mycompany.lab02;

/* @author VGSG */
public class Lab02 {

    public static void main(String[] args) {
        String uni = "1,2,3,4,5,6,7,8,9,10,11,12,13,14";
        String a = "2,4,6,8,10,12,14";
        String b = "1,2,3,5,8,13";
        String c = "1,2,4,6,7,10,11,13";
       
        String [] cu = uni.split("\\,");
        String [] ca = a.split("\\,");
        String [] cu2 = uni.split("\\,");
        String [] cb = b.split("\\,");
        String [] cc = c.split("\\,");
        
        System.out.println("U = {"+uni+"}");
        System.out.println("A = {"+a+"}");
        System.out.println("B = {"+b+"}");
        System.out.println("C = {"+c+"}");
        
        String[] ca1 = new String[cu.length];
        String salida = "{";
        int aux = 0;
        
        /* Conjunto A union Conjunto B */
        
        System.out.println("\nA U B");
        
        for (int i=0;i<ca.length;i++){
            ca1[i]=ca[i];
            aux=i;
        }
        aux++;
        for(int k=0;k<cb.length;k++){
            ca1[aux]=cb[k];
            aux++;
        }
        aux=ca.length;
        for(int i=0;i<ca.length;i++){
            for(int j=0;j<cb.length;j++){
                if(ca1[i].equals(ca1[aux+j])){
                    ca1[aux+j]=null;
                }
            }
        }
        salida = "{";
        for(String v:ca1){
            if(v!=null){
                salida+=v+",";
            }
        }
        salida=salida.substring(0,salida.length()-1);
        salida+="}";
        System.out.println(salida+"\n");
        
        /* Complemento de Conjunto C */
        
        System.out.println("C'");
        cu2 = cu;
        for(int i=0;i<cc.length;i++){
            for(int k=0; k<cu.length;k++){
                if(cc[i].equals(cu[k])){
                    cu2[k]=null;
                }
            }
        }
        salida = "{";
        for(String v:cu2)
        {
            if(v!=null)
            {
                salida=salida+v+",";
            }
            
        }
        salida=salida.substring(0,salida.length()-1);
        salida+="}";
        System.out.println(salida+"\n"); 
        
        /* Conjunto B Interseccion Conjunto C */
        aux=0;
        ca1 = new String[cu.length];
        System.out.println( "B ^ C");
        for(int i=0;i<cb.length;i++){
            for(int j=0;j<cc.length;j++){
                if(cc[j].equals(cb[i])){
                    ca1[aux]=cc[j];
                    aux++;
                }
            }
        }
        salida="{";
        for(String v:ca1){
            if(v!=null){
                salida=salida+v+",";
            }
            
        }
        salida=salida.substring(0,salida.length()-1);
        salida+="}";
        System.out.println(salida+"\n");
        
        
        /* Conjunto B Interseccion Conjunto C */
        
        System.out.println("B U C");
        salida="{";
        salida+="}";
        System.out.println(salida+"\n");
        
        /* Conjunto A Interseccion Conjunto C */
        cu = uni.split("\\,");
        String[] ca_2 = new String[cu.length];
        aux = 0;
        System.out.println( "A ^ C");
        for(int i=0;i<ca.length;i++){
            for(int j=0;j<cc.length;j++){
                if(ca[i].equals(cc[j])){
                    ca_2[aux]=ca[i];
                    aux++;
                }
            }
        }
        salida="{";
        for(String v:ca_2){
            if(v!=null){
                salida=salida+v+",";
            }
            
        }
        salida=salida.substring(0,salida.length()-1);
        salida+="}";
        System.out.println(salida+"\n");
        
        /* Complemento de Conjunto A */
        
        System.out.println("A'");
        salida = "{";
        cu2 = cu;
        for(int i=0;i<ca.length;i++){
            for(int k=0; k<cu.length;k++){
                if(ca[i].equals(cu[k])){
                    cu2[k]=null;
                }
            }
        }
        
        for(String v:cu2){
            if(v!=null){
                salida=salida+v+",";
            }
            
        }
        salida=salida.substring(0,salida.length()-1);
        salida+="}";
        System.out.println(salida+"\n");
        
        /* Conjunto B diferencia Conjunto A */ 
        
        System.out.println("B - A");
        
        ca1 = cb;
        for(int i=0;i<cb.length;i++){
            for(int j=0;j<ca.length;j++){
                if(ca[j].equals(cb[i])){
                    ca1[i]=null;
                }
            }
        }
        salida="{";
        for(String v:ca1){
            if(v!=null){
                salida=salida+v+",";
            }
            
        }
        salida=salida.substring(0,salida.length()-1);
        salida+="}";
        System.out.println(salida+"\n");
        
        /* Conjunto C diferencia Conjunto B Complemento */

       //COMPLEMENTO DE B 
        System.out.println("C - B'");
        
        cb = b.split("\\,");
        cu = uni.split("\\,");
        String[] ccb = cu;
        for(int i=0;i<cb.length;i++){
            for(int k=0; k<cu.length;k++){
                if(cb[i].equals(cu[k])){
                    ccb[k]=null;
                }
            }
        }
        
        //DIFERENCIA
        
        cc = c.split("\\,");
        String[] cc2 = cc;
        for(int i=0;i<ccb.length;i++){
            for(int j=0;j<cc.length;j++){
                if(ccb[i]!=null){
                    if(ccb[i].equals(cc[j])){
                    cc2[j]=null;
                }
                }
            }
        }
        
        salida = "{";
        for(String v:cc2)
        {
            if(v!=null)
            {
                salida=salida+v+",";
            }
            
        }
        salida=salida.substring(0,salida.length()-1);
        salida+="}";
        System.out.println(salida+"\n");
        
        
    } 
}
