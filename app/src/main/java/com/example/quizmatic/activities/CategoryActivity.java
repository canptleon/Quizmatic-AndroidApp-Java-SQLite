package com.example.quizmatic.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.quizmatic.constants.CategoryConstants;
import com.example.quizmatic.constants.Constant;
import com.example.quizmatic.R;

public class CategoryActivity extends AppCompatActivity implements View.OnClickListener
{

    Button btnMath, btnSport, btnLic, btnCulture, btnScience;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        btnCulture = findViewById(R.id.btnCulture);
        btnSport = findViewById(R.id.btnSport);
        btnLic = findViewById(R.id.btnLic);
        btnScience = findViewById(R.id.btnScience);
        btnMath = findViewById(R.id.btnMath);

        btnCulture.setOnClickListener(this);
        btnSport.setOnClickListener(this);
        btnLic.setOnClickListener(this);
        btnScience.setOnClickListener(this);
        btnMath.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btnCulture:

                createLevelsForCulture();

                Intent intentCulture = new Intent(CategoryActivity.this, CultureLevelActivity.class);
                intentCulture.putExtra("Category", CategoryConstants.CULTURE);
                startActivity(intentCulture);
                break;

            case R.id.btnSport:

                createLevelsForSport();

                Intent intentSport = new Intent(CategoryActivity.this, SportLevelActivity.class);
                intentSport.putExtra("Category", CategoryConstants.SPORT);
                startActivity(intentSport);
                break;

            case R.id.btnLic:

                createLevelsForLic();

                Intent intentLic = new Intent(CategoryActivity.this, LicLevelActivity.class);
                intentLic.putExtra("Category", CategoryConstants.LITERATURE);
                startActivity(intentLic);
                break;

            case R.id.btnScience:

                createLevelsForScience();

                Intent intentScience = new Intent(CategoryActivity.this, ScienceLevelActivity.class);
                intentScience.putExtra("Category", CategoryConstants.SCIENCE);
                startActivity(intentScience);
                break;

            case R.id.btnMath:

                createLevelsForMath();

                Intent intentMath = new Intent(CategoryActivity.this, MathLevelActivity.class);
                intentMath.putExtra("Category", CategoryConstants.MATH);
                startActivity(intentMath);
                break;
        }
    }

    private void createLevelsForMath()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + Constant.MY_LEVEL_PREFFILE, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(Constant.KEY_MATH_LEVEL_1,1);
        editor.putString(Constant.KEY_CAT_MATH_LEVEL_1, "Unlock");
        editor.apply();

        if(sharedPreferences.getString(Constant.KEY_CAT_MATH_LEVEL_1,"N/A").equals("Unlock"))
        {
            editor.putInt(Constant.KEY_MATH_LEVEL_1,1);
            editor.putInt(Constant.KEY_MATH_LEVEL_2,1);
            editor.putInt(Constant.KEY_MATH_LEVEL_3,0);
        }
        else if(sharedPreferences.getString(Constant.KEY_CAT_MATH_LEVEL_2,"N/A").equals("Unlock"))
        {
            editor.putInt(Constant.KEY_MATH_LEVEL_1,1);
            editor.putInt(Constant.KEY_MATH_LEVEL_2,1);
            editor.putInt(Constant.KEY_MATH_LEVEL_3,0);
        }
        else if (sharedPreferences.getString(Constant.KEY_CAT_MATH_LEVEL_3,"N/A").equals("Unlock"))
        {
            editor.putInt(Constant.KEY_MATH_LEVEL_1,1);
            editor.putInt(Constant.KEY_MATH_LEVEL_2,1);
            editor.putInt(Constant.KEY_MATH_LEVEL_3,1);
        }
    }

    private void createLevelsForLic()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + Constant.MY_LEVEL_PREFFILE, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(Constant.KEY_LITERATURE_LEVEL_1,1);
        editor.putString(Constant.KEY_CAT_LITERATURE_LEVEL_1, "Unlock");
        editor.apply();

        if(sharedPreferences.getString(Constant.KEY_CAT_LITERATURE_LEVEL_1,"N/A").equals("Unlock"))
        {
            editor.putInt(Constant.KEY_LITERATURE_LEVEL_1,1);
            editor.putInt(Constant.KEY_LITERATURE_LEVEL_2,1);
            editor.putInt(Constant.KEY_LITERATURE_LEVEL_3,0);
        }
        else if(sharedPreferences.getString(Constant.KEY_CAT_LITERATURE_LEVEL_2,"N/A").equals("Unlock"))
        {
            editor.putInt(Constant.KEY_LITERATURE_LEVEL_1,1);
            editor.putInt(Constant.KEY_LITERATURE_LEVEL_2,1);
            editor.putInt(Constant.KEY_LITERATURE_LEVEL_3,0);
        }
        else if (sharedPreferences.getString(Constant.KEY_CAT_LITERATURE_LEVEL_3,"N/A").equals("Unlock"))
        {
            editor.putInt(Constant.KEY_LITERATURE_LEVEL_1,1);
            editor.putInt(Constant.KEY_LITERATURE_LEVEL_2,1);
            editor.putInt(Constant.KEY_LITERATURE_LEVEL_3,1);
        }
    }

    private void createLevelsForSport()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + Constant.MY_LEVEL_PREFFILE, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(Constant.KEY_SPORT_LEVEL_1,1);
        editor.putString(Constant.KEY_CAT_SPORT_LEVEL_1, "Unlock");
        editor.apply();

        if(sharedPreferences.getString(Constant.KEY_CAT_SPORT_LEVEL_1,"N/A").equals("Unlock"))
        {
            editor.putInt(Constant.KEY_SPORT_LEVEL_1,1);
            editor.putInt(Constant.KEY_SPORT_LEVEL_2,1);
            editor.putInt(Constant.KEY_SPORT_LEVEL_3,0);
        }
        else if(sharedPreferences.getString(Constant.KEY_CAT_SPORT_LEVEL_2,"N/A").equals("Unlock"))
        {
            editor.putInt(Constant.KEY_SPORT_LEVEL_1,1);
            editor.putInt(Constant.KEY_SPORT_LEVEL_2,1);
            editor.putInt(Constant.KEY_SPORT_LEVEL_3,0);
        }
        else if (sharedPreferences.getString(Constant.KEY_CAT_SPORT_LEVEL_3,"N/A").equals("Unlock"))
        {
            editor.putInt(Constant.KEY_SPORT_LEVEL_1,1);
            editor.putInt(Constant.KEY_SPORT_LEVEL_2,1);
            editor.putInt(Constant.KEY_SPORT_LEVEL_3,1);
        }
    }

    private void createLevelsForCulture()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + Constant.MY_LEVEL_PREFFILE, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(Constant.KEY_CULTURE_LEVEL_1,1);
        editor.putString(Constant.KEY_CAT_CULTURE_LEVEL_1, "Unlock");
        editor.apply();

        if(sharedPreferences.getString(Constant.KEY_CAT_CULTURE_LEVEL_1,"N/A").equals("Unlock"))
        {
            editor.putInt(Constant.KEY_CULTURE_LEVEL_1,1);
            editor.putInt(Constant.KEY_CULTURE_LEVEL_2,1);
            editor.putInt(Constant.KEY_CULTURE_LEVEL_3,0);
        }
        else if(sharedPreferences.getString(Constant.KEY_CAT_CULTURE_LEVEL_2,"N/A").equals("Unlock"))
        {
            editor.putInt(Constant.KEY_CULTURE_LEVEL_1,1);
            editor.putInt(Constant.KEY_CULTURE_LEVEL_2,1);
            editor.putInt(Constant.KEY_CULTURE_LEVEL_3,0);
        }
        else if (sharedPreferences.getString(Constant.KEY_CAT_CULTURE_LEVEL_3,"N/A").equals("Unlock"))
        {
            editor.putInt(Constant.KEY_CULTURE_LEVEL_1,1);
            editor.putInt(Constant.KEY_CULTURE_LEVEL_2,1);
            editor.putInt(Constant.KEY_CULTURE_LEVEL_3,1);
        }
    }

    private void createLevelsForScience()
    {
        SharedPreferences sharedPreferences =
                getSharedPreferences(getPackageName() + Constant.MY_LEVEL_PREFFILE,
                Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(Constant.KEY_SCIENCE_LEVEL_1,1);
        editor.putString(Constant.KEY_CAT_SCIENCE_LEVEL_1,"Unlock");
        editor.apply();

        if(sharedPreferences.getString(Constant.KEY_CAT_SCIENCE_LEVEL_1,"N/A").equals("Unlock"))
        {
            editor.putInt(Constant.KEY_SCIENCE_LEVEL_1,1);
            editor.putInt(Constant.KEY_SCIENCE_LEVEL_2,1);
            editor.putInt(Constant.KEY_SCIENCE_LEVEL_3,0);
        }
        else if(sharedPreferences.getString(Constant.KEY_CAT_SCIENCE_LEVEL_2,"N/A").equals("Unlock"))
        {
            editor.putInt(Constant.KEY_SCIENCE_LEVEL_1,1);
            editor.putInt(Constant.KEY_SCIENCE_LEVEL_2,1);
            editor.putInt(Constant.KEY_SCIENCE_LEVEL_3,0);
        }
        else if (sharedPreferences.getString(Constant.KEY_CAT_SCIENCE_LEVEL_3,"N/A").equals("Unlock"))
        {
            editor.putInt(Constant.KEY_SCIENCE_LEVEL_1,1);
            editor.putInt(Constant.KEY_SCIENCE_LEVEL_2,1);
            editor.putInt(Constant.KEY_SCIENCE_LEVEL_3,1);
        }
    }
}