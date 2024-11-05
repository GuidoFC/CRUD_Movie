package principal.hellodia24.Importante.Interfaces;

import principal.hellodia24.Importante.Modelo.Movie;
import principal.hellodia24.Importante.Modelo.Usuario;

import java.util.List;

public interface CRUD_User {

    void crearUsuario(Usuario crearUsuario);

    Usuario getUserByID(int id);

    void modificarUsuario(Movie updatedMovie);

    void eliminarUsuario(int id);

    int obtenerUltimoID();


}
