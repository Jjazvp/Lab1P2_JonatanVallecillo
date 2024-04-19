package lab1p2_jonatanvallecillo;

import java.util.Random;
import java.util.Scanner;

public class Lab1P2_JonatanVallecillo {

    static Random rand = new Random();
    static Scanner leer = new Scanner(System.in);
    static Scanner leer2 = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        int size = 0;
        
        do{
            System.out.print("Ingrese el tamano de matriz deseado: ");
            size = leer.nextInt();
        }while(size < 5 || (size % 2 == 0));
        
        int [][] matriz = new int [size][size];
        int numrandom = 0;
        
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                numrandom = rand.nextInt(10);
                matriz[i][j] = numrandom;
            }
        }
        
        System.out.println("\nMatriz: ");
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                System.out.print("["+matriz[i][j]+"] ");
            }
            System.out.println("");
        }
    }
    
    
    /*git clone
    git add -A
    git commit -m "El asunto del commit"
    git push*/
}
