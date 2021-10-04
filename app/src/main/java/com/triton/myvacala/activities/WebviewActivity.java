package com.triton.myvacala.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.triton.myvacala.R;
import com.wang.avi.AVLoadingIndicatorView;

import butterknife.BindView;

public class WebviewActivity extends AppCompatActivity implements View.OnClickListener {

    private String TAG = "WebviewActivity";

    ImageView imgBack;

    TextView toolbar_title;

    WebView wv_terms;

    String url = "https://www.google.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        Log.w(TAG,"onCreate");

        toolbar_title=findViewById(R.id.toolbar_title);

        imgBack=findViewById(R.id.imgBack);

        wv_terms=findViewById(R.id.wv_terms);

       toolbar_title.setText(getResources().getString(R.string.termsalone));

        loadurl(url);

        imgBack.setOnClickListener(this);

    }

    public void loadurl(String urlParams)
    {

        wv_terms.setWebViewClient(new MyWebViewClient());

        wv_terms.getSettings().setJavaScriptEnabled(true);

        wv_terms.loadUrl(urlParams); // load a web page in a web view


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.imgBack:
                onBackPressed();
                break;
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }



    private static class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }


}