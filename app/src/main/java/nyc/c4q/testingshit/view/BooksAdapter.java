package nyc.c4q.testingshit.view;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

import nyc.c4q.testingshit.Books;
import nyc.c4q.testingshit.R;
import nyc.c4q.testingshit.TopFragment;

/**
 * Created by jervon.arnoldd on 12/20/17.
 */

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BookHolder> {
    View view;
    List<Books> myBooks;

    public BooksAdapter(List<Books> myBooks) {
        this.myBooks = myBooks;
    }

    public BooksAdapter() {
    }

    @Override
    public BookHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bottom_item_view, parent, false);

        return new BookHolder(view);
    }

    @Override
    public void onBindViewHolder(BookHolder holder, int position) {
        final Books books = myBooks.get(position);
        holder.text.setText(books.getTitle());


        holder.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TopFragment fragment = new TopFragment();
                FragmentManager manager = ((FragmentActivity)view.getContext()).getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();

                Bundle bundle = new Bundle();

                bundle.putString("title", books.getTitle().toString());
                bundle.putString("author", books.getAuthor().toString());
                bundle.putInt("year", books.getYear());

                fragment.setArguments(bundle);

                transaction.replace(R.id.topcontainer, fragment);
                transaction.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return myBooks.size();
    }

    class BookHolder extends RecyclerView.ViewHolder {
        TextView text;

        public BookHolder(View itemView) {
            super(itemView);
            text= (TextView) itemView.findViewById(R.id.cycleview);
        }
    }
}
