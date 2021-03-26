package edu.temple.bookshelf;

import java.util.ArrayList;

public class BookList {
    private ArrayList<Book> Books;

    public BookList() {

    }

    void add(Book book) {
        Books.add(book);
    }

    void remove(Book book) {
        Books.remove(book);
    }

    Book get(int position) {
        return Books.get(position);
    }

    int size(){
        return Books.size();
    }

    // adds some books with very boring titles and strange but presciently named authors
    void addSomeBooks(int amount) {
        for( int i =0; i<amount; i++) {
            String title = "Title " + i;
            String author = "Author " + i;
            Book b = new Book(title, author);
            add(b);
        }
    }

}
