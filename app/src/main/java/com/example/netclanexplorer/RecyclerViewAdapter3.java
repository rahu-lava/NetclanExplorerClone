package com.example.netclanexplorer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter3 extends RecyclerView.Adapter<RecyclerViewAdapter3.ViewHolder> {

private final LayoutInflater layoutInflater;

private final List<String> data;

        RecyclerViewAdapter3(Context context, List<String> data){
        this.layoutInflater = LayoutInflater.from(context);
        this.data = data;
        }

@NonNull
@Override
public RecyclerViewAdapter3.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.custom_view3,parent,false);
        return new ViewHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull RecyclerViewAdapter3.ViewHolder holder, int position) {
        String name = data.get(position);
        holder.textTitle.setText(name);
        }

@Override
public int getItemCount() {
        return data.size();
        }

public static class ViewHolder extends RecyclerView.ViewHolder {
    TextView textTitle;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        textTitle = itemView.findViewById(R.id.textV11);
    }
}
}
