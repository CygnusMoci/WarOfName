package com.moci.warofname;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
    private TextView name1;
    private TextView name2;

    protected void initData(){

    }

    protected void initWidgt(){
        start = findViewById(R.id.start);
        review = findViewById(R.id.review);
        start.setOnClickListener(this);
        review.setOnClickListener(this);

        name1 = findViewById(R.id.name1);
        name2 = findViewById(R.id.name2);
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
        String p1 = name1.getText().toString();
        String p2 = name2.getText().toString();
        if(p1.length() != 0 && p2.length() != 0 ){
            Intent it = new Intent(MainActivity.this, FightActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("p1",p1);
            bundle.putString("p2",p2);
            it.putExtras(bundle);
            startActivityForResult(it,100);
            finish();
        }else {
            Toast.makeText(this.getApplicationContext(),"请输入正确的名字",Toast.LENGTH_LONG).show();
        }
    }

    private void enterReview(){
        startActivityForResult(new Intent(MainActivity.this, ReviewActivity.class),101);
        finish();
    }

}
