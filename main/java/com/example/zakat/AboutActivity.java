package com.example.zakat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {
    TextView linkTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        linkTextView = (TextView) findViewById(R.id.textView_hyperlink);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());

    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about :
                //Toast.makeText(this, "This is about",Toast.LENGTH_LONG).show();

                Intent intent = new Intent( this, AboutActivity.class);
                startActivity(intent);

                break;

            case R.id.calculator:

                //Toast.makeText(this, "This is calculator",Toast.LENGTH_LONG).show();
                Intent intent2 = new Intent( this, MainActivity.class);
                startActivity(intent2);

                break;
        }

        return super.onOptionsItemSelected(item);
    }
}