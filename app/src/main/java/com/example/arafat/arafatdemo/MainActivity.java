package com.example.arafat.arafatdemo;


import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.arafat.arafatdemo.bean.Book;
import com.example.arafat.arafatdemo.dialog.Quiz4;
import com.example.arafat.arafatdemo.util.utilLog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity implements View.OnTouchListener{

    private ImageButton bt1;
    private ImageButton bt3;
    private ImageButton bt2;
    private ImageButton launch_mode;

    private GestureDetector mGestureDetector;
    @BindView(R.id.main_fl)FrameLayout fl;

    @BindView(R.id.hw4) View hwview;
    private boolean check = false;
    private int var;
    private int counter;

    @OnClick(R.id.leftbutton)
    public void basebt(){
        if(check){
            hw4btcl();
        }
        else{
            hw4btop();
        }
    }

    public void hw4btop(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(hwview, "translationX", 0, 950); //translationY
        animator.setDuration(1000);
        animator.start();
        check = true;
    }

    public void hw4btcl(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(hwview, "translationX", 950, 0); //translationY
        animator.setDuration(1000);
        animator.start();
        check = false;
    }

    @OnClick(R.id.main_timer_anim)
    public void toAnimation(){
        toActivity(AnimationActivity.class);
    }
    @OnClick(R.id.main_timer_bt)
    public void toTimer() {
        toActivity(TimerActivity.class);
    }
    @OnClick(R.id.main_anim)
    public void toAnim() {
        toActivity(AnimatorActivity.class);
    }


    @OnClick(R.id.bt2)
    public void button2Click(){
        Intent intent = new Intent(this,DialogActivity.class);
        startActivityForResult(intent,2);
    }
    @OnClick(R.id.quiz4)
    public void toQuiz(){
        final Quiz4 dialog = new Quiz4(this, new Quiz4.ICustomDialogEventListener(){
            @Override
            public void onClickListener() {
                Intent intent = new Intent();
                intent.putExtra("message", "Dialog");
                setResult(RESULT_OK, intent);
                finish();
            }

            @Override
            public void onClick2Listener() {

            }

            @Override
            public void onClickCancel() {

            }
        });
        dialog.show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        initialListener();
        ButterKnife.bind(this);

        mGestureDetector = new GestureDetector(this, new simpleGestureListener());
        fl.setOnTouchListener(this);
    }
    @Override
    protected void onStart() {
        super.onStart();
        toastShort("onStart");
    }

    private void initialView(){
        //bt2 = (ImageButton) findViewById(R.id.bt2);
        bt1 = (ImageButton) findViewById(R.id.bt1);
        bt3 = (ImageButton) findViewById(R.id.bt3);
        launch_mode = (ImageButton) findViewById(R.id.launch_mode);

    }




    private void initialListener(){

        bt1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(v.getContext(), "Button 1 was clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent (v.getContext(),ViewPagerActivity.class);
                intent.putExtra("key","value");
                Bundle bundle = new Bundle();
                bundle.putInt("Integer", 12345);
                Book book = new Book();
                book.setName("Android");
                book.setAuthor("Arafat");
                bundle.putSerializable("book",book);
                intent.putExtras(bundle);
                //startActivity(intent);
                startActivityForResult(intent,1);
            }

        });

        bt3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // toActivity(ListViewActivity.class);
                Intent intent = new Intent(v.getContext(),ListViewActivity.class);
                startActivityForResult(intent,3);

                //Intent intent = new Intent (v.getContext(),ListViewActivity.class);
                //startActivity(intent);

            }

        });

        launch_mode.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                toActivity(ActivityA.class);


                //Intent intent = new Intent (v.getContext(),ListViewActivity.class);
                //startActivity(intent);

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
            case 4:
                break;
        }
    }

    public void onClick(View v){
        //Toast.makeText(this, "Button 2 was clicked", Toast.LENGTH_LONG).show();
        toastLong("Button2 was clicked");
        utilLog.logD("testD", "Toast");

        //Log.d("testD", "Toast");
    }

    public boolean onTouch(View v, MotionEvent event){
        return mGestureDetector.onTouchEvent(event);

    }
    private class simpleGestureListener extends
            GestureDetector.SimpleOnGestureListener{

        public boolean onDown(MotionEvent e){
//            utilLog.logD("MyGesture", "onDown");
//            toastShort("onDown");
            return true;
        }
        public void onShowPress(MotionEvent e){
//            utilLog.logD("MyGesture", "onShowPress");
//            toastShort("onShowPress");
        }
        public void onLongPress(MotionEvent e){
//            utilLog.logD("MyGesture", "onLongPress");
//            toastShort("onLongPress");
        }
        public boolean onSingleTapUp(MotionEvent e){
//            utilLog.logD("myGesture", "onSingleTapUp");
//            toastShort("onSingleTapUp");
            return true;
        }
        public boolean onSingleTapConfirmed(MotionEvent e){
//            utilLog.logD("myGesture", "onSingleTapUp");
//            toastShort("onSingleTapConfirmed");
            return true;
        }
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY){
            utilLog.logD("myGesture", "onScroll:" + (e2.getX() - e1.getX()) + " " + distanceX);
//            toastShort("onScroll");
            return true;
        }
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
            if(counter==0){
                ObjectAnimator animator = ObjectAnimator.ofFloat(hwview, "translationX", 0, 950,950,950,950); //translationY
                animator.setDuration(1000);
                animator.start();
                counter++;
            }
            else{
                ObjectAnimator animator = ObjectAnimator.ofFloat(hwview, "translationX", 950, 0,0,0,0); //translationY
                animator.setDuration(1000);
                animator.start();
                counter=0;
            }

            return true;
        }
        public boolean onDoubleTap(MotionEvent e){
            //           utilLog.logD("myGesture", "onDoubleTap");
            //           toastShort("onDoubleTap");
            return true;
        }
        public boolean onDoubleTapEvent(MotionEvent e){
            //           utilLog.logD("myGesture", "onDoubleTapEvent");
            //           toastShort("onDoubleTapEvent");
            return true;
        }

    }
}