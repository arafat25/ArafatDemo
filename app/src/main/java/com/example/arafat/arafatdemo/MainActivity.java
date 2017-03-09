package com.example.arafat.arafatdemo;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.arafat.arafatdemo.bean.Book;
import com.example.arafat.arafatdemo.util.utilLog;


import java.util.List;
import java.util.Timer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


    public class MainActivity extends BaseActivity implements View.OnTouchListener{
        private ImageButton bt1;
        private ImageButton bt3;
        private ImageButton bt4;
        private ScaleGestureDetector mGestureDetector;

        @BindView(R.id.main_fl) FrameLayout fl;




        @OnClick(R.id.main_anim_bt)
        public void toAnimation(){
            toActivity(AnimationActivity.class);
        }

        @OnClick(R.id.animator_bt)
        public void toAnimator(){
            toActivity(AnimatorActivity.class);
        }

        @OnClick(R.id.quiz_bt)
        public void toQuiz4(){
            toActivity(DialogActivity.class);
        }

        @OnClick(R.id.bt4)
        public void toActivityA(){
            toActivity(ActivityA.class);
        }

        @OnClick(R.id.main_timer_bt)
        public void toTimer(){
            toActivity((TimerActivity.class));
        }

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
            mGestureDetector = new ScaleGestureDetector(this, new simpleGestureListener());
            fl.setOnTouchListener(this);
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
        public boolean onTouch(View v, MotionEvent event){
            return mGestureDetector.onTouchEvent(event);
        }

        private class simpleGestureListener extends
                GestureDetector.SimpleOnGestureListener implements ScaleGestureDetector.OnScaleGestureListener {

            public boolean onDown(MotionEvent e){
                utilLog.logD("MyGesture", "onDown");
                toastShort( "onDown");
                return false;
            }

            public void onShowPress(MotionEvent e) {
                utilLog.logD("MyGesture", "onShowPress");
                toastShort( "onShowPress");

            }

            public void onLongPress(MotionEvent e) {
                utilLog.logD("MyGesture", "onLongPress");
                toastShort( "onLongPress");

            }

            public boolean onSingleTapUp(MotionEvent e) {
                utilLog.logD("MyGesture", "onSingleTapUp");
                toastShort( "onSingleTapUp");
                return true;
            }

            public boolean onSingleTapConfirmed(MotionEvent e) {
                utilLog.logD("MyGesture", "onSingleTapUp");
                toastShort( "onSingleTapConfirmed");
                return true;
            }

            public boolean onScroll(MotionEvent e1, MotionEvent e2,
                                    float distanceX, float distanceY) {
                utilLog.logD("MyGesture", "onScroll:" + (e2.getX() - e1.getX())+ " " + distanceX);
                toastShort( "onScroll");
                return true;
            }

            public boolean onFling(MotionEvent e1, MotionEvent e2,
                                    float velocityX, float velocityY) {
                utilLog.logD("MyGesture", "onFling");
                toastShort( "onFling");
                return true;
            }

            public boolean onDoubleTap(MotionEvent e) {
       //         utilLog.logD("MyGesture", "onDoubleTap");
                toastShort( "onDoubleTap");
                return true;
            }

            public boolean onDoubleTapEvent(MotionEvent e) {
    //            utilLog.logD("MyGesture", "onDoubleTapEvent");
                toastShort( "onDoubleTapEvent");
                return true;
            }




            @Override
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                return false;
            }

            @Override
            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return false;
            }

            @Override
            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {

            }



        }

        @Override
        protected void onStart() {
            toastShort("onStart");
            super.onStart();
        }
    }