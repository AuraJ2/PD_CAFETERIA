/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Vistas.FrmGanancia;
import Vistas.FrmVentas;
import conexion.AccionesMBD;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DAEL
 */
public class ControladorVentas implements ActionListener {

    private FrmVentas frm;
    private AccionesMBD acc;

    public ControladorVentas(FrmVentas _frm, AccionesMBD _acc) {
        this.acc = _acc;
        this.frm = _frm;

        this.frm.btnAgregar.addActionListener(this);
    }

    public void Centrar(FrmVentas a) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - a.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - a.getHeight()) / 2);
        a.setLocation(x, y);
        a.setLocation(x, y);
    }
    public void limpiar(){
        frm.txtNombreProducto.setText("");
        frm.txtPrecio.setText("");
    }
    public void actionPerformed(ActionEvent e) {
        String leyenda = "";
        DefaultTableModel tb = new DefaultTableModel();
        this.frm.tblVentas.setModel(tb);
        tb.setColumnIdentifiers(new Object[]{"", "",});
        Object[]fila=new Object[2];
        fila[0]=frm.txtNombreProducto.getText();
        fila[1]=frm.txtPrecio.getText();
        if (e.getSource() == frm.btnAgregar) {
            tb.addRow(fila);
            leyenda = acc.registrarAlta("ventas", " null, ' " + frm.txtNombreProducto.getText() + " ', " + frm.txtPrecio.getText());
            JOptionPane.showMessageDialog(null,leyenda);
            frm.Limpiar();

        }
    }
}
