package com.example.grocery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    TextView tv, tv2;
    String str, str2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        tv = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView2);


        str = getIntent().getExtras().getString("Value");
        str2 = getIntent().getExtras().getString("Value2");
        tv.setText(str);
        tv2.setText(str2);

        //share text on btn click
        Button buttonShare = findViewById(R.id.button_share);
        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get text from textview
                String text = tv.getText().toString();
                String text2 = tv2.getText().toString();

                //sharing intent
                Intent btnShareIntent = new Intent(Intent.ACTION_SEND);
                StringBuilder builder = new StringBuilder();
                builder.append(text);
                builder.append(text2);
                btnShareIntent.setType("text/plain");
                btnShareIntent.putExtra(Intent.EXTRA_SUBJECT, "Write your subject here");
                btnShareIntent.putExtra(Intent.EXTRA_TEXT, builder.toString());
                //btnShareIntent.putExtra(Intent.EXTRA_TEXT, text);
                //btnShareIntent.putExtra(Intent.EXTRA_TEXT, text2);
                startActivity(Intent.createChooser(btnShareIntent, "Share text via"));



            }
        });
    }

}
