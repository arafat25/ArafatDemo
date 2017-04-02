package com.example.arafat.arafatdemo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.widget.RadioGroup;

import com.example.arafat.arafatdemo.DialogActivity;
import com.example.arafat.arafatdemo.ListViewActivity;
import com.example.arafat.arafatdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;



    public class Quiz4 extends Dialog{

        private Quiz4.ICustomDialogEventListener listener;
        private int checkedID;


        @BindView(R.id.quizrdg)
        RadioGroup radioGroup;

        @OnClick(R.id.Cancel)
        public void onCancel(){
          //  Intent intent = new Intent(getContext(), ViewPagerActivity.class );
          //  getContext().startActivity(intent);
            dismiss();
        }

        @OnClick(R.id.Ok)
        public void onOkay(){
            switch (checkedID){
                case R.id.Button1:
                    listener.onClickListener();
                    Intent intent = new Intent(getContext(), DialogActivity.class );
                    getContext().startActivity(intent);
                    break;
                case R.id.Button2:
                    Intent intent2 = new Intent(getContext(), ListViewActivity.class );
                    getContext().startActivity(intent2);
                    break;
                default:
            }
            dismiss();
        }

        private void quiz1(){

        }




        public Quiz4(@NonNull Context context, Quiz4.ICustomDialogEventListener listener){
            super(context, R.style.dialog);
            this.listener = listener;
        }

        public interface ICustomDialogEventListener{
            public void onClickListener();

            void onClick2Listener();

            void onClickCancel();
        }

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_quiz4);
            ButterKnife.bind(this);

            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                    //toastShort("You checked the radio button"+checkedId);
                    checkedID = checkedId;
                }
            });
        }
    }
