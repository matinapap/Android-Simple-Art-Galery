package com.example.myapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button button1, button2, button3, button4, button5;

    protected void paintingsData(int title, String image, int caption) {
        SharedPreferences shp = getSharedPreferences("sp", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shp.edit();
        editor.putString("title", getString(title));
        editor.putString("image", image);
        editor.putString("caption", getString(caption));
        editor.apply();
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("key1", "sp");
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);

        button1.setOnClickListener(v -> paintingsData( R.string.button1_text, "paint1", R.string.paintings_info1));

        button2.setOnClickListener(v -> paintingsData(R.string.button2_text, "paint2", R.string.paintings_info2));

        button3.setOnClickListener(v -> paintingsData( R.string.button3_text, "paint3", R.string.paintings_info3));

        button4.setOnClickListener(v -> paintingsData(R.string.button4_text, "paint4", R.string.paintings_info4));

        button5.setOnClickListener(v -> paintingsData(R.string.button5_text, "paint5", R.string.paintings_info5));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}