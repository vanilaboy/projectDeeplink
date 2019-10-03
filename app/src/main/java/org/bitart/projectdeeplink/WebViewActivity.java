package org.bitart.projectdeeplink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebViewActivity extends AppCompatActivity {

    private static final String URI_FROM_DEEPLINK = "uri_from_deeplink";

    private WebView mWebView;
    private String mUrl = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);


        try {
            mUrl = getIntent().getStringExtra(URI_FROM_DEEPLINK);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "getStringExtra() fail", Toast.LENGTH_SHORT).show();
            startActivity(DummyActivity.newIntent(this));
            finish();
        }


        mWebView = findViewById(R.id.webView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });



        if(mUrl != null)
            mWebView.loadUrl(mUrl);
    }

    public static Intent newIntent(Context context, String uri) {
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra(URI_FROM_DEEPLINK, uri);
        return intent;
    }
}
