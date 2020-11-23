package pl.coderslab.DataBaseService;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.model.Author;
import pl.coderslab.model.AuthorImpl;
import pl.coderslab.model.BookImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service @Data @AllArgsConstructor
public class MemoryBookService implements BookService {
    private List<BookImpl> books;
    private static Long nextId = 6L;
    private AuthorService authorService;
    private  List<AuthorImpl> authorsList;

    @Autowired
    public MemoryBookService(AuthorService authorService){
        books = new ArrayList<>();
        this.authorService = authorService;
        this.authorsList = authorService.getAuthors();
        AuthorImpl author = new AuthorImpl(7L,"tttttt","ssssss");
        books.add(new BookImpl(1L,"9788324631766","Thinking in Java",author,"Helion","programming"));
        books.add(new BookImpl(2L,"9788324631766","Thinking in Java",author,"Helion","programming"));
        books.add(new BookImpl(3L,"9788324631766","Thinking in Java",author,"Helion","programming"));
        books.add(new BookImpl(4L,"9788324631766","Thinking in Java",author,"Helion","programming"));
        books.add(new BookImpl(5L,"9788324631766","Thinking in Java",author,"Helion","programming"));
    }

    @Override
    public Optional<BookImpl> getBookById(long id) {
        return books.stream()
                .filter(b -> b.getId()==id)
                .findFirst();
    }

    @Override
    public void addBook(BookImpl book) {
        book.setId(nextId);
        books.add(book);
        nextId++;
    }

    @Override
    public void deleteBook(long id) {
        books.removeIf(book -> book.getId().equals(id));
    }

    @Override
    public void editBook(BookImpl book) {
        Optional<BookImpl> bookById = getBookById(book.getId());
        bookById.map(b -> books.set(books.indexOf(b),book)).orElseThrow(() -> {
            throw new BookNotFoundException();
        });
    }
}
