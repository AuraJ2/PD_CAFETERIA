/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Vistas.FrmGanancia;
import Vistas.FrmGastos;
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
    private AccionesMBD acc;

    public MenuControl(MenuPrincipal menu, AccionesMBD acc) {
        this.menu = menu;
        this.acc = acc;
        
        this.menu.btnVentas.addActionListener(this);
        this.menu.btnGasto.addActionListener(this);
        this.menu.btnGanancia.addActionListener(this);
    }

   
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == menu.btnGasto){
            AccionesMBD oMBD = new AccionesMBD();
            FrmGastos gasto = new FrmGastos();
            ControladorGastos Cgasto = new ControladorGastos(gasto, oMBD);
            
            gasto.setVisible(true);
            
        }
        if (e.getSource() == menu.btnVentas) {
            AccionesMBD objMBD = new AccionesMBD();
            FrmVentas ventas = new FrmVentas();
            ControladorVentas Cventa = new ControladorVentas(ventas, objMBD);

            ventas.setVisible(true);
            
        }
        
     if (e.getSource()== menu.btnGanancia) {
        AccionesMBD obj = new AccionesMBD();
        FrmGanancia Ganancia = new FrmGanancia();
        ControladorGanancia Cganancia = new ControladorGanancia (Ganancia, obj);
        Ganancia.setVisible(true);
         
     }   
        
    }

}
