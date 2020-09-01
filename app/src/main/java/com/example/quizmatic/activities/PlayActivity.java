package com.example.quizmatic.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.quizmatic.R;

public class PlayActivity extends AppCompatActivity
{
    private long backPressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        Button btPlay = findViewById(R.id.bt_playbutton);

        btPlay.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent intent = new Intent(PlayActivity.this, CategoryActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        if (backPressedTime + 2000 > System.currentTimeMillis())
        {
            new AlertDialog.Builder(this)
                    .setTitle("Çıkmak istiyor musunuz?")
                    .setNegativeButton("Hayır", null)
                    .setPositiveButton("Evet", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {
                            setResult(RESULT_OK, new Intent().putExtra("Çıkış", true));
                            finish();
                        }
                    }).create().show();
        }else
            {
            Toast.makeText(this, "Tekrar çıkış'a basın.", Toast.LENGTH_SHORT).show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}
