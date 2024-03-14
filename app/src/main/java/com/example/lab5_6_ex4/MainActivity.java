package com.example.lab5_6_ex4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter adapter;
    Intent secondPageIntent;
    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        text = (EditText) findViewById(R.id.txtSend);
        secondPageIntent = new Intent(MainActivity.this, Activity2.class);
        listView = (ListView) findViewById(R.id.listChat);

        try {
            adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, Chat.chatHistory);
            listView.setAdapter(adapter);
        }catch(Exception ex) {

        }
    }

    public void sendMessage(View view) {
        String value = text.getText().toString();
        if(!value.equals("")) {
            //Toast.makeText(getApplicationContext(), text.getText(), Toast.LENGTH_SHORT).show();
            text.setText("");

            Chat.chatHistory.add("Main:   "+value);

            for (String i: Chat.chatHistory) {
                System.out.println(i);
            }

            adapter.notifyDataSetChanged();

        }
    }

    public void nextPage(View view) {
        startActivity(secondPageIntent);
    }
}