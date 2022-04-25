package emt.lab2backend.service.impl;

import emt.lab2backend.model.Author;
import emt.lab2backend.model.Book;
import emt.lab2backend.model.DTO.BookDTO;
import emt.lab2backend.model.Exceptions.AuthorNotFoundException;
import emt.lab2backend.model.Exceptions.BookNotFoundException;
import emt.lab2backend.repository.BookRepository;
import emt.lab2backend.service.AuthorService;
import emt.lab2backend.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }


    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> add(BookDTO bookDTO) {
        Author author=authorService.findById(bookDTO.getAuthor()).orElseThrow(AuthorNotFoundException::new);

        Book book=new Book(bookDTO.getName(), author,bookDTO.getCategory(), bookDTO.getAvailableCopies());

        bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, BookDTO bookDTO) {
        Author author=authorService.findById(bookDTO.getAuthor())
                .orElseThrow(AuthorNotFoundException::new);

        Book book= bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);

        book.setName(bookDTO.getName());
        book.setCategory(bookDTO.getCategory());
        book.setAuthor(author);
        book.setAvailableCopies(bookDTO.getAvailableCopies());
        bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public void delete(Long id) {
        Book book= bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        bookRepository.delete(book);

    }

    @Override
    public void MarkAsTaken(Long id) {
        Book book= bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        book.MarkAsTaken();
        bookRepository.save(book);
    }
}
