package com.example.myapplication.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.dao.DataBaseHelp;
import com.example.myapplication.dao.OperateTable;
import com.example.myapplication.dao.SearchTable;
import com.example.myapplication.utils.httputil.Post;
import com.example.myapplication.model.CheckParam;
import com.example.myapplication.model.LoginParam;
import com.google.gson.Gson;

import java.util.concurrent.CountDownLatch;

public class LoginActivity extends AppCompatActivity {
    private DataBaseHelp helper=null;
    private OperateTable mytable=null;
    private SearchTable searchTable=null;
    private String db_url="";
    private String login_url="/api/admin/login";

    private Button sign_in;
    private Button setting;
    private EditText userID;
    private EditText userPassword;
    private TextView t_log;
    private String result="";
    final CountDownLatch latch = new CountDownLatch(1);
    protected void onCreate(Bundle e){
        super.onCreate(e);
        setContentView(R.layout.login_activity);

        sign_in=findViewById(R.id.sign_in);
        setting=findViewById(R.id.setting);
        userID=findViewById(R.id.userID);
        t_log=findViewById(R.id.t_log);
        userPassword=findViewById(R.id.userPassword);
//获取ip
        helper=new DataBaseHelp(this);
        searchTable=new SearchTable(helper.getReadableDatabase());
        db_url=searchTable.find_ip(1);
        login_url=db_url+login_url;
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gson gson=new Gson();
                Thread t=new Thread(()->{
                    result=new Post().post(login_url,gson.toJson(getLoginParam()));
                    latch.countDown();
                });
                t.start();
                // 等待数据传回
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                String check=result;

                if(check.equals("error")){
                    Toast.makeText(LoginActivity.this,"账号密码错误",Toast.LENGTH_SHORT).show();
                    System.out.println("&*************^*&(%*&%*&(^&^*&(^(*&^*&^(*&^*&^*&^*&^*&^");
                    return;
                }
                CheckParam checkParam=gson.fromJson(check, CheckParam.class);
                Intent intent=new Intent();
                intent.setClass(com.example.myapplication.view.LoginActivity.this, MainActivity.class);
                intent.putExtra("accessToken",checkParam.getData().getAccess_token());
                intent.putExtra("url",db_url);
                //sql
                mytable=new OperateTable(helper.getWritableDatabase());
                mytable.insert(userID.getText().toString(),userPassword.getText().toString(),checkParam.getData().getAccess_token().toString());
                startActivity(intent);
                finish();

            }
        });
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(com.example.myapplication.view.LoginActivity.this,APIActivity.class);
                startActivity(intent);
            }
        });
        t_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("url",db_url);
                intent.setClass(com.example.myapplication.view.LoginActivity.this, WebViewActivty.class);
                startActivity(intent);
                finish();
            }
        });

    }

    /**
     * 返回登录信息
     * @return
     */
    private LoginParam getLoginParam(){
        LoginParam loginParam=null;
        loginParam=new LoginParam(userID.getText().toString(),userPassword.getText().toString(),null);
        return loginParam;
    }
}
