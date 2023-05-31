package com.anouarderdouri.m213_ch08_tp01.ex02;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.anouarderdouri.m213_ch08_tp01.R;

public class CalculatorActivity extends AppCompatActivity {
    Button btnEx01FirstNumber, btnEx01SecondNumber, btnEx01Addition, btnEx01Substraction, btnEx01Multiplication;
    TextView tvEx01FirstNumber, tvEx01SecondNumber;
    ActivityResultLauncher<Intent> getFirstNumber;
    ActivityResultLauncher<Intent> getSecondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        btnEx01FirstNumber = findViewById(R.id.btnEx01FirstNumber);
        btnEx01SecondNumber = findViewById(R.id.btnEx01SecondNumber);
        btnEx01Addition = findViewById(R.id.btnEx01Addition);
        btnEx01Substraction = findViewById(R.id.btnEx01Substraction);
        btnEx01Multiplication = findViewById(R.id.btnEx01Multiplication);
        tvEx01FirstNumber = findViewById(R.id.tvEx01FirstNumber);
        tvEx01SecondNumber = findViewById(R.id.tvEx01SecondNumber);

        getFirstNumber = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent intent = result.getData();
                        Integer number = intent.getIntExtra("number", Integer.parseInt(tvEx01FirstNumber.getText().toString()));

                        tvEx01FirstNumber.setText(Integer.toString(number));
                    }
                });

        getSecondNumber = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent intent = result.getData();
                        Integer number = intent.getIntExtra("number", Integer.parseInt(tvEx01SecondNumber.getText().toString()));

                        tvEx01SecondNumber.setText(Integer.toString(number));
                    }
                });

        btnEx01FirstNumber.setOnClickListener(v -> {
            Intent intent = new Intent(CalculatorActivity.this, NumberActivity.class);
            intent.putExtra("message", "First Number");
            intent.putExtra("number", tvEx01FirstNumber.getText().toString());
            getFirstNumber.launch(intent);
        });

        btnEx01SecondNumber.setOnClickListener(v -> {
            Intent intent = new Intent(CalculatorActivity.this, NumberActivity.class);
            intent.putExtra("message", "Second Number");
            intent.putExtra("number", tvEx01SecondNumber.getText().toString());
            getSecondNumber.launch(intent);
        });

        btnEx01Addition.setOnClickListener(v -> {
            Integer firstNumber = Integer.parseInt(tvEx01FirstNumber.getText().toString());
            Integer secondNumber = Integer.parseInt(tvEx01SecondNumber.getText().toString());
            Integer result = firstNumber + secondNumber;

            Toast.makeText(this, String.format("%d + %d = %d", firstNumber, secondNumber, result), Toast.LENGTH_LONG).show();

        });

        btnEx01Substraction.setOnClickListener(v -> {
            Integer firstNumber = Integer.parseInt(tvEx01FirstNumber.getText().toString());
            Integer secondNumber = Integer.parseInt(tvEx01SecondNumber.getText().toString());
            Integer result = firstNumber - secondNumber;

            Toast.makeText(this, String.format("%d - %d = %d", firstNumber, secondNumber, result), Toast.LENGTH_LONG).show();

        });

        btnEx01Multiplication.setOnClickListener(v -> {
            Integer firstNumber = Integer.parseInt(tvEx01FirstNumber.getText().toString());
            Integer secondNumber = Integer.parseInt(tvEx01SecondNumber.getText().toString());
            Integer result = firstNumber * secondNumber;

            Toast.makeText(this, String.format("%d * %d = %d", firstNumber, secondNumber, result), Toast.LENGTH_LONG).show();

        });
    }

    // ToDo
    class GetNumber extends ActivityResultLauncher<Intent> {

        @Override
        public void launch(Intent input, @Nullable ActivityOptionsCompat options) {

        }

        @Override
        public void unregister() {

        }

        @NonNull
        @Override
        public ActivityResultContract<Intent, ?> getContract() {
            return null;
        }
    }
}