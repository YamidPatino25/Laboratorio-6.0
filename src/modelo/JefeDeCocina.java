/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class JefeDeCocina {
    public NodoIng ptringrediente;

    public JefeDeCocina(NodoIng ptrIngrediente) {
       this.ptringrediente = null;
       
    }

    public JefeDeCocina() {
        
    }
    
    public NodoIng agregarPlatos(String nombrePlato, String Ing1, String Ing2, String Ing3, String Ing4, int cant1, int cant2, int cant3, int cant4, NodoIng ptr, int precio){
        NodoIng p = new NodoIng();
        //GUARDO INGREDIENTES Y SU RESPECTIVA CANTIDAD POR PLATO
        p.Plato = nombrePlato;
        p.Ingrediente1 = Ing1;
        p.Ingrediente2 = Ing2;
        p.Igrendiente3 = Ing3;
        p.Ingrediente4 = Ing4;
        p.Cantidad1 = cant1;
        p.Cantidad2 = cant2;
        p.Cantidad3 = cant3;
        p.Cantidad4 = cant4;
        p.precio = precio;
        if(ptr == null){
          ptr = p;  
        }else{
           NodoIng q = ptr;
            while(q.link != null){
                q = q.link;
            }
            q.link = p; 
        }
     
        return ptr;
        
    }
    public boolean verificarIngredientes(File archivo, String Ing1, String Ing2, String Ing3, String Ing4, int cant1, int cant2, int cant3, int cant4){
       
         boolean I1 = verificar(archivo, Ing1, cant1);
         boolean I2 = verificar(archivo, Ing2, cant2);
         boolean I3 = verificar(archivo, Ing3, cant3);
         boolean I4 = verificar(archivo, Ing4, cant4);
        
         if (I1 == true && I2 == true && I3 == true && I4 == true) {
            return true;
         }else{
             if(I1 == false){
                 System.out.println("Insuficiente: "+ Ing1);
             }
             if(I2 == false){
                 System.out.println("Insuficiente: "+ Ing2);
             }
             if(I3 == false){
                 System.out.println("Insuficiente: "+ Ing3);
             }
             if(I4 == false){
                 System.out.println("Insuficiente: "+ Ing4);
             }
           return false;  
             
         }
     
    }
    
    public boolean verificar(File archivo, String Ing, int cant){
        
         try (Scanner lector = new Scanner(archivo)) {
                // Mientras el archivo tenga otra línea.
                while (lector.hasNextLine()) {
                    // Pedir la linea
                    String linea = lector.nextLine();

                    // Separar los datos
                    String[] datos = linea.split(",");

                    // Convertir los datos
                    String ingrediente = datos[0];
                    int cantidad = Integer.parseInt(datos[1]);
                    
                    if(ingrediente.equals(Ing)){
                        ///Verifico si la cantidad es suficiente
                        if (cantidad >= cant) {
                         return true;    
                        }else{
                            JOptionPane.showMessageDialog(null, "No hay suficiente del ingrediente. Vuelva a intentar", "Error", JOptionPane.ERROR_MESSAGE);
                            return false;
                        }
                        
                    }
                    

                }
            } catch (FileNotFoundException ex) {
                // TODO enviar mensaje al usuario
            } catch (NumberFormatException ex) {
                // TODO enviar mensaje al usuario
            } catch (Exception ex) {
                // TODO enviar mensaje al usuario
            }
        
        
        return false;
    }
}
