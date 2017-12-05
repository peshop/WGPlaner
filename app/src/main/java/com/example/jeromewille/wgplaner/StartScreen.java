package com.example.jeromewille.wgplaner;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jeromewille.wgplaner.Fragments.BenotigteSachen;
import com.example.jeromewille.wgplaner.Fragments.ScreenAdapter;

public class StartScreen extends AppCompatActivity implements BenotigteSachen.OnFragmentInteractionListener{

    ScreenAdapter adapter;
    ViewPager pager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        this.Init();
    }


    private void Init()
    {
        this.tabLayout = (TabLayout) findViewById(R.id.TabLayout);
        this.tabLayout.addTab(tabLayout.newTab().setText("Benötigte Sachen"));
        this.tabLayout.addTab(tabLayout.newTab().setText("Gekaufte Sachen"));

        this.adapter = new ScreenAdapter(getSupportFragmentManager(), BenotigteSachen.class);

        this.pager = (ViewPager) findViewById(R.id.Pager);
        this.pager.setAdapter(adapter);

        this.pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(this.tabLayout));

        this.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
