package hello.supinternet.com.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            IncrementBinderService.LocalBinder binder = (IncrementBinderService.LocalBinder) iBinder;
            IncrementBinderService mService = binder.getService();

            TextView textContainer = (TextView) findViewById(R.id.activityNumber);
            textContainer.setText( String.valueOf(mService.getNbConn()));
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    public static void startActivity(Context context){
        Intent activityIntent = new Intent(context, MainActivity.class);
        context.startActivity(activityIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent serviceIntent = new Intent(this, IncrementBinderService.class);
        bindService(serviceIntent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    public void launchNext(View view) {
        MainActivity.startActivity(MainActivity.this.getApplicationContext());
    }
}
