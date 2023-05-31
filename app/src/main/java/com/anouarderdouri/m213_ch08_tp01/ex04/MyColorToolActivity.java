package com.anouarderdouri.m213_ch08_tp01.ex04;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.anouarderdouri.m213_ch08_tp01.R;

public class MyColorToolActivity extends AppCompatActivity {
    NumericUpDownFragment numericUpDownFragmentRed;
    NumericUpDownFragment numericUpDownFragmentGreen;
    NumericUpDownFragment numericUpDownFragmentBlue;
    Button btnEx03Ok;
    View viewEx03Color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_color_tool);

        btnEx03Ok = findViewById(R.id.btnEx03Ok);
        viewEx03Color = findViewById(R.id.viewEx03Color);

        numericUpDownFragmentRed = NumericUpDownFragment.newInstance(0, 255);
        numericUpDownFragmentGreen = NumericUpDownFragment.newInstance(0, 255);
        numericUpDownFragmentBlue = NumericUpDownFragment.newInstance(0, 255);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.frameLayoutEx03Red, numericUpDownFragmentRed)
                .commit();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.frameLayoutEx03Green, numericUpDownFragmentGreen)
                .commit();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.frameLayoutEx03Blue, numericUpDownFragmentBlue)
                .commit();

        btnEx03Ok.setOnClickListener(v -> {
            int red = numericUpDownFragmentRed.getValue();
            int green = numericUpDownFragmentGreen.getValue();
            int blue = numericUpDownFragmentBlue.getValue();

            viewEx03Color.setBackgroundColor(Color.rgb(red, green, blue));
        });
    }
}