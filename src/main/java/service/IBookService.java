package service;

import model.Book;

import java.util.List;

public interface IBookService {

    //satılan kitaplar
    public List<Book> findSolded();

    //bütün kitapları bul
    public List<Book> findAll();

    //yeni kitap ekle
    public Book addNewBook(Book book);

    //kitap güncelle
    public Book updateBook(Book book);

    //kitap sil
    public void deleteBook(Book book);




}
