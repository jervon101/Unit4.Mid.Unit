package nyc.c4q.testingshit;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.testingshit.view.BooksAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class BottomFragment extends Fragment {
    View view;
    RecyclerView recyclerView;

    List<Books> membersList = new ArrayList<>();
    public BottomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        view = inflater.inflate(R.layout.fragment_bottom, container, false);

        String str = getString();
        JSONModelCon(str);

        recyclerView = (RecyclerView) view.findViewById(R.id.bottomcycle);
        LinearLayoutManager manager = new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false);
        BooksAdapter adapter = new BooksAdapter(membersList);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        Log.e("Display is running ", "");

        return view;


    }

    public void JSONModelCon(String str) {

        try {


            JSONObject jsonObject = new JSONObject(str); // sets my string input as a JSON OBJECT. My string is not an JSONObject yet! We need to set it!
            JSONArray jsonArray = jsonObject.getJSONArray("books"); //lets extract the objects in my array and put them in an arraylist!


            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject1 = (JSONObject) jsonArray.get(i); //this will store each index.       remember to cast!

                String objectTitle = jsonObject1.getString("title");
                String objectAuthor = jsonObject1.getString("author");
                int objectYear = jsonObject1.getInt("year");

                Books name = new Books();
                name.setTitle(objectTitle);
                name.setAuthor(objectAuthor);
                name.setYear(objectYear);

                membersList.add(name);


                Log.e("Final ArrayList", membersList.toString());

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public String getString(){

        String str = "{\n" +
                "  \"books\": [\n" +
                "    {\n" +
                "      \"title\": \"Northanger Abbey\",\n" +
                "      \"author\": \"Austen, Jane\",\n" +
                "      \"year\": 1814\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"War and Peace\",\n" +
                "      \"author\": \"Tolstoy, Leo\",\n" +
                "      \"year\": 1865\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Anna Karenina\",\n" +
                "      \"author\": \"Tolstoy, Leo\",\n" +
                "      \"year\": 1875\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Mrs. Dalloway\",\n" +
                "      \"author\": \"Woolf, Virginia\",\n" +
                "      \"year\": 1925\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"The Hours\",\n" +
                "      \"author\": \"Cunnningham, Michael\",\n" +
                "      \"year\": 1999\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Huckleberry Finn\",\n" +
                "      \"author\": \"Twain, Mark\",\n" +
                "      \"year\": 1865\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Bleak House\",\n" +
                "      \"author\": \"Dickens, Charles\",\n" +
                "      \"year\": 1870\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Tom Sawyer\",\n" +
                "      \"author\": \"Twain, Mark\",\n" +
                "      \"year\": 1862\n" +
                "    }\n" +
                "  ]\n" +
                "}\n";
        return str;
    }
}

