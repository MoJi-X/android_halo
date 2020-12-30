package com.example.myapplication.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.dao.DataBaseHelp;
import com.example.myapplication.dao.OperateTable;
import com.example.myapplication.dao.SearchTable;

public class APIActivity extends AppCompatActivity {
    private DataBaseHelp helper=null;
    private OperateTable mytable=null;
    private SearchTable searchTable=null;
    private Button save;
    private Button reset;
    private EditText IP;

    private String default_ip="http://47.113.204.48";
    private String new_ip="";
    protected void onCreate(Bundle e){
        super.onCreate(e);
        setContentView(R.layout.setting_activity);
        save=findViewById(R.id.API_Save);
        reset=findViewById(R.id.API_Reset);
        IP=findViewById(R.id.set_ip);
        helper=new DataBaseHelp(this);
        searchTable=new SearchTable(helper.getReadableDatabase());
        default_ip=searchTable.find_ip(1);

        //显示默认IP
        IP.setText(default_ip);

        //设置API
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new_ip=IP.getText().toString();
                mytable=new OperateTable(helper.getWritableDatabase());
                mytable.update_API(1,new_ip);
            }
        });

        //恢复默认设置
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IP.setText(default_ip);
                new_ip=default_ip;
            }
        });
    }
}
