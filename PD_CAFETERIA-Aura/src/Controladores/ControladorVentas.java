/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Vistas.FrmVentas;
import conexion.AccionesMBD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author DAEL
 */
public class ControladorVentas implements ActionListener{

    private FrmVentas frm;
    private AccionesMBD acc;

    public ControladorVentas(FrmVentas _frm, AccionesMBD _acc) {
        this.acc = _acc;
        this.frm = _frm;

        this.frm.btnAgregar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String leyenda = "";
        if (e.getSource() == frm.btnAgregar) {
            leyenda = acc.registrarAlta("tbventas"," null, ' " +frm.txtNombreProducto.getText()+" ', " +frm.txtPrecio.getText()  );

            System.out.println(leyenda);
            System.out.println("hola");
        }
    }
}
