package com.example.myapplication.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.ui.eassy.EassyActivity;
import com.example.myapplication.ui.me.MeActivity;
import com.example.myapplication.ui.media.MediaActivity;
import com.example.myapplication.ui.page.PageActivity;
import com.example.myapplication.ui.stats.StatsActivity;

public class DashboardFragment extends Fragment {
    private String db_url="";
    private DashboardViewModel dashboardViewModel;
    private ImageButton stats;
    private ImageButton  media;
    private ImageButton  page;
    private ImageButton eassy;

    private TextView textView_stats;
    private TextView  textView_media;
    private TextView  textView_page;
    private TextView textView_eassy;
    private TextView textView_setting;
    private String key;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        MainActivity mainActivity = (MainActivity)getActivity();
        key=mainActivity.getKey();
        db_url=mainActivity.getDB_url();
        stats =root.findViewById(R.id.imageButton_stats);
        media=root.findViewById(R.id.imageButton_media);
        page=root.findViewById(R.id.imageButton_page);
        eassy=root.findViewById(R.id.imageButton_essay);

        textView_eassy=root.findViewById(R.id.textView_eassy);
        textView_media=root.findViewById(R.id.textView_media);
        textView_page=root.findViewById(R.id.textView_page);
        textView_stats=root.findViewById(R.id.textView_stats);
        textView_setting=root.findViewById(R.id.textView_setting);

//        //设置监听
       setClickListener();
        textView_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(), MeActivity.class);
                intent.putExtra("key",key);
                intent.putExtra("url",db_url);
                startActivity(intent);

            }
        });
        return root;
    }

    public void setClickListener(){
        stats.setOnClickListener(new StatsOnClick());
        textView_stats.setOnClickListener(new StatsOnClick());
        media.setOnClickListener(new MediaOnClick());
        textView_media.setOnClickListener(new MediaOnClick());
        page.setOnClickListener(new PageOnClick());
        textView_page.setOnClickListener(new PageOnClick());
        eassy.setOnClickListener(new EassyOnClick());
        textView_eassy.setOnClickListener(new EassyOnClick());
    }

    private class StatsOnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent=new Intent();
            intent.setClass(getActivity(), StatsActivity.class);
            intent.putExtra("key",key);
            intent.putExtra("url",db_url);
            startActivity(intent);
        }
    }
    private class MediaOnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent=new Intent();
            intent.setClass(getActivity(), MediaActivity.class);
            intent.putExtra("key",key);
            intent.putExtra("url",db_url);
            startActivity(intent);
        }
    }
    private class PageOnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent=new Intent();
            intent.setClass(getActivity(), PageActivity.class);
            intent.putExtra("key",key);
            intent.putExtra("url",db_url);
            startActivity(intent);
        }
    }

    private class EassyOnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent=new Intent();
            intent.setClass(getActivity(), EassyActivity.class);
            intent.putExtra("key",key);
            intent.putExtra("url",db_url);
            startActivity(intent);
        }
    }
}