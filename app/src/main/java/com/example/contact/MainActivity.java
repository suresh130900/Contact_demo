package com.example.contact;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //creating a list of programming languages
        String languages[] = {"Java","Python","Flutter","React","C++","R","C","Vue","Rust","Dart+66"};
        //creating a listview
        ListView programming = findViewById(R.id.programming);

        //arrayadapter is used for listview
        ArrayAdapter <String> pro_languages = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,languages);
        //setting a arrayadapter
        programming.setAdapter(pro_languages);

        EditText name = findViewById(R.id.name);
        EditText email = findViewById(R.id.email);
        Button submit = findViewById(R.id.submit);

        ArrayList<String> Selected_languages = new ArrayList<String>();


        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.nothern_ligths);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] byteArray = stream.toByteArray();


        submit.setOnClickListener(e->{

            Intent i = new Intent(getApplicationContext(), new_page.class);
            i.putExtra("The name of user is: ",name.getText().toString());
            i.putExtra("The Email of user is: ",email.getText().toString());
            i.putExtra("keyname",Selected_languages.toString());
            i.putExtra("picture", byteArray);
            startActivity(i);
            Log.d("TAG", "onCreate: "+ Selected_languages);

        });

        programming.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // When clicked, show a toast with the TextView text
                Selected_languages.add(((TextView) view).getText().toString());
            }
        });


    }
}