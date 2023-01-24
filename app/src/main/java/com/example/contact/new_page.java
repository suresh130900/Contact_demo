package com.example.contact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class new_page extends AppCompatActivity {


    HashMap<String, Boolean> selected_lang = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_page);

        TextView name = findViewById(R.id.name);
        TextView email = findViewById(R.id.email);
        ListView selected_languages = findViewById(R.id.selected_languages);

        Intent intent = getIntent();
        String name1 = intent.getStringExtra("The name of user is: ");
        String email1 = intent.getStringExtra("The Email of user is: ");

        //getting the value from the listview and storing it in the Bundle type
        Bundle extras = getIntent().getExtras();

        //now storing the extras to the string by the keyname from the main activity
        String list_data = extras.getString("keyname");

        //List<String> lang = Arrays.asList(list_data.split(",[ ]*"));

        String[] lang = list_data.split("[, \\[ \\] ]+", 0);

        int n = lang.length;

        removeDups(lang, n);


        Set<String> keySet = selected_lang.keySet();

        // Creating an ArrayList of keys
        // by passing the keySet
        ArrayList<String> listOfKeys = new ArrayList<String>(keySet);

        //ArrayList<String> lang = new ArrayList<String>(Arrays.asList(list_data.split(",")));

        //ArrayList<String> lang = new ArrayList<String>(Collections.singleton(extras.getString("keyname")));
        name.setText(name1);
        email.setText(email1);

        //selected_languages.setText(list_data);

        ArrayAdapter<String> selected = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listOfKeys);
        //setting a arrayadapter
        selected_languages.setAdapter(selected);


        byte[] byteArray = extras.getByteArray("picture");

        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        ImageView image = (ImageView) findViewById(R.id.image);

        image.setImageBitmap(bmp);

    }
    void removeDups(String[] a, int n)
    {

        // Hash map which will store the
        // elements which has appeared previously.


        for (int i = 0; i < n; ++i) {

            // Print the element if it is not
            // present there in the hash map
            // and Insert the element in the hash map
            if (selected_lang.get(a[i]) == null)
            {
                //System.out.print(a[i] + " ");
                //Toast.makeText(this,a[i],Toast.LENGTH_LONG).show();
                selected_lang.put(a[i], true);
            }
        }
    }
}