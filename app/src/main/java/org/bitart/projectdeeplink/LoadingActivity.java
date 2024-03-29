package org.bitart.projectdeeplink;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.facebook.FacebookSdk;

import bolts.AppLinks;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FacebookSdk.sdkInitialize(this);


        Uri targetUri = AppLinks.getTargetUrlFromInboundIntent(this, getIntent());


        if (targetUri != null) {
            try {
                String urlFromDeeplink = targetUri.toString().split("!")[1];
                startActivity(WebViewActivity.newIntent(this, urlFromDeeplink));
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "Parse error", Toast.LENGTH_SHORT).show();
                startActivity(DummyActivity.newIntent(this));
            }
        } else {
            startActivity(DummyActivity.newIntent(this));
        }

    }
}
