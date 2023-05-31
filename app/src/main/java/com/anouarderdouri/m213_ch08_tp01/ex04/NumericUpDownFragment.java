package com.anouarderdouri.m213_ch08_tp01.ex04;

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

public class NumericUpDownFragment extends Fragment {
    Button btnNUDDecrement, btnNUDIncrement;
    TextView tvNUDValue;

    int min = 0;
    int max = 10;
    int value;

    public NumericUpDownFragment() {
        // Required empty public constructor
    }

    public static NumericUpDownFragment newInstance(int min, int max) {
        NumericUpDownFragment fragment = new NumericUpDownFragment();
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
            this.min = getArguments().getInt("min");
            this.max = getArguments().getInt("max");

            this.value = min;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_numeric_up_down, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnNUDDecrement = view.findViewById(R.id.btnNUDDecrement);
        btnNUDIncrement = view.findViewById(R.id.btnNUDIncrement);
        tvNUDValue = view.findViewById(R.id.tvNUDValue);

        tvNUDValue.setText(Integer.toString(value));

        btnNUDDecrement.setOnClickListener(v -> {
            if (value > min) {
                value--;
                tvNUDValue.setText(Integer.toString(value));
            }
        });

        btnNUDIncrement.setOnClickListener(v -> {
            if (value < max) {
                value++;
                tvNUDValue.setText(Integer.toString(value));
            }
        });
    }

    public int getValue() {
        return value;
    }
}