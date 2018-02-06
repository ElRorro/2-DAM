package es.vcarmen.video02;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video02 extends AppCompatActivity {

    VideoView reproductor;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video02);

        reproductor = (VideoView) findViewById(R.id.videoView);
        mediaController = new MediaController(this, true);

        reproductor.setVideoURI(Uri.parse("http://www.androidbegin.com/tutorial/AndroidCommercial.3gp"));
        mediaController.setAnchorView(reproductor);
        reproductor.setMediaController(mediaController);

        reproductor.start();
        reproductor.requestFocus();
    }
}
