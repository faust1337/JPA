package tienda;

import java.util.logging.Level;
import java.util.logging.Logger;

import tienda.servicios.ProductoService;

public class tienda {

    public static void main(String[] args) {
        ProductoService producir = new ProductoService();
        try {
            producir.crearProducto(69, "Paraguas", 420.69, 3);
        } catch (Exception e) {
            Logger.getLogger(tienda.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    
}
