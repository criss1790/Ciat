/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UbicacionGanado;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class AreassinProteccion {
    public static HashMap<String, Ruta> rutasOptimas = new HashMap<>(); //caché o memoization
    
    public Ruta obtenerRutaGanado(ArrayList<Ruta> rutas) {
        Ruta menor = new Ruta();
        for (int i = 0; i < rutas.size(); i++) {
            if (i == 0 || rutas.get(i).costo < menor.costo) {
                menor = rutas.get(i);
            }
        }
        
        return menor;
    }
    
    public Ruta ubicacionGanado(int[][] matriz, int fila, int columna){
        String indice = String.valueOf(fila) + "-" + String.valueOf(columna);
        if (rutasOptimas.containsKey(indice)) {
            return rutasOptimas.get(indice);
        }
        
        Ruta ruta = new Ruta();
        
        if (fila == matriz.length - 1) {
            ruta.elementos.add(columna);
            ruta.costo = matriz[fila][columna];
            rutasOptimas.put(indice, ruta);
            return ruta;
        }
        
        ArrayList<Ruta> nodos = new ArrayList<>();
        
        if (columna > 0) {
            Ruta rutaIzquierda = ubicacionGanado(matriz, fila + 1, columna - 1);
            nodos.add(rutaIzquierda);
        }
        
        Ruta rutaCentro = ubicacionGanado(matriz, fila + 1, columna);
        nodos.add(rutaCentro);
        
        if (columna < matriz[fila].length - 1) {
            Ruta rutaDerecha = ubicacionGanado(matriz, fila + 1, columna + 1);
            nodos.add(rutaDerecha);
        }
        
        Ruta menor = obtenerRutaGanado(nodos);
        
        ruta.elementos = new ArrayList<>(menor.elementos);
        ruta.elementos.add(columna);
        ruta.costo = matriz[fila][columna] + menor.costo;
        rutasOptimas.put(indice, ruta);
        return ruta;
    }
    
    public Ruta obtenerRutaGanado(int[][] matriz) {
        AreassinProteccion.rutasOptimas = new HashMap<>();
        ArrayList<Ruta> rutas = new ArrayList<>();
        for (int i = 0; i < matriz[0].length; i++) {
            Ruta ruta = ubicacionGanado(matriz, 0, i);
            rutas.add(ruta);
        }

        Ruta optimo = obtenerRutaGanado(rutas);
        Collections.reverse(optimo.elementos);
        return optimo;
    }
}
