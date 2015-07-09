
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class lexico2 {
    private FileReader entrada;
    private String letra="AINTPYWaintpyw";
    private String num="0123456789";
    private String LI="EJKLMUOCHSXejklmuochsx";
    private String L="aintpyweojklmuchsxeAITPYWEJKLMUOCHSXE";
   // private String L57=""

    private int matriz[][]={
//{   .1   ,  a,  e,   i,   j,   k,  l,   m,    n,   t,    u,   p,   O,  y,  w,    L,    ?},
{0,   0,  0,  0,  0,   0,   0,   0,   0,  0,   0,   0,     0,   0,   0,  0, 0,      0,   0},
{0,   2,  3, 37,  0,   34,  0,   0,  0,   0,    6,  21,    0,  51,   0, 28, 47,    57,   0},
{0,   1,  1,  1,  1,   1,   1,   1,  1,   1,    1,   1,    1,   1,   1,  1,   1,    1,   1},
{0,   1,  1,  1,  1,   1,   1,   1,  1,   1,    1,   1,    1,   1,   1,  1,   1,    1,   1},
{0,   0,  0,  0,  0,   0,   0,   0,  0,   0,    0,   0,    0,   0,   0,  0,   0,   57,   5},
{0,   1,  1,  1,  1,   1,   1,   1,  1,   1,    1,   1,    1,   1,   1,  1,   1,    1,   1},
{0,   0,  0,  4,  7,   16,  0,   0,  0,   0,    0,   0,    0,   0,   0,  0,   0,   57,   0},
{0,   0,  0,  0,  0,   0,   8,   0,  0,   0,    0,   0,    0,  13,   0,  0,   0,   57,   0},
{0,   0,  0,  0,  0,   0,   0,   0,  0,   0,    0,   0,    9,   0,   0,  0,   0,   57,   0},
{0,   0,  0, 10,  0,   0,   0,   0,  0,   0,    0,   0,    0,   0,   0,  0,   0,   57,   0},
{0,  0,  0,  0,  0,   0,   0,   0,  0,   0,   11,   0,    0,   0,   0,  0,   0,   57,   0},
{0,  0,  0,  0,  0,   0,   0,   0,  0,   0,    0,   0,    0,   0,   0,  0,   0,   57,  12},
{0,  1,  1,  1,  1,   1,   1,   1,  1,   1,    1,   1,    1,   1,   1,  1,   1,    1,   1},
{0,  0,  0, 14,  0,   0,   0,   0,  0,   0,    0,   0,    0,   0,   0,  0,   0,   57,   0},
{0,  0,  0,  0,  0,   0,   0,   0,  0,   0,    0,   0,    0,   0,   0,  0,   0,   57,  15},
{0,  1,  1,  1,  1,   1,   1,   1,  1,   1,    1,   1,    1,   1,   1,  1,   1,    1,   1},//15
{0,  0,  0,  0,  0,   0,   0,  17,  0,   0,    0,   0,    0,   0,   0,  0,   0,   57,   0},
{0,  0,  0, 18,  0,   0,   0,   0,  0,   0,    0,   0,    0,   0,   0,  0,   0,   57,   0},
{0,  0,  0,  0,  0,   0,   0,   0,  0,   0,   19,   0,    0,   0,   0,  0,   0,   57,   0},
{0,  0,  0,  0,  0,   0,   0,   0,  0,   0,    0,   0,    0,   0,   0,  0,   0,   57,  20},
{0,  1,  1,  1,  1,   1,   1,    1, 1,   1,    1,   1,    1,   1,   1,  1,   1,    1,   1},
{0,  0,  0,  0, 22,   0 ,  0,    0, 0,   0,    0,   0,    0,   0,   0,  0,   0,   57,   0},
{0,  0,  0,  0,  0,   0,  23,    0, 0,   0,    0,   0,    0,   0,   0,  0,   0,   57,   0} ,
{0,  0,  0,  0,  0,   0,   0,    0, 0,   0,    0,   0,   24,   0,   0,  0,   0,   57,   0},
{0,  0,  0, 25,  0,   0,   0,    0, 0,   0,    0,   0,    0,   0,   0,  0,   0,   57,   0},
{0,  0,  0,  0,  0,   0,   0,    0, 0,   0,   26,   0,    0,   0,   0,  0,   0,   57,   0} ,
{0,  0,  0,  0,  0,   0,   0,    0, 0,   0,    0,   0,    0,   0,   0,  0,   0,   57,  27},
{0,  1,  1,  1,  1,   1,   1,    1, 1,   1,    1,   1,    1,   1,   1,  1,   1,    1,   1},
{0,  0,  0,  0, 29,   0 ,  0,    0, 0,   0,    0,   0,    0,   0,   0,  0,   0,   57,   0},
{0,  0,  0,  0,  0,   0,  30,    0, 0,   0,    0,   0,    0,   0,   0,  0,   0,   57,   0},
{0,  0,  0,  0,  0,   0,   0,    0, 0,   0,    0,   0,   31,   0,   0,  0,   0,   57,   0},//30
{0,  0,  0, 32,  0,   0,   0,    0, 0,   0,    0,   0,    0,   0,   0,  0,   0,   57,   0},
{0,  0,  0,  0,  0,   0,   0,    0, 0,   0,   33,   0,    0,   0,   0,  0,   0,   57,   0},
{0,  0,  0,  0,  0,   0,   0,    0, 0,   0,    0,   0,    0,   0,   0,  0,   0,   57,  44},
{0,  0,  0,  0,  0,   0,   0,    0, 0,   0,    35,   0,    0,  0,   0,  0,   0,   57,  0 } ,
{0,  0,  0,  0,  0,   0,   0,    0, 0,   0,    0,   0,    0,   0,   0,  0,   0,   57,  36},
{0,  1,  1,  1,  1,   1,   1,    1, 1,   1,    1,   1,    1,   1,   1,  1,   1,    1,   1},
{0,  0,  0,  0,  0,   0,   0,    0, 0,   0,   38,   0,    0,   0,   0,  0,   0,   57,   0},
//{   .    ,  a,  e,   i,   j,    k, l,  m,     n,   t,    u,   p,   o,  y,   w,    L,   ?}
{0,  0,  0,  0,  0,   0,   0,    0, 0,   39,   0,   0,    0,   0,   0,  0,   0,   57,   0},
{0,  0,  0,  0, 40,   0,   0,    0, 0,   0,    0,   0,    0,   0,   0,  0,   0,   57,   0},
{0,  0,  0,  0,  0,   0,  41,    0, 0,   0,    0,   0,    0,   0,   0,  0,   0,   57,   0},
{0,  0,  0,  0,  0,   0,   0,    0, 0,   0,    0,   0,   42,   0,   0,  0,   0,   57,   0},
{0,  0,  0, 43,  0,   0,   0,    0, 0,   0,    0,   0,    0,   0,   0,  0,   0,   57,   0},
{0,  0,  0,  0,  0,   0,   0,    0, 0,   0,   45,   0,    0,   0,   0,  0,   0,   57,   0},
{0,  1,  1,  1,  1,   1,   1,    1, 1,   1,    1,   1,    1,   1,   1,  1,   1,    1,   1} ,
{0,  0,  0,  0,  0,   0,   0,    0, 0,   0,    0,   0,    0,   0,   0,  0,   0,   57,  46},
{0,  1,  1,  1,  1,   1,   1,    1, 1,   1,    1,   1,    1,   1,   1,  1,   1,    1,   1},
{0,  0,  0, 48,  0,   0,   0,    0, 0,   0,    0,   0,    0,   0,   0,  0,   0,   57,   0},
{0,  0,  0,  0,  0,   0,   0,    0, 0,   0,   49,   0,    0,   0,   0,  0,   0,   57,   0},
{0,  0,  0,  0,  0,   0,   0,    0, 0,   0,    0,   0,    0,   0,   0,  0,   0,   57,  50},
{0,  1,  1,  1,  1,   1,   1,    1, 1,   1,    1,   1,    1,   1,   1,  1,   1,    1,   1},
{0,  0,  0, 52,  0,   0,   0,    0, 0,   0,    0,   0,    0,   0,   0,  0,   0,   57,   0  },
{0,  0,  0,  0,  0,   0,   0,    0, 0,   53,   0,   0,    0,   0,   0,  0,   0,   57,   0 },
{0,  0,  0,  0,  0,   0,   0,    0, 0,   0,    0,   0,    0,  54,   0,  0,   0,   57,   0 },
{0,  0,  0, 55,  0,   0,   0,    0, 0,   0,    0,   0,    0,   0,   0,  0,   0,   57,   0  },
{0,  0,  0,  0,  0,   0,   0,    0, 0,   0,    0,   0,    0,   0,   0,  0,   0,   57,  56 },
{0,  1,  1,  1,  1,   1,   1,    1, 1,   1,    1,   1,    1,   1,   1,  1,   1,    1,   1  },//56
{0,  0 ,  0,  0,  0,  64,   0,   58,   59,  0,    0, 60,    0,   0,  66,  0,   0,   57,   0},
{0,  0,  0,  0,  0,   0,   0,    0,    0,   0,   0,  0,    0,   0,   0,  0,   0,   57,  68},
{0,  0,  0,  0,  0,   0,   0,    0,    0,   0,   0,  0,    0,   0,   0,  0,   0,   57,  69},
{0,  0,  0,  0,  0,   0,   0,    0,   61,   0,   0,  0,    0,   0,   0,  0,   0,   0,    0},
{0,  0,  0,  0,  0,  62,   0,    0,    0,   0,   0,  0,    0,   0,   0,  0,   0,   57,  63},
{0,  0,  0,  0,  0,   0,   0,    0,    0,   0,   0,  0,    0,   0,   0,  0,   0,   57,  70},
{0,  1,  1,  1,  1,   1,   1,    1,    1,   1,   1,  1,    1,   1,   1,  1,   1,    1,   1},
{0,  0,  0,  0,  0,   0,   0,    0,    0,   0,  65,  0,    0,   0,   0,  0,   0,    0,   0},
{0,  0,  0,  0,  0,   0,   0,    0,    0,   0,   0,  0,    0,   0,   0,  0,   0,   57,  71},
{0,  0,  0,  0,  0,   0,   0,   67,    0,   0,   0,  0,    0,   0,   0,  0,   0,   0,    0},
{0,  0,  0,  0,  0,   0,   0,    0,    0,   0,   0,  0,    0,   0,   0,  0,   0,   57,   72},
{0,  1,  1,  1,  1,   1,   1,    1,    1,   1,   1,   1,    1,   1,   1,  1,   1,    1,   1},
{0,  1,  1,  1,  1,   1,   1,    1,    1,   1,   1,   1,    1,   1,   1,  1,   1,    1,   1},
{0,  1,  1,  1,  1,   1,   1,    1,    1,   1,   1,   1,    1,   1,   1,  1,   1,    1,   1},
{0,  1,  1,  1,  1,   1,   1,    1,    1,   1,   1,   1,    1,   1,   1,  1,   1,    1,   1},
{0,  1,  1,  1,  1,   1,   1,    1,    1,   1,   1,   1,    1,   1,   1,  1,   1,    1,   1},
               };
   // private String permitidoLetra="_-ABCDEFabcdef0123456789GHIJLLMNOPQRSTUVWXYZghijklmnopqrstuvwxyz";
    private boolean correcto;

    public lexico2(){
        entrada=null;
    }

/*   private String lex(char c){

   String sal="";//,opt=Character.toString(c);
   switch(buscar(c)){
       case 1:
           System.out.println("letra "+c);
               break;
       case 2:
           System.out.println("num "+c);
               break;
       case 3:
           System.out.println("hex "+c);
               break;
       case 4:
           System.out.println("guion bajo "+c);
               break;
       case 5:
           System.out.println("menos "+c);
               break;
       case 6:
           System.out.println("slash "+c);
               break;
       case 7:
           System.out.println("comillas "+c);
               break;
       case 8:
           System.out.println("pocentaje "+c);
               break;
       case 9:
           System.out.println("menor que "+c);
               break;
       case 10:
           System.out.println("mayor que "+c);
               break;
       case 11:
           System.out.println("asterisco "+c);
               break;
       case 12:
           System.out.println("dos puntos "+c);
               break;
       case 13:
           System.out.println("punto y coma "+c);
               break;
       case 14:
           System.out.println("llave abre "+c);
               break;
       case 15:
           System.out.println("llave cierra "+c);
               break;
       case 16:
           System.out.println("coma "+c);
               break;
       case 17:
           System.out.println("comilla "+c);
               break;
       case 18:
           System.out.println("mas "+c);
               break;
       case 19:
           System.out.println("corchete abre "+c);
               break;
       case 20:
           System.out.println("corchete cierra "+c);
               break;
       case 21:
           System.out.println("igual "+c);
               break;
       case 22:
           System.out.println("parentesis abre "+c);
               break;
       case 23:
           System.out.println("parentesis cierra "+c);
               break;
       case 24:
           System.out.println("back slash "+c);
               break;
       case 25:
           System.out.println("punto "+c);
               break;
       case 26:
           System.out.println("gato "+c);
               break;

       default:
           System.out.println("otro "+c);
   }

   return sal;
   }*/

   private int buscar2(char c){

   	for(int i=0;i<L.length();i++)
       if(L.charAt(i)==c){

       	System.out.print("encontro *****");
           return 17;}
System.out.print("malll ");
return 0;
   }

   private int buscar(char c, int p){
       /*for(int i=0;i<letra.length();i++)
       if(letra.charAt(i)==c)
           return 1;*/

if(p==1){

       for(int i=0;i<LI.length();i++)
       if(LI.charAt(i)==c)
           return 17;}



       /*for(int i=0;i<hex.length();i++)
       if(hex.charAt(i)==c)
           return 3;*/
       if(c=='.')
           return 1;
       if(c==',')
           return 2;
       if(c=='a')
           return 3;
       if(c=='e')
           return 4;
       if(c=='i')
           return 5;
       if(c=='j')
           return 6;
       if(c=='k')
           return 7;
       if(c=='l')
           return 8;
       if(c=='m')
           return 9;
       if(c=='n')
           return 10;
       if(c=='t')
           return 11;
       if(c=='u')
           return 12;
       if(c=='p')
           return 13;
       if(c=='o')
           return 14;
       if(c=='y')
           return 15;
       if(c=='w')
           return 16;




       return 18;
   }

    public ArrayList <String []> analizar(String path){

        ArrayList <String []> tabla=new ArrayList();
        ArrayList texto=new ArrayList();
        int estado=1;
        int aux=0;

        String token="";
        String lexema="";


        try{
            entrada=new FileReader(path);
            int c;
   //System.out.println(entrada.read());
            while ((c=entrada.read())!=-1){
                System.out.println("Codigo ascii: "+c);
                texto.add((char)c);
            }
          System.out.println("--------------------------------------\n"+token);
       }catch (Exception ex) {
            System.out.println(ex);       }



        finally{
//cerrar los flujos de datos
            if(entrada!=null){
                try{
                    entrada.close();
                }catch(Exception ex){}
                }}



       int pos=0;
       int j=1,i=0;//j:Estados i:terminales
       int linea=1;
       int temp=0;
       correcto=true;
       System.out.println("Numero total de caracteres: "+texto.size());//tendrian que ser 32



       for (pos=0;pos<texto.size();pos++){//Analiza todo el texto
            System.out.println("Estado: "+j);//Imprime estado actual
            i=buscar((Character)texto.get(pos),j);//Busca el siguiente estado

             j=this.matriz[j][i];//Actualiza el estado

             if(j==0){
		 i=buscar2((Character)texto.get(pos));//Busca el siguiente estado

             j=this.matriz[temp][i];//Actualiza el estad
             }


            lexema+= (Character) texto.get(pos);
            System.out.println("Lexema: "+lexema);
            System.out.println("Estado resultante: "+j);
 temp=j;
       if (isError(j)){//Estado no valido 0
                if(lexema.equals("\r"))
                    System.out.println("Reconocio un retorno de carro");
                if(lexema.equals("\n")){
                    System.out.println("Reconocio un cambio de linea");
                    linea++;           }
                if(lexema.equals(" "))
                    System.out.println("Reconocio un espacio");
                if(lexema.equals("\t"))
                    System.out.println("Reconocio una tabulacion");
                if (lexema.equals(""))
                    System.out.println("Reconocio fin de fichero");
                if ((!lexema.equals("\n")) && (!lexema.equals("\t")) && (!lexema.equals(" ")) && (!lexema.equals("\r"))){
                    String [] fila= {"ERROR Linea: "+linea,lexema,""+linea};
                    correcto=false;
                    tabla.add(fila);
                    System.out.println("Se agregó error a la tabla: "+lexema+"\n");            }

                lexema=""; j=1;        }

        else{//Estado de aceptacion =D
                if (this.isEstadoAceptacionRetroceso(j)){
                    lexema=lexema.substring(0,lexema.length()-1);
                    pos=pos-1;
                    String [] fila= {buscar(j,lexema),lexema,""+linea};
                    tabla.add(fila);
                    System.out.println("Se agregó lexema CON retroceso: "+lexema+"\n");
                    lexema="";
                    j=1;								}

                else
                    if (isEstadoAceptacion(j)){
                        String [] fila= {buscar(j,lexema),lexema,""+linea};
                        tabla.add(fila);
                        System.out.println("Se agregó lexema SIN retroceso: "+lexema+"\n");
                        lexema="";
                        j=1;
                    }
            }
       }
       //Comentario
       /*
       j=0;
       if (isError(j)){
           if(lexema.equals("\r"))
                System.out.println("Reconocio un retorno de carro");
            if(lexema.equals("\n"))
                System.out.println("Reconocio un cambio de linea");
            if(lexema.equals(" "))
                System.out.println("Reconocio un espacio");
            if(lexema.equals("\t"))
                System.out.println("Reconocio una tabulacion");
            if ((!lexema.equals("\n")) && (!lexema.equals("\t")) && (!lexema.equals(" ")) && (!lexema.equals("\r"))){
                String [] fila= {"ERROR",lexema};
                tabla.add(fila);
                System.out.println("Se agregó error a la tabla: "+lexema+"\n");
            }

            lexema="";
            j=1;
            }
            else{
                if (this.isEstadoAceptacionRetroceso(j)){
                    lexema=lexema.substring(0,lexema.length()-1);
                    pos=pos-1;
                    String [] fila= {buscar(j,lexema),lexema};
                    tabla.add(fila);
                    System.out.println("Se agregó lexema CON retroceso: "+lexema+"\n");
                    lexema="";
                    j=1;
                }
                else
                    if (isEstadoAceptacion(j)){
                        String [] fila= {buscar(j,lexema),lexema};
                        tabla.add(fila);
                        System.out.println("Se agregó lexema SIN retroceso: "+lexema+"\n");
                        lexema="";
                        j=1;
                    }
            }
       */
       //Comentario

       return tabla;
    }

    public boolean isEstadoAceptacion(int estado){
        if ( estado==2||
            estado==3   )
            return true;
        else
            return false;
    }

    public boolean isError(int estado){
        if (estado==0)
            return true;
        else
            return false;
    }

    public boolean isEstadoAceptacionRetroceso(int estado){
        if (estado==5 || estado==12 || estado==15  || estado==20 || estado==27
        	|| estado==44 || estado==36  || estado==46  || estado==50  || estado==63
        		|| estado==56||estado==68||estado==69||estado==70||estado==71||estado==72)
            return true;
        else
            return false;
    }

    public String buscar(int estado, String lexema){
        switch(estado){

        	case 2:
        		 return "PUNTO";

            case 3:
            	return "COMA";
               /* if (isPalabraReservada(lexema))
                    return "PALABRA RESERVADA";
                else
                    if (propiedad(lexema)){
                        return "COLOR";
                    }
                    else
                        if (medidas(lexema)){
                            return "MEDIDA";
                        }
                        else
                            if (this.ValoresEspeciales(lexema))
                                return "VALOR";
                            else
                                return "IDENTIFICADOR";*/

            case 5:
                return "PRONOMBRE";
            case 12:
                return "PRONOMBRE";
            case 15:
                return "ADVERBIO";
            case 20:
                return "ADVERBIO";
            case 27:
                return "PRONOMBRE";
            case 44:
                return "PRONOMBRE";
            case 36:
                return "PRONOMBRE";
            case 46:
                return "PRONOMBRE";
            case 50:
                return "CONJUNCION";
            case 63:
                return "SUSTANTIVO";
            case 56:
                return "COJUNCION";
            case 68:
                return "ADJETIVO";

            case 70:
                return "SUSTANTIVO";

            case 72:
                return "VERBO";

            case 69:
                return "SUSTANTIVO";

            case 71:
                return "SUSTANTIVO";



            default:
                return "ERROR";

        }

    }

    public static boolean isPalabraReservada(String str){
            String aux="";
            boolean band=false;
            try{
                File f=new File("palabras_reservadas.txt");
                FileReader lectorArchivo=new FileReader(f);
                BufferedReader br=new BufferedReader(lectorArchivo);
                while(true){
                    aux=br.readLine();
                    if (aux!=null){
                            if(aux.equals(str)){
                                return true;
                            }
                    }
                    else
                        break;
                }
                br.close();
                lectorArchivo.close();

                }catch(Exception e){
                        System.out.println("Error: "+e.toString());
                }
                return false;

           }
        //var=leer(c);
        //if(var==true)
        //    return "Palabra Reservada";
        //else{
        //    }
    public boolean verbos(String prop){
            String aux="";
            boolean band=false;
            try{
                File f=new File("verbos.txt");
                FileReader lectorArchivo=new FileReader(f);
                BufferedReader br=new BufferedReader(lectorArchivo);
                while(true){
                    aux=br.readLine();
                    if (aux!=null){
                            if(aux.toLowerCase().equals(prop.toLowerCase())){
                                return true;
                            }
                    }
                    else

                            break;
                }
                br.close();
                lectorArchivo.close();

                }catch(Exception e){
                        System.out.println("Error: "+e.toString());
                }
                return false;

    }

    public boolean sustantivos(String prop){
            String aux="";
            boolean band=false;
            try{
                File f=new File("sustantivos.txt");
                FileReader lectorArchivo=new FileReader(f);
                BufferedReader br=new BufferedReader(lectorArchivo);
                while(true){
                    aux=br.readLine();

                    if (aux!=null){
                            if(aux.toLowerCase().equals(prop.toLowerCase())){
                                return true;
                            }
                    }
                    else
                        break;
                }
                br.close();
                lectorArchivo.close();

                }catch(Exception e){
                        System.out.println("Error: "+e.toString());
                }
                return false;


    }

    public boolean isCorrecto() {
        return correcto;
    }

    public boolean adjetivos (String prop){
            String aux="";
            boolean band=false;
            try{
                File f=new File("adjetivos.txt");
                FileReader lectorArchivo=new FileReader(f);
                BufferedReader br=new BufferedReader(lectorArchivo);
                while(true){
                    aux=br.readLine();

                    if (aux!=null){
                            if(aux.toLowerCase().equals(prop.toLowerCase())){
                                return true;
                            }
                    }
                    else
                        break;
                }
                br.close();
                lectorArchivo.close();

                }catch(Exception e){
                        System.out.println("Error: "+e.toString());
                }
                return false;


    }


}