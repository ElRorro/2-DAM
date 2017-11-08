package es.vcarmen.material02;

import android.animation.Animator;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Toast;

public class activity_material02 extends AppCompatActivity {
    FloatingActionButton fab;
    boolean tocado = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material02);

        fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setScaleX(0);
        fab.setScaleY(0);

        //creamos un interpolator
        final Interpolator interpolator = AnimationUtils.loadInterpolator(getBaseContext(), android.R.interpolator.fast_out_slow_in);
        fab.animate().scaleX(1).scaleY(1).setInterpolator(interpolator).setDuration(600).setStartDelay(1000);

        fab.animate().setListener(new Animator.AnimatorListener(){


            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                //fab.animate().scaleX(0).scaleY(0).setInterpolator(interpolator).setDuration(600).start();

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "FAB TOCADO", Toast.LENGTH_LONG).show();
                tocado = !tocado;
                fab.animate().scaleX(0).scaleY(0).setInterpolator(interpolator).setDuration(600).start();
                view.animate().rotation(tocado ? 45f : 0).setInterpolator(interpolator).start();
            }
        });
    }
}
