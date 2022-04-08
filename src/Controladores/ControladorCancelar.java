package Controladores;

import Vistas.frmCancelarVenta;
import conexion.AccionesMBD;
import conexion.Conexion;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorCancelar implements ActionListener {

    private frmCancelarVenta venta;
    private AccionesMBD b;
    Conexion conexion = new Conexion("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/bdcafeteria", "root", "pepeteye");
    Connection con = conexion.ObtenerConexion();

    public ControladorCancelar(frmCancelarVenta venta, AccionesMBD b) {
        this.venta = venta;
        this.b = b;
        this.venta.txtBorrar.addActionListener(this);
        this.venta.btnBuscar.addActionListener(this);
        this.venta.btnBorrar.addActionListener(this);
    }
    public void Centrar(frmCancelarVenta venta){ 
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize(); 
        int x = (int) ((dimension.getWidth() - venta.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - venta.getHeight()) / 2); venta.setLocation(x, y); 
        venta.setLocation(x, y);
    }


    public void buscar() {

        String texto = venta.txtBorrar.getText();
        String buscar = "SELECT * FROM bdcafeteria.ventas WHERE idventas='" + texto + "' OR producto = '" + texto + "' OR precio = '" + texto + "'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(buscar);
            DefaultTableModel tb = new DefaultTableModel();

            tb.setColumnIdentifiers(new Object[]{"ID", "PRODUCTO", "PRECIO"});
            venta.TablaBorrar.setModel(tb);
            try {
                while (rs.next()) {
                    tb.addRow(new Object[]{rs.getInt("idventas"), rs.getString("producto"), rs.getInt("precio")});
                }
                if(rs.next() == false){
                    JOptionPane.showMessageDialog(null, "ERROR No se han encontrado datos con el id: "+texto);
                }
            } catch (Exception e) {

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar" + e.getMessage());
        }
    }

    public void borrar() {
        String id = venta.txtBorr.getText();
        String borrar = "DELETE FROM bdcafeteria.ventas WHERE idventas ='"+id+"'";
        try {

            
            Statement st = con.createStatement();
            int valor = st.executeUpdate(borrar);
            
            if(valor>0){
                JOptionPane.showMessageDialog(null,"Se eliminaron los datos");
            }else{
                JOptionPane.showMessageDialog(null, "ERROR No se han encontrado datos para se eliminados intenta de nuevo");
            
            }
        } catch (Exception e) {

        }
    }
    public void borrarText(){
        venta.txtBorr.setText("");
        venta.txtBorrar.setText("");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == venta.btnBuscar) {
            buscar();
            borrarText();
        }

        if (e.getSource() == venta.btnBorrar) {
            borrar();
            borrarText();
        }
    }

}
