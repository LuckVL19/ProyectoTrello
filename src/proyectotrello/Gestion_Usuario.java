/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotrello;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author eliel
 */
public class Gestion_Usuario {
   // aca esta la creacion de la clase de tarea
    public class tarea {
        public String titulo;
        public String descripcion;
        public String fecha;
        public String asigUser;
        // este constructor es para crear instancias de la clase tarea
        public tarea(String titulo, String descripcion, String fecha, String asigUser){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.asigUser = null;
        }
        
        public void asignarUsuario(String usuario) {
        this.asigUser = usuario;
        }
        
        @Override
        public String toString() {
            return titulo + "," + descripcion + "," + fecha;
        }
        
    }
    
    // aca se crea el nodo de inicio
    class nodo {
        tarea tarea;
        nodo sig;
    }
    // creacion de la listas
    class lista {
        nodo L;
        nodo aux;
        
        lista(){
            L = null;
        }
        // aca se crea la tarea y se guerda en la lista
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
                }
              aux.sig = nuevoEspacio;
            }
        }
        // aca muestras todas las tareas de una lista
        public void verTarea() {
          aux = L;
          if (aux == null){
              System.out.println("no hay ninguna tarea");
          } else {
              while (aux != null){
                  System.out.println(aux.tarea.titulo);
                  System.out.println(aux.tarea.descripcion);
                  System.out.println(aux.tarea.fecha);
                  System.out.println();
                  aux = aux.sig;
              }
           }
        }
        // aca sirve para eliminar las tareas de la lista y si la lista esta en la primera
        //posicion entonces la borra
        public boolean eliminar(String titulo) {
            aux = L;
            if (L == null) {
               System.out.println("lista vacia");
               return false;
            }
            
            if (L.tarea.titulo.equals(titulo)) {
                L = L.sig;
                System.out.println("tarea " + titulo + " eliminada");
                return true;
            }
            
            nodo ant = L;
            while (aux != null) {
                if (aux.tarea.titulo.equals(titulo)) {
                    ant.sig = aux.sig;
                    System.out.println("tarea " + titulo + " eliminada");
                    return true;
                }
                ant = aux;
                aux = aux.sig;
            }   
            System.out.println("no se encontro la tarea con el titulo " + titulo);
            return false;
        }
        //esta funcion es para poder crear un archivo txt
        // verifica si ya existe un archivo de la lista o no
        public void guardarListaEnArchivo(String nombreArchivo) throws IOException {
            
            File file = new File(nombreArchivo);
            
             if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter escri = new BufferedWriter(new FileWriter(nombreArchivo));
            nodo aux = L;
            while (aux != null) {
                escri.write(aux.tarea.toString());
                escri.newLine();
                aux = aux.sig;
            }
            escri.close();
            System.out.println("lista guardada en " + nombreArchivo);
        }
        //funcion para asignar una tarea de la lista pendiente a un usuario
        public boolean asigUserTarea (String titulo, String usuario) {
            aux = L;
            while (aux != null) {
                if (aux.tarea.titulo.equals(titulo)) {
                    aux.tarea.asignarUsuario(usuario);

                    asignada.creaTarea(aux.tarea);
                    eliminar(titulo);
                    System.out.println("tarea asignada a " + usuario);
                    return true;
                }   
                aux = aux.sig;
            }
            System.out.println("no se encontró la tarea con el título " + titulo);
            return false;
        }
    
  
    
        lista pendiente = new lista();
        lista asignada = new lista();
        lista enCurso = new lista();
        lista completadas = new lista();
    }
        
    
    
}


//    ___
//   | / |
//   | / |
//   | / |
//   | / |
//   | / |______
//   | / / / / /|
//   |_/_/_/_/_/|