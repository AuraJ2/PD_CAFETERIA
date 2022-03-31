/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Vistas.FrmGanancia;
import Vistas.FrmVentas;
import Vistas.Login;
import Vistas.MenuPrincipal;
import conexion.AccionesMBD;
import conexion.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author DELL
 */
public class ControladorGanancia implements ActionListener{

    public ControladorGanancia(FrmGanancia a, AccionesMBD c) {
        this.a = a;
        this.c = c;
        this.a.btnConsultar.addActionListener(this);
    }
    
    
    
    private FrmGanancia a;
    private FrmVentas b;
    private AccionesMBD c;

    Conexion conexion = new Conexion("com.mysql.cj.jdbc.Driver", "jdbc:mysql://127.0.0.1:3306/bdcafeteria", "root", "LeeDoHyunM95");
    Connection con = conexion.ObtenerConexion();
   

    public void Consultar (){
      
   
        //String usuario = String.valueOf(FrmGastos.CajaTotal.getText());
        //String contra = String.valueOf(FrmVentas.t.getText());
        
        String venta = "SELECT * FROM ventas ";
        String gasto = "SELECT * FROM gastos ";
        
        try {
            
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(venta);
            
        if (rs.next()) {
            String total = rs.getString("producto");
            System.out.println(total);
            }
        
        }catch (Exception e){
            
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
     if(e.getSource()== a.btnConsultar) {
       Consultar (); 
     }
    }
    
    
}
