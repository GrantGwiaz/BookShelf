package edu.temple.bookshelf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BookListFragment.BookListFragmentInterface {


        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        BookListFragment bookListFragment;
        //BookDetailsFragment bookDetailsFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create initial book list and add some boring books
        BookList books = new BookList();
        books.addSomeBooks(10);

        if(getSupportFragmentManager().findFragmentById((R.id.container_1)) instanceof BookListFragment
                && getSupportFragmentManager().findFragmentById((R.id.container_1)) != null )
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .attach(getSupportFragmentManager().findFragmentById((R.id.container_1)))
                    .commit();

        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container_1,BookListFragment.newInstance(books))
                    .commit();
        }


    }

    public void fragmentClick(Book book) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_1, BookDetailsFragment.newInstance(book))
                .addToBackStack(null)
                .commit();
    }


}