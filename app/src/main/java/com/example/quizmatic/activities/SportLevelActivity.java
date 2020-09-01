package com.example.quizmatic.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.quizmatic.constants.Constant;
import com.example.quizmatic.model.Questions;
import com.example.quizmatic.R;

public class SportLevelActivity extends AppCompatActivity implements View.OnClickListener
{

    Button btnLevel1, btnLevel2, btnLevel3;

    String CategoryValue = "";
    int SSL1, SSL2, SSL3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_levels);

        btnLevel1 = findViewById(R.id.btnLevel1);
        btnLevel2 = findViewById(R.id.btnLevel2);
        btnLevel3 = findViewById(R.id.btnLevel3);

        lockandUnlockLevels();

        Intent intentCategory = getIntent();
        CategoryValue = intentCategory.getStringExtra("Category");
    }

    private void lockandUnlockLevels()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + Constant.MY_LEVEL_PREFFILE, Context.MODE_PRIVATE);

        SSL1 = sharedPreferences.getInt(Constant.KEY_SPORT_LEVEL_1,0);
        SSL2 = sharedPreferences.getInt(Constant.KEY_SPORT_LEVEL_2,0);
        SSL3 = sharedPreferences.getInt(Constant.KEY_SPORT_LEVEL_3,0);

        if(SSL1 == 1)
        {
            btnLevel1.setClickable(true);
            btnLevel1.setBackground(ContextCompat.getDrawable(this,R.drawable.button_next_background));
            btnLevel1.setOnClickListener(this);
        }
        else if (SSL1 == 0)
        {
            btnLevel1.setClickable(false);
            btnLevel1.setBackground(ContextCompat.getDrawable(this,R.drawable.level_lock));
        }

        if (SSL2 == 1)
        {
            btnLevel2.setClickable(true);
            btnLevel2.setBackground(ContextCompat.getDrawable(this,R.drawable.button_next_background));
            btnLevel2.setOnClickListener(this);
        }
        else if (SSL2 == 0)
        {
            btnLevel2.setClickable(false);
            btnLevel2.setBackground(ContextCompat.getDrawable(this,R.drawable.level_lock));
        }

        if (SSL3 == 1)
        {
            btnLevel3.setClickable(true);
            btnLevel3.setBackground(ContextCompat.getDrawable(this,R.drawable.button_next_background));
            btnLevel3.setOnClickListener(this);
        }
        else if (SSL3 == 0)
        {
            btnLevel3.setClickable(false);
            btnLevel3.setBackground(ContextCompat.getDrawable(this,R.drawable.level_lock));
        }
    }

    @Override
    public void onClick(View v)
    {
        if (CategoryValue.equals("Spor"))
        {
            switch (v.getId())
            {
                case R.id.btnLevel1:

                    Intent intentSportLevel1 = new Intent(SportLevelActivity.this, QuizActivity.class);
                    intentSportLevel1.putExtra("Category", Questions.CATEGORY_SPORT);
                    intentSportLevel1.putExtra("Level", Questions.LEVEL1);
                    startActivity(intentSportLevel1);
                    break;

                case R.id.btnLevel2:

                    Intent intentSportLevel2 = new Intent(SportLevelActivity.this,QuizActivity.class);
                    intentSportLevel2.putExtra("Category", Questions.CATEGORY_SPORT);
                    intentSportLevel2.putExtra("Level", Questions.LEVEL2);
                    startActivity(intentSportLevel2);
                    break;

                case R.id.btnLevel3:

                    Intent intentSportLevel3 = new Intent(SportLevelActivity.this,QuizActivity.class);
                    intentSportLevel3.putExtra("Category", Questions.CATEGORY_SPORT);
                    intentSportLevel3.putExtra("Level", Questions.LEVEL3);
                    startActivity(intentSportLevel3);
                    break;
            }
        }
    }
}