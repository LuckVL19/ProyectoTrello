/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotrello;
import java.io.*;

/**
 *
 * @author eliel
 */
public class Gestion_Usuario {
   
    public class tarea {
        public String titulo;
        public String descripcion;
        public String fecha;
        public String estado; 
        
        public tarea(String titulo, String descripcion, String fecha, String estado){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estado = estado;
        }
    }
    
    
    class nodo {
        tarea tarea;
        nodo sig;
    }
    
    class lista {
        nodo L;
        nodo aux;
        
        lista(){
            L = null;
        }
        
        public void creaTarea(tarea nuevaTarea){
        nodo nuevoEspacio = new nodo();
        nuevoEspacio.tarea = nuevaTarea;
        nuevoEspacio.sig = null;
        
        if (L == null) {
            L = nuevoEspacio;
        } else {
            aux = L;
            while (aux.sig != null) {
                aux = aux.sig;
                aux.sig = nuevoEspacio;
            }
        }
        
    }

}
     Gestion_Usuario;
}
