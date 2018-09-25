package com.example.android_class_tabhost;

import android.app.TabActivity;
import android.os.Bundle;

public class TabHost extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_host);
        android.widget.TabHost tabHost=getTabHost();
        android.widget.TabHost.TabSpec tab1=tabHost.newTabSpec("tab1")
                .setIndicator("已接电话")
                .setContent(R.id.tab01);
        tabHost.addTab(tab1);
        android.widget.TabHost.TabSpec tab2=tabHost.newTabSpec("tab2")
                .setIndicator("未接电话")
                .setContent(R.id.tab02);
        tabHost.addTab(tab2);
    }
}
