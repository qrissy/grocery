package com.example.grocery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText editText, editText2;
    String str, str2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.add_button);
        editText = (EditText) findViewById(R.id.editText2);
        editText2 = (EditText) findViewById(R.id.editText3);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FinalActivity.class);
                str = editText.getText().toString();
                str2 = editText2.getText().toString();
                intent.putExtra("Value", str);
                intent.putExtra("Value2", str2);
                startActivity(intent);
                finish();
            }
        });
    }


}
