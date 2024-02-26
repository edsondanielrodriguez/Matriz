import java.util.*;
import java.io.*; //importando clases para entrada y salida (IN OUT)
import java.math.*; //clases utiles para operaciones y valores matematicos


public class Matriz{

    public static void main(String args[]){
        //variables
        int opcion = 0;
    

        //Creación de objetos
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("");
        System.out.println("Bienvenido, presione:" );
        System.out.println("1. Crear e insertar matriz" );
        System.out.println("2. " );
        System.out.println("");

        do{
            System.out.printf("Ingrese una opción: ");
            opcion = entrada.nextInt();
        }while(opcion<1 || opcion>2);

        switch (opcion){
            case 1:
                int columna=0, renglon=0;
                System.out.printf("%n");
                Scanner sc =  new Scanner(System.in);

                do{
                    System.out.printf("Ingrese la cantidad de columnas: ");
                    columna = sc.nextInt();
                }while(columna<1);
                
                System.out.printf("%n");
                do{
                    System.out.printf("Ingrese la cantidad de renglones: ");
                    renglon = sc.nextInt();
                }while(renglon<1);

                /* 
                Solicitud_Matriz matrix = new Solicitud_Matriz();
                matrix.get_matriz(columna,renglon);
                
                /* 
                //Mostrar datos de renglon
                System.out.printf("%n");
                matrix.mostrarColumnaRenglon();
                System.out.printf("%n");
                */

                //Hacer matriz
            
                int matriz[][] = new int [renglon][columna];  
                for(int i = 0; i < matriz.length; i++){
                    for(int j = 0; j < matriz[i].length; j++){
                        System.out.printf("Ingresa el nombre de la fila " + i + " y la columna " + j);
                        matriz[i][j] = sc.next();
                        System.out.printf("=)");

                    }
                }

                break;
        
            default:
                break;
        }
    }
}
