
package com.example.myapplication.ui.stats;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.utils.TimeConversion;
import com.example.myapplication.utils.httputil.Get;
import com.example.myapplication.model.LatestListParam;
import com.example.myapplication.model.StatsParam;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class StatsActivity extends AppCompatActivity {
    private String db_url="";
    private TextView eassy;
    private TextView comment;
    private TextView click_num;
    private TextView days;
    private ListView listView;
    private StatsParam statsParam;
    private LatestListParam latestListParam;
    private String key;
    private String result="";
    private String log_result="";
    private String stats_url="/api/admin/statistics";
    private String log_url="/api/admin/logs/latest?top=10";
    final CountDownLatch latch = new CountDownLatch(1);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats_activity);
        eassy=findViewById(R.id.stat_essay);
        comment=findViewById(R.id.stats_post);
        click_num=findViewById(R.id.stats_click);
        days=findViewById(R.id.day_set_up);
        listView=(ListView) findViewById(R.id.log_stats);

        Intent intent=getIntent();
        key=intent.getStringExtra("key");
        db_url=intent.getStringExtra("url");
        stats_url=db_url+stats_url;
        log_url=db_url+log_url;
        Gson gson=new Gson();
        new Thread(()->{
            result=new Get().get(stats_url,"",key);
            log_result=new Get().get(log_url,"",key);
            latch.countDown();
        }).start();

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        statsParam=gson.fromJson(result,StatsParam.class);
        latestListParam=gson.fromJson(log_result,LatestListParam.class);


        eassy.setText("文章:"+String.valueOf(statsParam.getData().getPostcount()));
        comment.setText("评论:"+String.valueOf(statsParam.getData().getCommentcount()));
        click_num.setText("访问数 ："+String.valueOf(statsParam.getData().getVisitCount()));
        days.setText("建立天数："+String.valueOf(statsParam.getData().getEstablishdays()));
        //days.setText("asdasdads"+latestListParam.getMessage());
       SimpleAdapter simpleAdapter = new SimpleAdapter(StatsActivity.this,getInfo(),R.layout.log_simple_list,new String []{"type","time","content"},new int[]{R.id.type_title,R.id.time_content,R.id.user_content});
       listView.setAdapter(simpleAdapter);
    }
    private List<Map<String,Object>> getInfo(){
        List<Map<String,Object>> list =new ArrayList<Map<String, Object>>();
        List<LatestListParam.Data> log_list = latestListParam.getData();
        for(LatestListParam.Data data:log_list){
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("type",data.getType());//待转换为中文
            map.put("time", TimeConversion.TimeConversion(data.getCreateTime()));
            map.put("content",data.getContent());
            list.add(map);
        }
        return list;
    }

}
