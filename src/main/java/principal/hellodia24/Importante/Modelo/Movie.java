package principal.hellodia24.Importante.Modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

//07/11
// podemos usar LOMBOK { allArgsConstrcutor, Data, NoArgsConstructor
//
// si en esta variable Entity no decimos nada, supondra que el nombre es Movie (q es el nombre de la clase)
@Entity
// nombre de la tabla de mi BD
@Table(name = "movies")
// Tengo que buscar como relacionar las tablas
//@ManyToOne
public class Movie {
    // especificar el ID, y le decimos que es Autoincrement
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    Si el nombre de la columna no coincide con el atributo tenemos en esta clase tenemos q que usar @Column
//    @Column(name = "titol")
    private String title;
    private String description;
    private Integer year;

    public Movie(){

    }
    public Movie(Long id, String title, String description, Integer year) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
