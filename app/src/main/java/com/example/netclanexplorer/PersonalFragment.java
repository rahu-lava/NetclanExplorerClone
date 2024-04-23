package com.example.netclanexplorer;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.animation.TranslateAnimation;


import com.getbase.floatingactionbutton.*;

import java.util.ArrayList;

public class PersonalFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;
    ArrayList<String> item;

    FloatingActionsMenu mAddFab;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_personal, container, false);
        View transView = view.findViewById(R.id.transparentView);

        item = new ArrayList<>();
        item.add("Jeshma Jayprakash");
        item.add("Rahul Yadav");
        item.add("Rahul Yadav");
        item.add("Rahul Yadav");
        item.add("Rahul Yadav");
        item.add("Rahul Yadav");
        item.add("Rahul Yadav");
        item.add("Rahul Yadav");
        item.add("Rahul Yadav");
        item.add("Rahul Yadav");

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RecyclerViewAdapter(getContext(),item);
        recyclerView.setAdapter(adapter);

        mAddFab = view.findViewById(R.id.floatingActionButton);
        mAddFab.setOnFloatingActionsMenuUpdateListener(new FloatingActionsMenu.OnFloatingActionsMenuUpdateListener() {
            @Override
            public void onMenuExpanded() {
                transView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onMenuCollapsed() {
                transView.setVisibility(View.GONE);
            }
        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy<0 && !mAddFab.isShown())
                    slideUp(mAddFab);
                else if(dy>0 && mAddFab.isShown() && !mAddFab.isExpanded())
                    slideDown(mAddFab);
            }
        });
        transView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transView.setVisibility(View.GONE);
                mAddFab.collapse();
            }
        });
        return view;
    }
    // Slide down animation to hide the view
    public void slideDown(final View view) {
        TranslateAnimation animate = new TranslateAnimation(0, 0, 0, view.getHeight());
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);
        view.setVisibility(View.GONE);
    }
    // Slide up animation to show the view
    public void slideUp(final View view) {
        view.setVisibility(View.VISIBLE);
        TranslateAnimation animate = new TranslateAnimation(0, 0, view.getHeight(), 0);
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);
    }
}