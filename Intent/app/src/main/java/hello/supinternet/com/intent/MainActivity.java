package hello.supinternet.com.intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    private int PICK_IMAGE_REQUEST = 1;
    private ImageView footer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.footer = findViewById(R.id.footer);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == this.PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();
            this.footer.setImageURI(uri);
        }
    }

    private void findPicture(){
        Intent intent = new Intent();
// Show only images, no videos or anything else
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
// Always show the chooser (if there are multiple options available)
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), this.PICK_IMAGE_REQUEST);
    }

    private void launchBrowser(String url){
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void sendEmail(String to, String obj){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); //to be sure it is an email app!


        String[] dest = {to};

        intent.putExtra(Intent.EXTRA_SUBJECT, obj);
        intent.putExtra(Intent.EXTRA_EMAIL,  dest);


        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void click(View view) {
        switch (view.getId()){
            case R.id.pictureButton:
//                this.elemToAnimate.startAnimation(this.scaleAnim);
                this.findPicture();
                break;
            case R.id.openPageButton:
//                this.elemToAnimate.startAnimation(this.rotateAnim);
                this.launchBrowser("http://intranet.supinternet.fr/?action=presence");
                break;
            case R.id.emailButton:
//                this.elemToAnimate.startAnimation(this.translateAnim);
                this.sendEmail("antoine.deguin@supinternet.fr", "ag test");
                break;
        }
    }
}
