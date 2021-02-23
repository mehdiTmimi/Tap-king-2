package com.tmimi.tapking;

import android.content.Context;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MyProgressBar extends ProgressBar {

    private MainActivity mainActivity;
    public MyProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public synchronized void setProgress(int value) {
       super.setProgress(value);
    // teste
        if(value==0)
        {
            // traitement en cas de perte
            mainActivity.getBtnAction().stopTimer();
            mainActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mainActivity.getTextView().setText(getResources().getText(R.string.loose));
                    mainActivity.getTextView().setTextColor(getResources().getColor(R.color.loose));
                }
            });
            mainActivity.setEtat(2);
            waitTwoSeconds();
        }
        else if(value==getMax())
        {
            // WIN
            mainActivity.getBtnAction().stopTimer();
            mainActivity.getTextView().setText(getResources().getText(R.string.win));
            mainActivity.getTextView().setTextColor(getResources().getColor(R.color.win));
            mainActivity.setEtat(2);
            waitTwoSeconds();
        }

    }
    public void setMainActivity(MainActivity mainActivity)
    {
        this.mainActivity=mainActivity;
    }
    public void waitTwoSeconds(){
        Vibrator v = (Vibrator) mainActivity.getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(2000);
        final Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                mainActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mainActivity.initialiser();
                    }
                });

                timer.cancel();
                timer.purge();
            }
        },2000);
    }
}
