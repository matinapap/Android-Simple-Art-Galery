package com.example.myapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String value1 = intent.getStringExtra("key1");

        TextView t1, t2;
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);

        ImageView imageView;
        imageView = findViewById(R.id.imageView);

        SharedPreferences sp = getApplicationContext().getSharedPreferences(value1, Context.MODE_PRIVATE);
        String title = sp.getString("title", "");
        String image = sp.getString("image", "");
        String caption = sp.getString("caption", "");

        t1.setText(title);
        t2.setText(caption);
        @SuppressLint("DiscouragedApi") int resourceId = getResources().getIdentifier(image, "drawable", getPackageName());
        if (resourceId != 0) {
            imageView.setImageResource(resourceId);
        } else {
            imageView.setImageResource(R.drawable.paint1);
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}