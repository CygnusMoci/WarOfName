package com.moci.warofname;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReviewActivity extends AppCompatActivity{
    private static final String TAG = "ReviewActivity";
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        initData();
        initWidgt();
//        showReview();
    }

    private Button back;
    private TextView logPreview;
    private File file;

    private float x = 0;
    private float y = 0;
    protected void initData(){
        mHandler = new Handler();

//        String fileName = mTool.getTime()+"_log.txt";
//        String filePath = "/storage/emulated/0/defaultAndroid/";
//
//        File tfile = new File(filePath);
//        if (!tfile.exists()) {
//            tfile.mkdir();
//        }
//
//        file = new File(filePath, fileName);

    }

    protected void initWidgt(){
        logPreview = findViewById(R.id.logPreview);
        logPreview.setMovementMethod(new ScrollingMovementMethod());

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterBack();
            }
        });
    }

    String content = "";

    protected void showReview(){
        try {
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
            // 主线程设置log
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    logPreview.setText(content);
                    // 自动滚动到最后一行
                    int offset=logPreview.getLineCount()*logPreview.getLineHeight();
                    if(offset>logPreview.getHeight()){
                        logPreview.scrollTo(0,offset-logPreview.getHeight());
                    }
                }
            });
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void enterBack(){
        startActivity(new Intent(ReviewActivity.this,MainActivity.class));
        finish();
    }

}
