/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UbicacionGanado;

import java.util.ArrayList;


public class Ruta {
    
    ArrayList<Integer> elementos;
    int costo;
    //String indice;
    
    public Ruta() {
        elementos = new ArrayList<>();
        costo = 0;
    }
    
    public int[] convertirCamino() {
        return elementos.stream().mapToInt(Integer::intValue).toArray();
    }
}
