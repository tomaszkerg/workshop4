//package pl.coderslab.controller;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import pl.coderslab.DataBaseService.AuthorNotFoundException;
//import pl.coderslab.DataBaseService.AuthorService;
//import pl.coderslab.DataBaseService.BookNotFoundException;
//import pl.coderslab.model.AuthorImpl;
//import pl.coderslab.model.BookImpl;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/authors")
//public class AuthorController {
//
//    private AuthorService authorService;
//
//    public AuthorController(AuthorService authorService){
//        this.authorService = authorService;
//    }
//    @GetMapping("")
//    public List<AuthorImpl> getList() {
//        return authorService.getAuthors();
//    }
//    @PostMapping("")
//    public void addBook(@RequestBody AuthorImpl author){
//        authorService.addAuthor(author);
//    }
//
//    @GetMapping("/{id}")
//    public AuthorImpl getBook(@PathVariable long id){
//        return authorService.getAuthorById(id).orElseThrow(() -> {
//            throw new AuthorNotFoundException();
//        });
//    }
//    @DeleteMapping("/{id}")
//    public void deleteBook(@PathVariable long id){
//        authorService.deleteAuthor(id);
//    }
//
//    @PutMapping("")
//    public void editBook(@RequestBody AuthorImpl author){
//        authorService.editAuthor(author);
//    }
//}
