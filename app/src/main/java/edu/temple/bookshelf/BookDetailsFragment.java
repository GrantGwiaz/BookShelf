package edu.temple.bookshelf;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class BookDetailsFragment extends Fragment {

    public BookDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  layout = inflater.inflate(R.layout.fragment_book_list, container, false);

        TextView bookTitle = layout.findViewById(R.id.textViewBookTitle);
        TextView bookAuthor = layout.findViewById(R.id.textViewBookAuthor);



        return layout;
    }

    public static BookDetailsFragment newInstance(Book book) {
        
        Bundle args = new Bundle();
        
        BookDetailsFragment fragment = new BookDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }
}