package repository;

import model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
    //find book
    Book findBook(Book book);

    //book ekle
    Book addBook(Book book);

    //book sil
    void deleteBook(Book book);
}
