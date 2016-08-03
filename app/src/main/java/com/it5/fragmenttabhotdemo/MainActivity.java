package com.it5.fragmenttabhotdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.it5.fragmenttab.MainActivity_TabHost_adp;
import com.it5.fragmenttab.MainActivity_Tab_1;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tabHost_One(View view){
        Toast.makeText(this,"tabHost_One",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,MainActivity_One.class));
    }
    public void tabHost_Two(View view){
        Toast.makeText(this,"tabHost_Two",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,MainActivity_Two.class));
    }
    public void tab_group_One(View view){
        Toast.makeText(this,"tab_group_One",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,MainActivity_Tab_1.class));
    }
    public void tab_group_Two(View view){
        Toast.makeText(this,"tab_group_Two",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,MainActivity_TabHost_adp.class));

    }

    public void tab_host_viewpager(View view){
        Toast.makeText(this,"tab_group_Two",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,MainActivity_TabHost_ViewPager.class));
    }

    public void tab_bgabadgerview(View view){
        Toast.makeText(this,"tab_group_Two",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,MainActivity_BGABadgeView.class));
    }

}
