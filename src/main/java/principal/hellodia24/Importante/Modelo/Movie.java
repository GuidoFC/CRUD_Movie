package principal.hellodia24.Importante.Modelo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data



public class Movie {
    private Long id;
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
