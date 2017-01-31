package com.chig.cookieclicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageButton imageButton;
    RelativeLayout relativeLayout;
    int tennisBalls;
    TextView score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageButton = (ImageButton)findViewById(R.id.imageButton_1);
        relativeLayout = (RelativeLayout)findViewById(R.id.activity_main);
        score = (TextView)findViewById(R.id.textView_score);

        imageButton.setImageResource(R.drawable.djokovic);








        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tennisBalls++;
                score.setText("Tennis Balls: " + tennisBalls);

                TextView textView = new TextView(MainActivity.this);
                textView.setText("+1");
                textView.setPadding(0, 0, 0, 100);

                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                params.addRule(RelativeLayout.ABOVE, R.id.imageButton_1);

                TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 4, Animation.RELATIVE_TO_SELF, 0);
                translateAnimation.setDuration(3000);

                relativeLayout.addView(textView, params);
                textView.startAnimation(translateAnimation);

                relativeLayout.removeView(textView);
            }
        });



    }
}
