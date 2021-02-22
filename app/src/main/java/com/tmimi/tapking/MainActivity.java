package com.tmimi.tapking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private Button btn;
    private Spinner spinner;
    private TextView textView;
    private int etat;// 0: initial, 1: en cours, 2: fin
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=findViewById(R.id.progressBar);
        btn=findViewById(R.id.button);
        spinner=findViewById(R.id.spinner);
        textView=findViewById(R.id.textView);
        BtnAction btnAction=new BtnAction(this);
        btn.setOnClickListener(btnAction);
        initialiser();
    }
   public void changeText(String text){
        this.textView.setText(text);
   }

   public void initialiser(){
        progressBar.setProgress(50);
        btn.setText(getResources().getText(R.string.start));
        etat=0;
       textView.setText("");
   }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    public Spinner getSpinner() {
        return spinner;
    }

    public void setSpinner(Spinner spinner) {
        this.spinner = spinner;
    }
}