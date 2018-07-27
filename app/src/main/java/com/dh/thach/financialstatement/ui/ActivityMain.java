package com.dh.thach.financialstatement.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.dh.thach.financialstatement.R;
import com.dh.thach.financialstatement.adapter.*;

import java.util.ArrayList;
import java.util.List;

public class ActivityMain extends AppCompatActivity {

    android.support.v4.app.FragmentManager fragmentManager;
    android.support.v4.app.FragmentTransaction fragmentTransaction;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentIncome fragmentIncome;
    private LiabilitiesFragment liabilitiesFragment;
    private FragmentExpenses fragmentExpenses;
    private FragmentAssets fragmentAssets;

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
         fragmentExpenses = new FragmentExpenses();
         fragmentAssets = new FragmentAssets();
//        fragmentTransaction.add(R.id.fragment_container, fragmentIncome);
//        fragmentTransaction.commit();

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        setIcon();
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(fragmentIncome, "Income");
        adapter.addFragment(liabilitiesFragment, "Liabilities");
        adapter.addFragment(fragmentExpenses, "Expenses");
        adapter.addFragment(fragmentAssets, "Assets");
        viewPager.setAdapter(adapter);
    }

    private void setIcon()
    {
        tabLayout.getTabAt(0).setIcon(R.drawable.cricle_green);
        tabLayout.getTabAt(1).setIcon(R.drawable.cricle_red);
        tabLayout.getTabAt(2).setIcon(R.drawable.cricle_green);
        tabLayout.getTabAt(3).setIcon(R.drawable.cricle_red);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings:
                onClick();
                Toast.makeText(this,"action setting",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_add:
                Toast.makeText(this,"action add",Toast.LENGTH_SHORT).show();
                break;
                default:
                    break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void onClick() {
        ListView notificationListView = (ListView) findViewById(R.id.notification_list_view);

        // if you don't need the notifications anymore use:
        // notificationListView.setVisibility(View.GONE);
        notificationListView.setVisibility(View.VISIBLE);

        final List<String> notificationList = new ArrayList<>();
        notificationList.add("Notification 1");
        notificationList.add("Notification 2");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, notificationList);
        notificationListView.setAdapter(adapter);
        notificationListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String chosenNotification = notificationList.get(position);
            }
        });
    }
}
