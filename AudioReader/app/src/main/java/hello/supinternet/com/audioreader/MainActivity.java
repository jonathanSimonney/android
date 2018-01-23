package hello.supinternet.com.audioreader;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private boolean serviceBound = false;
    private AudioReaderService audioService;
    private boolean isPlaying = false;
    private Button playPause;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            AudioReaderService.LocalBinder binder = (AudioReaderService.LocalBinder) iBinder;
            AudioReaderService mService = binder.getService();

            MainActivity.this.serviceBound = true;
            MainActivity.this.audioService = mService;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.playPause = findViewById(R.id.playButton);

        Intent serviceIntent = new Intent(this, AudioReaderService.class);
        bindService(serviceIntent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    public void click(View view) {
        if (this.serviceBound){
            switch (view.getId()){
                case R.id.playButton:
                {
                    handlePlayClick();
                }
                break;
                case R.id.stopButton:
                    this.audioService.stop();
                    this.isPlaying = false;
                    this.playPause.setText(R.string.playText);
                    break;
            }
        }
    }

    private void handlePlayClick() {
        if (this.isPlaying){
            this.audioService.pause();
            this.playPause.setText(R.string.playText);
        }else{
            this.audioService.launch();
            this.playPause.setText(R.string.pause);
        }

        this.isPlaying = !this.isPlaying;
    }
}
