package com.ianduran.baseconverter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity
{
    private Button btnDecimal;
    private Button btnBinary;
    private Button btnHex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDecimal = (Button)findViewById(R.id.btnDecimal);
        btnBinary = (Button)findViewById(R.id.btnBinary);
        btnHex = (Button) findViewById (R.id.btnHex);

        btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, DecimalConverterActivity.class);
                startActivity(i);
            }
        });

        btnBinary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, BinaryConverterActivity.class);
                startActivity(i);
            }
        });

        btnHex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, HexConverterActivity.class);
                startActivity(i);
            }
        });
    }
}
