package com.example.quizz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class LevelSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_selection);

        Button easyBtn = findViewById(R.id.btn_easy);
        Button mediumBtn = findViewById(R.id.btn_medium);
        Button hardBtn = findViewById(R.id.btn_hard);

        easyBtn.setOnClickListener(view -> launchQuiz("easy"));
        mediumBtn.setOnClickListener(view -> launchQuiz("medium"));
        hardBtn.setOnClickListener(view -> launchQuiz("hard"));
    }

    private void launchQuiz(String level) {
        Intent intent = new Intent(LevelSelectionActivity.this, MainActivity.class);
        intent.putExtra("level", level);
        startActivity(intent);
    }
}
