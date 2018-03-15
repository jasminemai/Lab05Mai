package com.example.android.lab05_mai;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String DATABASE_NAME = "person_db";
    private Button submitBtn;
    private Button viewBtn;
    private LabDatabase labDB;
    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        labDB = Room.databaseBuilder(this, LabDatabase.class, DATABASE_NAME).build();

        submitBtn = findViewById(R.id.submitBtn);
        viewBtn = findViewById(R.id.viewBtn);
        input = findViewById(R.id.editText);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitToDatabase(input.getText().toString());
                input.setText("");
            }
        });

        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retrieveName();

            }
        });
    }

    private void submitToDatabase(String name)
    {
        MyAsyncTask myAsyncTask = new MyAsyncTask(labDB);
        myAsyncTask.execute(name);
    }

    private void retrieveName()
    {
        MyAsyncTask2 myAsyncTask2 = new MyAsyncTask2(labDB, getApplicationContext());
        myAsyncTask2.execute();
    }
}
