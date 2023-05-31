package com.anouarderdouri.m213_ch08_tp01.ex02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.anouarderdouri.m213_ch08_tp01.R;

public class NumberActivity extends AppCompatActivity {
    TextView tvEx01Message;
    EditText etEx01Number;
    Button btnEx01OK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        tvEx01Message = findViewById(R.id.tvEx01Message);
        etEx01Number = findViewById(R.id.etEx01Number);
        btnEx01OK = findViewById(R.id.btnEx01OK);

        Intent intent = getIntent();
        tvEx01Message.setText(intent.getStringExtra("message"));
        etEx01Number.setText(intent.getStringExtra("number"));

        btnEx01OK.setOnClickListener(v -> {
            try {
                Integer number = Integer.parseInt(etEx01Number.getText().toString());
                Intent replyIntent = new Intent();

                replyIntent.putExtra("number", number);

                setResult(RESULT_OK, replyIntent);

                finish();
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Something went wrong !!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}