package com.example.quizmatic.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizmatic.R;

public class ResultActivity extends AppCompatActivity
{

    TextView txtHighScore;
    TextView txtTotalQuizQues,txtCorrectQues,txtWrongQues;

    Button btStartQuiz;
    Button btMainMenu;

    private int highScore;
    public static final String SHARED_PREFERRENCE = "shread_prefrence";
    public static final String SHARED_PREFERRENCE_HIGH_SCORE = "shread_prefrence_high_score";

    private long backPressedTime;

    String CategoryAgainValue ="";
    int levelsId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        btMainMenu = findViewById(R.id.result_bt_mainmenu);
        btStartQuiz = findViewById(R.id.result_bt_playAgain);
        txtHighScore = findViewById(R.id.result_text_High_Score);
        txtTotalQuizQues = findViewById(R.id.result_total_Ques);
        txtCorrectQues = findViewById(R.id.result_Correct_Ques);
        txtWrongQues = findViewById(R.id.result_Wrong_Ques);

        btMainMenu.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(ResultActivity.this, PlayActivity.class);
                startActivity(intent);
            }
        });

        btStartQuiz.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(ResultActivity.this, QuizActivity.class);
                intent.putExtra("Category",CategoryAgainValue);
                intent.putExtra("Level",levelsId);
                startActivity(intent);
            }
        });

        loadHighScore();

        Intent intent = getIntent();

        int score = intent.getIntExtra("UserScore",0);
        int totalQuestion = intent.getIntExtra("TotalQuestion",0);
        int correctQues = intent.getIntExtra("CorrectQues",0);
        int wrongQues = intent.getIntExtra("WrongQues",0);

        CategoryAgainValue = intent.getStringExtra("Category");
        levelsId = intent.getIntExtra("Level",0);

        txtTotalQuizQues.setText("Toplam soru: " + String.valueOf(totalQuestion));
        txtCorrectQues.setText("Doğru: " + String.valueOf(correctQues));
        txtWrongQues.setText("Yanlış " + String.valueOf(wrongQues));

        if (score > highScore)
        {
            updateHighScore(score);
        }
    }

    private void updateHighScore(int newHighScore)
    {
        highScore = newHighScore;
        txtHighScore.setText("En yüksek puan: " + String.valueOf(highScore));

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERRENCE,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(SHARED_PREFERRENCE_HIGH_SCORE,highScore);
        editor.apply();
    }

    private void loadHighScore()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERRENCE,MODE_PRIVATE);
        highScore = sharedPreferences.getInt(SHARED_PREFERRENCE_HIGH_SCORE,0);
        txtHighScore.setText("En yüksek puan: " + String.valueOf(highScore));
    }

    @Override
    public void onBackPressed()
    {
        if (backPressedTime + 2000 > System.currentTimeMillis())
        {
            Intent intent = new Intent(ResultActivity.this,PlayActivity.class);
            startActivity(intent);
        }
        else
            {
            Toast.makeText(this, "Tekrar çıkış'a basın.", Toast.LENGTH_SHORT).show();
        }
        backPressedTime = System.currentTimeMillis();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("BUGBUG","onStop() in PlayActivity");
        finish();
    }

    public void sendToLevelAgain(View view)
    {

        if (CategoryAgainValue.equals("Bilim"))
        {
            Intent intentScience = new Intent(ResultActivity.this, ScienceLevelActivity.class);
            startActivity(intentScience);
        }
        else if (CategoryAgainValue.equals("Matematik"))
        {
            Intent intentMath = new Intent(ResultActivity.this, MathLevelActivity.class);
            startActivity(intentMath);
        }
        else if (CategoryAgainValue.equals("Genel Kültür"))
        {
            Intent intentCulture = new Intent(ResultActivity.this, CultureLevelActivity.class);
            startActivity(intentCulture);
        }
        else if (CategoryAgainValue.equals("Spor"))
        {
            Intent intentSport = new Intent(ResultActivity.this, SportLevelActivity.class);
            startActivity(intentSport);
        }
        else if (CategoryAgainValue.equals("Edebiyat"))
        {
            Intent intentLic = new Intent(ResultActivity.this, LicLevelActivity.class);
            startActivity(intentLic);
        }
    }
}
