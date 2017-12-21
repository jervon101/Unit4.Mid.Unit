package nyc.c4q.testingshit;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayFragment extends Fragment {
    View view;
    Button button;

    public DisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_display, container, false);


        BottomFragment bottomFragment = new BottomFragment();
        FragmentManager bottommanger =getActivity().getSupportFragmentManager();
        FragmentTransaction bottomTran = bottommanger.beginTransaction();
        bottomTran.replace(R.id.bottomcontainer , bottomFragment);
        bottomTran.commit();

        return view;
    }

}
