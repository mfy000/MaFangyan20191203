package com.bawei.mafangyan20191203.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bawei.mafangyan20191203.R;
import com.bawei.mafangyan20191203.base.BaseActivity;
import com.bawei.mafangyan20191203.view.fragment.Fragment_grid;
import com.bawei.mafangyan20191203.view.fragment.Fragment_home;
import com.bawei.mafangyan20191203.view.fragment.Fragment_my;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity  {


    private ViewPager viewPager;
    private RadioGroup radioGroup;
    private RadioButton radio_grid;
    private RadioButton radio_home;
    private RadioButton radio_my;

    @Override
    protected void initData() {
        final List<Fragment> fList=new ArrayList<>();
        fList.add(new Fragment_grid());
        fList.add(new Fragment_my());
        fList.add(new Fragment_home());
     viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
         @NonNull
         @Override
         public Fragment getItem(int position) {
             return fList.get(position);
         }

         @Override
         public int getCount() {
             return fList.size();
         }
     });
radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.radio_home:
                viewPager.setCurrentItem(0);
                break;
            case R.id.radio_grid:
                viewPager.setCurrentItem(1);
                break;
            case R.id.radio_my:
                viewPager.setCurrentItem(2);
                break;
        }
    }
});
    }

    @Override
    protected void initView() {
        viewPager = findViewById(R.id.ViewPager);
        radioGroup = findViewById(R.id.RadioGroup);
        radio_grid = findViewById(R.id.radio_grid);
        radio_home = findViewById(R.id.radio_home);
        radio_my = findViewById(R.id.radio_my);
    }

    @Override
    protected int bingLayoutID() {
        return R.layout.activity_main;
    }
}
