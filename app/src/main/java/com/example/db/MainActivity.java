package com.example.db;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.toastlibrary.Toaster;

public class MainActivity extends AppCompatActivity {
    private EditText et_username;
    private Button bt_save;
    private Button getdata,bttoast;
    private DBHelper dbHelper;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_username = findViewById(R.id.et_username);
        bt_save = findViewById(R.id.bt_save);
        getdata = findViewById(R.id.getdata);
        bttoast = findViewById(R.id.showtoast);
        dbHelper = DBHelper.getInstance(getApplicationContext());
        textView = findViewById(R.id.tv_stored_value);
        setlistener(getApplicationContext());


    }

    private void setlistener(Context context) {
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.saveInDB(et_username.getText().toString());

            }
        });
        getdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] strings= DBHelper.getInstance(getApplicationContext()).getFromDB();
              //  for (int i=0; i<strings.length; i++)
                    textView.setText(strings[0]);
             }
        });
        bttoast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toaster.showMyToast(context,"newtoast");
             }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}