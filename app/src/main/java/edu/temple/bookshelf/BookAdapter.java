package edu.temple.bookshelf;

import android.content.Context;
import android.media.Image;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class BookAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Book> books;

    public BookAdapter (Context context, ArrayList<Book> books) {
        this.context = context;
        this.books = books;
    }

    @Override
    public int getCount() { return books.size(); }

    @Override
    public Object getItem(int position) {
        return books.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView title;
        TextView author;

        LinearLayout linearLayout;

        if(convertView == null) {
            linearLayout = new LinearLayout(context);
            title = new TextView(context);
            author = new TextView(context);

            linearLayout.setOrientation(LinearLayout.VERTICAL);
            linearLayout.addView(title);
            linearLayout.addView(author);

            title.setTextSize(20);
            author.setTextSize(10);
            title.setPadding(15, 30,15,0);
            author.setPadding(15, 10,15,0);

            title.setGravity(Gravity.CENTER_HORIZONTAL);
            author.setGravity(Gravity.CENTER_HORIZONTAL);


        } else {
            linearLayout = (LinearLayout) convertView;
            title = (TextView) linearLayout.getChildAt(0);
            author = (TextView) linearLayout.getChildAt(1);
        }

        title.setText(books.get(position).getTitle());
        author.setText(books.get(position).getTitle());

        return linearLayout;
    }
}
