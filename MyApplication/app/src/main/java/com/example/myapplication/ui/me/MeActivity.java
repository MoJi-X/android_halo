package com.example.myapplication.ui.me;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;

/**
 * 个人设置
 */
public class MeActivity extends AppCompatActivity {
    private String db_url="";
    private TextView meSetting;
    private TextView exit;
    private String key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.me_fragment);

        meSetting=findViewById(R.id.textView_stats);
        exit=findViewById(R.id.textView_setting);

        Intent intent1=getIntent();
        key=intent1.getStringExtra("key");
        db_url=intent1.getStringExtra("url");
        meSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("key",key);
                intent.putExtra("url",db_url);
                intent.setClass(MeActivity.this,MeSetting.class);
                startActivity(intent);
                finish();
            }
        });



        //进行数据库删除，回到登录页面
    }

}
