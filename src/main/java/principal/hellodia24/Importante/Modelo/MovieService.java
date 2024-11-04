package principal.hellodia24.Importante.Modelo;

import principal.hellodia24.Importante.ModeloDAO.MovieDAO;

import java.util.List;
import java.util.Optional;

public class MovieService {

// TODO: pq necesitamos hacer este paso? Es decir, porq no cogemos la lista de MovieDAO
//    En MovieDAO solo tienes la lógica de acceso a la base de datos (cómo conectar y obtener los datos),
//    mientras que en MovieService ovieService se encarga de la lógica de negocio, por ejemplo hacer filtros...
//    mostrar peliculas para mayores de 18 años.
    public List<Movie> getListMovieFromService(){

        MovieDAO dao = new MovieDAO();
        List<Movie> list = dao.getAllMovieFromBD();

        return list;
    }

    public Optional<Movie> getMovieById(int id){
        MovieDAO dao = new MovieDAO();
        Movie movie = dao.getMovieByID(Long.valueOf(id));

        return Optional.of(movie);
    }


    public void updateMovie(Movie updatedMovie) {
        MovieDAO dao = new MovieDAO();
        dao.modificarPelicula(updatedMovie);
    }

    public void removePeliculaById(int id) {
        MovieDAO dao = new MovieDAO();
        dao.eliminarPeliculaByID(Long.valueOf(id));
    }

    public void crearMovie(Movie crearPelicula) {
        MovieDAO dao = new MovieDAO();
        Long id = dao.obtenerUltimoID();
        crearPelicula.setId(id + 1);

        dao.crearPelicula(crearPelicula);
    }
}
