package emt.lab2backend.web;

import emt.lab2backend.model.Book;
import emt.lab2backend.model.DTO.BookDTO;
import emt.lab2backend.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/book")
public class BookRestController {
    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> findAllBooks(){
        return bookService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        return bookService.findById(id)
                .map(book->ResponseEntity.ok().body(book))
                .orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody BookDTO bookDto){
        return bookService.add(bookDto)
                .map(book->ResponseEntity.ok().body(book))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> editBook(@PathVariable Long id, @RequestBody BookDTO bookDto){
        return bookService.edit(id,bookDto)
                .map(book->ResponseEntity.ok().body(book))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable Long id){
        this.bookService.delete(id);
        if(this.bookService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
    @PostMapping("/markastaken/{id}")
    public ResponseEntity MarkAsTaken(@PathVariable Long id){
        this.bookService.MarkAsTaken(id);
        return ResponseEntity.ok().build();
    }

}