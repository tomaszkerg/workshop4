package pl.coderslab.DataBaseService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Brak książki o ID")
public class BookNotFoundException extends RuntimeException {
}
