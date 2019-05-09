package com.example.gimnasdual.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gimnasdual.R;

public class CategoriesInfoFragment extends Fragment {

    View rootView;

    public CategoriesInfoFragment()
    {

    }

    public static CategoriesInfoFragment newInstance() {
        return new CategoriesInfoFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        String stringRebut = arguments.getString("id");
        Toast.makeText(getContext(), stringRebut, Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_categories_info, container, false);



        return rootView;
    }

}
