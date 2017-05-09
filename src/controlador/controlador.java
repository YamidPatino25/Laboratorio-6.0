package controlador;

import modelo.Camarero;
import modelo.JefeDeCocina;
import modelo.NodoIng;
import java.io.File;
import javax.swing.JOptionPane;
import modelo.Cocinero;
import modelo.NodoPed;

public class controlador {

    JefeDeCocina obj_jefe = new JefeDeCocina();
    Camarero camarero = new Camarero();
    Cocinero cocinero = new Cocinero();

    private NodoIng ptr;  //PTR DE PLATOS
    private NodoPed ptrPedidos;
    private NodoPed ptrFacturas;

    public controlador() {

    }

    public void crearPlato(String NombrePlato, String Ing1, String Ing2, String Ing3, String Ing4, int cant1, int cant2, int cant3, int cant4, File archivo, NodoIng ptr, int precio) {
        //SOLO DEJA AGREGAR PLATOS SI LOS INGREDIENTES SON SUFICIENTES
        if (obj_jefe.verificarIngredientes(archivo, Ing1, Ing2, Ing3, Ing4, cant1, cant2, cant3, cant4) == true) {

            this.ptr = obj_jefe.agregarPlatos(NombrePlato, Ing1, Ing2, Ing3, Ing4, cant1, cant2, cant3, cant4, ptr, precio);

            System.out.println(this.ptr);
            System.out.println("Existen ingredientes necesarios");

        } else {

            System.out.println("No existe ingredientes necesarios");

        }

    }

    public NodoIng getPtr() {

        return this.ptr;
    }

    public void tomarPedido(String tipoPedido, String pedido, int precio, int cantidad, String mesa, String mesero, NodoPed ptrPedidos) {
        this.ptrPedidos = camarero.agregarPedido(tipoPedido, pedido, precio, cantidad, mesa, mesero, ptrPedidos);

    }

    public NodoPed getPtrPedido() {

        return this.ptrPedidos;
    }
    public NodoPed getPtrFacturas(){
        
        return this.ptrFacturas;
    }

    public void cocinar(String pedido, int cant, String mesero, String mesa, NodoPed ptrFacturas, NodoPed ptrPedidos) {

        this.ptrFacturas = cocinero.agregarPedido(pedido, cant, mesero, mesa, ptrFacturas);
        this.ptrPedidos = eliminarPedido(ptrPedidos, pedido, mesero, mesa, cant);
        

    }

    public NodoPed eliminarPedido(NodoPed ptrPedidos, String pedido, String mesero, String mesa, int cant) {

        NodoPed p = new NodoPed();
        p = ptrPedidos;

        NodoPed antp = null;
        while (p.link != null && (pedido != p.Pedido || mesero != p.mesero || mesa != p.mesa || cant != p.cantidad) == true) {
            antp = p;
            p = p.link;

        }
        if (pedido == p.Pedido && mesero == p.mesero && mesa == p.mesa && cant == p.cantidad) {
            if (p == ptrPedidos) {
                ptrPedidos = ptrPedidos.link;
            } else {
                antp.link = p.link;
            }
            p.link = null;

        }
        return ptrPedidos;

    }

}
