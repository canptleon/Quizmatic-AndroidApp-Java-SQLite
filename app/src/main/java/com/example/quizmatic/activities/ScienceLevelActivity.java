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

public class ScienceLevelActivity extends AppCompatActivity implements View.OnClickListener
{

    Button btnLevel1, btnLevel2, btnLevel3;

    String CategoryValue = "";
    int SL1, SL2, SL3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_levels);

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

        SL1 = sharedPreferences.getInt(Constant.KEY_SCIENCE_LEVEL_1,0);
        SL2 = sharedPreferences.getInt(Constant.KEY_SCIENCE_LEVEL_2,0);
        SL3 = sharedPreferences.getInt(Constant.KEY_SCIENCE_LEVEL_3,0);

        if(SL1 == 1)
        {
            btnLevel1.setClickable(true);
            btnLevel1.setBackground(ContextCompat.getDrawable(this,R.drawable.button_next_background));
            btnLevel1.setOnClickListener(this);
        }
        else if (SL1 == 0)
        {
            btnLevel1.setClickable(false);
            btnLevel1.setBackground(ContextCompat.getDrawable(this,R.drawable.level_lock));
        }

        if (SL2 == 1)
        {
            btnLevel2.setClickable(true);
            btnLevel2.setBackground(ContextCompat.getDrawable(this,R.drawable.button_next_background));
            btnLevel2.setOnClickListener(this);
        }
        else if (SL2 == 0)
        {
            btnLevel2.setClickable(false);
            btnLevel2.setBackground(ContextCompat.getDrawable(this,R.drawable.level_lock));
        }

        if (SL3 == 1)
        {
            btnLevel3.setClickable(true);
            btnLevel3.setBackground(ContextCompat.getDrawable(this,R.drawable.button_next_background));
            btnLevel3.setOnClickListener(this);
        }
        else if (SL3 == 0)
        {
            btnLevel3.setClickable(false);
            btnLevel3.setBackground(ContextCompat.getDrawable(this,R.drawable.level_lock));
        }
    }

    @Override
    public void onClick(View v)
    {
        if (CategoryValue.equals("Bilim"))
        {
            switch (v.getId())
            {
                case R.id.btnLevel1:

                    Intent intentScienceLevel1 = new Intent(ScienceLevelActivity.this, QuizActivity.class);
                    intentScienceLevel1.putExtra("Category", Questions.CATEGORY_SCIENCE);
                    intentScienceLevel1.putExtra("Level", Questions.LEVEL1);
                    startActivity(intentScienceLevel1);
                    break;

                case R.id.btnLevel2:

                    Intent intentScienceLevel2 = new Intent(ScienceLevelActivity.this,QuizActivity.class);
                    intentScienceLevel2.putExtra("Category", Questions.CATEGORY_SCIENCE);
                    intentScienceLevel2.putExtra("Level", Questions.LEVEL2);
                    startActivity(intentScienceLevel2);
                    break;

                case R.id.btnLevel3:

                    Intent intentScienceLevel3 = new Intent(ScienceLevelActivity.this,QuizActivity.class);
                    intentScienceLevel3.putExtra("Category", Questions.CATEGORY_SCIENCE);
                    intentScienceLevel3.putExtra("Level", Questions.LEVEL3);
                    startActivity(intentScienceLevel3);
                    break;
            }
        }
    }
}