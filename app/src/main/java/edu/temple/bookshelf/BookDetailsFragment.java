package edu.temple.bookshelf;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class BookDetailsFragment extends Fragment {

    private static final String ARG_BOOK = "param1";

    private Book book;

    TextView title;
    TextView author;

    public BookDetailsFragment() {
        // Required empty public constructor
    }

    public static BookDetailsFragment newInstance(Book book) {

        BookDetailsFragment fragment = new BookDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_BOOK, book);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        if( getArguments() != null) {
            book = getArguments().getParcelable(ARG_BOOK);
        } else {
            book = new Book();
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ConstraintLayout layout = (ConstraintLayout) inflater.inflate(R.layout.fragment_book_details, container, false);

        title = layout.findViewById(R.id.textViewBookTitle);
        author = layout.findViewById(R.id.textViewBookAuthor);

        if (getArguments() == null) {
            book = new Book();
        }
        title.setText(book.getTitle());
        author.setText(book.getAuthor());

        title.setTextSize(25);
        author.setTextSize(20);
        title.setPadding(15, 30,15,0);
        author.setPadding(15, 10,15,0);

        title.setGravity(Gravity.CENTER_HORIZONTAL);
        author.setGravity(Gravity.CENTER_HORIZONTAL);

        return layout;
    }

    public void changeBook(Book book) {
        title.setText(book.getTitle());
        author.setText(book.getAuthor());
    }



}