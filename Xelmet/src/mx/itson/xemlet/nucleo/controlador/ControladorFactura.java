/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.xemlet.nucleo.controlador;

import javax.swing.JOptionPane;
import mx.itson.xemlet.persistencia.SessionFactura;
import mx.itson.xemlet.persistencia.SessionCliente;
import mx.itson.xemlet.presentacion.Principal;
import mx.itson.xemlet.presentacion.Registro;
import mx.itson.xemlet.presentacion.FrameFactura;
import mx.itson.xemlet.nucleo.entidades.Factura;
/**
 *
 * @author javiershaka
 */
public class ControladorFactura {
    /**
     * en este metodo se verifica que los datos de la factura esten correctos si no entonces no se ejecutara la factura
     */
    public void VerificarFacturar() {
        /**
         * en esta validacion se valida los espacios obtenidos no esten vacios
         */
        if (!FrameFactura.txtAño.getText().isEmpty() && FrameFactura.cbMes.getSelectedIndex() > 0) {
            //se inicia session cliente 
            SessionCliente cliente = new SessionCliente();
            //variable para que acumule los minutos
            int minutos = 0;
            //variable para que acumule las llamadas fijas
            int llamadas = 0;
            //variable para que acumule las llamadas de celular
            int llamadasCelular = 0;
            //variable para que acumule las llamadas realizadas en total
            int llamadasRealizadas;
            //variable para que saque el costo adicional para la llamad apor minuto
            int AdicionalCelular = 0;
            //variable para que acumule el costo adicional de las llamadas fijas
            int AdicionalLlamadas = 0;
            //variable para que acumule el cargo 
            double cargo = 0;
            //variable que acumula el total
            double total;
            //string para que acumule el mes y el año
            String fecha = "" + FrameFactura.cbMes.getSelectedItem().toString().toUpperCase() + "/" + FrameFactura.txtAño.getText().toUpperCase();
            //for para las llamadas
            for (int var = 0; var < Integer.parseInt("" + Registro.txtLlamadasRealizadas.getText()); var++) {
                //condicion para clientes llamadadas que esten en la fecha
                if (cliente.obtenerTodos(Principal.tbClientes.getSelectedRow()).get(Principal.tbClientes.getSelectedRow()).getLlamadas().get(var).getFecha().toUpperCase().contains(fecha.toUpperCase())) {
                    //condicion para las llamadas fijas
                    if (cliente.obtenerTodos(Principal.tbClientes.getSelectedRow()).get(Principal.tbClientes.getSelectedRow()).getLlamadas().get(var).getTipoLlamada().equalsIgnoreCase("FIJA")) {
                        llamadas += 1;
                    }
                    //condicion para llamadas movil
                    if (cliente.obtenerTodos(Principal.tbClientes.getSelectedRow()).get(Principal.tbClientes.getSelectedRow()).getLlamadas().get(var).getTipoLlamada().equalsIgnoreCase("Movil")) {
                        minutos += cliente.obtenerTodos(Principal.tbClientes.getSelectedRow()).get(Principal.tbClientes.getSelectedRow()).getLlamadas().get(var).getDuracionMinutos();
                        llamadasCelular += 1;
                    }

                }
            }
            //metodos de sumas y restas
            llamadasRealizadas = llamadas + llamadasCelular;
            FrameFactura.txtLlamadasFijas.setText("" + llamadas);
            FrameFactura.txtMinutosCelular.setText("" + minutos);
            FrameFactura.txtLlamadasRealizadas.setText("" + llamadasRealizadas);
            llamadas = llamadas - cliente.obtenerTodos(Principal.tbClientes.getSelectedRow()).get(Principal.tbClientes.getSelectedRow()).getPaquete().getLlamadasFijas();
            minutos = minutos - cliente.obtenerTodos(Principal.tbClientes.getSelectedRow()).get(Principal.tbClientes.getSelectedRow()).getPaquete().getMinutosACelular();
            //condiciones para el cobro adicional
            if (llamadas > 0) {
                AdicionalLlamadas = llamadas * cliente.obtenerTodos(Principal.tbClientes.getSelectedRow()).get(Principal.tbClientes.getSelectedRow()).getPaquete().getCostoAdicionalPorLlamada();
            } else {
                AdicionalLlamadas = 0;
            }
            if (minutos > 0) {
                AdicionalCelular = minutos * cliente.obtenerTodos(Principal.tbClientes.getSelectedRow()).get(Principal.tbClientes.getSelectedRow()).getPaquete().getCostoAdicionalPorMinitos();
            } else {
                AdicionalCelular = 0;
            }
            cargo = AdicionalCelular + AdicionalLlamadas;
            total = cargo + cliente.obtenerTodos(Principal.tbClientes.getSelectedRow()).get(Principal.tbClientes.getSelectedRow()).getPaquete().getPrecio();
                //se lleman el frame factura
            FrameFactura.txtCostoPaquete.setText(""+cliente.obtenerTodos(Principal.tbClientes.getSelectedRow()).get(Principal.tbClientes.getSelectedRow()).getPaquete().getPrecio());
            FrameFactura.txtCargosAdicionales.setText(""+cargo);
            FrameFactura.txtTotal.setText(""+total);
            //condicion para facturar
            if(llamadasRealizadas>0 ){
                FrameFactura.btnVG.setText("Facturar");
            }
            else{
                JOptionPane.showMessageDialog(null,"La fecha que ingreso no coincide con algun registro","Aviso" ,JOptionPane.INFORMATION_MESSAGE);
            }
           
        }

    }
    /**
     * Metodo donde se agrega una factura 
     */
    public void AgregarFactura(){
        Factura factura = new Factura();
        factura.setCargosAdicionales(Double.parseDouble(""+FrameFactura.txtCargosAdicionales.getText()));
        factura.setCostoPaquete(Double.parseDouble(""+FrameFactura.txtCostoPaquete.getText()));
        factura.setFecha(""+FrameFactura.cbMes.getSelectedItem().toString()+"/"+FrameFactura.txtAño.getText());
        factura.setIdCliente(Integer.parseInt(""+Registro.txtRegistroCliente.getText()));
        factura.setLlamadasFijas(Integer.parseInt(""+FrameFactura.txtLlamadasFijas.getText()));
        factura.setLlamadasMovil(Integer.parseInt(""+FrameFactura.txtMinutosCelular.getText()));
        factura.setLlamadasRealizadas(Integer.parseInt(""+FrameFactura.txtLlamadasRealizadas.getText()));
        factura.setNombre(""+Registro.txtNombreCliente.getText());
        factura.setTotal(Double.parseDouble(""+FrameFactura.txtTotal.getText()));
        new SessionFactura().AgregarFactura(factura);
    }

}
