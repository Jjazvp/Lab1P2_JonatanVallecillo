package lab1p2_jonatanvallecillo;

import java.util.Random;
import java.util.Scanner;

public class Lab1P2_JonatanVallecillo {
    
    //Fila 2, silla 2

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
        
        ImprimirMatriz(matriz, size);
        
        int filas = 0;
        matriz = bubbleSort(matriz, size, filas);
        
        ImprimirMatriz(matriz, size);
    }
    
    public static int [][] bubbleSort(int [][] matriz, int size, int filas){
        int [] arreglo = new int [size];
        int [][] temporal = new int [size][size];
        
        do{
            for(int i = 0; i < size; i++){
                arreglo[i] = matriz[filas][i];
            }
            
            int cambio = 0;
            
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    if(arreglo[j] < arreglo[i]){
                        cambio = arreglo[i];
                        arreglo[i] = arreglo[j];
                        arreglo[j] = cambio;
                    }
                }
            }
            
            for(int i = 0; i < size; i++){
                temporal[filas][i] = arreglo[i];
            }
            
            for(int i = 0; i < size; i++){
                System.out.print(arreglo[i]+" ");
            }
            
            System.out.println("");
            
            filas ++;
            
            if (filas < size){
                bubbleSort(matriz, size, filas);
            }
            
        }while(filas < size);
        
        return temporal;
    }
    
    public static void ImprimirMatriz(int [][] matriz, int size){
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
