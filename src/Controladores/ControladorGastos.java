/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Vistas.FrmGastos;
import conexion.AccionesMBD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author gerar
 */
public class ControladorGastos implements ActionListener{
private FrmGastos a;
private AccionesMBD b;

    public ControladorGastos(FrmGastos a, AccionesMBD b) {
        this.a = a;
        this.b = b;
        
        this.a.btnTotal.addActionListener(this);
    }


    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
 String leyenda = "";
        if (e.getSource() == a.btnTotal) {
            leyenda = b.registrarAlta("tbGastos"," null, ' " +""+" ', " +a.CajaTotal.getText()  );

            System.out.println(leyenda);
            System.out.println("hola");
        }
}

    
    
    
    
    
    
}
