package com.moci.warofname;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.moci.warofname.entity.NameHero;
import com.moci.warofname.manager.FightManager;
import com.moci.warofname.util.mTool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FightActivity extends AppCompatActivity{
    private static final String TAG = "tagatg";
    private final Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);
        initData();
        initWidgt();
    }

    private Button start;
    private Button back;
    private TextView logPreview;
    private File file;

    private String p1name;
    private String p2name;
    private NameHero hero_p1;
    private NameHero hero_p2;
    private TextView p1;
    private TextView hp1;
    private TextView mp1;
    private TextView att1;
    private TextView def1;

    private TextView p2;
    private TextView hp2;
    private TextView mp2;
    private TextView att2;
    private TextView def2;
    private int[] order = {0};


    protected void initData(){

        Bundle bundle = getIntent().getExtras();
        p1name = bundle.getString("p1");
        p2name = bundle.getString("p2");

        hero_p1 = new NameHero(p1name);
        hero_p2 = new NameHero(p2name);
        String fileName = mTool.getTime()+"_log.txt";
        String filePath = "/storage/emulated/0/nameFightLog/";

        File tfile = new File(filePath);
        if (!tfile.exists()) {
            tfile.mkdir();
        }

        file = new File(filePath, fileName);

    }

    protected void initWidgt(){
        logPreview = findViewById(R.id.fight_logPreview);
        logPreview.setMovementMethod(new ScrollingMovementMethod());
        back = findViewById(R.id.fight_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FightActivity.this,MainActivity.class));
                finish();
            }
        });
        start = findViewById(R.id.fight_start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start.setEnabled(false);
                startFight();
                start.setEnabled(true);
            }
        });

        p1 = findViewById(R.id.p1);
        hp1 = findViewById(R.id.hp1);
        mp1 = findViewById(R.id.mp1);
        att1 = findViewById(R.id.att1);
        def1 = findViewById(R.id.def1);

        p2 = findViewById(R.id.p2);
        hp2 = findViewById(R.id.hp2);
        mp2 = findViewById(R.id.mp2);
        att2 = findViewById(R.id.att2);
        def2 = findViewById(R.id.def2);

        p1.setText(p1name);
        hp1.setText(hero_p1.getHp()+"");
        mp1.setText(hero_p1.getMp()+"");
        att1.setText(hero_p1.getAtt()+"");
        def1.setText(hero_p1.getDef()+"");


        p2.setText(p2name);
        hp2.setText(hero_p2.getHp()+"");
        mp2.setText(hero_p2.getMp()+"");
        att2.setText(hero_p2.getAtt()+"");
        def2.setText(hero_p2.getDef()+"");
    }

    String content = "";
    private Runnable task = new Runnable() {
        @Override
        public void run() {
            String result = FightManager.getInstance().fight(hero_p1,hero_p2,order);
            updataFightLog(result);
            mHandler.postDelayed(this, 500);

            if(hero_p1.getHp() <= 0 || hero_p2.getHp() <= 0){
                mHandler.removeCallbacks(task);
                String deathname = hero_p1.getHp()>=0? hero_p2.getName():hero_p1.getName();
                updataFightLog(deathname+"被打死了。");
            }
        }
    };
    private void startFight(){
        updataFightLog("开始搞基");
        mHandler.postDelayed(task,500);

    }

    protected void updataFightLog(String rawMsg){
        String msg = rawMsg+"\n";
        try {
            FileOutputStream fos = new FileOutputStream(file,true);
            fos.write(msg.getBytes());
            fos.close();

            InputStream instream = new FileInputStream(file);
            content = "";
            if (instream != null) {
                InputStreamReader inputreader
                        = new InputStreamReader(instream, "UTF-8");
                BufferedReader buffreader = new BufferedReader(inputreader);
                String line = "";
                //分行读取
                while ((line = buffreader.readLine()) != null) {
                    content += line + "\n";
                }
                instream.close();//关闭输入流
            }

            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    logPreview.setText(content);
                    hp1.setText(hero_p1.getHp()+"");
                    hp2.setText(hero_p2.getHp()+"");
                    // 自动滚动到最后一行
                    int offset=logPreview.getLineCount()*(11+logPreview.getLineHeight());
                    Log.w(TAG, "getLineCount = "+logPreview.getLineCount());
                    Log.w(TAG, "getLineHeight = "+logPreview.getLineHeight());
                    Log.w(TAG, "logPreview.getHeight() = "+logPreview.getHeight());

                    if(offset>logPreview.getHeight()){
                        logPreview.scrollTo(0,offset-logPreview.getHeight());
                    }
                }
            });
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
