package com.capsule.exview.exview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    @Override
    protected void onResume() {
        super.onResume();

        textView = findViewById(R.id.tv);
        float translationX = textView.getTranslationX();
        float translationY = textView.getTranslationY();
        Log.v("vegeta", "translationX is " + translationX + ", translationY is " + translationY);

    }
}
