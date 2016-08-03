package com.it5.fragmenttabhotdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.it5.fragmenttabhotdemo.fragment.Fragment1;
import com.it5.fragmenttabhotdemo.fragment.Fragment2;
import com.it5.fragmenttabhotdemo.fragment.Fragment3;
import com.it5.fragmenttabhotdemo.fragment.Fragment4;
import com.it5.fragmenttabhotdemo.fragment.Fragment5;

import java.util.ArrayList;
import java.util.List;

/**
 * FragmentTabHost+Fragment+viewpager 实现滑动分页
 */
public class MainActivity_TabHost_ViewPager extends AppCompatActivity {
    // 定义FragmentTabHost对象
    private FragmentTabHost mTabHost;
    //定义一个布局
    private LayoutInflater layoutInflater;

    /**
     * Fragment数组界面
     *
     */
    private Class mFragmentArray[] = { Fragment1.class, Fragment2.class,
            Fragment3.class, Fragment4.class, Fragment5.class };


    /**
     * 定义数组来存放按钮图片
     *
     */
    private int mImageArray[] = { R.drawable.tab1,
            R.drawable.tab2, R.drawable.tab3,
            R.drawable.tab4, R.drawable.tab5 };

    // Tab选项卡的文字
    private String mTextviewArray[] = { "首页", "消息", "好友", "广场", "更多" };

    private ViewPager viewPager;

    private List<Fragment> list = new ArrayList<Fragment>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabhost_viewpager);
        initview();
        initviewpager();
    }

    /**
     * 初始化组件
     */
    private void initview() {
        viewPager= (ViewPager) findViewById(R.id.pager);
        viewPager.addOnPageChangeListener(new ViewPagerListener());
        // 实例化布局对象
        layoutInflater=LayoutInflater.from(this);
        // 实例化TabHost对象，得到TabHost
        mTabHost= (FragmentTabHost) findViewById(android.R.id.tabhost);
        // 得到对象后，初始化
        mTabHost.setup(this,getSupportFragmentManager(), R.id.pager);
        mTabHost.setOnTabChangedListener(new TabHostListener());
        // 得到fragment的个数
        int count = mFragmentArray.length;
        for (int i=0;i<count;i++){
            // 为每一个Tab按钮设置图标、文字和内容
            FragmentTabHost.TabSpec tabSpec = mTabHost.newTabSpec(mTextviewArray[i])
                    .setIndicator(getTabItemView(i));
            // 将Tab按钮添加进Tab选项卡中
            mTabHost.addTab(tabSpec, mFragmentArray[i], null);
           /* mTabHost.setTag(i);
            // 设置Tab按钮的背景
            mTabHost.getTabWidget().getChildAt(i)
                    .setBackgroundResource(R.drawable.btn_color_selector);*/
        }

    }

    private void initviewpager() {
        Fragment1 p1=new Fragment1();
        Fragment2 p2=new Fragment2();
        Fragment3 p3=new Fragment3();
        Fragment4 p4=new Fragment4();
        Fragment5 p5=new Fragment5();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        viewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(),list));
        viewPager.setOffscreenPageLimit(5);
    }

    /**
     * 给Tab按钮设置图标和文字
     */
    private View getTabItemView(int index) {
        View view = layoutInflater.inflate(R.layout.tab_item_view, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
        imageView.setImageResource(mImageArray[index]);
        TextView textView = (TextView) view.findViewById(R.id.textview);
        textView.setText(mTextviewArray[index]);
        return view;
    }

    private class TabHostListener implements TabHost.OnTabChangeListener {
        @Override
        public void onTabChanged(String tabId) {
            int position = mTabHost.getCurrentTab();
            viewPager.setCurrentItem(position);
        }
    }


    class ViewPagerListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            TabWidget widget= mTabHost.getTabWidget();
            int oldFocusability = widget.getDescendantFocusability();
            widget.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
            mTabHost.setCurrentTab(position);
            widget.setDescendantFocusability(oldFocusability);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
