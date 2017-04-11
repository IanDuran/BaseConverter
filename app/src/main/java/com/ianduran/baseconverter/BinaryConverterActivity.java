package com.ianduran.baseconverter;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BinaryConverterActivity extends Activity
{
    private Button btnConvert;
    private EditText editInput;
    private TextView txtInput;
    private TextView txtFirstTitle;
    private TextView txtSecondTitle;
    private TextView txtFirstOut;
    private TextView txtSecondOut;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.converter_layout);

        txtInput = (TextView)findViewById(R.id.txtInput);
        txtInput.setText(R.string.binary);

        editInput = (EditText)findViewById(R.id.editInput);
        editInput.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
        editInput.setKeyListener(DigitsKeyListener.getInstance("-01"));
        txtFirstOut = (TextView)findViewById(R.id.txtFirstOut);
        txtSecondOut = (TextView)findViewById(R.id.txtSecondOut);
        if(savedInstanceState != null)
        {
            editInput.setText(savedInstanceState.getString("BinValue"));
            txtFirstOut.setText(savedInstanceState.getString("DecOutput", ""));
            txtSecondOut.setText(savedInstanceState.getString("HexOutput", ""));
        }
        txtFirstTitle = (TextView)findViewById(R.id.txtFirstTitle);
        txtFirstTitle.setText(R.string.decimal);
        txtSecondTitle = (TextView)findViewById(R.id.txtSecondTitle);
        txtSecondTitle.setText(R.string.hex);



        btnConvert = (Button)findViewById(R.id.btnConvert);
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editInput.getText().toString().equals(""))
                    Toast.makeText(BinaryConverterActivity.this, "Missing field", Toast.LENGTH_SHORT).show();
                else {
                    int toConvert = Integer.parseInt(editInput.getText().toString(), 2);
                    txtFirstOut.setText(Integer.toString(toConvert));
                    txtSecondOut.setText(Integer.toHexString(toConvert));
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        if(!editInput.getText().toString().equals(""))
            savedInstanceState.putString("BinValue", editInput.getText().toString());
        if(!txtFirstOut.getText().toString().equals(""))
            savedInstanceState.putString("DecOutput", txtFirstOut.getText().toString());
        if(!txtSecondOut.getText().toString().equals(""))
            savedInstanceState.putString("HexOutput", txtSecondOut.getText().toString());
    }
}
