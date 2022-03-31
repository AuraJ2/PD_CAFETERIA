package Controladores;

import Vistas.Login;
import Vistas.MenuPrincipal;
import conexion.AccionesMBD;
import conexion.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ControladorLogin implements ActionListener {

    private Login login;
    private AccionesMBD b;
    Conexion conexion = new Conexion("com.mysql.cj.jdbc.Driver", "jdbc:mysql://locallhost:3306/bdcafeteria", "root", "6*8ny3FEtihK");
    Connection con = conexion.ObtenerConexion();

    public void Ingresar() {
        int resultado = 0;

        String usuario = String.valueOf(login.txtUsuario.getText());
        String contra = String.valueOf(login.txtContraseña.getText());
        String SQL = "SELECT * FROM tblogin WHERE Usuario='" + usuario + "' AND pasword='" + contra + "' ";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            if (rs.next()) {
                resultado = 1;

                if (resultado == 1) {
                    AccionesMBD objMBD = new AccionesMBD();
                    MenuPrincipal menu = new MenuPrincipal();
                    MenuControl Cventa = new MenuControl(menu, objMBD);
                    
                    menu.setVisible(true);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Error el usuario o contraseña no son correctos");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
    }

    public ControladorLogin(Login login, AccionesMBD b) {
        this.login = login;
        this.b = b;
        this.login.btnIngresar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String leyenda = "";

        if (e.getSource() == login.btnIngresar) {
            Ingresar();
        }

    }
}
