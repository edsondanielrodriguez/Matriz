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
       //         Scanner sc =  new Scanner(System.in);

                do{
                    System.out.printf("Ingrese la cantidad de columnas: ");
                    columna = entrada.nextInt();
                }while(columna<1);
                
                System.out.printf("%n");
                do{
                    System.out.printf("Ingrese la cantidad de renglones: ");
                    renglon = entrada.nextInt();
                }while(renglon<1);

                //Hacer matriz

                int[][] ob = new ob[renglon][columna];
            
                System.out.println("Ingrese los números enteros para la matriz:");
                for (int i = 0; i < renglon; i++) {
                    for (int j = 0; j < columna; j++) {
                        System.out.printf("Elemento [%d][%d]: ", i, j);
                        ob[i][j] = entrada.nextInt();
                    }
                }

                // Opcional: Mostrar la matriz para verificar

                System.out.println("\nMatriz ingresada:");
                for (int i = 0; i < renglon; i++) {
                    for (int j = 0; j < columna; j++) {
                        System.out.print(ob[i][j] + " ");
                    }
                    System.out.println(); // Nueva línea después de cada fila
                }

            //    scanner.close(); // Cerrar el scanner para evitar fugas de recursos

                break;
        
            default:
                break;
        }
    }
}
