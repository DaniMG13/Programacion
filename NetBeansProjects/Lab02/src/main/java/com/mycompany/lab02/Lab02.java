package com.mycompany.lab02;

/* @author VGSG */
public class Lab02 {

    public static void main(String[] args) {
        String var_u = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,a,b,x";
       
       String var_a = "2,4,6,8,10,12,14";
       String var_b = "1,2,3,5,8,13";
       String var_c = "1,2,4,6,7,10,11,13";
       
       
        String [] conjunto_u = var_u.split("\\,");
        String [] conjunto_a = var_a.split("\\,");
        String [] conjunto_ej6 = var_u.split("\\,");
        String [] conjunto_b = var_b.split("\\,");
        String [] conjunto_c = var_c.split("\\,");
        
        String [] conjunto_ej1 = new String [conjunto_u.length];
       // String [] conjunto_ej1 = new String [conjunto_u.length];
        
        System.out.println("conjunto u");
        for(String v:conjunto_u)
        {
            System.out.println(v);
        }
        System.out.println("conjunto a");
        for(String v:conjunto_a)
        {
            System.out.println(v);
        }
        System.out.println("             -------------");
       
        
        
        System.out.println("complemento del conjunto a considerando el universo (ejercicio 6)");
        
        for(int i=0;i<conjunto_a.length;i++)
        {
            for(int k=0; k<conjunto_u.length;k++)
            {
                if(conjunto_a[i].equals(conjunto_u[k]))
                {
                     
                    conjunto_ej6[k]=null;
                }
            }
        }
        for(String v:conjunto_ej6)
        {
            if(v!=null)
            {
                System.out.println(v);
            }
            
        }
         System.out.println("       -----------");
         
         
         
         System.out.println( "a union con b (ejercicio 1)");
         int auxI=0;
         for(int i=0;i<conjunto_a.length;i++)
        {
            conjunto_ej1[i]=conjunto_a[i];
            auxI=i;
        }
           
         auxI++;
         for(int k=0; k<conjunto_b.length;k++)
            {
                if(conjunto_a[k]!=conjunto_b[k])
                {
                     conjunto_ej1[auxI]=conjunto_b[k];
                    
                }
                if(conjunto_a[k]==conjunto_b[k])
                {
                    conjunto_ej1[auxI]=null;
                }
                auxI++;
            }
        
         for(String v:conjunto_ej1)
        {
            if(v!=null)
            {
                System.out.println(v);
            }
            
        }
        System.out.println("      -------------");
        
        
        
        System.out.println("b interseccion con c (ejercicio 2)");
        
        for (int i=0;i<conjunto_b.length;i++)
        {
            for (int k=0;k<conjunto_c.length;k++)
            {
                //if
            }
        }
    }
}
