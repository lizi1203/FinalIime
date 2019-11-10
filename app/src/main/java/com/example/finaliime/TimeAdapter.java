package com.example.finaliime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class TimeAdapter extends ArrayAdapter<TimeItem> {
    private int resourceId;
    public TimeAdapter(@NonNull Context context, int resource, @NonNull ArrayList<TimeItem> objects) {
        super(context, resource, objects);
        resourceId=resource;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        TimeItem timeItem = getItem(position);//获取当前项的实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        ((ImageView) view.findViewById(R.id.image)).setImageResource(timeItem.getImageId());
        ((TextView) view.findViewById(R.id.title)).setText(timeItem.getTitle());
        ((TextView) view.findViewById(R.id.date)).setText(timeItem.getDate());
        ((TextView) view.findViewById(R.id.description)).setText(timeItem.getDescription());

        return view;
    }
}
