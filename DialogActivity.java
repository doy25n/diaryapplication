package com.cookandroid.project10_2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;


public class DialogActivity extends AppCompatActivity {
    public String str = null;
    public Button cha_Btn, del_Btn, save_Btn, x_button;
    public EditText contextEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) { // 앱 첫 시작 시 돌아가는 메소드
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writediary);

        contextEditText = findViewById(R.id.contextEditText);
        save_Btn = findViewById(R.id.save_Btn);
        del_Btn = findViewById(R.id.del_Btn);
        cha_Btn = findViewById(R.id.cha_Btn);
        x_button = (Button) findViewById(R.id.button5);
        contextEditText.setText("");

        x_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        MainActivity.class);
                startActivity(intent);

            }
        });

        save_Btn.setVisibility(View.VISIBLE);
        cha_Btn.setVisibility(View.INVISIBLE);
        del_Btn.setVisibility(View.INVISIBLE);

        save_Btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                str = contextEditText.getText().toString();
                save_Btn.setVisibility(View.INVISIBLE);
                cha_Btn.setVisibility(View.VISIBLE);
                del_Btn.setVisibility(View.VISIBLE);

            }
        });


    }

}

