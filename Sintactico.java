
import java.util.ArrayList;
public class Sintactico {
    private ArrayList <String []> filas;
    private String preanalisis;
    private int count;

    public Sintactico(ArrayList <String []> aux){
        filas=aux;
        count=0;
        preanalisis=filas.get(count)[0];
        System.out.println("Prueba: "+preanalisis);
    }

    public void Emparejar (String t){
        if (t.equals(preanalisis)){
            count++;
            if (count>=filas.size()){
                System.out.println("Error Sintáctico en Emparejar: "+preanalisis+" "+t);
            }
            else{
                preanalisis=filas.get(count)[0];
            }
            
        }
        else{
            System.out.println("Error Sintáctico: "+preanalisis+" "+t);
        }
    }

    public void S(){
        if (preanalisis.equals("IDENTIFICADOR")|| preanalisis.equals("PALABRA RESERVADA") ||
            preanalisis.equals("PUNTO") || preanalisis.equals("GATO") || preanalisis.equals("ASTERISCO") ||
            preanalisis.equals("$")){

            F();
        }
        else{
            System.out.println ("ERROR SINTACTICO: ");
        }

    }

    public void F(){
         if (preanalisis.equals("IDENTIFICADOR")|| preanalisis.equals("PALABRA RESERVADA") ||
             preanalisis.equals("PUNTO") || preanalisis.equals("GATO") || preanalisis.equals("ASTERISCO")){
             Selector();
             Emparejar("LLAVE QUE ABRE");
             K ();
             Emparejar("LLAVE QUE CIERRA");
             F();
         }
        else{
             if (preanalisis.equals("$"));
            else{
                 System.out.println ("ERROR SINTACTICO:");
            }

        }
    }

    public void K (){
        if (preanalisis.equals("PALABRA RESERVADA")){
            Declaracion ();
            K();
        }
        else{
            if (preanalisis.equals("LLAVE QUE CIERRA"));
            else{
                System.out.println("ERROR SINTACTICO: ");
            }
        }
    }

    public void Declaracion (){
        if (preanalisis.equals("PALABRA RESERVADA")){
            Emparejar("PALABRA RESERVADA");
            Emparejar("DOS PUNTOS");
            Val();
            Emparejar("PUNTO Y COMA");
        }
        else{
            System.out.println("ERROR SINTACTICO EN DECLRACION");
        }
    }

    public void Val (){
        if (preanalisis.equals("GATO")){
            Emparejar ("GATO");
            Emparejar ("VALOR");
        }
        else
            if (preanalisis.equals("COLOR")){
                Emparejar ("COLOR");
            }
            else
                if(preanalisis.equals("VALOR")){
                    Emparejar ("VALOR");
                    Me();
                }
                else
                    System.out.println("ERROR SINTACTICO EN Val ()");
    }

    public void Me (){
        if (preanalisis.equals("MEDIDA")){
            Emparejar("MEDIDA");
        }
        else{
            if (preanalisis.equals("PUNTO Y COMA"));
            else
                System.out.println("ERROR SINTACTICO EN Me()");
        }

    }

    public void Selector (){
        if (preanalisis.equals("PUNTO")){
            Clase ();
            A ();
        }
        else
            if (preanalisis.equals("GATO")){
                Id ();
                A ();
            }
            else
                if (preanalisis.equals("ASTERISCO")){
                    Emparejar ("ASTERISCO");
                    A();
                }
                else
                    if (preanalisis.equals("IDENTIFICADOR")||preanalisis.equals("PALABRA RESERVADA")){
                        B ();
                        A ();
                    }
                    else
                        System.out.println("ERROR SINTACTICO EN Seletor");
    }

    public void A (){
        if (preanalisis.equals("COMA")){
            Emparejar ("COMA");
            Selector();
        }
        else
            if (preanalisis.equals("LLAVE QUE ABRE"));
            else
                System.out.println("ERROR SINTACTICO EN A()");
    }

    public void B (){
        if (preanalisis.equals("PALABRA RESERVADA")){
            Emparejar ("PALABRA RESERVADA");
        }
        else
            if (preanalisis.equals("IDENTIFICADOR")){
                Emparejar ("IDENTIFICADOR");
            }
            else
                System.out.println("ERROR SINTACTICO EN B()");
    }

    public void Clase (){
        if (preanalisis.equals("PUNTO")){
            Emparejar ("PUNTO");
            B ();
        }
        else
            System.out.println("ERROR SINTACTICO EN Clase()");
    }

    public void Id (){
        if (preanalisis.equals("GATO")){
            Emparejar ("GATO");
            B ();
        }
        else
            System.out.println("ERROR SINTACTICO EN Id ()");
    }

}
