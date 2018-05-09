package com.example.hp.practical_quiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.hp.practical_quiz.R.menu.main;

public class MainActivity extends AppCompatActivity {

    Button next;
    EditText name, email,desc;
    SharedPreferences sharedPreferences;
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("usename","Falguni");
        savedInstanceState.putString("emailid","pfalguni307@gmail.com");
        savedInstanceState.putString("descri","I am an Android developer and loving this Android developer course..!!");
    }
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        next=(Button) findViewById(R.id.button);
        name=(EditText) findViewById(R.id.editText);
        email=(EditText) findViewById(R.id.editText2);
        desc=(EditText) findViewById(R.id.editText3);

            next.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (savedInstanceState != null) {
                String name = savedInstanceState.getString("usename");
                String email = savedInstanceState.getString("email");
                String desc = savedInstanceState.getString("desc");
                Intent intent = new Intent(getApplicationContext(), Details.class);
                Bundle extras = new Bundle();
                extras.putString("USERNAME",name);
                extras.putString("EMAIL",email);
                extras.putString("DESC",desc);
                intent.putExtras(extras);
                startActivity(intent);

            } else {

                sharedPreferences = getSharedPreferences("uname", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", name.getText().toString());
                editor.putString("email", email.getText().toString());
                editor.putString("description", desc.getText().toString());
                editor.commit();
                Intent intent = new Intent(getApplicationContext(), Details.class);
                startActivity(intent);
            }
            }});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(getApplicationContext(), Details.class);
        startActivity(intent);
        return true;

    }
}
