package org.bitart.projectdeeplink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class DummyActivity extends AppCompatActivity {

    //  ga0RGNYHvNM5d0SLGQfpQWAPGJ8=

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy);

        Toast.makeText(this, "Dummy is here", Toast.LENGTH_SHORT).show();
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, DummyActivity.class);
    }
}
