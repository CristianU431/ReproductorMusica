package com.example.reproductormusica;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Disco extends AppCompatActivity {

    Button play_pause, btn_repetir;
    MediaPlayer mp;
    ImageView iv;
    int repetir = 2, posicion = 0;
    MediaPlayer vectormp [] = new MediaPlayer[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disco);

        play_pause = (Button)findViewById(R.id.btnPlay2);
        btn_repetir = (Button)findViewById(R.id.btnRepetir2);
        iv = (ImageView)findViewById(R.id.imageView);

        vectormp[0] = MediaPlayer.create(this,R.raw.music06);
        vectormp[1] = MediaPlayer.create(this,R.raw.music07);
        vectormp[2] = MediaPlayer.create(this,R.raw.music08);
        vectormp[3] = MediaPlayer.create(this,R.raw.music09);
        vectormp[4] = MediaPlayer.create(this,R.raw.music10);
    }

    //Metodo para el boton PlayPause
    public void PlayPause(View view)
    {
        if(vectormp[posicion].isPlaying())
        {
            vectormp[posicion].pause();
            play_pause.setBackgroundResource(R.drawable.reproducir);
            Toast.makeText(this,"Pausa", Toast.LENGTH_SHORT).show();
        } else
        {
            vectormp[posicion].start();
            play_pause.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this,"Play", Toast.LENGTH_SHORT).show();
        }
    }

    //Metodo para el boton Stop
    public void Stop(View view)
    {
        if(vectormp[posicion] != null)
        {
            vectormp[posicion].stop();

            vectormp[0] = MediaPlayer.create(this,R.raw.music06);
            vectormp[1] = MediaPlayer.create(this,R.raw.music07);
            vectormp[2] = MediaPlayer.create(this,R.raw.music08);
            vectormp[3] = MediaPlayer.create(this,R.raw.music09);
            vectormp[4] = MediaPlayer.create(this,R.raw.music10);
            posicion = 0;
            play_pause.setBackgroundResource(R.drawable.reproducir);
            iv.setImageResource(R.drawable.img01);
            Toast.makeText(this, "Stop",Toast.LENGTH_SHORT).show();
        }
    }

    //Metodo repetir una pista
    public void  Repetir(View view)
    {
        if (repetir == 1)
        {
            btn_repetir.setBackgroundResource(R.drawable.no_repetir);
            Toast.makeText(this, "no repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(false);
            repetir = 2;
        } else
        {
            btn_repetir.setBackgroundResource(R.drawable.repetir);
            Toast.makeText(this, "Repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(true);
            repetir = 1;
        }
    }

    //Metodo para saltar a la siguiente canci??n
    public void Siguiente(View view)
    {
        if (posicion < vectormp.length -1)
        {
            if (vectormp[posicion].isPlaying())
            {
                vectormp[posicion].stop();
                posicion++;
                vectormp[posicion].start();

                if (posicion == 0)
                {
                    iv.setImageResource(R.drawable.img06);
                }
                else if(posicion == 1)
                {
                    iv.setImageResource(R.drawable.img07);
                }
                else if (posicion == 2)
                {
                    iv.setImageResource(R.drawable.img08);
                }
                else if (posicion == 3)
                {
                    iv.setImageResource(R.drawable.img09);
                }
                else if (posicion == 4)
                {
                    iv.setImageResource(R.drawable.img10);
                }

            } else
            {
                posicion++;

                if (posicion == 0)
                {
                    iv.setImageResource(R.drawable.img06);
                }
                else if(posicion == 1)
                {
                    iv.setImageResource(R.drawable.img07);
                }
                else if (posicion == 2)
                {
                    iv.setImageResource(R.drawable.img08);
                }
                else if (posicion == 3)
                {
                    iv.setImageResource(R.drawable.img09);
                }
                else if (posicion == 4)
                {
                    iv.setImageResource(R.drawable.img10);
                }
            }
        } else
        {
            Toast.makeText(this, "No hay m??s canciones",Toast.LENGTH_SHORT).show();
        }
    }

    //metodo para regresar a la cancion anterior
    public void Anterior(View view)
    {
        if (posicion >=1 )
        {
            if(vectormp[posicion].isPlaying())
            {
                vectormp[posicion].stop();
                vectormp[0] = MediaPlayer.create(this,R.raw.music06);
                vectormp[1] = MediaPlayer.create(this,R.raw.music07);
                vectormp[2] = MediaPlayer.create(this,R.raw.music08);
                vectormp[3] = MediaPlayer.create(this,R.raw.music09);
                vectormp[4] = MediaPlayer.create(this,R.raw.music10);
                posicion--;

                if (posicion == 0)
                {
                    iv.setImageResource(R.drawable.img06);
                }
                else if(posicion == 1)
                {
                    iv.setImageResource(R.drawable.img07);
                }
                else if (posicion == 2)
                {
                    iv.setImageResource(R.drawable.img08);
                }
                else if (posicion == 3)
                {
                    iv.setImageResource(R.drawable.img09);
                }
                else if (posicion == 4)
                {
                    iv.setImageResource(R.drawable.img10);
                }

                vectormp[posicion].start();

            }else
            {
                posicion--;

                if (posicion == 0)
                {
                    iv.setImageResource(R.drawable.img06);
                }
                else if(posicion == 1)
                {
                    iv.setImageResource(R.drawable.img07);
                }
                else if (posicion == 2)
                {
                    iv.setImageResource(R.drawable.img08);
                }
                else if (posicion == 3)
                {
                    iv.setImageResource(R.drawable.img09);
                }
                else if (posicion == 4)
                {
                    iv.setImageResource(R.drawable.img10);
                }
            }

        } else
        {
            Toast.makeText(this, "No hay m??s canciones",Toast.LENGTH_SHORT).show();
        }
    }

}