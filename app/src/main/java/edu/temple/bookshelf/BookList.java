package edu.temple.bookshelf;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class BookList implements Parcelable {

    private ArrayList<Book> books;

    public BookList() {
        books = new ArrayList<Book>();
    }

    protected BookList(Parcel in) {
        books = in.createTypedArrayList(Book.CREATOR);
    }

    public static final Creator<BookList> CREATOR = new Creator<BookList>() {
        @Override
        public BookList createFromParcel(Parcel in) {
            return new BookList(in);
        }

        @Override
        public BookList[] newArray(int size) {
            return new BookList[size];
        }
    };

    void add(Book book) {
        books.add(book);
    }

    void remove(Book book) {
        books.remove(book);
    }

    Book get(int position) {
        return books.get(position);
    }

    int size(){
        return books.size();
    }

    // adds some books with very boring titles and strange but presciently named authors
    void addSomeBooks(int amount) {
        for( int i =0; i<amount; i++) {
            String title = "Title " + i;
            String author = "Author " + i;
            Book b = new Book(title, author);
            books.add(b);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(books);
    }
}
