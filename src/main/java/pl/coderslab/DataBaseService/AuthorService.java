package pl.coderslab.DataBaseService;

import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.model.AuthorImpl;

import java.util.List;
import java.util.Optional;

public interface AuthorService {


    List<AuthorImpl> getAuthors();

    Optional<AuthorImpl> getAuthorById(long id);

    void addAuthor(AuthorImpl book);

    void deleteAuthor(long id);

    void editAuthor(AuthorImpl author);
}
