package pl.coderslab.DataBaseService;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import pl.coderslab.model.AuthorImpl;
import pl.coderslab.model.BookImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
public class MemoryAuthorService implements AuthorService{

    private List<AuthorImpl> authors;
    private static Long nextId = 2L;

    public MemoryAuthorService(){
        authors = new ArrayList<>();
        authors.add(new AuthorImpl(1L,"Bruce","Trelski"));
        authors.add(new AuthorImpl(2L,"Bruce","Trelski"));
        authors.add(new AuthorImpl(3L,"Bruce","Trelski"));
        authors.add(new AuthorImpl(4L,"Bruce","Trelski"));
    }


    @Override
    public Optional<AuthorImpl> getAuthorById(long id) {
        return authors.stream()
                .filter(author -> author.getId()==id)
                .findFirst();
    }

    @Override
    public void addAuthor(AuthorImpl author) {
        author.setId(nextId);
        authors.add(author);
        nextId++;
    }

    @Override
    public void deleteAuthor(long id) {
        authors.removeIf(author -> author.getId()==id);
    }

    @Override
    public void editAuthor(AuthorImpl author) {
        Optional<AuthorImpl> authorById = getAuthorById(author.getId());
        authorById.map(b -> authors.set(authors.indexOf(b),author)).orElseThrow(() -> {
            throw new AuthorNotFoundException();
        });
    }
}
