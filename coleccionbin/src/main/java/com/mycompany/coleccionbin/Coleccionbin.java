package com.mycompany.coleccionbin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet; 

public class Coleccionbin
{
    public static void main(String[] args)
    {
       /*System.out.println("Hola mundo");
	ArrayList<String> a = new ArrayList<>();
	a.add("Hola");
	a.add("2");
	a.add("3");
	System.out.println(a);

	ArrayList<String> b = new ArrayList<>();
	b.add("Hola");
	b.add("Cara");
	b.add("Nalga");
	System.out.println(b);

	b.addAll(a);
	//addAll solo conctena los datos no la unión de estos
	System.out.println(b);

	TreeSet<String> a = new TreeSet<>();
	TreeSet<String> b = new TreeSet<>();

	a.add("Hola");
	a.add("2");
	a.add("3");
	System.out.println(a);

	b.add("Hola");
	b.add("Cara");
	b.add("Nalga");
	b.add("10");
	System.out.println(b);
	
	a.addAll(b);
	System.out.println(a);
	//Arboles ordenados, elimina los repetidos
	
	
	HashSet<String> a = new HashSet<>();
	HashSet<String> b = new HashSet<>();

	a.add("Hola");
	a.add("2");
	a.add("3");
	System.out.println(a);

	b.add("Hola");
	b.add("Cara");
	b.add("Nalga");
	b.add("10");
	System.out.println(b);

	//Elimina los repetidos el HashSet

	//a.retainAll(b);
	//Resta los conjuntos	

	//a.containsAll(b);
	
	System.out.println(a);
	*/

        Set<Integer> u = new HashSet<Integer>();
	Set<Integer> a = new HashSet<Integer>();
	Set<Integer> b = new HashSet<Integer>();
        Set<Integer> c = new HashSet<Integer>();

        u.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14));
	a.addAll(Arrays.asList(2,4,6,8,10,12,14));
	b.addAll(Arrays.asList(1,2,3,5,8,13));
        c.addAll(Arrays.asList(1,2,4,6,7,10,11,13));

	//Implementacion de union con Set
        System.out.println("A U B");
	Set<Integer> union = new HashSet<Integer>();
	union.addAll(a);
	union.addAll(b);
	System.out.println(union);

        //Implementacion de interseccion con Set
        System.out.println("B ^ C");
	Set<Integer> interseccion = new HashSet<Integer>();
	interseccion.addAll(b);
	interseccion.retainAll(c);
	System.out.println(interseccion);
        
        //Implementacion del complemento con Set
        System.out.println("C'");
	Set<Integer> complemento = new HashSet<Integer>();
	complemento.addAll(u);
	complemento.removeAll(c);
	System.out.println(complemento);
        
        //Implementacion de union con Set
        System.out.println("B U C");
	union = new HashSet<Integer>();
	union.addAll(b);
	union.addAll(c);
	System.out.println(union);
        
        //Implementacion de interseccion con Set
        System.out.println("A ^ C");
	interseccion = new HashSet<Integer>();
	interseccion.addAll(a);
	interseccion.retainAll(c);
	System.out.println(interseccion);
        
        
        //Implementacion del complemento con Set
        System.out.println("A'");
	complemento = new HashSet<Integer>();
	complemento.addAll(u);
	complemento.removeAll(a);
	System.out.println(complemento);
	

        //Implementando la diferencia con Set
	System.out.println("B - A");
	Set<Integer> diferencia = new HashSet<Integer>();
	diferencia.addAll(b);
	diferencia.removeAll(a);
	System.out.println(diferencia);
        
        //Implementando la diferencia de complemento con Set
	System.out.println("C - B'");
        complemento = new HashSet<Integer>();
	complemento.addAll(u);
	complemento.removeAll(b);
	diferencia = new HashSet<Integer>();
	diferencia.addAll(c);
	diferencia.removeAll(complemento);
	System.out.println(diferencia);

	

	
    }
}
