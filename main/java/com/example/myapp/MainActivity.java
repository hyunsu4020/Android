package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText et1;
    CheckBox cb1, cb2, cb3;
    ImageView img, img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.editText1);
        RadioGroup rg1 = findViewById(R.id.radioGroup);

        img = (ImageView)findViewById((R.id.imageView));
        img2 = (ImageView)findViewById((R.id.imageView2));

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton:
                        et1.setText("햄버거");
                        img2.setImageResource(R.drawable.food1);
                        break;
                    case R.id.radioButton2:
                        et1.setText("스파게티");
                        img2.setImageResource(R.drawable.food2);
                        break;
                    case R.id.radioButton3:
                        et1.setText("피자");
                        img2.setImageResource(R.drawable.food3);
                        break;
                }
                cb1 = findViewById(R.id.checkBox);
                cb2 = findViewById(R.id.checkBox2);
                cb3 = findViewById(R.id.checkBox3);

                cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        if (isChecked) {
                            img.setImageResource(R.drawable.drink1);
                        } else
                            img.setImageResource(R.drawable.blank);
                    }
                });

                cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        if (isChecked) {
                            img.setImageResource(R.drawable.drink2);
                        } else
                            img.setImageResource(R.drawable.blank);
                    }
                });

                cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        if (isChecked) {
                            img.setImageResource(R.drawable.drink3);
                        } else
                            img.setImageResource(R.drawable.blank);
                    }
                });
            }
        });
    }
}