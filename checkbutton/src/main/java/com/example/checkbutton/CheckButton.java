package com.example.checkbutton;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

public class CheckButton extends Activity {
    RadioGroup rg;
    TextView show;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_button);
        rg=(RadioGroup)findViewById(R.id.rg);
        show=(TextView)findViewById(R.id.show);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                String tip=i == R.id.male ? "您的性别是男人" : "您的性别是女人";
                show.setText(tip);
            }
        });
    }
}
