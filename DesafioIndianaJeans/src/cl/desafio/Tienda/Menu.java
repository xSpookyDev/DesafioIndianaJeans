package cl.desafio.Tienda;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

    public class Menu {
        private final ProductoServicio productoServicio = new ProductoServicio();
        private final ExportadorTxt exportador = new ExportadorTxt();
        private final Scanner sr = new Scanner(System.in);

        public void mostrarMenu() {
            int opcion = 0;
            do {
                System.out.println("1. Listar Producto");
                System.out.println("2. Agregar Producto");
                System.out.println("3. Exportar Datos");
                System.out.println("4. Salir");
                System.out.print("Ingrese una opción: ");

                try {
                    opcion = sr.nextInt();
                    sr.nextLine();
                    switch (opcion) {
                        case 1:
                            productoServicio.listarProductos();
                            break;
                        case 2:
                            agregarProducto();
                            break;
                        case 3:
                            exportarDatos();
                            break;
                        case 4:
                            System.out.println("¡Hasta luego!");
                            break;
                        default:
                            System.out.println("Opción no válida.");
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, ingrese un número válido.");
                    sr.next();
                }
            } while (opcion != 4);
        }

        private void agregarProducto() {
            try {
                System.out.print("Ingresar nombre artículo: ");
                String articulo = sr.nextLine();

                System.out.print("Ingresa precio: ");
                String precio = sr.nextLine();

                System.out.print("Ingresa descripción: ");
                String descripcion = sr.nextLine();

                System.out.print("Ingresa código: ");
                String codigo = sr.nextLine();

                System.out.print("Ingresa talla: ");
                String talla = sr.nextLine();

                System.out.print("Ingresa marca: ");
                String marca = sr.nextLine();

                System.out.print("Ingresa color: ");
                String color = sr.nextLine();

                Producto producto = new Producto(articulo, precio, descripcion,codigo, talla,color);
                productoServicio.agregarProducto(producto);
                System.out.println("¡Producto agregado exitosamente!");
            } catch (Exception e) {
                System.out.println("Error al agregar producto: " + e.getMessage());
            }
        }

        private void exportarDatos() {
            try {
                System.out.print("Ingrese el nombre del archivo para exportar: ");
                String nombreArchivo = sr.nextLine();
                exportador.setNombreArchivo(nombreArchivo);
                List<Producto> listaProductos = productoServicio.getListaProductos();
                if (listaProductos.isEmpty()) {
                    System.out.println("No hay productos para exportar.");
                } else {
                    exportador.exportar(listaProductos);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Nombre de archivo inválido: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error al exportar datos: " + e.getMessage());
            }
        }


    }

