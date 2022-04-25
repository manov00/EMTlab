package emt.lab2backend.web;

import emt.lab2backend.model.Country;
import emt.lab2backend.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/country")
public class CountryRestController {
    private final CountryService countryService;

    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }
    @GetMapping
    public List<Country> findAllCountries(){
        return countryService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Country> findCountryById(@PathVariable Long id){
        return countryService.findById(id)
                .map(country->ResponseEntity.ok().body(country))
                .orElseGet(()->ResponseEntity.notFound().build());
    }
}
