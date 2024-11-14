import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class documentos {


    public static String leerArchivo(String direccion) throws IOException {

        File archivo = new File(direccion);

        if (!archivo.exists()) {
            return null;
        }

        BufferedReader lector = new BufferedReader(new FileReader(direccion));
        StringBuilder contenido = new StringBuilder();
        String lineaActual = lector.readLine();

        if (lineaActual != null) {
            contenido.append(lineaActual);
            while ((lineaActual = lector.readLine()) != null) {
                contenido.append("\n").append(lineaActual);
            }
        }
        lector.close();
        return contenido.toString();
    }
}
