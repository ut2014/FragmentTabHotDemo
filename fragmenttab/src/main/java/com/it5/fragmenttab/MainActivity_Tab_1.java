package com.it5.fragmenttab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.it5.fragmenttab.fragment.IndexFragment;

/**
 * Created by IT5 on 2016/7/26.
 */
public class MainActivity_Tab_1 extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    public static final String TAG = "Tab_1";
    //用于查找回退栈中的fragment，findFragmentByTag
    public static final String INDEX_TAG = "index";
    public static final String CATEGORY_TAG = "category";
    public static final String SHOP_TAG = "shop";
    public static final String ME_TAG = "me";
    public static final String MORE_TAG = "more";

    //底部菜单
    RadioGroup mTabMenu;
    //保留当前的显示的fragment的标签
    String mLastFragmentTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabgroup_1);
        initView();
    }

    private void initView() {
        //初始化底部菜单
        mTabMenu = (RadioGroup) findViewById(R.id.tab_menu);
        mTabMenu.setOnCheckedChangeListener(this);

        //后退栈为空，添加首页fragment
        if (findViewById(R.id.fragment_container) != null) {
            IndexFragment indexFragment = IndexFragment.newInstance(INDEX_TAG);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, indexFragment, INDEX_TAG)
                    //加这一句，回退到空白
//                    .addToBackStack(null)
                    .commit();
            mLastFragmentTag = INDEX_TAG;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.shop) {
            change(SHOP_TAG);
        } else if (checkedId == R.id.category) {
            change(CATEGORY_TAG);
        }else if (checkedId == R.id.index) {
            change(INDEX_TAG);
        }else if (checkedId == R.id.me) {
            change(ME_TAG);
        }else if (checkedId == R.id.more) {
            change(MORE_TAG);
        }
    }

    //切换 fragment
    private void change(String nowTag) {
        if (nowTag!=mLastFragmentTag) {
            Fragment lastFragment=getSupportFragmentManager().findFragmentByTag(mLastFragmentTag);
            Fragment nowFragment=getSupportFragmentManager().findFragmentByTag(nowTag);
            if (nowFragment!=null) {
                getSupportFragmentManager().beginTransaction()
                        .show(nowFragment)
                        .hide(lastFragment)
                        .commit();
            }else {
                Fragment fragment=IndexFragment.newInstance(nowTag);
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_container,fragment,nowTag)
                        .addToBackStack(null)
                        .hide(lastFragment)
                        .commit();
            }
            mLastFragmentTag=nowTag;
        }
    }


}
