package com.example.quizz;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView questionTextView, totalQuestionTextView;
    Button ansA, ansB, ansC, ansD, btn_submit;

    int score = 0;
    int totalQuestion;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    String level = "";
    String[] questions;
    String[][] choices;
    String[] correctAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        level = getIntent().getStringExtra("level");
        if (level == null) {
            level = "easy";
        } else {
            level = level.trim().toLowerCase(); // Normalize and clean the string
        }

        questions = QuestionAnswer.getQuestions(level);
        choices = QuestionAnswer.getChoices(level);
        correctAnswers = QuestionAnswer.getCorrectAnswers(level);
        totalQuestion = questions.length;

        questionTextView = findViewById(R.id.question);
        totalQuestionTextView = findViewById(R.id.total_question);
        ansA = findViewById(R.id.ans_a);
        ansB = findViewById(R.id.ans_b);
        ansC = findViewById(R.id.ans_c);
        ansD = findViewById(R.id.ans_d);
        btn_submit = findViewById(R.id.btn_submit);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        btn_submit.setOnClickListener(this);

        // Display total number of questions
        totalQuestionTextView.setText(getString(R.string.total_questions_label, totalQuestion));
        loadNewQuestion();
    }

    private void loadNewQuestion() {
        if (currentQuestionIndex == totalQuestion) {
            finishQuiz();
            return;
        }

        questionTextView.setText(questions[currentQuestionIndex]);
        ansA.setText(choices[currentQuestionIndex][0]);
        ansB.setText(choices[currentQuestionIndex][1]);
        ansC.setText(choices[currentQuestionIndex][2]);
        ansD.setText(choices[currentQuestionIndex][3]);

        selectedAnswer = "";
    }

    private void finishQuiz() {
        // Updated score check (based on 10 marks total, with each question carrying 2 marks)
        String passStatus = (score >= totalQuestion * 1.0) ? "Passed" : "Failed";

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Your score is " + score + " out of " + (totalQuestion * 2))  // Multiply total questions by 2 for full score
                .setPositiveButton("Restart", (dialog, i) -> restartQuiz())
                .setCancelable(false)
                .show();
    }

    private void restartQuiz() {
        Intent intent = new Intent(MainActivity.this, LevelSelectionActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish(); // Close current activity
    }

    @Override
    public void onClick(View view) {
        // Reset button background color
        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;

        if (clickedButton.getId() == R.id.btn_submit) {
            if (!selectedAnswer.isEmpty()) {
                // Add 2 marks for correct answer
                if (selectedAnswer.equals(correctAnswers[currentQuestionIndex])) {
                    score += 2; // Increment by 2 marks instead of 1
                }
                currentQuestionIndex++;
                loadNewQuestion();
            }
        } else {
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.YELLOW);
        }
    }
}
