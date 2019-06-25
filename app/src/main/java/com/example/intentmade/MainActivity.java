package com.example.intentmade;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.intentmade.MoveForResultActivity.EXTRA_SELECTED_VALUE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnMoveActivity;
    Button btnMoveWithData;
    Button btnWithObject;
    Button btnDialNumber;
    Button btnMoveForResult;
    TextView tvResult;

    private int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoveActivity = findViewById(R.id.btn_move_ac);
        btnMoveActivity.setOnClickListener(this);

        btnMoveWithData = findViewById(R.id.btn_move_with_dat);
        btnMoveWithData.setOnClickListener(this);

        btnWithObject = findViewById(R.id.btn_move_with_obj);
        btnWithObject.setOnClickListener(this);

        btnDialNumber = findViewById(R.id.btn_dial_numb);
        btnDialNumber.setOnClickListener(this);

        btnMoveForResult = findViewById(R.id.btn_move_for_result);
        btnMoveForResult.setOnClickListener(this);

        tvResult = findViewById(R.id.tv_result);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_move_ac:
                Intent moveIntent = new Intent(MainActivity.this,MoveActivity.class);
                startActivity(moveIntent);
            break;

            case R.id.btn_move_with_dat:
                Intent moveData = new Intent(MainActivity.this,MoveWithDataActivity.class);
                moveData.putExtra(MoveWithDataActivity.EXTRA_NAME,"dicod jun");
                moveData.putExtra(MoveWithDataActivity.EXTRA_AGE,5);
                startActivity(moveData);
                break;

            case R.id.btn_move_with_obj:
                Person person = new Person();
                person.setName("Waluyo");
                person.setAge(52);
                person.setEmail("waluyo@waluyo");
                person.setCity("Jogja");

                Intent moveObjectIntent = new Intent(MainActivity.this, MoveWithObjectActivity.class);
                moveObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON,person);
                startActivity(moveObjectIntent);
                break;

            case R.id.btn_dial_numb:
                String phoneNumber = "023243352112";
                Intent dialPhoneNumb = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(dialPhoneNumb);
                break;

            case R.id.btn_move_for_result:
                Intent moveForResult = new Intent(MainActivity.this, MoveForResultActivity.class);
                startActivityForResult(moveForResult,REQUEST_CODE);
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if (requestCode == REQUEST_CODE) {
            if (resultCode == MoveForResultActivity.RESULT_CODE) {
                int selectedValue = data.getIntExtra(MoveForResultActivity



                        .EXTRA_SELECTED_VALUE, 0);

                tvResult.setText(String.format("Hasil : %s", selectedValue));
            }
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
