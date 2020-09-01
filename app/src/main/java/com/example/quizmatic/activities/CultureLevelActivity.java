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

public class CultureLevelActivity extends AppCompatActivity implements View.OnClickListener
{

    Button btnLevel1, btnLevel2, btnLevel3;

    String CategoryValue = "";
    int CL1, CL2, CL3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culture_levels);

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

        CL1 = sharedPreferences.getInt(Constant.KEY_CULTURE_LEVEL_1,0);
        CL2 = sharedPreferences.getInt(Constant.KEY_CULTURE_LEVEL_2,0);
        CL3 = sharedPreferences.getInt(Constant.KEY_CULTURE_LEVEL_3,0);

        if(CL1 == 1)
        {
            btnLevel1.setClickable(true);
            btnLevel1.setBackground(ContextCompat.getDrawable(this,R.drawable.button_next_background));
            btnLevel1.setOnClickListener(this);
        }
        else if (CL1 == 0)
        {
            btnLevel1.setClickable(false);
            btnLevel1.setBackground(ContextCompat.getDrawable(this,R.drawable.level_lock));
        }

        if (CL2 == 1)
        {
            btnLevel2.setClickable(true);
            btnLevel2.setBackground(ContextCompat.getDrawable(this,R.drawable.button_next_background));
            btnLevel2.setOnClickListener(this);
        }
        else if (CL2 == 0)
        {
            btnLevel2.setClickable(false);
            btnLevel2.setBackground(ContextCompat.getDrawable(this,R.drawable.level_lock));
        }

        if (CL3 == 1)
        {
            btnLevel3.setClickable(true);
            btnLevel3.setBackground(ContextCompat.getDrawable(this,R.drawable.button_next_background));
            btnLevel3.setOnClickListener(this);
        }
        else if (CL3 == 0)
        {
            btnLevel3.setClickable(false);
            btnLevel3.setBackground(ContextCompat.getDrawable(this,R.drawable.level_lock));
        }
    }

    @Override
    public void onClick(View v)
    {
        if (CategoryValue.equals("Genel Kültür"))
        {
            switch (v.getId())
            {
                case R.id.btnLevel1:

                    Intent intentCultureLevel1 = new Intent(CultureLevelActivity.this, QuizActivity.class);
                    intentCultureLevel1.putExtra("Category", Questions.CATEGORY_GENERAL_CULTURE);
                    intentCultureLevel1.putExtra("Level", Questions.LEVEL1);
                    startActivity(intentCultureLevel1);
                    break;

                case R.id.btnLevel2:

                    Intent intentCultureLevel2 = new Intent(CultureLevelActivity.this,QuizActivity.class);
                    intentCultureLevel2.putExtra("Category", Questions.CATEGORY_GENERAL_CULTURE);
                    intentCultureLevel2.putExtra("Level", Questions.LEVEL2);
                    startActivity(intentCultureLevel2);
                    break;

                case R.id.btnLevel3:

                    Intent intentCultureLevel3 = new Intent(CultureLevelActivity.this,QuizActivity.class);
                    intentCultureLevel3.putExtra("Category", Questions.CATEGORY_GENERAL_CULTURE);
                    intentCultureLevel3.putExtra("Level", Questions.LEVEL3);
                    startActivity(intentCultureLevel3);
                    break;
            }
        }
    }
}