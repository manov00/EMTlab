package emt.lab2backend.service;

import emt.lab2backend.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    public List<Author> findAll();
    public Optional<Author> findById(Long id);

}
