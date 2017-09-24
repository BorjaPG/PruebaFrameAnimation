package com.bp.pruebaframeanimation;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView android = (ImageView) findViewById(R.id.image);

        /*La animación se aplica al fondo de la vista*/
        android.setBackgroundResource(R.drawable.frame_animation);

        /*Se crea una nueva instancia para iniciar la animación en un nuevo thread*/
        final AnimationDrawable animation = (AnimationDrawable) android.getBackground();

        /*Se ejecuta la animación en otro thread para no bloquear el thread del UI*/
        android.post(new Runnable(){
            public void run(){
                if (animation != null)
                    animation.start();
            }
        });
    }
}
