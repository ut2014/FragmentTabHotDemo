package com.it5.fragmenttab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.it5.fragmenttab.fragment_1.TabAFm;
import com.it5.fragmenttab.fragment_1.TabBFm;
import com.it5.fragmenttab.fragment_1.TabCFm;
import com.it5.fragmenttab.fragment_1.TabDFm;
import com.it5.fragmenttab.fragment_1.TabEFm;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_TabHost_adp extends AppCompatActivity {

    /**
     * Called when the activity is first created.
     */
    private RadioGroup rgs;
    public List<Fragment> fragments = new ArrayList<Fragment>();

    public String hello = "hello ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabhost_adapter);

        fragments.add(new TabAFm());
        fragments.add(new TabBFm());
        fragments.add(new TabCFm());
        fragments.add(new TabDFm());
        fragments.add(new TabEFm());

        rgs= (RadioGroup) findViewById(R.id.tabs_rg);

        FragmentTabAdapter tabAdapter = new FragmentTabAdapter(this, fragments, R.id.tab_content, rgs);
        tabAdapter.setOnRgsExtraCheckedChangedListener(new FragmentTabAdapter.OnRgsExtraCheckedChangedListener(){
            @Override
            public void OnRgsExtraCheckedChanged(RadioGroup radioGroup, int checkedId, int index) {
                System.out.println("Extra---- " + index + " checked!!! ");
            }
        });

    }
}
