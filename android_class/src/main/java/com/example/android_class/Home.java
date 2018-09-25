package com.example.android_class;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Home extends AppCompatActivity {

    private String [] names={"疯狂Android讲义","计算机网络","数据库系统概论","数据结构"};
    private String [] authors={"李刚","詹姆斯.F.库仑斯","王珊","李云清"};
    private double[] price={108.00,89.00,39.60,42.00};
    private int [] itemImage={R.drawable.android,R.drawable.network,R.drawable.database,R.drawable.datastructure};
    private ListView list_item;   //用来获取listView中的控件
    private List<Map<String,Object>> list_map=new ArrayList<Map<String,Object>>();

    private ImageView imageView;
    private int currentIndex=0;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        list_item=(ListView)findViewById(R.id.list_item);
        initdata();
        SimpleAdapter adapter=new SimpleAdapter(Home.this,list_map,R.layout.ativity_list_item,new String[]{
                "image","name","author","price"
        },new int[] {
                R.id.item_image,R.id.name,R.id.author,R.id.price
        });
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,names);
        list_item.setAdapter(adapter);
        //设置自动图片轮播
        imageView=(ImageView)findViewById(R.id.Image1);
        handler=new Handler(){
            public  void handleMessage(Message msg){
                if(msg.what==0x11){
                    currentIndex=(currentIndex+1)%itemImage.length;
                    imageView.setImageResource(itemImage[currentIndex]);
                }
            }
        };
        start();
        //设置自动搜索功能
        AutoCompleteTextView autoCompleteTextView=(AutoCompleteTextView)findViewById(R.id.AutoCompleteTextView);
        autoCompleteTextView.setAdapter(adapter1);

    }
//开始线程
    private void start() {
        new Thread(){
            public void run(){
                while(true){
                    try{
                        Thread.sleep(6000);
                        handler.sendEmptyMessage(0x11);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
//初始化
    public void initdata(){
        for(int i=0;i<names.length;i++){
            Map<String,Object> item=new HashMap<String,Object>();
            item.put("name","《"+names[i]+"》");
            item.put("author","作者："+authors[i]);
            item.put("price","价格："+price[i]+"元");
            item.put("image",itemImage[i]);
            list_map.add(item);
        }
    }

}
