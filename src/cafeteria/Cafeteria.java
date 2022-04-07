/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cafeteria;

import Controladores.ControladorCancelar;
import Controladores.ControladorGanancia;
import Controladores.ControladorLogin;
import Controladores.ControladorVentas;
import Controladores.MenuControl;
import Vistas.FrmGanancia;
import Vistas.FrmVentas;
import Vistas.Login;
import Vistas.MenuPrincipal;
import Vistas.frmCancelarVenta;
import conexion.AccionesMBD;

/**
 *
 * @author DELL
 */
public class Cafeteria {

   private FrmVentas _view;
   
    public static void main(String[] args) {
//        frmCancelarVenta v = new frmCancelarVenta();
//        AccionesMBD objMBD = new AccionesMBD();
//        ControladorCancelar c = new ControladorCancelar(v,objMBD);
//        c.Centrar(v);
//        v.setVisible(true);
       Login log = new Login();
       AccionesMBD objMBD = new AccionesMBD();
       ControladorLogin cLog =new ControladorLogin(log,objMBD);
       cLog.Centrar(log);
       
       log.setVisible(true);


    } 
    
}
