package com.example.bohongtao.sch;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;

public class startActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_start);
        Handler x = new Handler();
        x.postDelayed(new start(), 2000);

    }

    class start implements Runnable{
        public void run(){
            startActivity(new Intent(getApplication(),MainActivity.class));
            startActivity.this.finish();
        }
    }


}
