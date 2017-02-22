package com.example.arafat.arafatdemo;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.arafat.arafatdemo.adapter.ViewPagerAdapter;
import com.example.arafat.arafatdemo.bean.Book;
import com.example.arafat.arafatdemo.fragment.ContentFragment;
import com.example.arafat.arafatdemo.fragment.HistoryFragment;
import com.example.arafat.arafatdemo.fragment.LoginFragment;
import com.example.arafat.arafatdemo.util.utilLog;

import java.util.ArrayList;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
    private TabLayout tabLayout;
    //private ListView listView;
    /*private ArrayList<String> listResult;
    private android.view.View ViewHeader;*/

    //fragmentList.add(new)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // listResult = new ArrayList<String>();
        setContentView(R.layout.activity_view_pager);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String message = intent.getStringExtra("key");
        int number = bundle.getInt("Integer", 0);
        int fakeNumber = bundle.getInt("fake", 0);
        Book book = (Book) bundle.getSerializable("book");
        utilLog.logD("ViewPagerActivity", "value is: " + message);
        utilLog.logD("ViewPagerActivity", "number is: " + number);
        utilLog.logD("ViewPagerActivity", "Book author is: " + book.getAuthor());
        init();
    }

    @Override
    protected void onStart(){
        super.onStart();

    }

    private void init() {
        viewPager = (ViewPager)findViewById(R.id.view_pager);

        fragmentList.add(new ContentFragment());
        fragmentList.add(new HistoryFragment());
        fragmentList.add(new LoginFragment());
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        viewPagerAdapter.setContent(fragmentList);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(viewPagerAdapter);


        tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("message", "ListView");
        setResult(RESULT_OK, intent);
        super.onBackPressed();

    }
}
