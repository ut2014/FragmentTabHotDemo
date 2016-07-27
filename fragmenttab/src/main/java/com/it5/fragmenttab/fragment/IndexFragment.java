package com.it5.fragmenttab.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.it5.fragmenttab.R;

/**
 * Created by IT5 on 2016/7/27.
 */
public class IndexFragment extends Fragment {
    public static final String TAG="IndexFragment";
    public static final String SHOW_TEXT="show_text";

    public View mTotalView;

    public IndexFragment(){
        
    }

    public static IndexFragment newInstance(String showText) {
        Bundle args = new Bundle();
        args.putString(SHOW_TEXT,showText);
        IndexFragment fragment = new IndexFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mTotalView=inflater.inflate(R.layout.index_frame,container,false);
        TextView showText= (TextView) mTotalView.findViewById(R.id.show_txt);
        showText.setText(getArguments().getString(SHOW_TEXT));
        return mTotalView;
    }
}
