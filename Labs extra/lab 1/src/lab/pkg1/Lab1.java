package lab.pkg1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab1 {

    static Scanner leer = new Scanner(System.in);
    static Scanner leer2 = new Scanner(System.in);
        
    public static void main(String[] args) {
        int opcion = 0;
        
        do{
            do{
                System.out.print("Menu\n"
                    + "1. Tokens\n"
                    + "2. Expresiones regulares\n"
                    + "3. Do while\n"
                    + "4. Salir\n"
                    + "Ingrese la opcion: ");
                opcion = leer.nextInt();
                System.out.println();
            }while(opcion <= 0 || opcion > 4);

            switch(opcion){
                case 1:
                    Token();
                    break;
                case 2:
                    ExpresionesRegulares();
                    break;
                case 3:
                    DoWhile();
                    break;
                case 4:
                    break;
            }
        }while(opcion != 4);
    }
    
    public static void DoWhile(){
        System.out.print("Ingrese la cadena: ");
        String app = leer2.nextLine();
        int contador = 0;
        char carac = ' ';
        while(true){
            if(contador < app.length()){
                carac = app.charAt(contador);
                System.out.println(carac);
                contador ++;
            }else{
                break;
            }
        }
        
        System.out.println();
        contador = 0;
        int ascci = 0;
        int suma = 0;
        do{
            carac = app.charAt(contador);
            ascci = (int) carac;
            suma += ascci;
            contador ++;
        }while(contador < app.length());
        
        System.out.println("La suma de su cadena es: "+suma+"\n");
    }
    
    public static void Token(){
        System.out.print("Escriba una frase: ");
        String frase = leer2.nextLine();
        String delimit = "[,.!#$%&/)('?¡¿!|+ ]";
        String [] token = frase.split(delimit);
        
        System.out.println(token.length);
        System.out.println("");
        
        for(int i = 0; i < token.length; i++){
            System.out.println(token[i]);
        }
        
        System.out.println("");
    }
    
    public static void ExpresionesRegulares(){
        System.out.print("Ingrese una cadena cualesquiera: ");
        String cadena = leer2.nextLine();
        String regex;
        
        char continuar = ' ';
        do{
            System.out.print("Ingrese comandos: ");
            regex = leer2.next();
            
            if(regex.equals("exit"))
                break;
            Pattern patron = Pattern.compile(regex);
            Matcher a = patron.matcher(cadena);
            
            boolean igual = a.find();
            System.out.println("Hay similitud?  "+igual);
            System.out.println("\nDesea continuar? (otro/n)");
            continuar = leer.next().charAt(0);
            System.out.println();
        }while(continuar != 'n');
    }
}
