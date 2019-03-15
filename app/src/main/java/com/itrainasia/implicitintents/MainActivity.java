package com.itrainasia.implicitintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
    EditText websiteEditText, locationEditText, quoteEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        websiteEditText = findViewById(R.id.websiteEditText);
        locationEditText = findViewById(R.id.locationEditText);
        quoteEditText = findViewById(R.id.quoteEditText);
    }

    public void openLocation(View view) {

        String loc = locationEditText.getText().toString();
        Uri addressUri = Uri.parse("geo:0,0?q="+loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
        if (intent.resolveActivity(getPackageManager() )!= null){
            startActivity(intent);
        }
        else {
            Log.d("Implicit intents","Can't handle this intent");
        }

    }

    public void openWebsite(View view) {

        String url = websiteEditText.getText().toString();
        Uri webpage  = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);


        if (intent.resolveActivity(getPackageManager() )!= null){
            startActivity(intent);
        }
        else {
            Log.d("Implicit intents","Can't handle this intent");
        }
    }

    public void shareText(View view) {

        String txt = quoteEditText.getText().toString();
        String mimeType = "text/plain";
        Log.d("debug","test is "+txt);
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share with ")
                .setText(txt)
                .startChooser();
    }
}
