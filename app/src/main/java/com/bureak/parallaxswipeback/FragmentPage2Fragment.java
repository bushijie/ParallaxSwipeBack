package com.bureak.parallaxswipeback;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentPage2Fragment
        extends Fragment
{
    TextView textView;

    // 要显示的视图
    protected View currentView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        currentView = inflater.inflate(R.layout.fragment_page, container, false);
        return currentView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        textView = (TextView) currentView.findViewById(R.id.tv_fragment_page);

        // 初始化
        init();
    }

    /**
     * 初始化
     */
    protected void init()
    {
        textView.setText("页卡2");
    }
}
