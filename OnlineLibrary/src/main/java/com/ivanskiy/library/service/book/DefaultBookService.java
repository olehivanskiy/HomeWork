package com.ivanskiy.library.service.book;

import com.ivanskiy.library.model.Author;
import com.ivanskiy.library.model.Book;
import com.ivanskiy.library.repository.AuthorRepository;
import com.ivanskiy.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefaultBookService implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public DefaultBookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.createBook(book);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.getBooks();
    }

    @Override
    public void deleteBook(int id) {
      bookRepository.deleteBook(id);
    }

    @Override
    public List<Book> sortBookByGenre() {
        return bookRepository.getBooks().stream()
                .sorted(Comparator.comparing(Book::getGenre))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> sortBookByAuthor() {
        List<Book> sortResult = new ArrayList<>();
        for (int i = 1; i < authorRepository.getAuthors().size(); i++) {
            List<Long> booksId = authorRepository.getById(i).getBooksId();
            if (booksId.isEmpty()) {

            } else {
                for (int j = 1; j < booksId.size(); j++) {
                    int bookIndex = booksId.get(j).intValue();
                }
            }
        }
        return sortResult;
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.updateBook(book);
    }
}
