package tienda.persistencia;

import tienda.entidades.Producto;

public final class ProductoDAO extends DAO {
    
    public void guardarProducto(Producto p) throws Exception{
        try {
            if(p == null){
                throw new Exception("Debe indicar un producto.");
            }
            String sql = "INSERT INTO producto (codigo, nombre, precio, codigo_fabricante)"
                    + "VALUES (" 
                    + p.getCodigo() +",'"
                    +p.getNombre()+"',"
                    +p.getPrecio()+","
                    +p.getCodigo_fabricante()
                    +");";
            instertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificarPrecio(Producto p) throws Exception{
        try {
            if(p == null){
                throw new Exception("Debe indicar un producto a modificar.");
            }
            String sql = "UPDATE producto SET "
                    + "precio = " + p.getPrecio() + " WHERE codigo = " + p.getCodigo()+";";
            instertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminarProducto(int codigo) throws Exception{
        try {
            String sql = "DELETE FROM producto WHERE codigo = " + codigo + ";";
            instertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Producto buscarCodigoProducto(int codigo) throws Exception{
        try {
            String sql = "SELECT * FROM producto "
                    + "WHERE codigo = " + codigo +";";
            consultarBase(sql);
            
            Producto p = null;
            while(resultado.next()){
                p = new Producto();
                p.setCodigo(resultado.getInt(1));
                p.setNombre(resultado.getString(2));
                p.setPrecio(resultado.getDouble(3));
                p.setCodigo_fabricante(resultado.getInt(4));
            }
            desconectarBase();
            return p;
            
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
}

