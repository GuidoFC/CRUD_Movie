package principal.hellodia24.Importante.Interfaces;

import principal.hellodia24.Importante.Modelo.Movie;

import java.util.List;

public interface CRUD {
    public List listar();
    public Movie list(int id);
    public boolean add(Movie movie);
    public boolean edit(Movie movie);
    public boolean eliminar(int id);
}
