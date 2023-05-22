/* @author sergi */
import java.util.Scanner;

public class Main{
static Scanner tecla;
      public static void main(String args[]){
          tecla = new Scanner(System.in);
              int opc;
              
              do{
                 opc = Menu();  
                 switch(opc){
                     case 1:LibroTexto();break;
                     case 2:LibroUni();break;
                     case 3:Novela();break;
                }
              }while(opc!=0);
              System.out.println("------------------------- Adios -------------------------");
      }
      
      private static int Menu(){
          int opc = 0;
          boolean ban=true;
          do{
             System.out.println("---------------------- Bienvenido -----------------------");
             System.out.println("| 1 .- Nuevo Libro de Texto                             |");
             System.out.println("| 2 .- Nuevo Libro la Universidad Nacional de Colombia  |");
             System.out.println("| 3 .- Nueva Novela                                     |");
             System.out.println("| 0 .- Salir                                            |");
             System.out.println("---------------------------------------------------------");
             System.out.print("Ingresa tu respuesta: ");
             try{
                 opc = tecla.nextInt();
                 System.out.println("---------------------------------------------------------");
             }catch(Exception e){
                 System.out.print("Caracter invalido, reintenta\n");
             }
             if(opc <0 || opc > 3){
                 System.out.print("Opcion invalida, reintenta\n");
             }else{
                 ban = false;
             }
          }while(ban);
          return opc;
      }

    private static void LibroTexto() {
        String title,author,curse;
        float price;
        
        tecla = new Scanner(System.in);
        System.out.println("--------------------- Libro de Texto --------------------");
        System.out.print("Ingresa el titulo del libro: ");
        title = tecla.nextLine();
        
        System.out.print("Ingresa el autor del libro: ");
        author = tecla.nextLine();
        
        System.out.print("Ingresa el curso del libro: ");
        curse = tecla.nextLine();
        
        System.out.print("Ingresa el precio del libro: ");
        price = tecla.nextFloat();
        
        System.out.println("---------------------------------------------------------");
        
        LibroTexto lt = new LibroTexto(title,author,price);
        lt.setCurso(curse);
        System.out.println(lt.Imprimir());
    }

    private static void LibroUni() {
        String title,author,curse,facu;
        float price;
        
        tecla = new Scanner(System.in);
        System.out.println("------------- Libro Universidad de Colombia --------------");
        System.out.print("Ingresa el titulo del libro: ");
        title = tecla.nextLine();
        
        System.out.print("Ingresa el autor del libro: ");
        author = tecla.nextLine();
        
        System.out.print("Ingresa el curso del libro: ");
        curse = tecla.nextLine();
        
        System.out.print("Ingresa el precio del libro: ");
        price = tecla.nextFloat();
        
        System.out.print("Ingresa la facultad de creacion del libro: ");
        
        tecla = new Scanner(System.in);
        
        facu = tecla.nextLine();
        
        System.out.println("---------------------------------------------------------");
        
        LibrosTextoUniColombia lu = new LibrosTextoUniColombia(title,author,price,curse);
        lu.setFacultad(facu);
        System.out.println(lu.Imprimir());
    }

    private static void Novela() {
        String title,author,type;
        float price;
        
        tecla = new Scanner(System.in);
        System.out.println("-------------------------- Novela -----------------------");
        System.out.print("Ingresa el titulo de la novela: ");
        title = tecla.nextLine();
        
        System.out.print("Ingresa el autor de la novela: ");
        author = tecla.nextLine();
        
        System.out.print("Ingresa el tipo de novela: ");
        type = tecla.nextLine();
        
        System.out.print("Ingresa el precio del libro: ");
        price = tecla.nextFloat();
        
        System.out.println("---------------------------------------------------------");
        
        Novela lt = new Novela(title,author,price);
        lt.setTipo(type);
        System.out.println(lt.Imprimir());
    }
}

class Libro{

    private String titulo,autor;
    private float precio;

    Libro(String title, String author){
         this.autor = author;
         this.titulo = title;
    }

    public void setPrecio(float price){
        this.precio = price;
    }

    public void setTitulo(String title){
        this.titulo = title;
    }

    public void setAutor(String author){
        this.autor = author;
    }

    public float getPrecio(){
        return this.precio;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public String getAutor(){
        return this.autor;
    }

    public String Imprimir(){
        return "---------------- Datos del libro --------------\nTitulo: "+ getTitulo()+"\nAutor: "+getAutor()+"\nPrecio: "+getPrecio()+" MXN\n ------------------------------------- \n";
    }
    
}

class LibroTexto extends Libro{
    private String curso;

    LibroTexto(String title, String author, float price) {
        super(title,author);
        setPrecio(price);
    }

    public void setCurso(String curse){
        this.curso = curse;
    }

    public String getCurso(){
        return this.curso;
    }

    @Override
    public String Imprimir(){
        return "-------------------- Datos del libro -------------------- \nTitulo: "+getTitulo()+"\nAutor: "+getAutor()+"\nPrecio: "+
                getPrecio()+" MXN"+"\nCurso: "+getCurso()+"\n---------------------------------------------------------\n";

    }
}

class LibrosTextoUniColombia extends LibroTexto{
    private String facultad;

    LibrosTextoUniColombia(String title,String author,float price,String curse){
        super(title,author,price);
        setCurso(curse);
    }

    public void setFacultad(String facult){
        this.facultad = facult;
    }

    public String getFacultad(){
        return this.facultad;
    }

    @Override
    public String Imprimir(){
        return "--------------------- Datos del libro ------------------- \nTitulo: "+getTitulo()+"\nAutor: "+getAutor()+"\nPrecio: "+
                getPrecio()+" MXN"+"\nCurso: "+getCurso()+"\nFacultad: "+getFacultad()+"\n--------------------------------------------------------- \n";

    }
}

class Novela extends Libro{
    private String tipo;

    Novela(String title, String author,float price) {
        super(title,author);
        setPrecio(price);
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String type) {
        this.tipo = type;
    }

    @Override
    public String Imprimir() {
        return "-------------------- Datos de la novela -----------------\nTitulo: "+getTitulo()+"\nAutor: "+getAutor()+"\nPrecio: "+
                getPrecio()+" MXN"+"\nTipo: "+getTipo()+"\n---------------------------------------------------------\n";
    }
 
}