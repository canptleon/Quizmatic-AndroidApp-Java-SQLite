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

public class LicLevelActivity extends AppCompatActivity implements View.OnClickListener
{

    Button btnLevel1, btnLevel2, btnLevel3;


    String CategoryValue = "";
    int LL1, LL2, LL3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lic_levels);

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

        LL1 = sharedPreferences.getInt(Constant.KEY_LITERATURE_LEVEL_1,0);
        LL2 = sharedPreferences.getInt(Constant.KEY_LITERATURE_LEVEL_2,0);
        LL3 = sharedPreferences.getInt(Constant.KEY_LITERATURE_LEVEL_3,0);

        if(LL1 == 1)
        {
            btnLevel1.setClickable(true);
            btnLevel1.setBackground(ContextCompat.getDrawable(this,R.drawable.button_next_background));
            btnLevel1.setOnClickListener(this);
        }
        else if (LL1 == 0)
        {
            btnLevel1.setClickable(false);
            btnLevel1.setBackground(ContextCompat.getDrawable(this,R.drawable.level_lock));
        }

        if (LL2 == 1)
        {
            btnLevel2.setClickable(true);
            btnLevel2.setBackground(ContextCompat.getDrawable(this,R.drawable.button_next_background));
            btnLevel2.setOnClickListener(this);
        }
        else if (LL2 == 0)
        {
            btnLevel2.setClickable(false);
            btnLevel2.setBackground(ContextCompat.getDrawable(this,R.drawable.level_lock));
        }

        if (LL3 == 1)
        {
            btnLevel3.setClickable(true);
            btnLevel3.setBackground(ContextCompat.getDrawable(this,R.drawable.button_next_background));
            btnLevel3.setOnClickListener(this);
        }
        else if (LL3 == 0)
        {
            btnLevel3.setClickable(false);
            btnLevel3.setBackground(ContextCompat.getDrawable(this,R.drawable.level_lock));
        }
    }

    @Override
    public void onClick(View v)
    {
        if (CategoryValue.equals("Edebiyat"))
        {
            switch (v.getId())
            {
                case R.id.btnLevel1:

                    Intent intentLitLevel1 = new Intent(LicLevelActivity.this, QuizActivity.class);
                    intentLitLevel1.putExtra("Category", Questions.CATEGORY_LITERATURE);
                    intentLitLevel1.putExtra("Level", Questions.LEVEL1);
                    startActivity(intentLitLevel1);
                    break;

                case R.id.btnLevel2:

                    Intent intentLitLevel2 = new Intent(LicLevelActivity.this,QuizActivity.class);
                    intentLitLevel2.putExtra("Category", Questions.CATEGORY_LITERATURE);
                    intentLitLevel2.putExtra("Level", Questions.LEVEL2);
                    startActivity(intentLitLevel2);
                    break;

                case R.id.btnLevel3:

                    Intent intentLitLevel3 = new Intent(LicLevelActivity.this,QuizActivity.class);
                    intentLitLevel3.putExtra("Category", Questions.CATEGORY_LITERATURE);
                    intentLitLevel3.putExtra("Level", Questions.LEVEL3);
                    startActivity(intentLitLevel3);
                    break;
            }
        }
    }
}