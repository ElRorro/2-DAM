package es.vcarmen.sonido01;

import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

public class Sonido01 extends AppCompatActivity {

    private SeekBar mSeekBarVolumen, mSeekBarBalance, mSeekBarFrecuencia;
    private GestorSonido snd;
    private int laser, gato, bomba, disparo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonido01);

        mSeekBarVolumen = (SeekBar) findViewById(R.id.seekVolumen);
        mSeekBarBalance = (SeekBar) findViewById(R.id.seekBalance);
        mSeekBarFrecuencia = (SeekBar) findViewById(R.id.seekFrecuencia);

        snd = new GestorSonido(getApplicationContext());
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);

        laser = snd.carga(R.raw.laser);
        bomba = snd.carga(R.raw.explosion);
        disparo = snd.carga(R.raw.disparo);
        gato = snd.carga(R.raw.gato);

        snd.suena(laser);
        snd.suena(bomba);
        snd.suena(disparo);
        snd.suena(gato);

        SeekBar.OnSeekBarChangeListener barChange;
        barChange = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                switch (seekBar.getId()){
                    case R.id.seekVolumen:
                        snd.ajustarVolumen((float) i/100.0f);
                        break;
                    case R.id.seekBalance:
                        snd.ajustarBalance((float) i/100.0f);
                        break;
                    case R.id.seekFrecuencia:
                        snd.ajustaFrecuencia((float) i/100.0f);
                        break;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };

        mSeekBarVolumen.setOnSeekBarChangeListener(barChange);
        mSeekBarBalance.setOnSeekBarChangeListener(barChange);
        mSeekBarFrecuencia.setOnSeekBarChangeListener(barChange);

    }

    public void pulsado(View v){
        int id = v.getId();
        switch (id) {
            case R.id.btnLaser:
                snd.suena(laser);
                break;
            case R.id.btnBomba:
                snd.suena(bomba);
                break;
            case R.id.btnDisparo:
                snd.suena(disparo);
                break;
            case R.id.btnMaullido:
                snd.suena(gato);
                break;
        }

    }

}



