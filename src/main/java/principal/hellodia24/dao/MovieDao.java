package principal.hellodia24.dao;

import principal.hellodia24.model.Movie;

import java.util.List;

public interface MovieDao {
    List<Movie> getMovies();
    Movie findMovieById(Long id);
}
