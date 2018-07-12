package com.dh.thach.financialstatement.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dh.thach.financialstatement.R;
import com.dh.thach.financialstatement.adapter.*;

public class ActivityMain extends AppCompatActivity {

    android.support.v4.app.FragmentManager fragmentManager;
    android.support.v4.app.FragmentTransaction fragmentTransaction;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentIncome fragmentIncome;
    private LiabilitiesFragment liabilitiesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
//        fragmentManager = getSupportFragmentManager();
//        fragmentTransaction = fragmentManager.beginTransaction();
////        Intent intent = new Intent(this,FinancialStatementActivity.class);
////        startActivity(intent);
         fragmentIncome = new FragmentIncome();
         liabilitiesFragment = new LiabilitiesFragment();
//        fragmentTransaction.add(R.id.fragment_container, fragmentIncome);
//        fragmentTransaction.commit();

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        setIcon();
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(fragmentIncome, "Hello");
        adapter.addFragment(liabilitiesFragment, "World");
        viewPager.setAdapter(adapter);
    }

    private void setIcon()
    {
        tabLayout.getTabAt(0).setIcon(R.drawable.cricle_green);
        tabLayout.getTabAt(1).setIcon(R.drawable.cricle_red);
    }
}
