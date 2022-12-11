package com.example.ex4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ShoesAdapter extends BaseAdapter { // 추상메소드를 구현해야함.
    // layout을 처리해주는 layout인플레이터(inflater) 기능이 필요함.
    // 이 기능을 사용하려면 application의 context가 필요함.
    Context context;
    int itemlayout;
    ArrayList<Shoes> items;

    // 생성자
    public ShoesAdapter(Context context, int itemlayout, ArrayList<Shoes> items) {
        this.context = context;
        this.itemlayout = itemlayout;
        this.items = items;
    }

    // 추상 메소드 4개 구현
    @Override
    public int getCount() { // ListView가 출력한 item의 갯수를 돌려줌
        return items.size();    // 담겨있는 갯수를 계산해서 가져옴
    }

    @Override
    public Object getItem(int position) {  // 현재 선택한 항목의 행(index)에 해당하는 내용 가져옴
        return items.get(position);
    }

    @Override
    public long getItemId(int position) { // 항목(item)간에 고유한 값을 넘김, position을 넘겨주는 것이 간단한 방법임.
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) { // getView는 하나의 item에 대한 view입니다.
        if (convertView == null) {  // 처음 출력할때에는 convertView가 생성이 안되어 있으므로 만들어 줘야함.
            // 시스템서비스 종류가 많아서 (LayoutInflater)로 타입 캐스팅해서 사용함.
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(itemlayout, null);
        }

        Shoes Shoes = items.get(position);

        TextView tv1 = (TextView) convertView.findViewById(R.id.textViewitem1);
        tv1.setText(Shoes.getName());

        TextView tv2 = (TextView) convertView.findViewById(R.id.textViewitem2);
        tv2.setText(Shoes.getPrice());

        TextView tv3 = (TextView) convertView.findViewById(R.id.textViewitem3);
        tv3.setText(Shoes.getBrand());

        TextView tv4 = (TextView) convertView.findViewById(R.id.textViewitem4);
        tv4.setText(Shoes.getDate());


        return convertView;
    }
}
