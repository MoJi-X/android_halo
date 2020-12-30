package com.example.myapplication.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.model.LatestParam;
import com.example.myapplication.utils.TimeConversion;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class NotificationsFragment extends Fragment {
    private String db_url="";

    private NotificationsViewModel notificationsViewModel;
    private String key;
    private String query="?top=5&status=AUDITING";
    private String eassy_url="/api/admin/posts/comments/latest";
    private String page_url="/api/admin/sheets/comments/latest";
    private LatestParam pageParam;
    private LatestParam eassyParam;
    private boolean put_status=false;
    final CountDownLatch latch = new CountDownLatch(1);
    private String test_data[];
    private String test[]={"123123","123123"};
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Gson gson = new Gson();
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);
        MainActivity mainActivity=(MainActivity)getActivity();
        String key=mainActivity.getKey();
        db_url=mainActivity.getDB_url();
        eassy_url=db_url+eassy_url;
        page_url=db_url+page_url;
        new Thread(()->{
            eassyParam=notificationsViewModel.Http_getLatestParam(eassy_url,query,key);
            pageParam=notificationsViewModel.Http_getLatestParam(page_url,query,key);
            latch.countDown();
        }).start();

        // 等待数据传回
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    //测试数据
//        List<LatestParam.Data> list= eassyParam.getData();
//        test_data=new String[list.size()];
//        int i=0;
//        for(LatestParam.Data data:list){
//            test_data[i]=data.getAuthor()+" "+data.getContent();
//            i++;
//        }

        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        TabHost tab = (TabHost) root.findViewById(android.R.id.tabhost);
        ListView notification_all=root.findViewById(R.id.notification_all);
        ListView notification_eassy = root.findViewById(R.id.notification_unread);
        ListView notification_page= root.findViewById(R.id.notification_comment);

        //初始化TabHost容器
        tab.setup();
        //在TabHost创建标签，然后设置：标题／图标／标签页布局
        tab.addTab(tab.newTabSpec("tab1").setIndicator("全部", null).setContent(R.id.tab1));
        tab.addTab(tab.newTabSpec("tab2").setIndicator("文章", null).setContent(R.id.tab2));
        tab.addTab(tab.newTabSpec("tab2").setIndicator("页面" , null).setContent(R.id.tab3));


//        notification_all.setAdapter(notificationsViewModel.getAdapter(getActivity(),android.R.layout.simple_list_item_1,test_data));
        SimpleAdapter simpleAdapter =new SimpleAdapter(getActivity(),getInfo(),R.layout.notification_simple_list,new String []{"name","content","time","id"},new int[]{R.id.list_notification_name,R.id.list_notification_context,R.id.list_notification_time,R.id.list_notification_id}){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                final int p=position;
                final View view=super.getView(position, convertView, parent);
                Button useBtn=(Button)view.findViewById(R.id.button_pass);
                Button button=view.findViewById(R.id.button_delete);
                TextView textView=(TextView)view.findViewById(R.id.list_notification_time);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new Thread(()->{
                            put_status=notificationsViewModel.deleteComment(textView.getText().toString(),key)==200;
                        }).start();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if(put_status){
                            Toast.makeText(getActivity(),"操作成功",Toast.LENGTH_SHORT).show();
                            put_status=false;
                        }else {
                            Toast.makeText(getActivity(),"失败",Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                useBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        new Thread(()->{
                            put_status=notificationsViewModel.publishComment(textView.getText().toString(),key)==200;
                        }).start();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if(put_status){
                            Toast.makeText(getActivity(),"操作成功",Toast.LENGTH_SHORT).show();
                            put_status=false;
                        }else {
                            Toast.makeText(getActivity(),"失败",Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                return view;
            }

        };
        notification_eassy.setAdapter(simpleAdapter);
        SimpleAdapter simpleAdapter1 =new SimpleAdapter(getActivity(),getInfo1(),R.layout.notification_simple_list,new String []{"name","content","time","id"},new int[]{R.id.list_notification_name,R.id.list_notification_context,R.id.list_notification_time,R.id.list_notification_id}){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                final int p=position;
                final View view=super.getView(position, convertView, parent);
                Button useBtn=(Button)view.findViewById(R.id.button_pass);
                Button button=view.findViewById(R.id.button_delete);
                TextView textView=(TextView)view.findViewById(R.id.list_notification_time);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new Thread(()->{
                            put_status=notificationsViewModel.deleteComment(textView.getText().toString(),key)==200;
                        }).start();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if(put_status){
                            Toast.makeText(getActivity(),"操作成功",Toast.LENGTH_SHORT).show();
                            put_status=false;
                        }else {
                            Toast.makeText(getActivity(),"失败",Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                useBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        new Thread(()->{
                            put_status=notificationsViewModel.publishComment(textView.getText().toString(),key)==200;
                        }).start();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if(put_status){
                            Toast.makeText(getActivity(),"操作成功",Toast.LENGTH_SHORT).show();
                            put_status=false;
                        }else {
                            Toast.makeText(getActivity(),"失败",Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                return view;
            }

        };
        notification_page.setAdapter(simpleAdapter1);
        SimpleAdapter simpleAdapter2 =new SimpleAdapter(getActivity(),getInfo2(),R.layout.notification_simple_list,new String []{"name","content","time","id"},new int[]{R.id.list_notification_name,R.id.list_notification_context,R.id.list_notification_time,R.id.list_notification_id}){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                final int p=position;
                final View view=super.getView(position, convertView, parent);
                Button useBtn=(Button)view.findViewById(R.id.button_pass);
                Button button=view.findViewById(R.id.button_delete);
                TextView textView=(TextView)view.findViewById(R.id.list_notification_time);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new Thread(()->{
                            put_status=notificationsViewModel.deleteComment(textView.getText().toString(),key)==200;
                        }).start();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if(put_status){
                            Toast.makeText(getActivity(),"操作成功",Toast.LENGTH_SHORT).show();
                            put_status=false;
                        }else {
                            Toast.makeText(getActivity(),"失败",Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                useBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        new Thread(()->{
                            put_status=notificationsViewModel.publishComment(textView.getText().toString(),key)==200;
                        }).start();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if(put_status){
                            Toast.makeText(getActivity(),"操作成功",Toast.LENGTH_SHORT).show();
                            put_status=false;
                        }else {
                            Toast.makeText(getActivity(),"失败",Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                return view;
            }

        };
        notification_all.setAdapter(simpleAdapter2);
        return root;
    }
    //待优化
    private List<Map<String,String>> getInfo(){
        List<Map<String,String>> list =new ArrayList<Map<String, String>>();

        List<LatestParam.Data> eassy_list= eassyParam.getData();
        for(LatestParam.Data data:eassy_list){
            Map<String,String> map = new HashMap<String, String>();
            map.put("name",data.getAuthor());
            map.put("content",data.getContent());
            map.put("id",""+data.getId());//待转化
            map.put("time", TimeConversion.TimeConversion(data.getCreatetime()));
            list.add(map);
        }
        return list;
    }
    private List<Map<String,String>> getInfo1(){
        List<Map<String,String>> list =new ArrayList<Map<String, String>>();

        List<LatestParam.Data> eassy_list= pageParam.getData();
        for(LatestParam.Data data:eassy_list){
            Map<String,String> map = new HashMap<String, String>();
            map.put("name",data.getAuthor());
            map.put("content",data.getContent());
            map.put("id",""+data.getId());//待转化
            map.put("time", TimeConversion.TimeConversion(data.getCreatetime()));
            list.add(map);
        }
        return list;
    }
    private List<Map<String,String>> getInfo2(){
        List<Map<String,String>> list =new ArrayList<Map<String, String>>();

        List<LatestParam.Data> eassy_list= pageParam.getData();
        for(LatestParam.Data data:eassy_list){
            Map<String,String> map = new HashMap<String, String>();
            map.put("name",data.getAuthor());
            map.put("content",data.getContent());
            map.put("id",""+data.getId());//待转化
            map.put("time",""+ TimeConversion.TimeConversion(data.getCreatetime()));
            list.add(map);
        }
        List<LatestParam.Data> eassy_list1= eassyParam.getData();
        for(LatestParam.Data data:eassy_list1){
            Map<String,String> map = new HashMap<String, String>();
            map.put("name",data.getAuthor());
            map.put("content",data.getContent());
            map.put("id",""+data.getId());//待转化
            map.put("time",""+ TimeConversion.TimeConversion(data.getCreatetime()));
            list.add(map);
        }
        return list;
    }


}