package com.ianduran.baseconverter;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HexConverterActivity extends Activity
{
    private Button btnConvert;
    private EditText editInput;
    private TextView txtInput;
    private TextView txtFirstOut;
    private TextView txtSecondOut;
    private TextView txtFirstTitle;
    private TextView txtSecondTitle;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.converter_layout);

        txtInput = (TextView)findViewById(R.id.txtInput);
        txtInput.setText(R.string.hex);

        txtFirstTitle = (TextView)findViewById(R.id.txtFirstTitle);
        txtFirstTitle.setText(R.string.decimal);
        txtSecondTitle = (TextView)findViewById(R.id.txtSecondTitle);
        txtSecondTitle.setText(R.string.binary);

        txtFirstOut = (TextView)findViewById(R.id.txtFirstOut);
        txtSecondOut = (TextView)findViewById(R.id.txtSecondOut);

        editInput = (EditText)findViewById(R.id.editInput);
        editInput.setKeyListener(DigitsKeyListener.getInstance("-0123456789abcdef"));
        if(savedInstanceState != null)
        {
            editInput.setText(savedInstanceState.getString("HexValue"));
            txtFirstOut.setText(savedInstanceState.getString("DecOutput", ""));
            txtSecondOut.setText(savedInstanceState.getString("BinOutput", ""));
        }
        btnConvert = (Button)findViewById(R.id.btnConvert);
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editInput.getText().toString().equals(""))
                    Toast.makeText(HexConverterActivity.this, "Missing field", Toast.LENGTH_SHORT).show();
                else{
                    int toConvert = Integer.parseInt(editInput.getText().toString(), 16);
                    txtFirstOut.setText(Integer.toString(toConvert));
                    txtSecondOut.setText(Integer.toBinaryString(toConvert));
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        if(!editInput.getText().toString().equals(""))
            savedInstanceState.putString("HexValue", editInput.getText().toString());
        if(!txtFirstOut.getText().toString().equals(""))
            savedInstanceState.putString("DecOutput", txtFirstOut.getText().toString());
        if(!txtSecondOut.getText().toString().equals(""))
            savedInstanceState.putString("BinOutput", txtSecondOut.getText().toString());
    }
}
