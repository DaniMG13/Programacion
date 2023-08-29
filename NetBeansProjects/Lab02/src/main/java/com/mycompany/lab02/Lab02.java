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
        
        /* Complemento de Conjunto A */
        
        System.out.println("\nComplemento de A");
        
        for(int i=0;i<ca.length;i++)
        {
            for(int k=0; k<cu.length;k++)
            {
                if(ca[i].equals(cu[k]))
                {
                    cu2[k]=null;
                }
            }
        }
        String salida = "{";
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
        
        /* Conjunto A Interseccion Conjunto C */
         
        String[] ca1 = new String[cu.length];
        int aux = 0;
        System.out.println( "A ^ C");
        for(int i=0;i<ca.length;i++){
            for(int j=0;j<cc.length;j++){
                if(cc[j].equals(ca[i])){
                    ca1[aux]=cc[j];
                    aux++;
                }
            }
        }
        salida="{";
        for(String v:ca1)
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
        for(String v:ca1)
        {
            if(v!=null)
            {
                salida=salida+v+",";
            }
            
        }
        salida=salida.substring(0,salida.length()-1);
        salida+="}";
        System.out.println(salida+"\n");
        
        /* Complemento de Conjunto C */
        
        System.out.println("\nComplemento de C");
        cu2 = cu;
        for(int i=0;i<cc.length;i++)
        {
            for(int k=0; k<cu.length;k++)
            {
                if(cc[i].equals(cu[k]))
                {
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
        
        /* Conjunto B diferencia Conjunto A */ 
        
        
        
    }
}
