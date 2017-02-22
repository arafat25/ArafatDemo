package com.example.arafat.arafatdemo;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.arafat.arafatdemo.adapter.ListViewAdapter;
import com.example.arafat.arafatdemo.adapter.ViewPagerAdapter;
import com.example.arafat.arafatdemo.fragment.Fragment1;
import com.example.arafat.arafatdemo.fragment.Fragment2;
import com.example.arafat.arafatdemo.fragment.Fragment3;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listView;
    private ArrayList<String> listResult;
    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listResult = new ArrayList<String>();
        createFakeResult();
        initialView();


    }

    private void createFakeResult()
    {
        listResult.add("AAAAAAAAAAAAA");
        listResult.add("BBBBBBBB");
        listResult.add("CCCCCCC");
        listResult.add("DDDDDD");
        listResult.add("EEEE");
        listResult.add("F");
        listResult.add("GGGGGG");
        listResult.add("H");
        listResult.add("I");
        listResult.add("J");
        listResult.add("K");
        listResult.add("L");
        listResult.add("M");
        listResult.add("N");
        listResult.add("O");
        listResult.add("P");
        listResult.add("Q");
        listResult.add("R");
        listResult.add("S");
        listResult.add("T");
        listResult.add("U");
        listResult.add("V");
        listResult.add("W");
        listResult.add("X");
        listResult.add("Y");
        listResult.add("Z");

    }

    private void initialView()
    {
        listView = (ListView) findViewById(R.id.list_view);
        View view = getLayoutInflater().inflate(R.layout.list_view_header,null);

        LinearLayout listViewHeader= (LinearLayout)view.findViewById(R.id.list_view_header);

        viewPager = (ViewPager) view.findViewById(R.id.list_view_pager);

        fragmentList.add(new Fragment1());
        fragmentList.add(new Fragment2());
        fragmentList.add(new Fragment3());

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        viewPagerAdapter.setContent(fragmentList);
        viewPager.setAdapter(viewPagerAdapter);


        ListViewAdapter listViewAdapter = new ListViewAdapter(this,listResult);
        listView.addHeaderView(listViewHeader);

        TextView tv = new TextView(this);
        tv.setText("We have no more content.");
        tv.setTextSize(28);
        tv.setGravity(Gravity.CENTER);
        listView.addFooterView(tv);

        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Toast.makeText(this, "listView was clicked at position: " + position,Toast.LENGTH_LONG).show();
        Log.d("testListViewActivity", String.valueOf(position));
    }
    @Override
    public void onBackPressed(){

        Intent intent = new Intent();
        intent.putExtra("message", "ListView");
        setResult(RESULT_OK, intent);
        super.onBackPressed();
    }
}
