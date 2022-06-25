/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UbicacionGanado;
import UbicacionGanado.GuiLeastCostPath;


public class RutasGanado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Areas.cargarAreas();
        GuiLeastCostPath g1 = new GuiLeastCostPath();
        g1.show();
    }
    
}
