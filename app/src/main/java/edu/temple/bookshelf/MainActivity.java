package edu.temple.bookshelf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements BookListFragment.BookListFragmentInterface {


        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        BookListFragment bookListFragment;
        BookDetailsFragment bookDetailsFragment;


        boolean contain2present;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contain2present = (findViewById(R.id.container_2) != null);
        //create initial book list and add some boring books
        BookList books = new BookList();
        books.addSomeBooks(10);

        if(savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container_1,BookListFragment.newInstance(books))
                    .commit();
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_1,BookListFragment.newInstance(books))
                .commit();

        if (contain2present) {
            bookDetailsFragment = new BookDetailsFragment();

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container_2, bookDetailsFragment)
                    .commit();
        }

    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation ==Configuration.ORIENTATION_LANDSCAPE){

        } else if(newConfig.orientation ==Configuration.ORIENTATION_PORTRAIT) {

        }
    }

    public void fragmentClick(Book book) {
        if(!contain2present) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container_1, BookDetailsFragment.newInstance(book))
                    .addToBackStack(null)
                    .commit();
        } else {
            bookDetailsFragment.changeBook(book);
        }
    }


}