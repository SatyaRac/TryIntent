package com.example.intentmade;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static android.bluetooth.BluetoothDevice.EXTRA_NAME;

public class MoveWithDataActivity extends AppCompatActivity {
    public static final String EXTRA_AGE = "extra_age";
    public static final String EXTRA_NAME = "extra_name";

    TextView tvDataRecevied;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_data);

        tvDataRecevied = findViewById(R.id.tv_data_rec);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        int age = getIntent().getIntExtra(EXTRA_AGE,0);

        String text = "Name : " +name+",\nYour Age :"+age;
        tvDataRecevied.setText(text);
    }
}
