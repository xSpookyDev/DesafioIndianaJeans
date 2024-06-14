package cl.desafio.Tienda;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExportadorTxt extends Exportador {
    private String nombreArchivo;

    public void setNombreArchivo(String nombreArchivo) {
        if (nombreArchivo == null || nombreArchivo.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del archivo no puede estar vacío");
        }
        this.nombreArchivo = nombreArchivo;
    }


    public void exportar(List<Producto> listaProductos) {
        if (nombreArchivo == null || nombreArchivo.trim().isEmpty()) {
            throw new IllegalStateException("El nombre del archivo no está definido");
        }

        File file = new File(nombreArchivo + ".txt");
        if (file.exists()) {
            System.out.println("El archivo ya existe. Será sobrescrito.");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Producto producto : listaProductos) {
                writer.write(producto.toString());
                writer.newLine();
            }
            System.out.println("Exportación de archivo txt exitosa.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void exportar(ArrayList<Producto> listaProductos) {

    }
}