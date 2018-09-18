package com.capsule.exview.cons;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.capsule.exview.R;
import com.capsule.exview.dialog.BaseBottomDialog;

public class ConstraintFragment extends Fragment {


    public static ConstraintFragment newInstance() {
        Bundle args = new Bundle();
        ConstraintFragment fragment = new ConstraintFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_constraint, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.tv_1).setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
//            BaseBottomDialog dialog = new BaseBottomDialog();
//            dialog.show(getChildFragmentManager(), "bottom");
          }
        });
    }
}
