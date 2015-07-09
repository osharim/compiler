
import java.util.ArrayList;
import java.util.Stack;

public class SintacticoTabla {
    private Stack pila;
    private ArrayList <String []> filas;
    private String [] S={"ORACION","SE"};
    private String [] SE1={"C","ORACION","SE"};
    private String [] SE2={""};
    private String [] ORACION={"A","ADJETIVO","O"};
    private String [] O1={"VERBO","I"};
    private String [] O2={"I"};
    private String [] I={"INI","FIN"};
    private String [] INI1={"PRONOMBRE"};
    private String [] INI2={"SUSTANTIVO"};
    private String [] A1={"ADVERBIO"};
    private String [] A2={""};
    private String [] C1={"COMA"};
    private String [] C2={"COJUNCION"};
    private String [] FIN1={"PUNTO"};
    private String [] FIN2={""};
    /*private String [] A1={"COMA","Selector"};
    private String [] A2={""};
    private String [] B1={"PALABRA RESERVADA"};
    private String [] B2={"IDENTIFICADOR"};
    private String [] Clase={"PUNTO","B"};
    private String [] Id={"GATO","B"};*/

    private Object tabla [][]={{null,   null,          S,   null,   null,   null,   null,      S,   null  },
                               {null,   SE1,        null,    SE1,   null,   null,   null,   null,    SE2},
                               {null,   null,    ORACION,   null,   null,   null,   null, ORACION,  null},
                               {null,   null,       null,   null,     O1,     O2,     O2,    null,   null},
                               {null,   null,       null,   null,   null,      I,      I,    null,   null},
                               {null,   null,       null,   null,   null,   INI1,   INI2,    null,   null},
                               {null,   null,         A1,   null,   null,   null,   null,      A2,    null},
                               {null,     C1,       null,   C2,     null,   null,   null,    null,  null},
                               {FIN1,   FIN2,       null,   FIN2,   null,   null,   null,    null,  FIN2},       };
    public SintacticoTabla(ArrayList <String []> aux){
        pila=new Stack();
        filas=aux;




    }

    public String AnalizadorSintactico(){
        String resultado="";
        String A="";
        pila.push("$");
        pila.push("S");
        int i=0;
        int tamTabla=filas.size();
        System.out.println("El número de Tokens es: " +tamTabla);
        String a= filas.get(i)[0];
        System.out.println("El primer token es: " +a);
        do{
            A= (String) pila.peek();
            System.out.println("El elemento en el tope de la pila es: " +A);
            if (isTerminal(A)||A.equals("$")){
                if (A.equals(a)){
                    pila.pop();
                    System.out.println("Se quito el elemento " +A+" de la pila");
                    i++;
                    if (i<filas.size()){
                        a=filas.get(i)[0];
                        System.out.println("Siguiente Token: "+a);
                    }
                    else{
                        System.out.println("EXITO");
                        resultado+="\nEl Análisis Sintáctico terminó CORRECTAMENTE\nNO se encontraron Errores Sintacticos";
                    }



                }
                else{
                    //System.out.println("Encontrado Lexema de "+a+"  se esperaba: "+A);
                    resultado+="\nERROR SINTACTICO LINEA: "+filas.get(i)[2]+". Lexema encontrado: "+filas.get(i)[1];
                    break;
                }
            }
            else{//tabla//Pendiente

            System.out.print(" valores A a"+A+" "+a);
                if (tabla [this.NumeroProduccion(A)][this.NumeroTerminal(a)]!=null){
                    System.out.println("Tabla ["+this.NumeroProduccion(A)+"] ["+this.NumeroTerminal(a)+"]");
                    pila.pop();
                    System.out.println("Se quito el elemento " +A+" de la pila");
                    Object aux=tabla [this.NumeroProduccion(A)][this.NumeroTerminal(a)];
                    String [] aux2= (String []) aux;
                    int tam=aux2.length;
                    System.out.println("Tamaño de la produccion: "+tam);
                    int j=tam-1;
                    while (j>=0){
                        if (!aux2[j].equals("")){
                            pila.push(aux2[j]);
                            System.out.println("Se agregó el elemento "+aux2[j]+" a la pila");
                        }
                        j--;
                    }
                }
                else{
                    //System.out.println("ERROR SINTACTICO: Encontrado Lexema"+a+" Esperaba:");
                    resultado+="\nERROR SINTACTICO LINEA: "+filas.get(i)[2]+". Lexema encontrado: "+filas.get(i)[1];
                    break;
                }

            }

        }while (!A.equals("$"));
        System.out.println("Termino el algoritmo correctamente");
        return resultado;
    }

    public boolean isTerminal(String aux){
        if (aux.equals("S")||aux.equals("SE")||aux.equals("ORACION")||aux.equals("O")||aux.equals("I")||aux.equals("INI")||
            aux.equals("A")||aux.equals("C")||aux.equals("FIN")){
            System.out.print("*****es terminal");
            return false;
        }
        else
            return true;
    }

    public int NumeroProduccion(String A){
        if (A.equals("S"))
            return 0;
        else
            if (A.equals("SE"))
                return 1;
            else
                if (A.equals("ORACION"))
                    return 2;
                else
                    if (A.equals("O"))
                        return 3;
                    else
                        if (A.equals("I"))
                            return 4;
                        else
                            if (A.equals("INI"))
                                return 5;
                            else
                                if (A.equals("A"))
                                    return 6;
                                else
                                    if (A.equals("C"))
                                        return 7;
                                    else
                                        if (A.equals("FIN"))
                                            return 8;
                                        /*else
                                            if (A.equals("Clase"))
                                                return 9;
                                            else
                                                if (A.equals("Id"))
                                                    return 10;*/
                                                else
                                                    return -1;

    }

    public int NumeroTerminal(String a){
        if (a.equals("PUNTO"))
            return 0;
        else
            if (a.equals("COMA"))
                return 1;
            else
                if (a.equals("ADVERBIO"))
                    return 2;
                else
                    if (a.equals("CONJUNCION"))
                        return 3;
                    else
                        if (a.equals("VERBO"))
                            return 4;
                        else
                            if (a.equals("PRONOMBRE"))
                                return 5;
                            else
                                if (a.equals("SUSTANTIVO"))
                                    return 6;
                                else
                                    if (a.equals("ADJETIVO"))
                                        return 7;
                                    /*else
                                        if (a.equals("MEDIDA"))
                                            return 8;
                                        else
                                            if (a.equals("ASTERISCO"))
                                                return 9;
                                            else
                                                if (a.equals("COMA"))
                                                    return 10;
                                                else
                                                    if (a.equals("IDENTIFICADOR"))
                                                        return 11;
                                                    else
                                                        if (a.equals("PUNTO"))
                                                            return 12;*/
                                                        else
                                                            if (a.equals("$"))
                                                                return 8;
                                                            else
                                                                return -1;


    }
}
