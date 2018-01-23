package hello.supinternet.com.fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements MyFragment.MyFragmentInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNewFragment(1);
    }

    public void createNewFragment(int index){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        MyFragment fragment = MyFragment.newInstance(index);
        fragmentTransaction.replace(R.id.myFragmentContainer, fragment);

        if (index % 2 != 0){
            Log.e("added", "to backStack");
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.commit();
    }

    public void onBackPressed(){
        if (getFragmentManager().getBackStackEntryCount() > 0){
            getFragmentManager().popBackStack();
        } else{
            super.onBackPressed();
        }
    }
}
