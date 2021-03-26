package edu.temple.bookshelf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


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

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.listContainer,BookListFragment.newInstance(books))
                .commit();
        /*
        bookListFragment = BookListFragment.newInstance(books);
        //bookDetailsFragment = new BookDetailsFragment();

        fragmentManager = getSupportFragmentManager();

        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.listContainer, bookListFragment);

        fragmentTransaction.commit();

         */
    }


}