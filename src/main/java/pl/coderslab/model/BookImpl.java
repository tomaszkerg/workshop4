package pl.coderslab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class BookImpl implements Book{
    private Long id;
    private String isbn;
    private String title;
    private AuthorImpl author;
    private String publisher;
    private String type;
}
