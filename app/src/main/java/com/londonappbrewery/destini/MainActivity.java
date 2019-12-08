package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:

    TextView storyText;
    Button answer1;
    Button answer2;
    int chapter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storyText = (TextView) findViewById(R.id.storyTextView);
        answer1 = (Button) findViewById(R.id.buttonTop);
        answer2 = (Button) findViewById(R.id.buttonBottom);

        if (savedInstanceState != null) {
            chapter = savedInstanceState.getInt("Chapter");
            if (chapter == 2) {
                showT2_Story();
            } else if (chapter == 3) {
                showT3_Story();
            } else if (chapter == 4) {
                showT4_Story();
            } else if (chapter == 5) {
                showT5_Story();
            } else if (chapter == 6) {
                showT6_Story();
            }

        } else {
            this.chapter = 1;
        }

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showT3_Story();
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showT2_Story();
            }
        });
    }

    public void showT6_Story() {
        this.chapter = 6;
        storyText.setText(R.string.T6_End);
        answer1.setVisibility(View.GONE);
        answer2.setVisibility(View.GONE);
    }

    public void showT5_Story() {
        this.chapter = 5;
        storyText.setText(R.string.T5_End);
        answer1.setVisibility(View.GONE);
        answer2.setVisibility(View.GONE);
    }

    public void showT3_Story() {
        this.chapter = 3;
        storyText.setText(R.string.T3_Story);
        answer1.setText(R.string.T3_Ans1);
        answer2.setText(R.string.T3_Ans2);

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showT6_Story();
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showT5_Story();
            }
        });
    }

    public void showT2_Story() {
        this.chapter = 2;
        storyText.setText(R.string.T2_Story);
        answer1.setText(R.string.T2_Ans1);
        answer2.setText(R.string.T2_Ans2);

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showT3_Story();
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showT4_Story();
            }
        });
    }

    public void showT4_Story() {
        this.chapter = 4;
        storyText.setText(R.string.T4_End);
        answer1.setVisibility(View.GONE);
        answer2.setVisibility(View.GONE);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("Chapter" , this.chapter);

    }
}
