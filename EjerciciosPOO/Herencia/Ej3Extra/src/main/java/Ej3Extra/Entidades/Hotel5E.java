//Hotel 5E Cantidad de Habitaciones, Número de camas, Cantidad de Pisos, Gimnasio,
//Nombre del Restaurante, Capacidad del Restaurante, Cantidad Salones de
//Conferencia, Cantidad de Suites, Cantidad de Limosinas, Precio de las Habitaciones.
package Ej3Extra.Entidades;
public final class Hotel5E extends Hotel4E{
    private int cantSalonesConferencia, cantSuites, cantLimosinas;

    public Hotel5E(int cantSalonesConferencia, int cantSuites, int cantLimosinas, char gimnasio, String nombreRestaurante, int capacidadRestaurante, int cantHab, int cantCamas, int cantPisos, Integer precioHab, String nombre) {
        super(gimnasio, nombreRestaurante, capacidadRestaurante, cantHab, cantCamas, cantPisos, precioHab, nombre);
        this.cantSalonesConferencia = cantSalonesConferencia;
        this.cantSuites = cantSuites;
        this.cantLimosinas = cantLimosinas;
    }
    
    public int getCantSalonesConferencia() {
        return cantSalonesConferencia;
    }

    public void setCantSalonesConferencia(int cantSalonesConferencia) {
        this.cantSalonesConferencia = cantSalonesConferencia;
    }

    public int getCantSuites() {
        return cantSuites;
    }

    public void setCantSuites(int cantSuites) {
        this.cantSuites = cantSuites;
    }

    public int getCantLimosinas() {
        return cantLimosinas;
    }

    public void setCantLimosinas(int cantLimosinas) {
        this.cantLimosinas = cantLimosinas;
    }
    
    @Override
    public int precioHabitacion(){
        precioHab = super.precioHabitacion();
        return precioHab + 15*cantLimosinas;
    }
}