package com.anouarderdouri.m213_ch08_tp01.ex06;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anouarderdouri.m213_ch08_tp01.R;

public class DistanceFragment extends Fragment {
    Point point01 = new Point(),
            point02 = new Point();

    public void setPoint01(Point point01) {
        this.point01 = point01;
    }

    public void setPoint02(Point point02) {
        this.point02 = point02;
    }

    TextView tvDFPoint01, tvDFPoint02, tvDFDistance;

    public DistanceFragment() {
        // Required empty public constructor
    }

    public static DistanceFragment newInstance() {
        DistanceFragment fragment = new DistanceFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_distance, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvDFPoint01 = view.findViewById(R.id.tvDFPoint01);
        tvDFPoint02 = view.findViewById(R.id.tvDFPoint02);
        tvDFDistance = view.findViewById(R.id.tvDFDistance);
    }

    public Double distance() throws Exception {
        try {
            return Math.sqrt(Math.pow(point01.getX() - point02.getX(), 2) + Math.pow(point01.getY() - point02.getY(), 2));
        } catch (Exception e) {
            throw new Exception("?");
        }
    }

    public void show() {
        tvDFPoint01.setText(point01.toString());
        tvDFPoint02.setText(point02.toString());

        try {
            tvDFDistance.setText(String.format("%.2f", distance()));
        } catch (Exception e) {
            tvDFDistance.setText(e.getMessage());
        }
    }
}