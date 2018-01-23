package hello.supinternet.com.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();
    }

    private void setViews() {
        Button button = (Button) findViewById(R.id.mySuperButton);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText textInput = (EditText) findViewById(R.id.mySuperText);
                Activity1.startActivity(MainActivity.this.getApplicationContext(), textInput.getText().toString());
            }
        });
    }
}
