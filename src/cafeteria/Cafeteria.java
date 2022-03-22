/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cafeteria;

import Controladores.ControladorVentas;
import Controladores.MenuControl;
import Vistas.FrmVentas;
import Vistas.MenuPrincipal;
import conexion.AccionesMBD;

/**
 *
 * @author DELL
 */
public class Cafeteria {

   private FrmVentas _view;
   
    public static void main(String[] args) {
       AccionesMBD objMBD = new AccionesMBD();
       MenuPrincipal menu = new MenuPrincipal();
       MenuControl Cventa = new MenuControl(menu,objMBD);
       
       menu.setVisible(true);
    }
    
}
