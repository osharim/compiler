
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.*;

public class identificacion {
    

            private static File f;
            private static FileReader lectorArchivo;
            private static BufferedReader br;
            private static boolean var;
            private static String num="0123456789";
            
            
            public identificacion(){
            
            
            }

            public static String buscar(String c){
                    var=leer(c);
                    if(var==true)
                        return "Palabra Reservada";
                    else
                    {

                    if(c.equals("_"))
                        return "Guion bajo";
                    if(c.equals("-"))
                        return "Guion medio";
                    if(c.equals("/"))
                        return "Slash";
                    if(c.equals("\""))
                        return "Comillas dobles";
                    if(c.equals("%"))
                        return "Porcentaje";
                    if(c.equals("<"))
                        return "Menor que";
                    if(c.equals(">"))
                        return "Mayor que";
                    if(c.equals("*"))
                        return "Asterisco";
                    if(c.equals(":"))
                        return "Dos puntos";
                    if(c.equals(";"))
                        return "Punto y coma";
                    if(c.equals("{"))
                        return "Llave que abre";
                    if(c.equals("}"))
                        return "Llave que cierra";
                    if(c.equals(","))
                        return "Coma";
                    if(c.equals("\'"))
                        return "Comilla simple";
                    if(c.equals("+"))
                        return "Signo de mas";
                    if(c.equals("["))
                        return "Corchete que abre";
                    if(c.equals("]"))
                        return "Corchete que cierra";
                    if(c.equals("="))
                        return "Igual";
                    if(c.equals("("))
                        return "Parentesis que abre";
                    if(c.equals(")"))
                        return "Parentesis que cierra";
                    if(c.equals("\\"))
                        return "Slash invertido";
                    if(c.equals("."))
                        return "Punto";
                    if(c.equals("#"))
                        return "Gato";
                    if(var==false)
                        return "Identificador";
                    }
                return "Error";
            } 


        public static boolean leer(String str){
            String aux="";
            boolean band=false;
            try{
                f=new File("palabras_reservadas.txt");
                lectorArchivo=new FileReader(f);
                br=new BufferedReader(lectorArchivo);
                while(true){
                    aux=br.readLine();
                    if (aux!=null){
                            if(aux.equals(str)){
                                band=true;
                                break;
                            }
                    }
                    else
                        break;
                }
                br.close();
                lectorArchivo.close();
                return band;
                }catch(Exception e){
                        System.out.println("Error: "+e.toString());
                }
                return band;
           }
}