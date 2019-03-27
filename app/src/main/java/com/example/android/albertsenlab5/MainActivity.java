package com.example.android.albertsenlab5;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    EditText edit1;
    EditText edit2;
    EditText edit3;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView2);
        edit1 = findViewById(R.id.editText);
        edit2 = findViewById(R.id.editText2);
        edit3 = findViewById(R.id.editText3);
        save = findViewById(R.id.button);

        final SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);

        edit1.setText(sharedPreferences.getString("name",""));
        edit2.setText(sharedPreferences.getString("pass", ""));
        edit3.setText(sharedPreferences.getString("email",""));

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edit1.getText().toString();
                String pass = edit2.getText().toString();
                String email = edit3.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("name", name);
                editor.putString("pass", pass);
                editor.putString("email", email);
                editor.commit();
                Toast.makeText(MainActivity.this, "Good Job!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
