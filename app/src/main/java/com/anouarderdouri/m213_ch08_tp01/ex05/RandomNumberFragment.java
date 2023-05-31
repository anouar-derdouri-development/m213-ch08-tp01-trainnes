package com.anouarderdouri.m213_ch08_tp01.ex05;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.anouarderdouri.m213_ch08_tp01.R;

import java.util.Random;

public class RandomNumberFragment extends Fragment {
    Button btnGenerate;
    TextView tvGenerated;

    int min = 0;
    int max = 10;

    public RandomNumberFragment() {
        // Required empty public constructor
    }

    public static RandomNumberFragment newInstance(int min, int max) {
        RandomNumberFragment fragment = new RandomNumberFragment();
        Bundle args = new Bundle();
        args.putInt("min", min);
        args.putInt("max", max);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            min = getArguments().getInt("min");
            max = getArguments().getInt("max");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_random_number, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnGenerate = view.findViewById(R.id.btnGenerate);
        tvGenerated = view.findViewById(R.id.tvGenerated);

        btnGenerate.setText(String.format("Generate between %d and %d", min, max));

        btnGenerate.setOnClickListener(v -> {
            try {
                int r = new Random().nextInt((max - min) + 1) + min;

                tvGenerated.setText(Integer.toString(r));
            } catch (Exception e) {
                tvGenerated.setText("Error !!!");
            }
        });
    }

    public void setMin(int value) {
        min = value;
        btnGenerate.setText(String.format("Generate between %d and %d", min, max));
    }

    public void setMax(int value) {
        max = value;
        btnGenerate.setText(String.format("Generate between %d and %d", min, max));
    }
}