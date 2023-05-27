package com.example.uniconvert;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String arr[] = {"Length", "Area", "Temperature", "Time", "Volume", "Weight" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        ArrayList<Dimension> arrayList = new ArrayList<>();
        arrayList.add(new Dimension(R.drawable.item1, "Length"));
        arrayList.add(new Dimension(R.drawable.item2, "Area"));
        arrayList.add(new Dimension(R.drawable.item3, "Temperature"));
        arrayList.add(new Dimension(R.drawable.item4, "Time"));
        arrayList.add(new Dimension(R.drawable.item5, "Volume"));
        arrayList.add(new Dimension(R.drawable.item6, "Weight"));

        
        MySamanthAdapter samanthAdapter = new MySamanthAdapter(this, R.layout.list_row,arrayList);
        listView.setAdapter(samanthAdapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0)
                {
                    Intent intent = new Intent(MainActivity.this, Length.class);
                    startActivity(intent);
                    Snackbar.make(view,  "You clicked Length", Snackbar.LENGTH_LONG).show();

                }
                else if (i == 1) {
                    Intent intent2 = new Intent(MainActivity.this, Area.class);
                    startActivity(intent2);
                    Snackbar.make(view, "You clicked Area", Snackbar.LENGTH_LONG).show();

                }
                else if (i == 2) {
                    Intent intent3 = new Intent(MainActivity.this, Temperature.class);
                    startActivity(intent3);
                    Snackbar.make(view, "You clicked Temperature", Snackbar.LENGTH_LONG).show();

                }
                else if (i == 3) {
                    Intent intent4 = new Intent(MainActivity.this, Time.class);
                    startActivity(intent4);
                    Snackbar.make(view, "You clicked Time", Snackbar.LENGTH_LONG).show();

                }
                else if (i == 4) {
                    Intent intent5 = new Intent(MainActivity.this, Volume.class);
                    startActivity(intent5);
                    Snackbar.make(view, "You clicked Volume", Snackbar.LENGTH_LONG).show();

                }

                else if (0 != i)
                {
                    Snackbar.make(view, "You clicked on " + arr[i], Snackbar.LENGTH_LONG).show();
                }

            }        });
    }
}