package com.example.clase06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SinUserActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sin_user);

        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        SharedPreferences preferences = getSharedPreferences("config", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preferences.edit();

        TextView tv = findViewById(R.id.user);

        editor.putString("user", tv.getText().toString());

        editor.commit();

    }
}