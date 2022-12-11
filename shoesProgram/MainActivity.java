package com.example.ex4;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Shoes> items;
    ShoesAdapter adapter;
    String name, price, brand, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. 집합 데이터 ArrayList의 공간 확보
        items = new ArrayList<>();
        items.add(new Shoes("덩크 로우 레트로 블랙", "129000원", "나이키", "2021-12-20"));

        // 2. Adapter생성
        adapter = new ShoesAdapter(this, R.layout.item_layout1, items);

        // 3. AdapterView(ListView)에 Adapter 등록
        ListView lv1 = findViewById(R.id.ListView1);
        lv1.setAdapter(adapter);

        // 4. ItemClick, ItemLongClick 메소드 구현
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, SubActivity2.class);
                intent.putExtra("index", position);
                intent.putExtra("shoes", items.get(position));

                mResult2.launch(intent);    // 도서 수정 Activity로 이동
            }
        });

        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                items.remove(position);
                adapter.notifyDataSetChanged();

                return false;
            }
        });

    }

    ActivityResultLauncher<Intent> mResult1 = registerForActivityResult(    // 도서등록 콜백함수
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    Intent intent = result.getData();

                    name = intent.getStringExtra("name");
                    price = intent.getStringExtra("price");
                    brand = intent.getStringExtra("brand");
                    date = intent.getStringExtra("date");

                    items.add(new Shoes(name, price, brand, date));
                    adapter.notifyDataSetChanged();
                }
            }
    );
    //------------------------------------------------------------------------

    ActivityResultLauncher<Intent> mResult2 = registerForActivityResult(    // 도서수정 콜백함수
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    Intent intent = result.getData();

                    name = intent.getStringExtra("name");
                    price = intent.getStringExtra("price");
                    brand = intent.getStringExtra("brand");
                    date = intent.getStringExtra("date");

                    int index = intent.getIntExtra("index", -1);

                    if (index >= 0) {
                        Shoes Shoes = (Shoes)intent.getSerializableExtra("Shoes");
                        Shoes item = items.get(index);
                        
                        item.setName(Shoes.getName()); // 가져와서 다시 설정하는 작업
                        item.setPrice(Shoes.getPrice());
                        item.setBrand(Shoes.getBrand());
                        item.setDate(Shoes.getDate());

                        adapter.notifyDataSetChanged();
                    }
                }
            }
    );

    public void onButton1Click(View view) { // 추가 버튼
        Intent intent = new Intent(MainActivity.this, SubActivity1.class);
        mResult1.launch(intent);

//        items.add(new Shoes("무명", "무명", "무명", "2022-01-01"));
//        adapter.notifyDataSetChanged();
    }

    public void onButton4Click(View view) { // 신발 쇼핑 버튼
        Intent intent = new Intent(MainActivity.this, WepActivity.class);
        startActivity(intent);
    }
}