import dao.PeliculaDAO;
import model.Pelicula;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {






        Pelicula pelicula = new PeliculaDAO(JdbcUtils.getConnection()).findById(19);
        System.out.println(pelicula);


        //new PeliculaDAO(JdbcUtils.getConnection()).findByYearRange(2000, 2010).forEach(System.out::println);


        //int totalPeliculas = new PeliculaDAO(JdbcUtils.getConnection()).countTotalMovies();
       // System.out.println("Total de películas: " + totalPeliculas);


       // Pelicula peliculaActualizada = new Pelicula(25, "Nueva Película", "Acción", 2020);
        //new PeliculaDAO(JdbcUtils.getConnection()).update(peliculaActualizada);


        //new PeliculaDAO(JdbcUtils.getConnection()).save(new Pelicula(null, "Película de Ciencia Ficción", "Ciencia Ficción", 2024));


       // new PeliculaDAO(JdbcUtils.getConnection()).findAll().forEach(System.out::println);


        //new PeliculaDAO(JdbcUtils.getConnection()).delete(3);
    }
}


