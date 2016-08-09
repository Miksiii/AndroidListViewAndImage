package student2.metropolitan.fit.rs.pracc03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {

    private ImageView imgView;
    private Button swapImageButton;
    private int indexOfCurrentlyActiveImage;
    private int[] images = {R.drawable.img1, R.drawable.img2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        // back button
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        onImageSwitchListener();
    }

    private void onImageSwitchListener() {
        imgView = (ImageView) findViewById(R.id.imageView);
        swapImageButton = (Button) findViewById(R.id.swapImageButton);

        swapImageButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        indexOfCurrentlyActiveImage++;
                        indexOfCurrentlyActiveImage = indexOfCurrentlyActiveImage % images.length;
                        imgView.setImageResource(images[indexOfCurrentlyActiveImage]);
                    }
                }
        );
    }
}
