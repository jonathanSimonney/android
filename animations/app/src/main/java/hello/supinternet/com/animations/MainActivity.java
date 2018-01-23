package hello.supinternet.com.animations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private View elemToAnimate;

    private Animation scaleAnim;
    private Animation rotateAnim;
    private Animation translateAnim;
    private Animation fadeInAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setAnimations();

        final TextView elemToAnimate = findViewById(R.id.animatedElem);
        this.elemToAnimate = elemToAnimate;
        elemToAnimate.startAnimation(this.fadeInAnim);
    }

    private void setAnimations(){
        this.scaleAnim = AnimationUtils.loadAnimation(MainActivity.this.getApplicationContext(), R.anim.scale_anim);
        this.rotateAnim = AnimationUtils.loadAnimation(MainActivity.this.getApplicationContext(), R.anim.rotate_anim);
        this.translateAnim = AnimationUtils.loadAnimation(MainActivity.this.getApplicationContext(), R.anim.translate_anim);
        this.fadeInAnim = AnimationUtils.loadAnimation(MainActivity.this.getApplicationContext(), R.anim.fade_in);
    }

    public void click(View view) {
        switch (view.getId()){
            case R.id.scaleButton:
                this.elemToAnimate.startAnimation(this.scaleAnim);
                break;
            case R.id.rotateButton:
                this.elemToAnimate.startAnimation(this.rotateAnim);
                break;
            case R.id.translateButton:
                this.elemToAnimate.startAnimation(this.translateAnim);
                break;
        }
    }
}
