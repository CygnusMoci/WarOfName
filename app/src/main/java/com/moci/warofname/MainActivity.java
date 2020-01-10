package com.moci.warofname;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initWidgt();
    }

    private Button start;
    private Button review;

    protected void initData(){

    }

    protected void initWidgt(){
        start = findViewById(R.id.start);
        review = findViewById(R.id.review);
        start.setOnClickListener(this);
        review.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.start:
                enterFight();
                break;
            case R.id.review:
                enterReview();
                break;
        }
    }

    private void enterFight(){
        startActivity(new Intent(MainActivity.this, FightActivity.class));
//        finish();
    }

    private void enterReview(){
        startActivity(new Intent(MainActivity.this, ReviewActivity.class));
//        finish();
    }

}
