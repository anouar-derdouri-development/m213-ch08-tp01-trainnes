package com.anouarderdouri.m213_ch08_tp01.ex06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.anouarderdouri.m213_ch08_tp01.R;

public class TwoDPoints extends AppCompatActivity implements PointFragment.OnPointChanged {
    PointFragment pointFragment01, pointFragment02;
    DistanceFragment distanceFragment;
    Button btnEx05OK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_dpoints);

        pointFragment01 = PointFragment.newInstance();
        pointFragment02 = PointFragment.newInstance();
        distanceFragment = new DistanceFragment();

        btnEx05OK = findViewById(R.id.btnEx05OK);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fcvPoint01, pointFragment01)
                .commit();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fcvPoint02, pointFragment02)
                .commit();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fcvEx05Distance, distanceFragment)
                .commit();

        btnEx05OK.setOnClickListener(v -> {
            distanceFragment.setPoint01(pointFragment01.point);
            distanceFragment.setPoint02(pointFragment02.point);
            distanceFragment.show();
        });
    }

    @Override
    public void onChanged() {

    }
}