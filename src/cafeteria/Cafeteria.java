/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cafeteria;

import Controladores.ControladorGanancia;
import Controladores.ControladorLogin;
import Controladores.ControladorVentas;
import Controladores.MenuControl;
import Vistas.FrmGanancia;
import Vistas.FrmVentas;
import Vistas.Login;
import Vistas.MenuPrincipal;
import conexion.AccionesMBD;

/**
 *
 * @author DELL
 */
public class Cafeteria {

   private FrmVentas _view;
   
    public static void main(String[] args) {
//       AccionesMBD objMBD = new AccionesMBD();
//       Login log = new Login();
//       ControladorLogin cLog =new ControladorLogin(log,objMBD);
//       
//       log.setVisible(true);
AccionesMBD objMBD = new AccionesMBD();
FrmGanancia menu = new FrmGanancia();
ControladorGanancia Cventa = new ControladorGanancia (menu, objMBD);
    } 
    
}
