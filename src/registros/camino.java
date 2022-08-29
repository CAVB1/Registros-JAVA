
package registros;

import java.util.*;
import java.io.*;
import javax.swing.JFileChooser;
public class camino {
     Scanner teclado=new Scanner(System.in);
    int op=0;
    File archivo=new File("alumnos.txt");    
    BufferedReader read=null;
    FileReader si=null;
 
    
    public void menu(){
        creararchivo();
        do{
            System.out.println("1. Alta del alumno");
            System.out.println("2. Buscar alumno");
            System.out.println("3. Consultar promedio");
            System.out.println("4. Salir");
            op=teclado.nextInt();
            switch(op){
                case 1:
                    alta();
                    menu();
                    break;
                case 2:
                    buscar();
                    menu();
                    break;
                case 3:
                    promedio();
                    menu();
                    break;
             
                case 4:
                    System.out.println("Bye");
                    
                    
                    break;
                
            }
        }while(op!=4);
    }

    public void creararchivo() {
        if(archivo.exists()!=true){
         
        }else{
              try{
                archivo.createNewFile();
            }catch(IOException e){
                System.out.println(e);
            }
             
        }
    }

    public void alta() {
        
        System.out.println("Escriba los datos correspondientes del alumno");
        
        
        try{
            FileWriter escribir=new FileWriter(archivo,true);
            PrintWriter linea=new PrintWriter(escribir);
           
            System.out.println("Matricula: ");
            linea.println(teclado.next());
            
            System.out.println("Nombre: ");
            linea.println(teclado.next());
            
            System.out.println("Direccion: ");
            linea.println(teclado.next());
            
            System.out.println("Telefono: ");
            linea.println(teclado.next());
            
            System.out.println("Grupo: ");
            linea.println(teclado.next());
            
            System.out.println("Materia: ");
            linea.println(teclado.next());
            
            System.out.println("Calificacion del primer parcial: ");            
            linea.println(teclado.next());
            
            System.out.println("Calificacion del segundo parcial: ");
            linea.println(teclado.next());
            
            System.out.println("Calificacion del tercer parcial: ");            
            linea.println(teclado.next());
            
            
            linea.close();
            escribir.close();
        }catch(IOException ex){
            System.out.println(ex);
        }
    }

  

    private void buscar() {
        Scanner entrada=null;
        String linea;
        boolean bandera=false;
        String linea1;
        
        System.out.println("Matricula");
        String matricula=teclado.next();
        
        try{
            si=new FileReader(archivo);
            read=new BufferedReader(si);
            entrada=new Scanner(archivo);
            
            while(entrada.hasNext()&&bandera!=true){
                linea=entrada.nextLine();
                if(linea.contains(matricula)){
                    System.out.println();
                    
                    System.out.print("Matricula: ");
                    System.out.println(linea);
                    linea=entrada.nextLine();
                    System.out.print("Nombre: ");
                    System.out.println(linea);
                    linea=entrada.nextLine();
                    System.out.print("Direccion: ");
                    System.out.println(linea);
                    linea=entrada.nextLine();
                    System.out.print("Telefono: ");
                    System.out.println(linea);
                    linea=entrada.nextLine();
                    System.out.print("Grupo ");
                    System.out.println(linea);
                    linea=entrada.nextLine();
                    System.out.print("Materia: ");
                    System.out.println(linea);
                    linea=entrada.nextLine();
                    System.out.print("Calificacion del primer parcial: ");
                    System.out.println(linea);
                    linea=entrada.nextLine();
                    System.out.print("Calificacion del segundo parcial: ");
                    System.out.println(linea);
                    linea=entrada.nextLine();
                    System.out.print("Calificacion del tercer parcial: ");
                    System.out.println(linea);
                     System.out.println();
                   
                   bandera=true;
                                       
                }
                
            }
            if(!bandera){
                System.out.println(matricula+" no se encuentra registrado");
            }
            
        }catch (FileNotFoundException e){
            System.out.println(e.toString());
        }catch(NullPointerException e){
            System.out.println(e.toString()+"No se ha seleccionado ningun archivo");
        }catch(Exception e){
            System.out.println(e.toString());
        } finally{
            if(entrada!=null){
                entrada.close();
            }
        
        }
        
        
     

    }
    
    
    public void promedio(){
        Scanner entrada=null;
        String linea;        
        boolean bandera=false;
        double nota0,nota1,nota2, promedio;
               
        System.out.println("Matricula");
        String matricula=teclado.next();
        
        try{
            si=new FileReader(archivo);
            read=new BufferedReader(si);
            entrada=new Scanner(archivo);
            
            while(entrada.hasNext()&&bandera!=true){
                linea=entrada.nextLine();
                if(linea.contains(matricula)){
                    System.out.println();
                    
                    
                    
                    linea=entrada.nextLine();                  
                    linea=entrada.nextLine();                    
                    linea=entrada.nextLine();                    
                    linea=entrada.nextLine();
                    linea=entrada.nextLine();
                    linea=entrada.nextLine();
                    nota0=Double.parseDouble(linea);
                    linea=entrada.nextLine();
                    nota1=Double.parseDouble(linea);
                    linea=entrada.nextLine();
                    nota2=Double.parseDouble(linea);
                    promedio=(nota0+nota1+nota2)/3;
                    
                    System.out.println("Promedio final: "+promedio);
                    
                   
                   bandera=true;
                                       
                }
                
            }
            if(!bandera){
                System.out.println(matricula+" no se encuentra registrado");
            }
            
        }catch (FileNotFoundException e){
            System.out.println(e.toString());
        }catch(NullPointerException e){
            System.out.println(e.toString()+"No se ha seleccionado ningun archivo");
        }catch(Exception e){
            System.out.println(e.toString());
        } finally{
            if(entrada!=null){
                entrada.close();
            }
        
        }
    }
    

    
    
    
}
