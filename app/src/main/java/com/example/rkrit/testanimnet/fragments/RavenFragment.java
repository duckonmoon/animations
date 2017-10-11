package com.example.rkrit.testanimnet.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rkrit.testanimnet.R;
import com.example.rkrit.testanimnet.activities.Raven;


public class RavenFragment extends Fragment {

    public RavenFragment() {}

    private int mPageNumber;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
        mPageNumber = Raven.NUM_PAGES;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_raven, container, false);
        ((TextView) viewGroup.findViewById(android.R.id.text1)).setText("Raven");
        ((TextView) viewGroup.findViewById(R.id.fulltext)).setText(Raven.getRav().get(0));
        return viewGroup;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

}
