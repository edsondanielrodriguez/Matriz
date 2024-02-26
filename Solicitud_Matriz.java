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
    
}
