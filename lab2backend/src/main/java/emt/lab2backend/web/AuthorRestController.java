package emt.lab2backend.web;

import emt.lab2backend.model.Author;
import emt.lab2backend.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/author")
public class AuthorRestController {
    private final AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> findAllAuthors(){
        return authorService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Author> findAuthorById(@PathVariable Long id){
        return authorService.findById(id).
                map(author->ResponseEntity.ok().body(author))
                .orElseGet(()->ResponseEntity.notFound().build());
    }
}