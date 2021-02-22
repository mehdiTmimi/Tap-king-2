package com.tmimi.tapking;

import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class BtnAction  implements View.OnClickListener {
    private MainActivity mainActivity;
    private Timer timer;
    @Override
    public void onClick(View v) {
        if(mainActivity.getEtat()==0)
        {
            mainActivity.getBtn().setText(mainActivity.getResources().getText(R.string.tap));
            mainActivity.setEtat(1);
            int difficulty=Integer.parseInt(mainActivity.getSpinner().getSelectedItem().toString());
            timer=new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    mainActivity.getProgressBar().setProgress(mainActivity.getProgressBar().getProgress()-1);
                }
            }, 0, 1000 / difficulty);
        }
        else if(mainActivity.getEtat()==1)
        {
            mainActivity.getProgressBar().setProgress(mainActivity.getProgressBar().getProgress()+1);
        }
        // arreter le timer
        timer.cancel();
        timer.purge();
    }
    public BtnAction(MainActivity mainActivity)
    {
        this.mainActivity=mainActivity;
    }
}
