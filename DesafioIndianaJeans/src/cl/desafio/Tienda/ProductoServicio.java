package cl.desafio.Tienda;

import java.util.ArrayList;

public class ProductoServicio {

    //atributos
    ArrayList<Producto> listaProductos = new ArrayList<>();

    //metodos


    public ProductoServicio() {
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void listarProductos(){

     for (Producto producto: listaProductos){
         System.out.println("\n" + producto + "\n");
     }
  }


  public void agregarProducto(Producto producto){
        listaProductos.add(producto);
  }


}
