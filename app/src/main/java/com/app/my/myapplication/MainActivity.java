package com.app.my.myapplication;

import android.content.Context;
import android.content.res.Configuration;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.Surface;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v("0","oncreate orientation="+getResources().getConfiguration().orientation); //this value is always 1


        Display getOrient = getWindowManager().getDefaultDisplay();
        int orientation = Configuration.ORIENTATION_UNDEFINED;
        if(getOrient.getWidth()==getOrient.getHeight()){
            orientation = Configuration.ORIENTATION_SQUARE;
        } else{
            if(getOrient.getWidth() < getOrient.getHeight()){
                orientation = Configuration.ORIENTATION_PORTRAIT;
            }else {
                orientation = Configuration.ORIENTATION_LANDSCAPE;
            }
        }
        Log.v("0","oncreate orientation from default display="+orientation); //this value is also always 1


    }

    //never trigger this method
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.v("0","orientation="+newConfig.orientation);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Log.v("0","orientation="+newConfig.orientation);
        }
        int rotation=newConfig.orientation;
        int orientation;
        CharSequence text;
        switch (rotation) {
            case Surface.ROTATION_0:
                text = "SCREEN_ORIENTATION_PORTRAIT";
                break;
            case Surface.ROTATION_90:
                text = "SCREEN_ORIENTATION_LANDSCAPE";
                break;
            case Surface.ROTATION_180:
                text = "SCREEN_ORIENTATION_REVERSE_PORTRAIT";
                break;
            case Surface.ROTATION_270:
                text = "SCREEN_ORIENTATION_REVERSE_LANDSCAPE";
                break;
            default:
                text = "SCREEN_ORIENTATION_PORTRAIT";
                break;
        }
        Log.v("0","orientation="+text);
    }

}
