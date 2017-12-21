package nyc.c4q.testingshit.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import nyc.c4q.testingshit.Books;
import nyc.c4q.testingshit.JSONModel;
import nyc.c4q.testingshit.R;

/**
 * Created by jervon.arnoldd on 12/20/17.
 */

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BookHolder> {

    List<Books> myBooks;

    public BooksAdapter(List<Books> myBooks) {
        this.myBooks = myBooks;
    }

    public BooksAdapter() {
    }

    @Override
    public BookHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bottom_item_view, parent, false);

        return new BookHolder(view);
    }

    @Override
    public void onBindViewHolder(BookHolder holder, int position) {
        Books books = myBooks.get(position);
        holder.text.setText(books.getAuthor());
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
