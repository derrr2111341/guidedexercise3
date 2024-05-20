package com.example.guidedexercice3;

import android.view.Gravity;
import android.widget.Toast;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.example.guidedexercise3.R;

public class MainActivity extends AppCompatActivity {

    EditText edtNum1, edtNum2;
    Button btnSum, btnAve,  btnClose;
    Toast toast;

    double inputOne, inputTwo, result;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNum1 = findViewById(R.id.etNum1GE3);
        edtNum2 = findViewById(R.id.etNum2GE3);

        btnSum = findViewById(R.id.btnSumGE3);
        btnAve = findViewById(R.id.btnAveGE3);
        btnClose = findViewById(R.id.btnCloseGE3);

        btnSum.setOnClickListener(v -> { sum(); });
        btnAve.setOnClickListener(v -> { average(); });
        btnClose.setOnClickListener(v -> { close(); });
    }

    private boolean validateInput () {
        if (edtNum1.getText().toString().isEmpty() || edtNum2.getText().toString().isEmpty()) {
            showToasts("Please enter a Number");
            return false;
        } else if (!edtNum1.getText().toString().matches("[0-9]+") || !edtNum2.getText().toString().matches("[0-9]+")) {
            showToasts("Please enter a Number");
            return false;
        }
        return true;
    }

    private void sum () {
        if ( ! validateInput() ) {
            return;
        }
        inputOne = Double.parseDouble(edtNum1.getText().toString());
        inputTwo = Double.parseDouble(edtNum2.getText().toString());
        result = inputOne + inputTwo;
        showToasts("Sum: " + result);
    }


    private void average() {
        if (!validateInput()) {
            return;
        }
        inputOne = Double.parseDouble(edtNum1.getText().toString());
        inputTwo = Double.parseDouble(edtNum2.getText().toString());
        result = (inputOne + inputTwo) / 2;
        showToasts("Average: " + result);
    }

    private void showToasts(String message) {
        toast = Toast.makeText(MainActivity.this,message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 100);
        toast.show();
    }

    public void close() {
        finish();
    }

}