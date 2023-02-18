package com.example.pbpserfis2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvResult;
    private Button stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tv_result);
        stop = (Button) findViewById(R.id.buttonStop);
        stop.setOnClickListener(this);
        ListView listView = findViewById(R.id.listview);

        List<String> list = new ArrayList<>();
        list.add("Indonesia Raya (Instrumental)");
        list.add("Indonesia Raya (1 Stanza)");
        list.add("Indonesia Raya (2 Stanza)");
        list.add("Indonesia Raya (3 Stanza)");
        list.add("Indonesia Raya (Cover)");


        //menggunakan list view untuk menampilkan list musik
        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    stopService(new Intent(MainActivity.this, MyService.class));
                    startService(new Intent(MainActivity.this, MyService.class));
                    stopService(new Intent(MainActivity.this, MyService2.class));
                    stopService(new Intent(MainActivity.this, MyService3.class));
                    stopService(new Intent(MainActivity.this, MyService4.class));
                    stopService(new Intent(MainActivity.this, MyService5.class));
                    String teks = "Memutar : Indonesia Raya (Instrumental)";
                    tvResult.setText(teks);

                } else if (position == 1) {
                    stopService(new Intent(MainActivity.this, MyService2.class));
                    startService(new Intent(MainActivity.this, MyService2.class));
                    stopService(new Intent(MainActivity.this, MyService.class));
                    stopService(new Intent(MainActivity.this, MyService3.class));
                    stopService(new Intent(MainActivity.this, MyService4.class));
                    stopService(new Intent(MainActivity.this, MyService5.class));
                    String teks = "Memutar : Indonesia Raya (1 Stanza)";
                    tvResult.setText(teks);
                } else if (position == 2) {
                    stopService(new Intent(MainActivity.this, MyService3.class));
                    startService(new Intent(MainActivity.this, MyService3.class));
                    stopService(new Intent(MainActivity.this, MyService.class));
                    stopService(new Intent(MainActivity.this, MyService2.class));
                    stopService(new Intent(MainActivity.this, MyService4.class));
                    stopService(new Intent(MainActivity.this, MyService5.class));
                    String teks = "Memutar : Indonesia Raya (2 Stanza)";
                    tvResult.setText(teks);
                } else if (position == 3) {
                    stopService(new Intent(MainActivity.this, MyService4.class));
                    startService(new Intent(MainActivity.this, MyService4.class));
                    stopService(new Intent(MainActivity.this, MyService.class));
                    stopService(new Intent(MainActivity.this, MyService2.class));
                    stopService(new Intent(MainActivity.this, MyService3.class));
                    stopService(new Intent(MainActivity.this, MyService5.class));
                    String teks = "Memutar : Indonesia Raya (3 Stanza)";
                    tvResult.setText(teks);
                } else if (position == 4) {
                    stopService(new Intent(MainActivity.this, MyService5.class));
                    startService(new Intent(MainActivity.this, MyService5.class));
                    stopService(new Intent(MainActivity.this, MyService.class));
                    stopService(new Intent(MainActivity.this, MyService2.class));
                    stopService(new Intent(MainActivity.this, MyService3.class));
                    stopService(new Intent(MainActivity.this, MyService4.class));
                    String teks = "Memutar : Indonesia Raya (Cover)";
                    tvResult.setText(teks);
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view == stop) {
            stopService(new Intent(MainActivity.this, MyService.class));
            stopService(new Intent(MainActivity.this, MyService2.class));
            stopService(new Intent(MainActivity.this, MyService3.class));
            stopService(new Intent(MainActivity.this, MyService4.class));
            stopService(new Intent(MainActivity.this, MyService5.class));
            String teks = "Musik berhenti";
            tvResult.setText(teks);
        }
    }

    private static final String STATE_RESULT = "state_result";
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tvResult.getText().toString());
    }
}