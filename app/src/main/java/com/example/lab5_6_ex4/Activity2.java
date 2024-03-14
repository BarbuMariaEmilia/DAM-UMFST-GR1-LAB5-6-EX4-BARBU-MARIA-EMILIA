package com.example.lab5_6_ex4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    ListView listView;
    EditText text;
    ArrayAdapter adapter;
    Intent mainPageIntent;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        listView = (ListView) findViewById(R.id.listChat2);
        text = (EditText) findViewById(R.id.txtSend);
        mainPageIntent = new Intent(this, MainActivity.class);

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

            Chat.chatHistory.add("Second:   "+ value);

            for (String i: Chat.chatHistory) {
                System.out.println(i);
            }

            adapter.notifyDataSetChanged();
        }
    }

    public void previousPage(View view) {
        startActivity(mainPageIntent);
    }
}