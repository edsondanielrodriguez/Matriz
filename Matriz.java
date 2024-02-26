import java.util.Scanner;

public class Matriz {

    public static void main(String args[]) {
        // Variables
        int opcion = 0;

        // Creación de objetos Scanner para la entrada de datos
        Scanner entrada = new Scanner(System.in);

        System.out.println("\nBienvenido, presione:");
        System.out.println("1. Crear e insertar matriz");
        System.out.println("2. Salir\n");

        do {
            System.out.print("Ingrese una opción: ");
            opcion = entrada.nextInt();
        } while (opcion < 1 || opcion > 2);

        switch (opcion) {
            case 1:
                int columna = 0, renglon = 0;
                System.out.println(); // Se cambió printf por println para una nueva línea

                do {
                    System.out.print("Ingrese la cantidad de columnas: ");
                    columna = entrada.nextInt();
                } while (columna < 1);

                System.out.println(); // Nueva línea
                do {
                    System.out.print("Ingrese la cantidad de renglones: ");
                    renglon = entrada.nextInt();
                } while (renglon < 1);

                // Creación de la matriz
                int[][] matriz = new int[renglon][columna]; // Corrección: "new matriz" a "new int"
                
                System.out.println("Ingrese los números enteros para la matriz:");
                for (int i = 0; i < renglon; i++) {
                    for (int j = 0; j < columna; j++) {
                        System.out.printf("Elemento [%d][%d]: ", i, j);
                        matriz[i][j] = entrada.nextInt(); // Restaurado para leer la entrada del usuario
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

                break;
            case 2:
                System.out.println("Saliendo...");
                break;
            default:
                // No es necesario, ya que la validación de la opción asegura entrar en uno de los casos válidos
                break;
        }

        entrada.close(); // Se mueve afuera del switch para cerrar el scanner correctamente
    }
}