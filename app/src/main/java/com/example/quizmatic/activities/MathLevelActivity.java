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

public class MathLevelActivity extends AppCompatActivity implements View.OnClickListener
{

    Button btnLevel1, btnLevel2, btnLevel3;

    String CategoryValue = "";
    int ML1, ML2, ML3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_levels);

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

        ML1 = sharedPreferences.getInt(Constant.KEY_MATH_LEVEL_1,0);
        ML2 = sharedPreferences.getInt(Constant.KEY_MATH_LEVEL_2,0);
        ML3 = sharedPreferences.getInt(Constant.KEY_MATH_LEVEL_3,0);

        if(ML1 == 1)
        {
            btnLevel1.setClickable(true);
            btnLevel1.setBackground(ContextCompat.getDrawable(this,R.drawable.button_next_background));
            btnLevel1.setOnClickListener(this);
        }
        else if (ML1 == 0)
        {
            btnLevel1.setClickable(false);
            btnLevel1.setBackground(ContextCompat.getDrawable(this,R.drawable.level_lock));
        }

        if (ML2 == 1)
        {
            btnLevel2.setClickable(true);
            btnLevel2.setBackground(ContextCompat.getDrawable(this,R.drawable.button_next_background));
            btnLevel2.setOnClickListener(this);
        }
        else if (ML2 == 0)
        {
            btnLevel2.setClickable(false);
            btnLevel2.setBackground(ContextCompat.getDrawable(this,R.drawable.level_lock));
        }

        if (ML3 == 1)
        {
            btnLevel3.setClickable(true);
            btnLevel3.setBackground(ContextCompat.getDrawable(this,R.drawable.button_next_background));
            btnLevel3.setOnClickListener(this);
        }
        else if (ML3 == 0)
        {
            btnLevel3.setClickable(false);
            btnLevel3.setBackground(ContextCompat.getDrawable(this,R.drawable.level_lock));
        }
    }

    @Override
    public void onClick(View v)
    {
        if (CategoryValue.equals("Matematik"))
        {
            switch (v.getId())
            {
                case R.id.btnLevel1:

                    Intent intentMathLevel1 = new Intent(MathLevelActivity.this, QuizActivity.class);
                    intentMathLevel1.putExtra("Category", Questions.CATEGORY_MATH);
                    intentMathLevel1.putExtra("Level", Questions.LEVEL1);
                    startActivity(intentMathLevel1);
                    break;

                case R.id.btnLevel2:

                    Intent intentMathLevel2 = new Intent(MathLevelActivity.this,QuizActivity.class);
                    intentMathLevel2.putExtra("Category", Questions.CATEGORY_MATH);
                    intentMathLevel2.putExtra("Level", Questions.LEVEL2);
                    startActivity(intentMathLevel2);
                    break;

                case R.id.btnLevel3:

                    Intent intentMathLevel3 = new Intent(MathLevelActivity.this,QuizActivity.class);
                    intentMathLevel3.putExtra("Category", Questions.CATEGORY_MATH);
                    intentMathLevel3.putExtra("Level", Questions.LEVEL3);
                    startActivity(intentMathLevel3);
                    break;
            }
        }
    }
}