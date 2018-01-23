package hello.supinternet.com.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class MyFragment extends Fragment {
    public static final String INDEX_KEY = "INDEX_KEY";
    private int index;

    public static MyFragment newInstance(int index){
        MyFragment myFragment = new MyFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(INDEX_KEY, index);

        myFragment.setArguments(bundle);

        return myFragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.my_fragment, container, false);

        setButtonListener(view);

        this.setViewIndex(getArguments(), view);

        //inflate the layout for this fragment
        return view;
    }

    private void setButtonListener(View view) {
        Button myButton = view.findViewById(R.id.mySuperButton);

        myButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((MyFragmentInterface)getActivity()).createNewFragment(MyFragment.this.index + 1);
            }
        });
    }

    private void setViewIndex(Bundle instanceState, View view) {
        TextView index = view.findViewById(R.id.index);

        if (instanceState != null && instanceState.containsKey(INDEX_KEY)){
            this.index = (Integer)instanceState.get(INDEX_KEY);
        }else{
            this.index = 1;
        }

        index.setText(String.valueOf(this.index));
    }

    public interface MyFragmentInterface{
        void createNewFragment(int index);
    }
}
