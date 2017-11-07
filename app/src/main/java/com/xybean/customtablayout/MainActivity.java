package com.xybean.customtablayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.Toast;

import com.xybean.customtablayout.fragment.OneFragment;
import com.xybean.customtablayout.fragment.ThreeFragment;
import com.xybean.customtablayout.fragment.TwoFragment;
import com.xybean.customtablayout.tablayout.CustomTabItem;
import com.xybean.customtablayout.tablayout.CustomTabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>() {{
        add(new OneFragment());
        add(new TwoFragment());
        add(new ThreeFragment());
    }};

    private CustomTabLayout tabLayout;
    private ViewPager viewPager;
    private MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        adapter = new MyAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager, true);
        viewPager.setCurrentItem(0);

        List<String> tabs = new ArrayList<>();
        tabs.add("helllllllllo");
        tabs.add("world");
        tabs.add("!!!!!!!");

        if (tabLayout.getTabCount() == 0) {
            for (int i = 0; i < tabs.size(); i++) {
                CustomTabItem item = new CustomTabItem(this);
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                tabLayout.addView(item, layoutParams);
            }
        }

        for (int i = 0; i < tabs.size(); i++) {
            CustomTabLayout.Tab temp = tabLayout.getTabAt(i);
            if (temp != null) {
                temp.setText(tabs.get(i));
            }
        }

        tabLayout.addOnTabSelectedListener(new CustomTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(CustomTabLayout.Tab tab) {
                Toast.makeText(MainActivity.this, tab.getText(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(CustomTabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(CustomTabLayout.Tab tab) {

            }
        });
    }
}
