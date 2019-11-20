package com.example.finaliime;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class TimeAdapter extends ArrayAdapter<TimeItem> {

    public TimeAdapter(@NonNull Context context, int resource, @NonNull ArrayList<TimeItem> objects) {
        super(context, resource, objects);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        final TimeItem timeItem = getItem(position);//获取当前项的实例
        View oneTimeAllView = LayoutInflater.from(getContext()).inflate(R.layout.time_item, parent, false);
        ((ImageView) oneTimeAllView.findViewById(R.id.image)).setImageResource(timeItem.getImageId());
        ((TextView) oneTimeAllView.findViewById(R.id.title)).setText(timeItem.getTitle());
        ((TextView) oneTimeAllView.findViewById(R.id.date)).setText(timeItem.getDate());
        ((TextView) oneTimeAllView.findViewById(R.id.description)).setText(timeItem.getDescription());
        oneTimeAllView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), TimeAllActivity.class);
                intent.putExtra("Title", timeItem.getTitle());
                intent.putExtra("Date", timeItem.getDate());
                getContext().startActivity(intent);
            }
        });

        return oneTimeAllView;
    }



}