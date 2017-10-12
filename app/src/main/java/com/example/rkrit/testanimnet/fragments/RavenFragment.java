package com.example.rkrit.testanimnet.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rkrit.testanimnet.R;
import com.example.rkrit.testanimnet.activities.Raven;


public class RavenFragment extends Fragment {
    private int number;

    public final static String NUMBER_OF_PAGE = "page_number";


    // чистий конструктор
    public RavenFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        number = getArguments().getInt(NUMBER_OF_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // ось тут в вюгруп попадає наша актівіті і ми з неї берем елементи і сетаєм в них наші значення
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_raven, container, false);
        ((TextView) viewGroup.findViewById(android.R.id.text1)).setText("Raven " + (number+1));
        // ось тут якраз сетається текст на сторінці фрагменту
        ((TextView) viewGroup.findViewById(R.id.fulltext)).setText(Raven.getRavenPage(number));
        return viewGroup;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

}
