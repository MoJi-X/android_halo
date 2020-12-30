package com.example.myapplication.ui.media;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.myapplication.R;
import com.example.myapplication.utils.httputil.Get;
import com.example.myapplication.model.MediaParam;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class MediaActivity extends AppCompatActivity {
    private String db_url="";
    private String page_url="/api/admin/attachments";
    private String param="?page=0&size=18";
    private String key;
    private MediaParam mediaParam;
    private String result;
    private ListView listView;
    final CountDownLatch latch = new CountDownLatch(1);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.media_activity);
        listView=findViewById(R.id.list_media);
        Intent intent=getIntent();
        key=intent.getStringExtra("key");
        db_url=intent.getStringExtra("url");
        page_url=db_url+page_url;
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
        mediaParam=gson.fromJson(result,MediaParam.class);

        SimpleAdapter simpleAdapter = new SimpleAdapter(MediaActivity.this,getInfo(),R.layout.media_simple_list,new String []{"title","picture"},new int []{R.id.type_title,R.id.media_picture});
        simpleAdapter.setViewBinder(new SimpleAdapter.ViewBinder(){
            @Override
            public boolean setViewValue(View view, Object data, String textRepresentation) {
                //data为传入适配器的数据
                if(view instanceof ImageView && data instanceof String){
                    ImageView view1 = (ImageView) view;
                    Glide.with(MediaActivity.this)
                            .load(data.toString())
                            .diskCacheStrategy(DiskCacheStrategy.NONE)
                            .into(view1);
                    return true;
                }
                return false;
            }
        });
        listView.setAdapter(simpleAdapter);
    }
    private List<Map<String,Object>> getInfo(){
        List<Map<String,Object>> list =new ArrayList<Map<String, Object>>();
        List<MediaParam.Data.Content> media_list=mediaParam.getData().getContent();
        for(MediaParam.Data.Content data:media_list){
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("title",data.getName());
            map.put("picture",data.getPath());
            list.add(map);
        }
        return list;
    }


}
