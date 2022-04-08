/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Vistas.FrmGanancia;
import Vistas.FrmVentas;
import Vistas.frmConsulta;
import conexion.AccionesMBD;
import conexion.Conexion;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class ControladorGanancia implements ActionListener {

    public ControladorGanancia(FrmGanancia a, AccionesMBD c) {
        this.a = a;
        this.c = c;
        this.a.btnConsultar.addActionListener(this);
        this.a.btnGuardar.addActionListener(this);

    }

    public void Centrar(FrmGanancia a) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - a.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - a.getHeight()) / 2);
        a.setLocation(x, y);
        a.setLocation(x, y);
    }
    private FrmGanancia a;
    private FrmVentas b;
    private frmConsulta g =  new frmConsulta();
    private AccionesMBD c;

    Conexion conexion = new Conexion("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/bdcafeteria", "root", "pepeteye");
    Connection con = conexion.ObtenerConexion();

    ControladorGanancia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void ganancia() {

        //String usuario = String.valueOf(FrmGastos.CajaTotal.getText());
        //String contra = String.valueOf(FrmVentas.t.getText());
        String venta = "SELECT SUM(precio) FROM ventas";
        String gasto = "SELECT * FROM gastos ";

        try {

            Statement st = con.createStatement();
            Statement st2 = con.createStatement();

            ResultSet rs = st.executeQuery(venta);
            ResultSet sr = st2.executeQuery(gasto);

            if (rs.next() && sr.next()) {
                int total1 = rs.getInt(1);
                int totalgastos = sr.getInt("Totalgastos");
                int total = total1 - totalgastos;

                String leyenda = "";
                LocalDate dia = LocalDate.now();

                leyenda = c.registrarAlta("tbganancias", " null, ' " + dia + " ', " + total);
                System.out.println(leyenda);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }

    }

    public void consultar() {
        String SQl = "SELECT * FROM bdcafeteria.tbganancias WHERE fechaganacia ='" + a.txtConsulta.getText() + "'";
        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQl);
            DefaultTableModel tb = new DefaultTableModel();
            this.g.Tabla.setModel(tb);
            tb.setColumnIdentifiers(new Object[]{"ID", "FECHA", "GANANCIA"});

            try {
                while (rs.next()) {
                    tb.addRow(new Object[]{rs.getInt("idGanancia"), rs.getString("fechaganacia"), rs.getInt("GananciaTotal")});
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }
    }
    
    public void limpiar(){
        a.txtConsulta.setText("");
  
    }
    @Override

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == a.btnGuardar) {
            ganancia();
        }
        if (e.getSource() == a.btnConsultar) {
            g.setVisible(true);
            consultar();
            limpiar();
        }
    }

}
