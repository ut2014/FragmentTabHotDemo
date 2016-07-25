package com.it5.fragmenttabhotdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.it5.fragmenttabhotdemo.fragment.Fragment1;
import com.it5.fragmenttabhotdemo.fragment.Fragment2;
import com.it5.fragmenttabhotdemo.fragment.Fragment3;
import com.it5.fragmenttabhotdemo.fragment.Fragment4;
import com.it5.fragmenttabhotdemo.fragment.Fragment5;

public class MainActivity extends AppCompatActivity {
    private FragmentTabHost tabHost;
    //布局填充器
    private LayoutInflater layoutInflater;

    /**
     * Fragment数组界面
     *
     */
    private Class mFragmentArray[] = { Fragment1.class, Fragment2.class,
            Fragment3.class, Fragment4.class, Fragment5.class };


    /**
     * 存放图片数组
     *
     */
    private int mImageArray[] = { R.drawable.tab1,
            R.drawable.tab2, R.drawable.tab3,
            R.drawable.tab4, R.drawable.tab5 };

    /**
     * 选修卡文字
     *
     */
    private String mTextArray[] = { "首页", "消息", "好友", "搜索", "更多" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        initView();
    }

    /**
     * 初始化组件
     */
    private void initView(){
        layoutInflater=layoutInflater.from(this);
        tabHost= (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(this,getSupportFragmentManager(),R.id.realtabcontent);
//        tabHost.getChildAt(0).performClick();

        //去掉分割线
        tabHost.getTabWidget().setDividerDrawable(null);
        //得到fragment的个数
        int count =mFragmentArray.length;
        for (int i=0;i<count;i++) {
            // 给每个Tab按钮设置图标、文字和内容
            FragmentTabHost.TabSpec tabSpec = tabHost.newTabSpec(mTextArray[i])
                    .setIndicator(getTabItemView(i));
            // 将Tab按钮添加进Tab选项卡中
            tabHost.addTab(tabSpec, mFragmentArray[i], null);
            // 设置Tab按钮的背景
      /*      tabHost.getTabWidget().getChildAt(i)
                    .setBackgroundResource(android.R.color.background_dark);*/
        }

        //设置当前tab
        tabHost.setCurrentTab(2);
    }

    /**
     *
     * 给每个Tab按钮设置图标和文字
     */
    private View getTabItemView(int index) {
        View view = layoutInflater.inflate(R.layout.tab_item_view, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
        imageView.setImageResource(mImageArray[index]);
        TextView textView = (TextView) view.findViewById(R.id.textview);
        textView.setText(mTextArray[index]);
        return view;
    }
}
