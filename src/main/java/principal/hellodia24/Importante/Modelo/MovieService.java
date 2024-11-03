package principal.hellodia24.Importante.Modelo;

import principal.hellodia24.Importante.Interfaces.MovieDao;
import principal.hellodia24.Importante.ModeloDAO.MovieDAO;

import java.util.List;

public class MovieService {


    public List<Movie> getListMovie(){
        MovieDAO dao = new MovieDAO();
        List<Movie> list = dao.listar();

        return list;
    }

}
