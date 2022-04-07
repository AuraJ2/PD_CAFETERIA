
package Controladores;

import Vistas.FrmPagoTarjeta;
import Vistas.Login;
import conexion.AccionesMBD;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class ControladorPagoTarjeta implements ActionListener{
    private AccionesMBD a;
    private FrmPagoTarjeta p;

    public ControladorPagoTarjeta(AccionesMBD a, FrmPagoTarjeta p) {
        this.a = a;
        this.p = p;
        this.p.btnAceptar.addActionListener(this);
    }
    
     public void Centrar(FrmPagoTarjeta a) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - a.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - a.getHeight()) / 2);
        a.setLocation(x, y);
        a.setLocation(x, y);
    }
    public void guardarPago(){
        String leyenda = "";
        
        leyenda = a.registrarAlta("tbpagotarjeta",  " null, ' " +p.txtNumeroDeTarjeta.getText()+"','" +p.txtFechaDeVencimiento.getText()+"',"+p.pswClaveDeSeguridad.getText());
        
        JOptionPane.showMessageDialog(null,leyenda);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == p.btnAceptar){
            guardarPago();
        }
    }
    
}
