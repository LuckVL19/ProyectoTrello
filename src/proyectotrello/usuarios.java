public class usuarios {

        int id;
        String nombre;
         String apellido;
         String cedula;
         String nombreDeUsuario;
         String contrasena;
         String rol;

        private static int contadorId = 1; // Controla el total de usuarios creados

        public usuarios(String nombre, String apellido, String cedula, String nombreDeUsuario,String rol, String contrasena) {
            this.id = contadorId++;
            this.nombre = nombre;
            this.apellido = apellido;
            this.cedula = cedula;
            this.nombreDeUsuario = nombreDeUsuario;
            this.contrasena = contrasena;
            this.rol = rol;

        }

        public String informacionUsuario() {
            return "ID: " + this.id + "Nombre: " + this.nombre + " Apellido: " +" Usuario: " + this.nombreDeUsuario + " Rol: " + this.rol + this.apellido +" Cedula: " + this.cedula;
        }

        //inicia se sesion comprobando el usuario y la pass
        public boolean sesion(String usuario, String pass) {
            return this.nombreDeUsuario.equals(usuario) && this.contrasena.equals(pass);
        }

}
