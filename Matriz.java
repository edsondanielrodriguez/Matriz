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
            System.out.println("3. Editar matriz");
            System.out.println("4. Salir\n");

            System.out.print("Ingrese una opción: ");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    crearEInsertarMatriz(entrada);
                break;

                    case 2:
                    if (matrizGlobal != null) {
                        mostrarMatriz();
                        System.out.println("\nPresione Enter para continuar...");
                        entrada.nextLine(); // Consumir el salto de línea restante que nextInt() deja
                        entrada.nextLine(); // Esperar a que el usuario presione Enter
                    } else {
                        System.out.println("No hay una matriz para mostrar. Por favor, cree una primero.");
                        System.out.println("\nPresione Enter para continuar...");
                        entrada.nextLine(); // Consumir el salto de línea restante
                        entrada.nextLine(); // Esperar a que el usuario presione Enter
                    }
                    break;
                   
                    case 3:
                        editarValorMatriz(entrada, renglon, columna);
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 4);

        entrada.close();
    }

    //Funcion para crear e insertar matriz
    private static void crearEInsertarMatriz(Scanner entrada) {
        int columna, renglon;
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
    }
    
    
    //Funcion de mostrar matriz
    private static void mostrarMatriz(int renglon, int columna) {
        
        System.out.println("\nMatriz ingresada:");
        for (int i = 0; i < renglon; i++) {
            for (int j = 0; j < columna; j++) {
                System.out.print(matrizGlobal[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Funcion de editar matriz
    private static void editarValorMatriz(Scanner entrada, int renglon, int columna) {
        if (matrizGlobal == null || renglon == 0 || columna == 0) {
            System.out.println("La matriz no está inicializada o es inválida.");
            entrada.nextLine(); // Consumir el salto de línea restante
            entrada.nextLine(); // Esperar a que el usuario presione Enter
            return;
        }
        
        System.out.println("Ingrese la fila del elemento a editar:");
        int fila = entrada.nextInt();
        System.out.println("Ingrese la columna del elemento a editar:");
        int col = entrada.nextInt();
        
        // Verifica si la fila y columna son válidas
        if (fila >= 1 && fila <= renglon && col >= 1 && col <= columna) {
            System.out.println("El valor actual es: " + matrizGlobal[fila - 1][col - 1]);
            System.out.println("Ingrese el nuevo valor:");
            matrizGlobal[fila - 1][col - 1] = entrada.nextInt();
            System.out.println("Valor actualizado exitosamente.");
        } else {
            System.out.println("Posición fuera de los límites de la matriz.");
        }
    }
    
    private static void mostrarMatriz() {
        if (matrizGlobal != null) {
            System.out.println("\nMatriz ingresada:");
            for (int i = 0; i < matrizGlobal.length; i++) {
                for (int j = 0; j < matrizGlobal[i].length; j++) {
                    System.out.print(matrizGlobal[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No hay una matriz para mostrar. Por favor, cree una primero.");
        }
    }
}
