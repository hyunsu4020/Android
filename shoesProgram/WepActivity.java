package com.example.ex4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class WepActivity extends AppCompatActivity {
    WebView wb;
    EditText et5;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wep);

        wb = (WebView) findViewById(R.id.wepView1);
        et5 = (EditText) findViewById(R.id.editText5);
    }

    public void onButton5Click(View view) { // Search버튼
        url = et5.getText().toString();

        wb.setWebViewClient(new WebViewClient());   //새창 띄우지 않기 설정
        wb.setWebChromeClient(new WebChromeClient());
        wb.setDownloadListener(new DownloadListener() { // 파일 다운로드 설정
            @Override
            public void onDownloadStart(String s, String s1, String s2, String s3, long l) {
            }
        });

        //webView 화면 크기에 맞추도록 설정
        wb.getSettings().setLoadWithOverviewMode(true);

        // wide viewport 설정
        wb.getSettings().setJavaScriptEnabled(true);

        wb.getSettings().setSupportZoom(false); // 줌 설정 여부
        wb.getSettings().setBuiltInZoomControls(false); // 줌 확대/축소 버튼 여부
        wb.getSettings().setJavaScriptEnabled(true); //자바스크립트 사용여부

        wb.loadUrl("https://" + url);
    }

    public void onButton6Click(View view) {
        wb.goBack();
    }

    public void onButton7Click(View view) {
        wb.loadUrl("https://www.kream.co.kr/");
    }

    public void onButton8Click(View view) {
        wb.goForward();
    }

    public void onButton9Click(View view) { // 구매 내역으로 돌아가기 버튼
        Intent intent = new Intent(WepActivity.this, MainActivity.class);
        startActivity(intent);
    }
}