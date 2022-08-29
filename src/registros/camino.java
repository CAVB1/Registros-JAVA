
package registros;

import java.util.*;
import java.io.*;
import javax.swing.JFileChooser;
public class camino {
    String momo[][];
    Scanner tec=new Scanner(System.in);
    int opcion=0;
    File f=new File("registro.txt");
    BufferedWriter bm;
    BufferedReader br=null;
    FileReader fr=null;
    int id=1;
    
    public void eleccion(){
        crear();
        do{
            System.out.println("1. Alta del alumno");
            System.out.println("2. Buscar alumno");
            System.out.println("3. Consultar promedio");
            System.out.println("4. Salir");
            opcion=tec.nextInt();
            switch(opcion){
                case 1:
                    introduce();
                    eleccion();
                    break;
                case 2:
                    buscar();
                    eleccion();
                    break;
                case 3:
                    prome();
                    eleccion();
                    break;
             
                case 4:
                    System.out.println("Bye");
                    
                    
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo");
            }
        }while(opcion!=4);
    }

    public void crear() {
        if(f.exists()!=true){
         
        }else{
              try{
                f.createNewFile();
            }catch(IOException e){
                System.out.println(e);
            }
             
        }
    }

    public void introduce() {
        
        System.out.println("Introduce los datos del alumno");
        double p1,p2,p3, promedio;
        
        try{
            FileWriter escribir=new FileWriter(f,true);
            PrintWriter linea=new PrintWriter(escribir);
            linea.println(String.valueOf(id));
            System.out.println("Matrícula: ");
            linea.println(tec.next());
            System.out.println("Nombre: ");
            linea.println(tec.next());
            System.out.println("Dirección: ");
            linea.println(tec.next());
            System.out.println("Teléfono: ");
            linea.println(tec.next());
            System.out.println("Grupo: ");
            linea.println(tec.next());
            System.out.println("Materia: ");
            linea.println(tec.next());
            System.out.println("Calificación primer parcial: ");
            p1=tec.nextDouble();
            linea.println(String.valueOf(p1));
            System.out.println("Calificación segundo parcial: ");
            p2=tec.nextDouble();
            linea.println(String.valueOf(p2));
            System.out.println("Calificación tercer parcial: ");
            p3=tec.nextDouble();
            linea.println(String.valueOf(p3));
            promedio=(p1+p2+p3)/3;
            linea.println(String.valueOf(promedio));
            
            linea.close();
            escribir.close();
        }catch(IOException ex){
            System.out.println(ex);
        }
    }

    public void ver() {
       try{           
            fr=new FileReader(f);
            br=new BufferedReader(fr);
            
            String linea;
            while((linea=br.readLine())!=null){
                System.out.println(linea);
            }
       }catch(Exception e){
           e.printStackTrace();
       }finally{
           try{
               if(null!=fr){
                   fr.close();
               }
           }catch(Exception e2){
               e2.printStackTrace();
           }
           
       
       }
    }

    private void buscar() {
        Scanner entrada=null;
        String linea;
        int nodelinea=1;
        boolean contiene=false;
        int cont=1;
        String linea1;
        
        System.out.println("Escribe la matrícula del alumno: ");
        String texto=tec.next();
        
        try{
            fr=new FileReader(f);
            br=new BufferedReader(fr);
            entrada=new Scanner(f);
            
            while(entrada.hasNext()&&contiene!=true){
                linea=entrada.nextLine();
                if(linea.contains(texto)){
                    System.out.println();
                    
                    System.out.print("Matrícula: ");
                    System.out.println(linea);
                    linea=entrada.nextLine();
                    System.out.print("Nombre: ");
                    System.out.println(linea);
                    linea=entrada.nextLine();
                    System.out.print("Dirección: ");
                    System.out.println(linea);
                    linea=entrada.nextLine();
                    System.out.print("Teléfono: ");
                    System.out.println(linea);
                    linea=entrada.nextLine();
                    System.out.print("Grupo: ");
                    System.out.println(linea);
                    linea=entrada.nextLine();
                    System.out.print("Materia: ");
                    System.out.println(linea);
                    linea=entrada.nextLine();
                    System.out.print("Calificación del primer parcial: ");
                    System.out.println(linea);
                    linea=entrada.nextLine();
                    System.out.print("Calificación del segundo parcial: ");
                    System.out.println(linea);
                    linea=entrada.nextLine();
                    System.out.print("Calificación del tercer parcial: ");
                    System.out.println(linea);
                     System.out.println();
                   
                   contiene=true;
                                       
                }
                
            }
            if(!contiene){
                System.out.println(texto+" no se ha encontrado en el archivo");
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
    public void prome(){
        Scanner entrada=null;
        String linea;
        int nodelinea=1;
        boolean contiene=false;
        int cont=1;
        String linea1;
        
        System.out.println("Escribe la matrícula del alumno: ");
        String texto=tec.next();
        
        try{
            fr=new FileReader(f);
            br=new BufferedReader(fr);
            entrada=new Scanner(f);
            
            while(entrada.hasNext()&&contiene!=true){
                linea=entrada.nextLine();
                if(linea.contains(texto)){
                    System.out.println();
                    
                    
                    
                    linea=entrada.nextLine();                  
                    linea=entrada.nextLine();                    
                    linea=entrada.nextLine();                    
                    linea=entrada.nextLine();
                    linea=entrada.nextLine();
                    linea=entrada.nextLine();
                    linea=entrada.nextLine();
                    linea=entrada.nextLine();
                    linea=entrada.nextLine();
                    System.out.println("El promedio del alumno es: "+linea);
                     System.out.println();
                   
                   contiene=true;
                                       
                }
                
            }
            if(!contiene){
                System.out.println(texto+" no se ha encontrado en el archivo");
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
    
    public void eliminar(){
        if(f.exists()){
            System.out.println("a");
            try{
                f.delete();
            }catch(Exception e){
                System.out.println(e);
            }
        
        }else{
            
        }       

    }
    
    
    
}
