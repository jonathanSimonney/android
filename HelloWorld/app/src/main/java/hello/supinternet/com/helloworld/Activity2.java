package hello.supinternet.com.helloworld;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity2 extends AppCompatActivity {

    public static void startActivity(Context context){
        Intent intent = new Intent(context, Activity2.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        setViews();
    }

    private void setViews() {
        Button button = (Button) findViewById(R.id.mySuperButton);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Activity3.startActivity(Activity2.this.getApplicationContext());
            }
        });
    }
}
