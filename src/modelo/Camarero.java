/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import modelo.NodoPed;

public class Camarero {

    NodoPed ptrPedidos;

    public Camarero() {
        this.ptrPedidos = null;

    }

    public NodoPed agregarPedido(String pedido, int precio, int cantidad, String mesa, String mesero, NodoPed ptrPedidos) {

        NodoPed p = new NodoPed();
        p.Pedido = pedido;
        p.cantidad = cantidad;
        p.mesa = mesa;
        p.mesero = mesero;
        p.precio = precio;

        if (ptrPedidos == null) {
            ptrPedidos = p;
        } else {
            NodoPed q = ptrPedidos;
            while (q.link != null) {
                q = q.link;
            }
            q.link = p;
        }

        return ptrPedidos;

    }

}
