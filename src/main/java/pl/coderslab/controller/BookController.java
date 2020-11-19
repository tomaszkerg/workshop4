package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.DataBaseService.AuthorService;
import pl.coderslab.DataBaseService.BookNotFoundException;
import pl.coderslab.DataBaseService.BookService;
import pl.coderslab.model.AuthorImpl;
import pl.coderslab.model.BookImpl;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;
    private AuthorService authorService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }


    @RequestMapping("/helloBook")
    public BookImpl helloBook() {
//        List<AuthorImpl> authors = authorService.getAuthors();
        AuthorImpl author = new AuthorImpl(7L,"kupa","sraka");
        return new BookImpl(1L, "9788324631766", "Thinking in Java",
                author, "Helion", "programming");
    }
    @GetMapping("")
    public List<BookImpl> getList() {
        return bookService.getBooks();
    }
    @PostMapping("")
    public void addBook(@RequestBody BookImpl book){
        bookService.addBook(book);
    }

    @GetMapping("/{id}")
    public BookImpl getBook(@PathVariable long id){
        return bookService.getBookById(id).orElseThrow(() -> {
            throw new BookNotFoundException();
        });
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id){
        bookService.deleteBook(id);
    }

    @PutMapping("")
    public void editBook(@RequestBody BookImpl book){
        bookService.editBook(book);
    }
}
