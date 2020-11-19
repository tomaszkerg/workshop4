package pl.coderslab.DataBaseService;

import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.model.BookImpl;

import java.util.List;
import java.util.Optional;

public interface BookService {

    @Autowired
    List<BookImpl> getBooks();

    Optional<BookImpl> getBookById(long id);

    void addBook(BookImpl book);

    void deleteBook(long id);

    void editBook(BookImpl book);

}

