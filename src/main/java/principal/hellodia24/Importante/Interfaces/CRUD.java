package principal.hellodia24.Importante.Interfaces;

import principal.hellodia24.Importante.Modelo.Movie;

import java.util.List;

public interface CRUD {
    public List getAllMovieFromBD();
    public Movie list(int id);
    public boolean add(Movie movie);


    Movie getMovieByID(Long id);

    void modificarPelicula(Movie updatedMovie);

    void eliminarPeliculaByID(Long id);

    Long obtenerUltimoID();

    void crearPelicula(Movie crearPelicula);
}
