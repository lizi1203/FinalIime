package com.example.finaliime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Time;
import java.util.ArrayList;

public class TimeAllActivity extends AppCompatActivity {
    Button buttonReturn;
    Button buttonDelete;
    Button buttonShare;
    Button buttonUpdate;
    Context context=this;
    TextView titleTextView2,descriptionTextView2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_all);

        buttonReturn=findViewById(R.id.button_return);
        buttonDelete=findViewById(R.id.button_delete);
        buttonShare=findViewById(R.id.button_share);
        buttonUpdate=findViewById(R.id.button_update);
        titleTextView2=findViewById(R.id.title_text_view2);
        descriptionTextView2=findViewById(R.id.description_text_view2);
        button=findViewById(R.id.button);

        final Intent intent=getIntent();
        final String title=intent.getStringExtra("Title");
        String date=intent.getStringExtra("Date");
        final String description=intent.getStringExtra("Description");
        final int position=intent.getIntExtra("position", 0);
        titleTextView2.setText(title);
        descriptionTextView2.setText(description);
        button.setText(date);
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new android.app.AlertDialog.Builder(context)
                        .setMessage("Delete this moment?")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            Intent intent1=new Intent();
                            intent1.putExtra("position", position);
                                setResult(RESULT_OK, intent1);
                            TimeAllActivity.this.finish();
                            }
                        })
                        .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .create().show();
            }
        });

       buttonUpdate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent2=new Intent(TimeAllActivity.this,CreatNewActivity.class);
               intent2.putExtra("title", title);
               intent2.putExtra("description", description);
               startActivity(intent2);
           }
       });
    }
}
