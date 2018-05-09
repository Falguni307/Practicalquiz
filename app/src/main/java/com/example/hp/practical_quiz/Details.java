package com.example.hp.practical_quiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by HP on 30-04-2018.
 */

public class Details extends AppCompatActivity {
    TextView name1, email1,desc1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);
        name1 =(TextView) findViewById(R.id.textView);
        email1 =(TextView) findViewById(R.id.textView2);
        desc1 =(TextView) findViewById(R.id.textView3);

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
        String name1 = extras.getString("USERNAME");
        String email1 = extras.getString("EMAIL");
        String desc1 = extras.getString("DESC");
        }
        SharedPreferences sharedPreferences = getSharedPreferences("uname", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username","");
        String email = sharedPreferences.getString("email","");
        String description = sharedPreferences.getString("description","");
        name1.setText(username);
        email1.setText(email);
        desc1.setText(description);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.back,menu);
       return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        return true;

    }

}
