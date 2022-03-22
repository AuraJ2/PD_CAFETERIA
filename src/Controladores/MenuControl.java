/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Vistas.FrmVentas;
import Vistas.MenuPrincipal;
import conexion.AccionesMBD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author DAEL
 */
public class MenuControl implements ActionListener {

    private MenuPrincipal menu = new MenuPrincipal();
     private FrmVentas frm;
    private AccionesMBD acc;

    public MenuControl(MenuPrincipal menu, AccionesMBD acc) {
        this.menu = menu;
        this.acc = acc;
        
        this.menu.btnVentas.addActionListener(this);
    }

   
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menu.btnVentas) {
            AccionesMBD objMBD = new AccionesMBD();
            FrmVentas ventas = new FrmVentas();
            ControladorVentas Cventa = new ControladorVentas(ventas, objMBD);

            ventas.setVisible(true);
        }
    }

}
