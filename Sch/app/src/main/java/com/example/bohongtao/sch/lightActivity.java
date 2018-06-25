package com.example.bohongtao.sch;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.ToggleButton;

public class lightActivity extends Activity {
    private ToggleButton toggleButton;
    private Camera camera = Camera.open();
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);

        toggleButton = (ToggleButton) this.findViewById(R.id.toggleButton1);
        //toggleButton.setOnClickListener(this);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ToggleButton tb = (ToggleButton) v;
                Camera.Parameters param = camera.getParameters();
                if(!toggleButton.isChecked()){
                    param.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                    toggleButton.setBackgroundDrawable(getResources().getDrawable(R.mipmap.light));
                }else{
                    param.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                    toggleButton.setBackgroundDrawable(getResources().getDrawable(R.mipmap.dark));
                }
                camera.setParameters(param);
            }
        });

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        //保持屏幕
    }

    @Override
    protected void onPause() {
//		camera.release();
//		Process.killProcess(Process.myPid());
        super.onPause();
    }
}