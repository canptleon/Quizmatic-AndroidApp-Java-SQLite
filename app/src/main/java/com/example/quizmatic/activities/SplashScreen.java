package com.example.quizmatic.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quizmatic.R;

import static java.lang.Thread.sleep;

public class SplashScreen extends AppCompatActivity
{
    private final static int EXIT_CODE = 100;

    TextView txtSplashText;
    ImageView imgViewLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        txtSplashText = findViewById(R.id.textviewLogoText);
        imgViewLogo = findViewById(R.id.imgviewLogo);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.trasnsition);
        imgViewLogo.setAnimation(animation);
        txtSplashText.setAnimation(animation);

        Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    sleep(3000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    GotoPlayActivity();
                }
            }
        });
        thread.start();
    }

    private void GotoPlayActivity()
    {
        startActivityForResult( new Intent(SplashScreen.this, PlayActivity.class),EXIT_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == EXIT_CODE){

            if (resultCode == RESULT_OK){
                if (data.getBooleanExtra("ÇIKIŞ",true)){
                    finish();
                }
            }
        }
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.i("BUGBUG","onStop() in SplashActivity");
        finish();
    }
}
