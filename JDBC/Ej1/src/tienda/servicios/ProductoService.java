package tienda.servicios;

import tienda.entidades.Producto;
import tienda.persistencia.ProductoDAO;

public class ProductoService {
    private ProductoDAO dao;
    
    public ProductoService(){
        this.dao = new ProductoDAO();
    }
    
    public void crearProducto(int codigo, String nombre, double precio, int codigoFabricante) throws Exception{
        try {
            if(dao.buscarCodigoProducto(codigo)!=null){
                throw new Exception("Ya existe un producto con el código indicado " + codigo);
            }
            Producto p = new Producto(codigo, codigoFabricante, precio, nombre);
            dao.guardarProducto(p);
        } catch (Exception e) {
            throw e;
        }
    }
}
