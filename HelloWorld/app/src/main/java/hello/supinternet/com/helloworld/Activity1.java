package hello.supinternet.com.helloworld;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity1 extends AppCompatActivity {

    private static final String EXTRA_TEXT = "Activity2";

    public static void startActivity(Context context, String text){
        Intent intent = new Intent(context, Activity1.class);
        intent.putExtra(Intent.EXTRA_TEXT, text);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        String newString = null;
        Bundle extras = getIntent().getExtras();
        if(extras != null && extras.containsKey(Intent.EXTRA_TEXT)) {
            newString = extras.getString(Intent.EXTRA_TEXT);
        }

        setViews(newString);
    }

    private void setViews(String newString) {
        TextView textContainer = (TextView) findViewById(R.id.textContainer);
        textContainer.setText(newString);

        Button button = (Button) findViewById(R.id.mySuperButton);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Activity2.startActivity(Activity1.this.getApplicationContext());
            }
        });
    }
}
