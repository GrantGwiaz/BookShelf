package edu.temple.bookshelf;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;



public class BookListFragment extends Fragment {

    BookListFragmentInterface parentActivity;

    private static final String ARG_BOOKLIST = "param1";

    private BookList bookList;

    public BookListFragment() {}

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(getActivity() instanceof BookListFragmentInterface) {
            parentActivity = (BookListFragmentInterface) context;
        } else {
            throw new RuntimeException("Please Implement the BookListFragmentInterface");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        parentActivity = null;
    }

    public static BookListFragment newInstance(BookList bookList) {
        BookListFragment fragment = new BookListFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_BOOKLIST, bookList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        if( getArguments() != null) {
            bookList = getArguments().getParcelable(ARG_BOOKLIST);
        } else {
            bookList = new BookList();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ListView  listView = (ListView) inflater.inflate(R.layout.fragment_book_list, container, false);

        BookAdapter adapter = new BookAdapter(getActivity(), bookList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                parentActivity.fragmentClick(bookList.get(position));

            }
        });

        return listView;
    }

    interface  BookListFragmentInterface {
        void fragmentClick(Book book);
    }
}