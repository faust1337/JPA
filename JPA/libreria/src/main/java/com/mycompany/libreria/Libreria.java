package com.mycompany.libreria;

import com.mycompany.libreria.entidades.Autor;
import com.mycompany.libreria.servicios.AutorServicio;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Libreria {

    public static void main(String[] args) throws Exception {
        AutorServicio autorsvc = new AutorServicio();
        //Autor asd = autorsvc.cargarAutor();
        //autorsvc.mostrarTabla();
        autorsvc.modificarAutor();
    }
}
