package com.example.kapis.gpa_calculator_kapish;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText gpa1;
    EditText gpa2;
    EditText gpa3;
    EditText gpa4;
    EditText gpa5;
    Button calc;
    TextView result;
    int res;
    boolean counter;
    ConstraintLayout screen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calc = (Button)findViewById(R.id.button);
        gpa1 = (EditText)findViewById(R.id.editText1);
        gpa2 = (EditText)findViewById(R.id.editText2);
        gpa3 = (EditText)findViewById(R.id.editText3);
        gpa4 = (EditText)findViewById(R.id.editText4);
        gpa5 = (EditText)findViewById(R.id.editText5);
        result = (TextView)findViewById(R.id.textView7);
        screen = (ConstraintLayout) findViewById(R.id.layout);
    }

    public void calculate(final View view) {
        counter = false;
        String gpa1num = gpa1.getText().toString();
        String gpa2num = gpa2.getText().toString();
        String gpa3num = gpa3.getText().toString();
        String gpa4num = gpa4.getText().toString();
        String gpa5num = gpa5.getText().toString();

        if (gpa1num.isEmpty() || gpa2num.isEmpty() || gpa3num.isEmpty() || gpa4num.isEmpty() || gpa5num.isEmpty()) {
            if (gpa1num.isEmpty()) {
                gpa1.setBackgroundColor(getResources().getColor(R.color.error));
            }
            if (gpa2num.isEmpty()) {
                gpa2.setBackgroundColor(getResources().getColor(R.color.error));
            }
            if (gpa3num.isEmpty()) {
                gpa3.setBackgroundColor(getResources().getColor(R.color.error));
            }
            if (gpa4num.isEmpty()) {
                gpa4.setBackgroundColor(getResources().getColor(R.color.error));
            }
            if (gpa5num.isEmpty()) {
                gpa5.setBackgroundColor(getResources().getColor(R.color.error));
            }

            result.setText("Please enter a number in the fields provided");
        }

        else {
            gpa1.setBackgroundColor(getResources().getColor(R.color.clear));
            gpa2.setBackgroundColor(getResources().getColor(R.color.clear));
            gpa3.setBackgroundColor(getResources().getColor(R.color.clear));
            gpa4.setBackgroundColor(getResources().getColor(R.color.clear));
            gpa5.setBackgroundColor(getResources().getColor(R.color.clear));
            res = (Integer.parseInt(gpa1num) + Integer.parseInt(gpa2num) +
                    Integer.parseInt(gpa3num) + Integer.parseInt(gpa4num) + Integer.parseInt(gpa5num)) / 5;

            if (res < 60) {
                screen.setBackgroundColor(getResources().getColor(R.color.lowGPA));
            }
            if (res < 79 && res > 61) {
                screen.setBackgroundColor(getResources().getColor(R.color.midGPA));
            }
            if (res > 80 && res < 100) {
                screen.setBackgroundColor(getResources().getColor(R.color.highGPA));
            }
            result.setText("Your Average GPA is " + Integer.toString(res));

            calc.setText("Clear Form");

            calc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gpa1.setText("");
                    gpa2.setText("");
                    gpa3.setText("");
                    gpa4.setText("");
                    gpa5.setText("");
                    result.setText("");
                    screen.setBackgroundColor(getResources().getColor(R.color.clear));

                    counter = true;
                    if (counter = true) {
                        calc.setText("Calculate GPA");
                        calc.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                calculate(v);
                            }
                        });
                    }
                }
            });
        }
    }
}
