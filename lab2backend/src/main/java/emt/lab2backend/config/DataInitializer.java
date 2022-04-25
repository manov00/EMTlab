package emt.lab2backend.config;


import emt.lab2backend.model.Author;
import emt.lab2backend.model.Book;
import emt.lab2backend.model.Country;
import emt.lab2backend.model.ENUM.Category;
import emt.lab2backend.repository.AuthorRepository;
import emt.lab2backend.repository.BookRepository;
import emt.lab2backend.repository.CountryRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;
    private final BookRepository bookRepository;

    public DataInitializer(AuthorRepository authorRepository, CountryRepository countryRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void initData() {

        Country macedonia=new Country("Macedonia","Europe");
        Country canada=new Country("Canada","North America");
        Country germany=new Country("Germany","Europe");
        Country norway=new Country("Norway", "Europe");
        Country senegal=new Country("Senegal","Africa");
        Country brazil=new Country("Brazil","South America");
        Country china=new Country("China","Asia");
        Country poland=new Country("Poland","Europe");
        countryRepository.save(macedonia);
        countryRepository.save(canada);
        countryRepository.save(germany);
        countryRepository.save(norway);
        countryRepository.save(senegal);
        countryRepository.save(brazil);
        countryRepository.save(china);
        countryRepository.save(poland);

        Author goranStefanovski=new Author("Goran","Stefanovski",macedonia);
        Author ristoKrle=new Author("Risto", "Krle",macedonia);
        Author josephBoyden=new Author("Joseph","Boyden",canada);
        Author pauloCoelho=new Author("Paulo","Coelho",brazil);
        Author olgaTokarczuk=new Author("Olga","Tokarczuk",poland);
        Author luXun=new Author("Lu","Xun",china);
        Author jonNesbo=new Author("Jon","Nesbo",norway);
        Author mariamaBa=new Author("Mariama","Ba",senegal);
        authorRepository.save(goranStefanovski);
        authorRepository.save(ristoKrle);
        authorRepository.save(josephBoyden);
        authorRepository.save(pauloCoelho);
        authorRepository.save(olgaTokarczuk);
        authorRepository.save(luXun);
        authorRepository.save(jonNesbo);
        authorRepository.save(mariamaBa);

        //Books
        Book divoMeso=new Book("Divo meso", goranStefanovski,Category.NOVEL,15);
        Book pariteSeOtepuvacka=new Book("Parite se otepuvacka",ristoKrle,Category.BIOGRAPHY,20);
        Book theOrenda=new Book("The Orenda",josephBoyden,Category.NOVEL,5);
        Book theAlchemist=new Book("The Alchemist",pauloCoelho,Category.DRAMA,40);
        Book flights=new Book("Flights", olgaTokarczuk,Category.FANTASY,3);
        Book hometown=new Book("Hometown",luXun,Category.THRILLER,7);
        Book twelve=new Book("Twelve",jonNesbo,Category.NOVEL, 12);
        Book scarletSong=new Book("Scarlet Song",mariamaBa,Category.CLASSICS,16);
        bookRepository.save(divoMeso);
        bookRepository.save(pariteSeOtepuvacka);
        bookRepository.save(theOrenda);
        bookRepository.save(theAlchemist);
        bookRepository.save(flights);
        bookRepository.save(hometown);
        bookRepository.save(twelve);
        bookRepository.save(scarletSong);
    }
}
