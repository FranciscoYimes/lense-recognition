package id.bustomi.d3ti.uns.readmysign2;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

import id.bustomi.d3ti_uns.readmysign2.R;

public class Splash extends Activity
{

    private boolean active = true;
    private int splashTime = 2500;
    private ImageView splashImage;
    private AlphaAnimation appearAnimation;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        splashImage = (ImageView) findViewById(R.id.splashImage);
        appearAnimation = new AlphaAnimation(0.0f, 1.0f);
        appearAnimation.setDuration(2500);
        appearAnimation.setFillAfter(true);


        Thread splashThread = new Thread()
        {
            @Override
            public void run()
            {
                splashImage.startAnimation(appearAnimation);
                try
                {
                    int waited = 0;
                    while (active && (waited < splashTime))
                    {
                        sleep(100);
                        if (active)
                        {
                            waited += 100;
                        }

                    }
                }
                catch (InterruptedException e)
                {

                }
                finally
                {
                    Intent intent = new Intent(Splash.this, MenuActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        };
        splashThread.start();
    }

    private void openApp()
    {
        finish();
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

}