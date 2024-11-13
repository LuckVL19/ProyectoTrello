/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotrello;

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
        
        public void verTarea() {
          aux = L;
          if (aux == null){
              System.out.println("no hay ninguna tarea");
          } else {
              while (aux != null){
                  System.out.println(aux.tarea.titulo);
                  System.out.println(aux.tarea.descripcion);
                  System.out.println(aux.tarea.fecha);
                  System.out.println(aux.tarea.estado);
                  System.out.println();
                  aux = aux.sig;
              }
          }
        }
    }
    
    
        lista pendiente = new lista();
        lista asignada = new lista();
        lista enCurso = new lista();
        lista completadas = new lista();
    
        public void agregarTarea(tarea nuevaTarea) {
            switch (nuevaTarea.estado.toLowerCase()){
                case "pendiente":
                    pendiente.creaTarea(nuevaTarea);
                    break;
                case "asignada":
                    asignada.creaTarea(nuevaTarea);
                    break;
                case "en Curso":
                    enCurso.creaTarea(nuevaTarea);
                    break;
                case "completadas":
                    completadas.creaTarea(nuevaTarea);
                    break;
                default:
                    System.out.println("no se ha podido agregar la tarea");
                    break;
            }
        }
    
        public void verTodasTareas() {
            System.out.println("tareas pendientes");
            pendiente.verTarea();
            System.out.println("tareas asignadas");
            asignada.verTarea();
            System.out.println("tareas en curso");
            enCurso.verTarea();
            System.out.println("tareas completadas");
            completadas.verTarea();
        }
    
    
}
