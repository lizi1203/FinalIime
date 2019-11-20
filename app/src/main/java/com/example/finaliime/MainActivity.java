package com.example.finaliime;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<TimeItem> timeItemList;
    Button button;
    ListView listView;
    TimeAdapter timeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button_new);
        listView=findViewById(R.id.list_view);
        Init();

       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(MainActivity.this,CreatNewActivity.class);
               startActivityForResult(intent,1);
           }
       });

       timeAdapter = new TimeAdapter(MainActivity.this, R.layout.time_item, timeItemList);
       listView.setAdapter(timeAdapter);
    }

    private void Init(){
        timeItemList=new ArrayList<>();
        timeItemList.add(
                new TimeItem("Birthday","1998.12.3","lizi",R.drawable.item_new));

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedTitle = data.getStringExtra("title");
                    String returnedDescription = data.getStringExtra("description");
                    String returnedDate;
                    getTimeItemList().add(0,new TimeItem(returnedTitle, "1997.09.01", returnedDescription,
                            R.drawable.item_new));
                    timeAdapter.notifyDataSetChanged();
                }
                break;
            case 2:
            if (resultCode == RESULT_OK) {
                timeItemList.remove(0);
                timeAdapter.notifyDataSetChanged();
            }
            break;
            default:
        }

    }


    public ArrayList<TimeItem> getTimeItemList(){return timeItemList;}
}
