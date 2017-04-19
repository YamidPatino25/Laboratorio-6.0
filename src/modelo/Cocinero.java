
package modelo;


public class Cocinero {
    public Cocinero(){
        
        
    }
    
    
    public NodoPed agregarPedido(String pedido, int cant, String mesero, String mesa, NodoPed ptrFacturas){
        NodoPed p = new NodoPed();
        
        p.Pedido = pedido;
        p.cantidad = cant;
        p.mesero = mesero;
        p.mesa = mesa;
        
        if(ptrFacturas == null){
          ptrFacturas = p;  
        }else{
           NodoPed q = ptrFacturas;
            while(q.link != null){
                q = q.link;
            }
            q.link = p; 
        }
        
        return ptrFacturas;
    }
}
