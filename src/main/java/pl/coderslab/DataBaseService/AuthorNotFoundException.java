package pl.coderslab.DataBaseService;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Brak autora o ID")
public class AuthorNotFoundException extends RuntimeException{
}
