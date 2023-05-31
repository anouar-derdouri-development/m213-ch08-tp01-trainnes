package com.anouarderdouri.m213_ch08_tp01.ex03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.anouarderdouri.m213_ch08_tp01.R;

public class OpenLinkActivity extends AppCompatActivity {
    EditText etEx02Link;
    Button btnEx02Open;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_link);

        etEx02Link = findViewById(R.id.etEx02Link);
        btnEx02Open = findViewById(R.id.btnEx02Open);

        btnEx02Open.setOnClickListener(v -> {
            addPrefix();
            openWebPage(etEx02Link.getText().toString());
        });
    }

    private void addPrefix() {
        String link = etEx02Link.getText().toString();
        if (link.startsWith("https://www")) {

        } else if (link.startsWith("www"))
            etEx02Link.setText(String.format("https://%s", link));
        else
            etEx02Link.setText(String.format("https://www.%s", link));
    }

    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            /*
                ! In order to use resolveActivity, i have to add <queries> tag in AndroidManifest.xml
                ! https://stackoverflow.com/questions/62535856/intent-resolveactivity-returns-null-in-api-30

                ! https://developer.android.com/training/package-visibility/use-cases

                ! https://medium.com/androiddevelopers/package-visibility-in-android-11-cc857f221cd9
             */
            startActivity(intent);
        } else {
            Toast.makeText(this, "There no app that can open the link !!!", Toast.LENGTH_SHORT).show();
        }
    }
}