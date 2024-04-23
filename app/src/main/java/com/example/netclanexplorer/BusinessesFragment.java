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

import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.util.ArrayList;

public class BusinessesFragment extends Fragment {
    RecyclerView recyclerView3;
    RecyclerViewAdapter3 adapter3;
    ArrayList<String> item3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view2 = inflater.inflate(R.layout.fragment_service, container, false);
        View transView = view2.findViewById(R.id.transparentView1);

        item3 = new ArrayList<>();
        item3.add("Brain Computers");
        item3.add("Rahul Yadav");
        item3.add("Rahul Yadav");
        item3.add("Rahul Yadav");
        item3.add("Rahul Yadav");
        item3.add("Rahul Yadav");
        item3.add("Rahul Yadav");
        item3.add("Rahul Yadav");
        item3.add("Rahul Yadav");
        item3.add("Rahul Yadav");

        recyclerView3 = view2.findViewById(R.id.recyclerView2);
        recyclerView3.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter3 = new RecyclerViewAdapter3(getContext(),item3);
        recyclerView3.setAdapter(adapter3);


        FloatingActionsMenu mAddFab = view2.findViewById(R.id.floatingActionButton);
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
        recyclerView3.addOnScrollListener(new RecyclerView.OnScrollListener() {
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

        // Inflate the layout for this fragment
        return view2;
    }
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