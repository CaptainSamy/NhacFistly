package com.example.nhac_fistly.Activity;



import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;


import com.example.nhac_fistly.Adapter.MainViewPagerAdapter;
import com.example.nhac_fistly.Fragment.Fragment_Thong_Tin_App;
import com.example.nhac_fistly.Fragment.Fragment_Tim_Kiem;
import com.example.nhac_fistly.Fragment.Fragment_Trang_Chu;
import com.example.nhac_fistly.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        init();
        Toast.makeText(MainActivity.this, "Đang tải...",Toast.LENGTH_LONG).show();
    }

    private void init() {
        MainViewPagerAdapter mainViewPagerAdapter= new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPagerAdapter.addFragment(new Fragment_Trang_Chu(), "");
        mainViewPagerAdapter.addFragment(new Fragment_Tim_Kiem(),"");
        mainViewPagerAdapter.addFragment(new Fragment_Thong_Tin_App(),"");
        viewPager.setAdapter(mainViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.icontrangchu);
        tabLayout.getTabAt(1).setIcon(R.drawable.iconsearch);
        tabLayout.getTabAt(2).setIcon(R.drawable.iconinformation);
    }

    private void anhXa() {
        tabLayout =findViewById(R.id.myTabLayout);
        viewPager=findViewById(R.id.myViewPager);
    }
}
