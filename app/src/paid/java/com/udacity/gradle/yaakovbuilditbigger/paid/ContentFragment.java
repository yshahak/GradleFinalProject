package com.udacity.gradle.yaakovbuilditbigger.paid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.udacity.gradle.yaakovbuilditbigger.R;

public class ContentFragment extends Fragment {

    public ContentFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        Toast.makeText(getContext(), "paid version", Toast.LENGTH_LONG).show();
        return root;
    }
}