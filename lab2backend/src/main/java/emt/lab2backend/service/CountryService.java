package emt.lab2backend.service;

import emt.lab2backend.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    public List<Country> findAll();
    public Optional<Country> findById(Long id);
}
