package com.example.myapplication.ui.notifications;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.utils.httputil.Get;
import com.example.myapplication.utils.httputil.Put;
import com.example.myapplication.model.LatestParam;
import com.example.myapplication.model.StatusParam;
import com.google.gson.Gson;

public class NotificationsViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private StatusParam statusParam;
    public NotificationsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
    public LatestParam Http_getLatestParam(String url,String params,String key){
        String response="";
        Gson gson = new Gson();
        response=new Get().get(url,params,key);
        LatestParam latestParam = gson.fromJson(response,LatestParam.class);
        return latestParam;
    }


    public ArrayAdapter<String> getAdapter(Context context, int layout, String data[]){
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(context,layout,data);
        return  arrayAdapter;
    }
    public int publishComment(String id,String key){
        String testurl="http://47.113.204.48/api/admin/posts/comments/"+id+"/status/PUBLISHED";
        int status=0;
        Gson gson = new Gson();
        return new Put().put(testurl,"",key);
    }
    public int deleteComment(String id,String key){
        String url="http://47.113.204.48/api/admin/posts/comments/"+id+"/status/RECYCLE";
        int status=0;
        return new Put().put(url,"",key);
    }

}