package com.example.myapplication.ui.eassy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.utils.TimeConversion;
import com.example.myapplication.utils.httputil.Get;
import com.example.myapplication.model.EassyParam;
import com.example.myapplication.view.WriteViewActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class EassyActivity extends AppCompatActivity {
    private String db_url="";
    private String page_url="/api/admin/posts";
    private String param="?page=0&size=10";
    private String key;
    private EassyParam eassyParam;
    private String result;
    private ListView listView;
    private FloatingActionButton floatingActionButton;
    final CountDownLatch latch = new CountDownLatch(1);
    protected void onCreate(Bundle e) {
        super.onCreate(e);
        setContentView(R.layout.eassy_activity);
        listView=findViewById(R.id.list_eassy);

        Intent intent=getIntent();
        key=intent.getStringExtra("key");
        db_url=intent.getStringExtra("url");
        page_url=db_url+page_url;
        floatingActionButton=findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent();
                intent.putExtra("key",key);
                intent.setClass(EassyActivity.this, WriteViewActivity.class);
                startActivity(intent);
                finish();
            }
        });
        new Thread(()->{
           result=new Get().get(page_url,param,key);
           latch.countDown();

        }).start();
        try {
           latch.await();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
        Gson gson =new Gson();
        eassyParam=gson.fromJson(result,EassyParam.class);

        SimpleAdapter simpleAdapter = new SimpleAdapter(EassyActivity.this,getInfo(),R.layout.eassy_simple_list,new String[]{"title","visits","status","commentCount","time"},new int[]{R.id.eassy_title,R.id.eassy_click,R.id.eassy_status,R.id.eassy_comment,R.id.eassy_time});
        listView.setAdapter(simpleAdapter);

        }

    private List<Map<String                                                                                                                                               ,Object>> getInfo(){
        List<Map<String,Object>> list =new ArrayList<Map<String, Object>>();
        EassyParam.Data data=eassyParam.getData();
        List<EassyParam.Data.Content> eassy_list= data.getContent();
        for(EassyParam.Data.Content content:eassy_list){
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("title",content.getTitle());
            map.put("visits","访问："+content.getVisits());
            map.put("status","状态："+content.getStatus());
            map.put("commentCount","评论："+content.getCommentCount());
            map.put("time","发表日期："+ TimeConversion.TimeConversion(content.getCreateTime()));
            list.add(map);
        }
        return list;
    }
}
