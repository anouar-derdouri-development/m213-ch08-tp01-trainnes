package com.anouarderdouri.m213_ch08_tp01.ex05;

import android.content.Context;
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

public class NumericUpDownFragmentEx04 extends Fragment {
    OnValueChanged myParentActivity;
    Button btnNUDDecrementEx04, btnNUDIncrementEx04;
    TextView tvNUDValueEx04;

    int min = 0;
    int max = 10;
    int value;

    public NumericUpDownFragmentEx04() {
        // Required empty public constructor
    }

    public static NumericUpDownFragmentEx04 newInstance(int min, int max) {
        NumericUpDownFragmentEx04 fragment = new NumericUpDownFragmentEx04();
        Bundle args = new Bundle();
        args.putInt("min", min);
        args.putInt("max", max);
        fragment.setArguments(args);
        fragment.value = min;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.min = getArguments().getInt("min");
            this.max = getArguments().getInt("max");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_numeric_up_down_ex04, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnNUDDecrementEx04 = view.findViewById(R.id.btnNUDDecrementEx04);
        btnNUDIncrementEx04 = view.findViewById(R.id.btnNUDIncrementEx04);
        tvNUDValueEx04 = view.findViewById(R.id.tvNUDValueEx04);

        tvNUDValueEx04.setText(Integer.toString(value));

        btnNUDDecrementEx04.setOnClickListener(v -> {
            if (value > min) {
                value--;
                tvNUDValueEx04.setText(Integer.toString(value));
                myParentActivity.onChange();
            }
        });

        btnNUDIncrementEx04.setOnClickListener(v -> {
            if (value < max) {
                value++;
                tvNUDValueEx04.setText(Integer.toString(value));
                myParentActivity.onChange();
            }
        });
    }

    public int getValue() {
        return value;
    }

    public interface OnValueChanged {
        void onChange();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        myParentActivity = (OnValueChanged) getActivity();
    }
}