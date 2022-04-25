package emt.lab2backend.service;

import emt.lab2backend.model.Book;
import emt.lab2backend.model.DTO.BookDTO;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public List<Book> findAll();
    public Optional<Book> findById(Long id);
    public Optional<Book> add(BookDTO bookDTO);
    public Optional<Book> edit(Long id, BookDTO bookDTO);
    public void delete(Long id);
    public void MarkAsTaken(Long id);
}
