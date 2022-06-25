/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UbicacionGanado;

import java.util.Collections;


public class AreasProtegidas {
    public int[] obtenerRutaGanado(int[] valores) {
        int costoMin = 0;
        int posMin = 0;
        for (int i = 0; i < valores.length; i++) {
            if (i == 0 || valores[i] < costoMin) {
                costoMin = valores[i];
                posMin = i;
            }
        }
        
        return new int[] { posMin, costoMin };
    }
    
    public Ruta obtenerRutaG(int[][] matriz){
        Ruta ruta = new Ruta();
        int columna = 0;
        
        for (int i = 0; i < matriz.length ; i++) {
            if (i == 0) {
                int menor[] = obtenerRutaGanado(matriz[i]);
                columna = menor[0];
                ruta.elementos.add(columna);
                ruta.costo += menor[1];
            }
            else {
                int colAnterior = columna;
                int[] valores = new int[] {99, 99, 99};
                if (colAnterior > 0) {
                    valores[0] = matriz[i][colAnterior - 1];
                }
                
                valores[1] = matriz[i][colAnterior];
                
                if (colAnterior < matriz[i].length - 1) {
                    valores[2] = matriz[i][colAnterior + 1];
                }
                
                int menor[] = obtenerRutaGanado(valores);
                columna = colAnterior - 1 + menor[0];
                ruta.elementos.add(columna);
                ruta.costo += menor[1];
            }
        }
        
        return ruta;
    }
}
