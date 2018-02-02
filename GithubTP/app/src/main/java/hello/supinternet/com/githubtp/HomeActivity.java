package hello.supinternet.com.githubtp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setViews();
    }

    private void setViews() {
        Button button = (Button) findViewById(R.id.mySuperButton);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText textInput = (EditText) findViewById(R.id.mySuperText);
                MainActivity.startActivity(HomeActivity.this.getApplicationContext(), textInput.getText().toString());
            }
        });
    }

}
