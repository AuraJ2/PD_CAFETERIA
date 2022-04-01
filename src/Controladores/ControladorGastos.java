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
import static java.lang.Float.parseFloat;
import static java.lang.String.valueOf;
import java.time.LocalDate;

/**
 *
 * @author gerar
 */
public class ControladorGastos implements ActionListener {

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

            //Variablres Gastos Administrativos
            float SalarioM, ImpuestoM, Prestamos, Otros1, Total;
            //Gastos de Mercadeo
            float Tarjetitas, Otros2;
            //Gastos de Mantenimiento
            float Pintura, Inmuebles, EquipoComputo, Otros3;
            //Gastos Fijos
            float Agua, Gas, Luz, Renta, Telefono, Otros4;
            //Gastos Variables
            float TrasportePrivado, TrasportePublico, Otros5;
            //Gastos Mercancia
            float Alimentos, Bebidas, Desechables, Otros6;

            //Parsear Gastos Administrativos
            SalarioM = parseFloat(a.CajaSm.getText());
            ImpuestoM = parseFloat(a.CajaIm.getText());
            Prestamos = parseFloat(a.CajaPrestamos.getText());
            Otros1 = parseFloat(a.Caja1.getText());
            //Parsear Gastos de Mercadeo
            Tarjetitas = parseFloat(a.CajaTarjeti.getText());
            Otros2 = parseFloat(a.Caja2.getText());
            //Parsear Gastos de Manteniminto
            Pintura = parseFloat(a.CajaPintura.getText());
            Inmuebles = parseFloat(a.CajaInmueble.getText());
            EquipoComputo = parseFloat(a.CajaEquipo.getText());
            Otros3 = parseFloat(a.Caja3.getText());
            //Parsear Gastos Fijos
            Agua = parseFloat(a.CajaAgua.getText());
            Gas = parseFloat(a.CajaGas.getText());
            Luz = parseFloat(a.CajaLuz.getText());
            Renta = parseFloat(a.CajaRenta.getText());
            Telefono = parseFloat(a.CajaTelefono.getText());
            Otros4 = parseFloat(a.Caja4.getText());
            //Parsear Gastos Variables
            TrasportePrivado = parseFloat(a.CajaTrasportePrivado.getText());
            TrasportePublico = parseFloat(a.CajaTrasportePublico.getText());
            Otros5 = parseFloat(a.Caja5.getText());
            //Parsear Gastos Mercancia
            Alimentos = parseFloat(a.CajaAlimentos.getText());
            Bebidas = parseFloat(a.CajaBebidas.getText());
            Desechables = parseFloat(a.CajaDesechable.getText());
            Otros6 = parseFloat(a.Caja6.getText());

            //Operaciones
            Total = SalarioM + ImpuestoM + Prestamos + Otros1 + Tarjetitas + Otros2 + Pintura + Inmuebles + EquipoComputo + Otros3 + Agua + Gas + Luz + Renta + Telefono + Otros4 + TrasportePrivado + TrasportePublico + Otros5 + Alimentos + Bebidas + Desechables + Otros6;

            //Mostrara en panatalla el total
            a.CajaTotal.setText(valueOf(Total));
            
            
            LocalDate dia = LocalDate.now();

            leyenda = b.registrarAlta("gastos", " null, ' " + dia + " ', " + a.CajaTotal.getText());

            System.out.println(leyenda);

        }
    }

}
