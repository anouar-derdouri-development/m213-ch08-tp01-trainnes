package com.anouarderdouri.m213_ch08_tp01.ex06;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.anouarderdouri.m213_ch08_tp01.R;

public class PointFragment extends Fragment {
    OnPointChanged myParentActivity;
    TextView tvPFLabel;
    EditText etPFx, etPFy;

    Point point = new Point();

    public PointFragment() {
        // Required empty public constructor
    }

    public static PointFragment newInstance() {
        PointFragment fragment = new PointFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        myParentActivity = (OnPointChanged) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_point, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvPFLabel = view.findViewById(R.id.tvPFLabel);
        etPFx = view.findViewById(R.id.etPFx);
        etPFy = view.findViewById(R.id.etPFy);

        tvPFLabel.setText(point.getLabel().toString());

        tvPFLabel.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    point.setLabel(s.toString().charAt(0));
                } catch (Exception e) {
                    point.setLabel(null);
                }

                myParentActivity.onChanged();
            }
        });

        etPFx.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    point.setX(Integer.parseInt(s.toString()));
                } catch (NumberFormatException e) {
                    point.setX(null);
                }

                myParentActivity.onChanged();
            }
        });

        etPFy.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    point.setY(Integer.parseInt(s.toString()));
                } catch (NumberFormatException e) {
                    point.setY(null);
                }

                myParentActivity.onChanged();
            }
        });
    }

    public Point getPoint() {
        return point;
    }

    interface OnPointChanged {
        void onChanged();
    }
}