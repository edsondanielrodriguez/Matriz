import java.util.*;

public class Solicitud_Matriz {
    private int columna, renglon;
    int[][] matriz;

    public void getColumnaRenglon(int columna, int renglon){
        this.columna = columna;
        this.renglon = renglon;
    }

    public void get_Matriz(int[][] matriz){
        this.matriz=matriz;
    }

    public int setColumna() {
        return columna;
    }

    public int setRenglon() {
        return renglon;
    }

    public int[][] setMatriz() {
        return matriz;
    }


    public void getColumnaRenglon() {
        System.out.printf("Columna: %d%n", setColumna());  
        System.out.printf("Renglón: %d%n", setRenglon());  
    }
    
    public void Mostrar_Matriz() {
        System.out.println("\nMatriz ingresada:");
        for (int i = 0; i < renglon; i++) {
            for (int j = 0; j < columna; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(); // Nueva línea después de cada fila
        }
    }
}
