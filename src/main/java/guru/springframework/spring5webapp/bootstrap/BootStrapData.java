package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		
		Publisher cjFallon = new Publisher("C J Fallon", "Dun Laoghaire", "Dublin", "Co. Dublin", "A94A962");
		
		publisherRepository.save(cjFallon);
		
		Author eric = new Author("Eric", "Evans");
		Book noEJB = new Book ("NoEJB", "12232");
		eric.getBooks().add(noEJB);
		noEJB.getAuthors().add(eric);
		noEJB.setPublisher(cjFallon);
		cjFallon.getBooks().add(noEJB);
		authorRepository.save(eric);
		bookRepository.save(noEJB);
		publisherRepository.save(cjFallon);
		
		Author john = new Author("John", "Thompson");
		Book spring = new Book("Spring", "23435");
		john.getBooks().add(spring);
		spring.getAuthors().add(john);
		spring.setPublisher(cjFallon);
		cjFallon.getBooks().add(spring);
		authorRepository.save(john);
		bookRepository.save(spring);
		publisherRepository.save(cjFallon);
		
		System.out.println(authorRepository.count());
		System.out.println(bookRepository.count());
		
		System.out.println(cjFallon.getBooks().size());

	}

}
