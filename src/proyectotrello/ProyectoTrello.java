/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotrello;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author eliel
 */
public class ProyectoTrello {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Gestion_Usuario tareas = new Gestion_Usuario();
        
        Gestion_Usuario.lista listas = tareas.new lista();
        
        Scanner sc = new Scanner(System.in);
        String titulo, descripcion, fecha, estado;
        
        System.out.println("Introduce el titulo de la tarea");
        titulo = sc.nextLine();
        System.out.println("Introduce la descripcion de la tarea");
        descripcion = sc.nextLine();
        System.out.println("Introduce la fecha limite de la tarea");
        fecha = sc.nextLine();
        System.out.println("Introduce el estado de la tarea");
        estado = sc.nextLine();
        
        Gestion_Usuario.tarea nuevaTarea = tareas.new tarea(titulo, descripcion, fecha, estado);
        
        listas.creaTarea(nuevaTarea);
        
        System.out.println("Tarea creada con exito");
        
        sc.close();
        
    }
    
}
