package com.mycompany.lab02;

/* @author VGSG */
public class Lab02 {

    public static void main(String[] args) {
       String uni = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15";
       String a = "2,4,6,8,10,12,14";
       String b = "1,2,3,5,8,13";
       String c = "1,2,4,6,7,10,11,13";
       
       
        String [] cu = uni.split("\\,");
        String [] ca = a.split("\\,");
        String [] cu2 = uni.split("\\,");
        String [] cb = b.split("\\,");
        String [] cc = c.split("\\,");
        
        String [] cu1 = new String [cu.length];
       // String [] conjunto_ej1 = new String [conjunto_u.length];
        
        
        System.out.println("U = {"+uni+"}");
        System.out.println("A = {"+a+"}");
        System.out.println("B = {"+b+"}");
        System.out.println("C = {"+c+"}");
        
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
        salida+="}";
        System.out.println(salida+"\n");

         System.out.println( "A U B");
         int auxI=0;
         for(int i=0;i<ca.length;i++)
        {
            cu1[i]=ca[i];
            auxI=i;
        }
           
         auxI++;
         for(int k=0; k<cb.length;k++)
            {
                if(ca[k]!=cb[k])
                {
                     cu1[auxI]=cb[k];
                    
                }
                if(ca[k]==cb[k])
                {
                    cu1[auxI]=null;
                }
                auxI++;
            }
        
         for(String v:cu1)
        {
            if(v!=null)
            {
                System.out.println(v);
            }
            
        }
        System.out.println("\n");
        
        System.out.println("B ^ C");
        
        for (int i=0;i<cb.length;i++)
        {
            for (int k=0;k<cc.length;k++)
            {
                //if
            }
        }
    }
}
