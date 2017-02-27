package com.example.arafat.arafatdemo;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.arafat.arafatdemo.bean.Book;
import com.example.arafat.arafatdemo.util.utilLog;


import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;


    public class MainActivity extends BaseActivity {
        private ImageButton bt1;
        private ImageButton bt3;
        private ImageButton bt4;

        @OnClick(R.id.bt2)
        public void button2Click(){
            Intent intent = new Intent(this, DialogActivity.class);
            startActivityForResult(intent, 2);
            //toActivity(DialogActivity.class);
        }



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            initialView();
            initialListener();
            ButterKnife.bind(this);
        }

        private void initialView(){
            bt1 = (ImageButton) findViewById(R.id.bt1);
            bt3 = (ImageButton) findViewById(R.id.bt3);
            bt4 = (ImageButton) findViewById(R.id.bt4);

        }

        private void initialListener(){
            bt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Button1 was clicked", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(v.getContext(),ViewPagerActivity.class);
                    intent.putExtra("key","value");
                    Bundle bundle = new Bundle();
                    bundle.putInt("Integer", 12345);
                    Book book = new Book();
                    book.setName("Android");
                    book.setAuthor("Laura");
                    bundle.putSerializable("book", book);
                    intent.putExtras(bundle);
                    startActivityForResult(intent, 1);
                }
            });
            bt3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //toActivity(ListViewActivity.class);
                    Intent intent = new Intent(v.getContext(),ListViewActivity.class);
                    startActivityForResult(intent, 3);
                }
            });
            bt4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //toActivity(ListViewActivity.class);
                    Intent intent = new Intent(v.getContext(), ActivityA.class);
                    startActivity(intent);
                }

            });

        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            switch (requestCode){
                case 1:
                    String message = data.getStringExtra("message");
                    toastShort(message);
                    break;
                case 2:
                    toastShort("Dialog");
                    break;
                case 3:

                    toastShort("ListView");
                    break;
                default:
            }
        }

        public void onClick(View v){
            toastLong("Button2 was clicked");
            utilLog.logD("testD","Toast");

//        Toast.makeText(this, "Button2 was clicked", Toast.LENGTH_LONG).show();
//        Log.d("testD","Toast1");
        }

        @Override
        protected void onStart() {
            toastShort("onStart");
            super.onStart();
        }
    }