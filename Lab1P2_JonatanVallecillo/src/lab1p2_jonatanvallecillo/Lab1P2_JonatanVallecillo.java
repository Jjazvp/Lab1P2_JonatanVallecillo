package lab1p2_jonatanvallecillo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Lab1P2_JonatanVallecillo {
    
    //Fila 2, silla 2

    static Random rand = new Random();
    static Scanner leer = new Scanner(System.in);
    static Scanner leer2 = new Scanner(System.in);
    static ArrayList <Integer> Medianas = new ArrayList <Integer>();   //ArrayList que se usará
    
    public static void main(String[] args) {
        int continuar = 1;
        do{
            int size = 0;
        
        do{ //Ciclo do-while donde se valida que el número sea mayor que 4 e impar
            System.out.print("Ingrese el tamano de matriz deseado: ");
            size = leer.nextInt();
        }while(size < 5 || (size % 2 == 0));
        
        int [][] matriz = new int [size][size];
        int numrandom = 0;
        
        for(int i = 0; i < size; i++){ //Generación de los números randoms
            for(int j = 0; j < size; j++){
                numrandom = rand.nextInt(10);
                matriz[i][j] = numrandom;
            }
        }
        
        ImprimirMatriz(matriz, size);
        System.out.println("");
        
        int filas = 0;
        bubbleSort(matriz, size, filas, Medianas);
        
        bubbleSortArrayList(size);
        
        System.out.println("\nArreglo de medianas ordenados: ");
        for(int i = 0; i < Medianas.size(); i++){ //Impresión de la ArrayList de medianas
            System.out.print("["+Medianas.get(i)+"] ");
        }
        
        int medianaMediana = Medianas.size() / 2;
        
        System.out.println("\nMediana de las medianas: "+Medianas.get(medianaMediana));
            
            
            System.out.println("Desea continuar? Ingrese 1 si desea seguir, otro numero si no desea: ");
            continuar = leer.nextInt();
            
            for(int i = 0; i < Medianas.size();){
                Medianas.remove(i);
            }
            
        }while(continuar == 1);
    }
    
    public static void bubbleSort(int [][] matriz, int size, int filas, ArrayList <Integer> Medianas){ //Método bubbleSort del ordenamiento de las filas
        
        int mediana = size/2;
        int [] arreglo = new int [size];
        int [][] temporal = new int [size][size];
        
        if(filas < size){
            for(int i = 0; i < size; i++){
                arreglo[i] = matriz[filas][i];
            }
            
            int cambio = 0;
            
            for(int i = 0; i < size; i++){ //Ordenamiento de las filas, utilizando un arreglo temporal
                for(int j = 0; j < size; j++){
                    if(arreglo[j] > arreglo[i]){
                        cambio = arreglo[i];
                        arreglo[i] = arreglo[j];
                        arreglo[j] = cambio;
                    }
                }
            }
            
            if(filas == 0){
                System.out.println("Matriz ordenada");
            }
            
            for(int i = 0; i < size; i++){ //Impresión de la matriz ordenada
                temporal[filas][i] = arreglo[i];
                System.out.print("["+temporal[filas][i]+"] ");
            }
            
            Medianas.add(arreglo[mediana]);
            
            System.out.println();
            
            filas ++;
            bubbleSort(matriz, size, filas, Medianas); //Recursiva aplicada
        }
    }
    
    public static void bubbleSortArrayList(int size){ //Método bubbleSort de ArrayList para la ordenación de las medianas
        int cambio = 0;
        int cambio2 = 0;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){ 
                if(Medianas.get(j) > Medianas.get(i)){ //Ordenamiento ArrayList
                    cambio = Medianas.get(i);
                    cambio2 = Medianas.get(j);
                    Medianas.set(i, cambio2);
                    Medianas.set(j, cambio);
                }
            }
        }
    }
    
    public static void ImprimirMatriz(int [][] matriz, int size){ //Método de impresión de la matriz
        System.out.println("\nMatriz: ");
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                System.out.print("["+matriz[i][j]+"] ");
            }
            System.out.println("");
        }
    }
}
