package principal.hellodia24.Importante.Interfaces;

import principal.hellodia24.Importante.Modelo.Movie;

import java.util.List;

public interface MovieDao {
    List<Movie> getMovies();
    Movie findMovieById(Long id);
}
