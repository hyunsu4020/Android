package com.example.ex4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

// 도서 수정
public class SubActivity2 extends AppCompatActivity {
    private int index;
    private Shoes shoes;
    EditText et1, et2, et3, et4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);

        TextView tv1 = (TextView)findViewById(R.id.textView1);
        tv1.setText("도서정보 수정");

        Intent intent = getIntent();
        index = intent.getIntExtra("index", -1);

        if (index != -1) {
            shoes = (Shoes)intent.getSerializableExtra("shoes");
        }

        et1 = findViewById(R.id.editText1);
        et1.setText(shoes.getName());

        et2 = findViewById(R.id.editText1);
        et2.setText(shoes.getPrice());

        et3 = findViewById(R.id.editText1);
        et3.setText(shoes.getBrand());

        et4 = findViewById(R.id.editText1);
        et4.setText(shoes.getDate());

    }

    public void onButton1Click(View view) { // 수정 버튼
        shoes.setName(et1.getText().toString());
        shoes.setPrice(et2.getText().toString());
        shoes.setBrand(et3.getText().toString());
        shoes.setDate(et4.getText().toString());

        Intent data = new Intent(SubActivity2.this, MainActivity.class);
        data.putExtra("index", index);
        data.putExtra("shoes", shoes);

        setResult(RESULT_OK, data);
        finish();
    }

    public void onButton2Click(View view) { finish(); }
}