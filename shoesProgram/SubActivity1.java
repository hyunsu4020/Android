package com.example.ex4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

// 도서 등록
public class SubActivity1 extends AppCompatActivity {
    EditText et1, et2, et3, et4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);

        TextView tv1 = (TextView)findViewById(R.id.textView1);
        tv1.setText("신발구매 내역 등록");

        et1 = findViewById(R.id.editText1);
        et2 = findViewById(R.id.editText2);
        et3 = findViewById(R.id.editText3);
        et4 = findViewById(R.id.editText4);
    }

    public void onButton1Click(View view) { // 등록 버튼
        String name = et1.getText().toString();
        String price = et2.getText().toString();
        String brand = et3.getText().toString();
        String date = et4.getText().toString();

        Intent data = new Intent();
        data.putExtra("name", name);
        data.putExtra("price", price);
        data.putExtra("brand", brand);
        data.putExtra("date", date);

        setResult(RESULT_OK, data);
        finish();
    }

    public void onButton2Click(View view) { // 취소 버튼
        finish();
    }
}