package pl.coderslab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AuthorImpl implements Author{

    private long id;
    private String firstName;
    private String lastName;
}
