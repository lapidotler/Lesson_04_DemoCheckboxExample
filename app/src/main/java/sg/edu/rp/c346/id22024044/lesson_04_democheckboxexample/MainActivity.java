package sg.edu.rp.c346.id22024044.lesson_04_democheckboxexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox cbEnabled;
    Button btnCheck;
    TextView tvShow;

    private double calcPay(double price, double discount) {
        double pay = price * (1-discount/100);
        return pay;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbEnabled = findViewById(R.id.checkBoxDiscount);
        btnCheck = findViewById(R.id.buttonCheck);
        tvShow = findViewById(R.id.textView);

        cbEnabled.setChecked(true);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MyActivity", "Inside onClick()");
                String checkResponse;
                Toast buttonClicked = Toast.makeText(MainActivity.this, "Button Clicked", Toast.LENGTH_LONG);

                if (cbEnabled.isChecked()) {
                    double pay = calcPay(100,20);
                    checkResponse = "The discount is given. You need to pay $" + pay;
                } else {
                    double pay = calcPay(100,0);
                    checkResponse = "The discount is not given. You need to pay $" + pay;
                }

                tvShow.setText(checkResponse);
                buttonClicked.show();
            }
        });


    }

}