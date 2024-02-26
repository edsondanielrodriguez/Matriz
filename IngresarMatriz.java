import java.util.Scanner;

public class IngresarMatriz {
        Scanner entrada = new Scanner(System.in);
        int columna = 0, renglon = 0;

        // Solicitar el número de columnas, asegurando que sea al menos 1
        do {
            System.out.print("Ingrese la cantidad de columnas: ");
            columna = entrada.nextInt();
        } while (columna < 1);

        System.out.println(); // Nueva línea

        // Solicitar el número de renglones, asegurando que sea al menos 1
        do {
            System.out.print("Ingrese la cantidad de renglones: ");
            renglon = entrada.nextInt();
        } while (renglon < 1);

        // Creación de la matriz
        int[][] matriz = new int[renglon][columna];
        
        // Solicitar al usuario que ingrese los números enteros para la matriz
        System.out.println("Ingrese los números enteros para la matriz:");
        for (int i = 0; i < renglon; i++) {
            for (int j = 0; j < columna; j++) {
                System.out.printf("Elemento [%d][%d]: ", i, j);
                matriz[i][j] = entrada.nextInt();
            }
        }

        // Mostrar la matriz para verificar
        System.out.println("\nMatriz ingresada:");
        for (int i = 0; i < renglon; i++) {
            for (int j = 0; j < columna; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(); // Nueva línea después de cada fila
        }

        entrada.close(); // Cerrar el scanner al finalizar
    
}