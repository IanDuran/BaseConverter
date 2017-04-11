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

public class DecimalConverterActivity extends Activity
{
    private Button btnConvert;
    private EditText editInput;
    private TextView txtInput;
    private TextView txtFirstTitle;
    private TextView txtFirstOut;
    private TextView txtSecondTitle;
    private TextView txtSecondOut;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.converter_layout);
        editInput = (EditText)findViewById(R.id.editInput);
        editInput.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
        editInput.setKeyListener(DigitsKeyListener.getInstance(true, false));

        txtFirstOut = (TextView)findViewById(R.id.txtFirstOut);
        txtSecondOut = (TextView)findViewById(R.id.txtSecondOut);

        if(savedInstanceState != null)
        {
            editInput.setText(savedInstanceState.getString("DecValue"));
            txtFirstOut.setText(savedInstanceState.getString("BinOutput", ""));
            txtSecondOut.setText(savedInstanceState.getString("HexOutput", ""));
        }
        txtInput = (TextView)findViewById(R.id.txtInput);
        txtInput.setText(R.string.decimal);
        txtFirstTitle = (TextView)findViewById(R.id.txtFirstTitle);
        txtFirstTitle.setText(R.string.binary);
        txtSecondTitle = (TextView)findViewById(R.id.txtSecondTitle);
        txtSecondTitle.setText(R.string.hex);



        btnConvert = (Button)findViewById(R.id.btnConvert);
        btnConvert.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(editInput.getText().toString().equals(""))
                    Toast.makeText(DecimalConverterActivity.this, "Missing field", Toast.LENGTH_SHORT).show();
                else{
                    int toConvert = Integer.parseInt(editInput.getText().toString());
                    txtFirstOut.setText(Integer.toBinaryString(toConvert));
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
            savedInstanceState.putString("DecValue", editInput.getText().toString());
        if(!txtFirstOut.getText().toString().equals(""))
            savedInstanceState.putString("BinOutput", txtFirstOut.getText().toString());
        if(!txtSecondOut.getText().toString().equals(""))
            savedInstanceState.putString("HexOutput", txtSecondOut.getText().toString());
    }
}
