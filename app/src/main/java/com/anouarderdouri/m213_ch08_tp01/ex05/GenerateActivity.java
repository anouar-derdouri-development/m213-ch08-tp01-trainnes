package com.anouarderdouri.m213_ch08_tp01.ex05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.anouarderdouri.m213_ch08_tp01.R;

public class GenerateActivity extends AppCompatActivity implements NumericUpDownFragmentEx04.OnValueChanged {
    public static final int MIN = 10;
    public static final int MAX = 20;
    NumericUpDownFragmentEx04 numericUpDownFragmentEx04Min;
    NumericUpDownFragmentEx04 numericUpDownFragmentEx04Max;
    RandomNumberFragment randomNumberFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate);

        numericUpDownFragmentEx04Min = NumericUpDownFragmentEx04.newInstance(MIN, MAX);
        numericUpDownFragmentEx04Max = NumericUpDownFragmentEx04.newInstance(MIN, MAX);
        randomNumberFragment = RandomNumberFragment.newInstance(numericUpDownFragmentEx04Min.getValue(),
                numericUpDownFragmentEx04Max.getValue());

        getSupportFragmentManager().beginTransaction()
                .add(R.id.frameLayoutMin, numericUpDownFragmentEx04Min)
                .commit();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.frameLayoutMax, numericUpDownFragmentEx04Max)
                .commit();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fcvRandom, randomNumberFragment)
                .commit();
    }

    @Override
    public void onChange() {
        randomNumberFragment.setMin(numericUpDownFragmentEx04Min.getValue());
        randomNumberFragment.setMax(numericUpDownFragmentEx04Max.getValue());
    }
}