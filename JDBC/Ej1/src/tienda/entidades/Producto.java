package tienda.entidades;
public class Producto {
    private int codigo, codigo_fabricante;
    private double precio;
    private String nombre;

    public Producto() {
    }

    public Producto(int codigo, int codigo_fabricante, double precio, String nombre) {
        this.codigo = codigo;
        this.codigo_fabricante = codigo_fabricante;
        this.precio = precio;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo_fabricante() {
        return codigo_fabricante;
    }

    public void setCodigo_fabricante(int codigo_fabricante) {
        this.codigo_fabricante = codigo_fabricante;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
