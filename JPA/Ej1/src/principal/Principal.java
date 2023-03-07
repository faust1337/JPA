package principal;

import servicios.AutorServicio;

public class Principal {

    public static void main(String[] args) {
        AutorServicio autorsvc = new AutorServicio();
        autorsvc.crearAutor();
    }
    
}
