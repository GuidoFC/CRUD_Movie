package principal.hellodia24.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor

public class Movie {
    private Long id;
    private String title;
    private String description;
    private Integer year;

    public Movie(Long id, String title, String description, Integer year) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.year = year;
    }
}
