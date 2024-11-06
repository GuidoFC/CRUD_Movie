package principal.hellodia24.Importante.Interfaces;

import principal.hellodia24.Importante.Modelo.Movie;
import principal.hellodia24.Importante.Modelo.Usuario;

public interface CRUD_User {

    void crearUsuarioBD(Usuario crearUsuario);

    Usuario getUserByID(int id);

    void modificarUsuario(Movie updatedMovie);

    void eliminarUsuario(int id);

    int obtenerUltimoID();


}
