import java.util.Scanner;

public class Matriz {
    private static double[][] matrizGlobal; // Campo estático para la matriz

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion;
    //    int[] vectorInvertido;
        int columna = 0, renglon = 0;
        int posicion_inicial = 0;
        int posicion_final = 0;
        int pasos = 0;
        System.out.println("\nBienvenido :)\n");
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

            System.out.println("\nMENU");
            System.out.println("1. Crear e insertar matriz");
            System.out.println("2. Mostrar matriz de transición");
            System.out.println("3. Editar matriz");
            System.out.println("4. Posición inicial");
            System.out.println("5. Posición final");
            System.out.println("6. Pasos");
            System.out.println("7. Resultados");
            System.out.println("8. Salir\n");

            System.out.print("Ingrese una opción: ");
            opcion = entrada.nextInt();

            switch (opcion) {
                //Iniciar matriz
                case 1:
                    System.out.println();
                    System.out.println("Presione 0 para cancelar o 1 para continuar");
                    opcion = entrada.nextInt();

                    if (opcion==0) {
                        break;
                    }
                    else{
                        do {
                            System.out.print("Ingrese la cantidad de estados: ");
                            columna = entrada.nextInt();
                        } while (columna < 1);

                        renglon = columna;

                        matrizGlobal = new double[renglon][columna];

                        System.out.println("Ingrese los números enteros para la matriz:");
                        for (int i = 0; i < renglon; i++) {
                            System.out.printf("\n");
                            for (int j = 0; j < columna; j++) {
                                System.out.printf("Elemento [%d][%d]: ", i+1, j+1);
                                matrizGlobal[i][j] = entrada.nextDouble();
                            }
                        }
                    }
                break;
                    
                    //Mostrar Matriz
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
                   
                    //Editar matriz
                    case 3:
                        System.out.println("Presione 0 para cancelar o 1 para continuar");
                        opcion = entrada.nextInt();
                        if (opcion==0) {
                            break;
                        }
                        else{
                            editarValorMatriz(entrada, renglon, columna);
                        }
                    break;

                    case 4:
                        System.out.println("Presione 0 para cancelar o 1 para continuar\n");
                        opcion = entrada.nextInt();
                        if (opcion==0) {
                            break;
                        }
                        else{
                            do {
                                System.out.print("Ingrese la posición inicial: ");
                                posicion_inicial = entrada.nextInt();
                            } while (posicion_inicial < 0  || posicion_inicial>columna-1);
                        }        
                    break;

                    case 5:
                        System.out.println("Presione 0 para cancelar o 1 para continuar\n");
                        opcion = entrada.nextInt();
                        if (opcion==0) {
                            break;
                        }
                        else{
                            do {
                                System.out.print("Ingrese la posición final: ");
                                posicion_final = entrada.nextInt();
                            } while (posicion_final < 0 || posicion_inicial>columna-1);
                        }        
                    break;

                    case 6:
                        System.out.println("Presione 0 para cancelar o 1 para continuar\n");
                        opcion = entrada.nextInt();
                        if (opcion==0) {
                            break;
                        }
                        else{
                            do {
                                System.out.print("Ingrese la cantidad de pasos: ");
                                pasos = entrada.nextInt();
                            } while (pasos < 0);
                        }        
                    break;

                    case 7:                        
                        Resolver_Proceso(entrada, columna, posicion_inicial, matrizGlobal, posicion_final, pasos);
                        System.out.println("\nPresione Enter para continuar...");
                        entrada.nextLine(); // Consumir el salto de línea restante
                        entrada.nextLine(); // Esperar a que el usuario presione Enter
                    break;

                    case 8:
                        System.out.println("Programa finalizado.");
                        System.exit(0);
                    break;

                    case 9:
                        System.out.print("Vector PI0: ");
                    
                        System.out.println();
                    break;

                    default:
                        System.out.println("");
                        System.out.println("Opción no válida.");
                        System.out.println("");
                    break;
            }
        } while (opcion != 8);

        entrada.close();
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
        if (fila >= 0 && fila <= renglon && col >= 1 && col <= columna) {
            System.out.println("El valor actual es: " + matrizGlobal[fila - 1][col - 1]);
            System.out.println("Ingrese el nuevo valor:");
            matrizGlobal[fila - 1][col - 1] = entrada.nextDouble();
            System.out.println("Valor actualizado exitosamente.");
        } else {
            System.out.println("Posición fuera de los límites de la matriz.");
        }
    }

    private static void Resolver_Proceso(Scanner entrada, int columna, int posicion_inicial, double[][] matrizGlobal, int posicion_final, int pasos){
        if (matrizGlobal == null) {
            System.out.println("La matriz no han sido inicializados.");
            return;
        }

        System.out.println();
        double[] vectorInvertido = new double[columna];
        double[] vectorP = new double[columna];

        for (int i = 0; i < columna; i++) {
            if (i == posicion_inicial) {
                vectorInvertido[i] = 1.0;
            } else {
                vectorInvertido[i] = 0.0;
            }
        }
        
        // PI 0
        System.out.print("PI0: \n");
        for (double valor : vectorInvertido) {
            System.out.print(valor + " ");
        }
        System.out.println();

        //////////////////////////////////////////77
        double[][] resultado = CopiarMatriz(matrizGlobal);
        double[][] resultado2 = new double[columna][columna];

        // Multiplicar la matriz por sí misma (pasos - 1) veces.
    //    for (int j = 1; j < pasos; j++) {
        resultado = matrizGlobal;
            for (int i = 0; i < pasos; i++) {
                int j=i+1;

                    System.out.println("\n\nPI " + j + ":");
                    
                //    mostrarMatriz(resultado.length, resultado[0].length, resultado);
                    
                    double[] filaExtraida = extraerFila(resultado, posicion_inicial);   ///////////77
                    resultado2=CopiarMatriz(resultado);
                    resultado = multiplicarMatrices(resultado, matrizGlobal);
                    for (double elemento : filaExtraida) {

                        System.out.print(elemento + " ");
                    }

            }
        // Imprimir resultado.
        System.out.println("\n");
        
        double valorEspecifico = resultado2[posicion_inicial][posicion_final];
        // double valorEspecifico = resultado2[posicion_final][posicion_inicial];

        System.out.println("La probabilidad de (" + posicion_inicial + " a " + posicion_final + ") es: " + valorEspecifico);

    }
    
    private static double[][] CopiarMatriz(double[][] matriz) {
        double[][] copia = new double[matriz.length][matriz[0].length];
        for (int i = 0; i < matriz.length; i++) {
            System.arraycopy(matriz[i], 0, copia[i], 0, matriz[i].length);
        }
        return copia;
    }
    
    // Método para multiplicar matrices.
    private static double[][] multiplicarMatrices(double[][] A, double[][] B) {
        double[][] resultado = new double[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < B.length; k++) {
                    resultado[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return resultado;
    }
    
    // Método modificado para mostrar matriz con parámetro matriz.
    private static void mostrarMatriz(int renglon, int columna, double[][] matriz) {
        for (int i = 0; i < renglon; i++) {
            for (int j = 0; j < columna; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static double[] extraerFila(double[][] matriz, int fila) {
        if (fila < 0 || fila >= matriz.length) {
            throw new IllegalArgumentException("Fila fuera de los límites de la matriz");
        }
        
        return matriz[fila];
    }

   
}