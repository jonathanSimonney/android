package hello.supinternet.com.audioreader;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

import java.io.IOException;

public class AudioReaderService extends Service {
    private MediaPlayer mediaPlayer = new MediaPlayer();

    public AudioReaderService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.mediaPlayer = MediaPlayer.create(this, R.raw.test);
    }

    // Binder given to clients
    private final IBinder mBinder = new LocalBinder();

    /**
     * Class used for the client Binder.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with IPC.
     */
    public class LocalBinder extends Binder {
        AudioReaderService getService() {
            // Return this instance of IncrementBinderService so clients can call public methods
            return AudioReaderService.this;
        }
    }

    public void launch(){
        this.mediaPlayer.start();
    }

    public void pause(){
        this.mediaPlayer.pause();
    }

    public void stop(){
        this.mediaPlayer.stop();
        this.mediaPlayer = MediaPlayer.create(this, R.raw.test);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
}
