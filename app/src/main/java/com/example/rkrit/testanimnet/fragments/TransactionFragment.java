package com.example.rkrit.testanimnet.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.transition.Scene;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.transition.TransitionManager;

import com.example.rkrit.testanimnet.R;


public class TransactionFragment extends Fragment {
    private Scene[] scenes;
    private ViewGroup sceneShow;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("e","I am here");
        View view = inflater.inflate(R.layout.fragment_transaction, container, false);
        RadioGroup radioGroup = view.findViewById(R.id.linearLayout);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.scene1:
                        TransitionManager.go(scenes[0]);
                        break;
                    case R.id.scene2:
                        TransitionManager.go(scenes[1]);
                        break;
                    case R.id.scene3:
                        TransitionManager.go(scenes[2]);
                        break;
                }
            }
        });
        scenes = new Scene[3];
        sceneShow = view.findViewById(R.id.scene_show);
        Log.wtf("d","just test");
        scenes[0] = Scene.getSceneForLayout(sceneShow, R.layout.scene1, getActivity());
        scenes[1] = Scene.getSceneForLayout(sceneShow, R.layout.scene2, getActivity());
        scenes[2] = Scene.getSceneForLayout(sceneShow, R.layout.scene3, getActivity());

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
