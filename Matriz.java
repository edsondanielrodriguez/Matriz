import java.util.Scanner;

public class Matriz {
    private static int[][] matrizGlobal; // Campo estático para la matriz

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion;
        int columna = 0, renglon = 0;

        do {
            // Intento de limpiar la pantalla
            try {
                String sistemaOperativo = System.getProperty("os.name");
                if (sistemaOperativo.contains("Windows")) {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                }
            } catch (Exception e) {
                System.out.println("No se pudo limpiar la pantalla");
            }

            System.out.println("\nBienvenido, presione:");
            System.out.println("1. Crear e insertar matriz");
            System.out.println("2. Mostrar matriz");
            System.out.println("3. Salir\n");

            System.out.print("Ingrese una opción: ");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println();
                    do {
                        System.out.print("Ingrese la cantidad de columnas: ");
                        columna = entrada.nextInt();
                    } while (columna < 1);

                    System.out.println();
                    do {
                        System.out.print("Ingrese la cantidad de renglones: ");
                        renglon = entrada.nextInt();
                    } while (renglon < 1);

                    matrizGlobal = new int[renglon][columna];

                    System.out.println("Ingrese los números enteros para la matriz:");
                    for (int i = 0; i < renglon; i++) {
                        for (int j = 0; j < columna; j++) {
                            System.out.printf("Elemento [%d][%d]: ", i, j);
                            matrizGlobal[i][j] = entrada.nextInt();
                        }
                    }
                    break;
                    case 2:
                    if (matrizGlobal != null) {
                        mostrarMatriz(renglon, columna);
                        System.out.println("\nPresione Enter para continuar...");
                        entrada.nextLine(); // Consumir el salto de línea restante
                        entrada.nextLine(); // Esperar a que el usuario presione Enter
                    } else {
                        System.out.println("No hay una matriz para mostrar. Por favor, cree una primero.");
                        System.out.println("\nPresione Enter para continuar...");
                        entrada.nextLine(); // Consumir el salto de línea restante
                        entrada.nextLine(); // Esperar a que el usuario presione Enter
                    }
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 3);

        entrada.close();
    }

    private static void mostrarMatriz(int renglon, int columna) {
        System.out.println("\nMatriz ingresada:");
        for (int i = 0; i < renglon; i++) {
            for (int j = 0; j < columna; j++) {
                System.out.print(matrizGlobal[i][j] + " ");
            }
            System.out.println();
        }
    }
}
