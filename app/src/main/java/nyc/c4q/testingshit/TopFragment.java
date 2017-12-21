package nyc.c4q.testingshit;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopFragment extends Fragment {

    TextView title, author, year;

    public TopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_top, container, false);

        title = (TextView) view.findViewById(R.id.title);
        author = (TextView) view.findViewById(R.id.authour);
        year = (TextView) view.findViewById(R.id.year);

       Bundle bundle = getArguments();


        String booktitle = bundle.getString("title");
        String authour = bundle.getString("author");
        int bookyear = bundle.getInt("year");


        title.setText(booktitle);
        author.setText(authour);
        year.setText( bookyear+ "");


        return view;
    }

}
