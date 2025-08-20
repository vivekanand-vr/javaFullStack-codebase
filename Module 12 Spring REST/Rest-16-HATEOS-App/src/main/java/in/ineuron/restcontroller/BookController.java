package in.ineuron.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.response.Book;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@GetMapping(value = "/getBook/{isbn}")
	public ResponseEntity<Book> getBook(@PathVariable("isbn") String isbn) {

		Book book = new Book(isbn, "Spring", 234.5, "RodJhonson");

		Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getAllBooks())
				.withRel("allBooks");

		book.add(link);

		return new ResponseEntity<Book>(book, HttpStatus.OK);

	}
	
	
	@GetMapping(value = "/allBooks")
	public List<Book> getAllBooks() {

		List<Book> bookList = new ArrayList<Book>();

		bookList.add(new Book("ISBN-111", "Spring", 350.5, "RodJhonson"));
		bookList.add(new Book("ISBN-222", "Hibernate", 350.5, "GavinKing"));
		bookList.add(new Book("ISBN-333", "Servlet", 350.5, "KeitySeirra"));

		return bookList;

	}
	
}
