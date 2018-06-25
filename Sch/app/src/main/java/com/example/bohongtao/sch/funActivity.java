package com.example.bohongtao.sch;

import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class funActivity extends AppCompatActivity {
    ImageView tv1,tv2,tv3,tv4,tv5,tv6,tv7;
    SoundPool msoundpool;
    int duo,la,mi,fa,sol,re,si;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun);
        tv1 = (ImageView) findViewById(R.id.tv1);
        tv2 = (ImageView) findViewById(R.id.tv2);
        tv3 = (ImageView) findViewById(R.id.tv3);
        tv4 = (ImageView) findViewById(R.id.tv4);
        tv5 = (ImageView) findViewById(R.id.tv5);
        tv6 = (ImageView) findViewById(R.id.tv6);
        tv7 = (ImageView) findViewById(R.id.tv7);

        OnClick m = new OnClick();
        msoundpool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        re = msoundpool.load(this,R.raw.re,1);
        duo = msoundpool.load(this, R.raw.duo, 1);
        mi = msoundpool.load(this, R.raw.mi, 1);
        fa = msoundpool.load(this, R.raw.fa, 1);
        sol = msoundpool.load(this, R.raw.sol, 1);
        la = msoundpool.load(this, R.raw.la, 1);
        si = msoundpool.load(this, R.raw.si, 1);
        tv1.setOnClickListener(m);
        tv2.setOnClickListener(m);
        tv3.setOnClickListener(m);
        tv4.setOnClickListener(m);
        tv5.setOnClickListener(m);
        tv6.setOnClickListener(m);
        tv7.setOnClickListener(m);
    }
    public class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            switch (v.getId()) {
                case R.id.tv1:
                    playSound(duo);
                    break;
                case R.id.tv2:
                    playSound(re);
                    break;
                case R.id.tv3:
                    playSound(mi);
                    break;
                case R.id.tv4:
                    playSound(fa);
                    break;
                case R.id.tv5:
                    playSound(sol);
                    break;
                case R.id.tv6:
                    playSound(la);
                    break;
                case R.id.tv7:
                    playSound(si);
                    break;

                default:
                    break;
            }
        }

    }
    private void playSound(int id){
        msoundpool.play(id, 1, 1, 0, 0, 1);
    }

}
