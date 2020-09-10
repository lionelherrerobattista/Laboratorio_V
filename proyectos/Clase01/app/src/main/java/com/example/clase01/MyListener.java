package com.example.clase01;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MyListener implements View.OnClickListener {

    MainActivity activity;
    TextView tv;

    public MyListener(MainActivity activity, TextView tv){
        this.activity = activity; //Le paso por referencia el ed
        this.tv = tv;
    }

    @Override
    public void onClick(View v) {


        if(v.getId()==R.id.btn) {
            EditText ed = activity.findViewById(R.id.ed); //Recién acá recupero el ed
            //Más óptimo hacer el ed acá
            tv.setText("Hola " + ed.getText());
        } else {
            tv.setText("Chau!!!");
        }

    }
}
