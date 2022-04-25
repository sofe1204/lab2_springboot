package mk.ukim.finki.emt.lab2.service.impl;

import mk.ukim.finki.emt.lab2.model.Author;
import mk.ukim.finki.emt.lab2.model.Book;
import mk.ukim.finki.emt.lab2.model.Category;
import mk.ukim.finki.emt.lab2.model.dto.BookDto;
import mk.ukim.finki.emt.lab2.model.exceptions.AuthorNotFound;
import mk.ukim.finki.emt.lab2.model.exceptions.ProductNotFoundException;
import mk.ukim.finki.emt.lab2.repository.jpa.*;
import mk.ukim.finki.emt.lab2.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;


    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;

        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> findByName(String name) {
        return this.bookRepository.findByName(name);
    }

    @Override
    @Transactional
    public Optional<Book> save(String name,Long categoryId, Long authorId, Integer availableCopies) {
        Author author = this.authorRepository.findById(authorId)
                .orElseThrow(() -> new AuthorNotFound(authorId));
        Category categoryBook = this.categoryRepository.findById(categoryId)
                .orElseThrow(()-> new ProductNotFoundException(categoryId));
        this.bookRepository.deleteByName(name);
        Book book = new Book(name,categoryBook,author,availableCopies);
        this.bookRepository.save(book);
        return Optional.of(book);

    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFound(bookDto.getAuthor()));
        Category categoryBook = this.categoryRepository.findById(bookDto.getCategory())
                .orElseThrow(()-> new ProductNotFoundException(bookDto.getCategory()));
        this.bookRepository.deleteByName(bookDto.getName());
        Book book = new Book(bookDto.getName(),categoryBook,author,bookDto.getAvailableCopies());
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    @Transactional
    public Optional<Book> edit(Long id, String name, Long categoryId, Long authorId, Integer availableCopies) {
        Book book = this.bookRepository.findById(id).orElseThrow(()-> new ProductNotFoundException(id));

        book.setName(name);
        book.setAvailableCopies(availableCopies);

        Category categoryBook = this.categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ProductNotFoundException(categoryId));
        book.setCategory(categoryBook);

        Author author = this.authorRepository.findById(authorId)
                .orElseThrow(() -> new AuthorNotFound(authorId));
        book.setAuthor(author);
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id).orElseThrow(()-> new ProductNotFoundException(id));

        book.setName(bookDto.getName());
        book.setAvailableCopies(bookDto.getAvailableCopies());
        Category categoryBook = this.categoryRepository.findById(bookDto.getCategory())
                .orElseThrow(() -> new ProductNotFoundException(bookDto.getCategory()));
        book.setCategory(categoryBook);

        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFound(bookDto.getAuthor()));
        book.setAuthor(author);

        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public void deleteById(Long id) {
            this.bookRepository.deleteById(id);
    }

    @Override
    public Book availableBooks(Long id) {
        Book Book = bookRepository.findById(id).orElseThrow(()->new ProductNotFoundException(id));
        Book.setAvailableCopies(Book.getAvailableCopies() - 1);
        bookRepository.save(Book);
        return Book;
    }
}
