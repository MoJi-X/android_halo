package com.example.myapplication.ui.page;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.utils.httputil.Get;
import com.example.myapplication.model.PageParam;
import com.example.myapplication.view.WebViewActivty;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class PageActivity extends AppCompatActivity {
    private String db_url="";
    private ListView listView;
    private String page_url="/api/admin/sheets/independent";
    private String key;
    private PageParam pageParam;
    final CountDownLatch latch = new CountDownLatch(1);
    protected void onCreate(Bundle e) {
        super.onCreate(e);
        setContentView(R.layout.page_activity);
        Intent intent=getIntent();
        key=intent.getStringExtra("key");
        db_url=intent.getStringExtra("url");
        page_url=db_url+page_url;

        listView=findViewById(R.id.list_page);

        Gson gson =new Gson();
        new Thread(()->{
            String result=new Get().get(page_url,"",key);
            pageParam=gson.fromJson(result,PageParam.class);
            latch.countDown();
        }).start();

        try {
            latch.await();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(PageActivity.this,getInfo(),R.layout.page_simple_list,new String[]{"title","fullpath","editable"},new int[]{R.id.page_title,R.id.page_path,R.id.page_available})
        {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                final int p=position;
                final View view=super.getView(position, convertView, parent);
                TextView textView=view.findViewById(R.id.page_path);
                TextView textView2=view.findViewById(R.id.page_available);
                TextView textView1=view.findViewById(R.id.page_title);
                if(textView2.getText().toString().equals("可用")){
                    textView1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent1 = new Intent();
                            intent.setClass(PageActivity.this, WebViewActivty.class);
                            intent.putExtra("url",textView.getText().toString());
                            startActivity(intent);
                            finish();
                        }
                    });
                }
                return view;
            }

        }
        ;
        listView.setAdapter(simpleAdapter);

    }
    private List<Map<String,Object>> getInfo(){
        List<Map<String,Object>> list =new ArrayList<Map<String, Object>>();
        List<PageParam.Data> page_list= pageParam.getData();
        for(PageParam.Data data:page_list){
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("title",data.getTitle());
            map.put("fullpath",data.getFullPath());
            if(data.getAvailable()){
                map.put("editable","可用");
            }else map.put("editable","不可用");
            list.add(map);
        }
        return list;
    }
}