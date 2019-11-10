package com.example.finaliime;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreatNewActivity extends AppCompatActivity {
    Button buttonReturn;
    Button buttonOk;
    EditText editTitle;
    EditText editDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat_new);
        buttonReturn=findViewById(R.id.button_return);
        buttonOk=findViewById(R.id.button_ok);
        editTitle=findViewById(R.id.edit_text_title);
        editDescription=findViewById(R.id.edit_text_description);

        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("title", editTitle.getText().toString());
                intent.putExtra("description", editDescription.getText().toString());
                setResult(RESULT_OK, intent);
                Log.d("bookTitle", editTitle.getText().toString());
                CreatNewActivity.this.finish();
            }
        });
    }

}
