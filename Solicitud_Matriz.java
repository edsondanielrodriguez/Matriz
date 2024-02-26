import java.util.*;

public class Solicitud_Matriz {
    private int columna=0, renglon=0;

    public void get_matriz(int columna, int renglon){
        this.columna = columna;
        this.renglon = renglon;
    }

    public int getColumna() {
        return columna;
    }

    public int getRenglon() {
        return renglon;
    }

    public void mostrarColumnaRenglon() {
        System.out.printf("Columna: %d%n", getColumna());  
        System.out.printf("Renglón: %d%n", getRenglon());  
    }
    /* 
    Scanner ob =  new Scanner(System.in);
    System.out.println("Cuantas filas deseas?: ");
    renglon = sc.nextInt();
    System.out.println("Cuantas columnas deseas?: ");
    columna = sc.nextInt();
    int[][] matriz = new int[columna][renglon];

    for(int i = 0; i < Matriz.length; i++){
        for(int j = 0; j < Matriz[i].length; j++){{
            System.out.println("Ingresa el numero de la fila " + i + " y la columna " + j);
            matriz[i][j] = ob.nextInt();
        }
      }
      */
}
