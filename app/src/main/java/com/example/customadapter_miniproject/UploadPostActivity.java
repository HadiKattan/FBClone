package com.example.customadapter_miniproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class UploadPostActivity extends AppCompatActivity {
    public static final String EXTRA_TEXT = "EXTRA_TEXT";
    private EditText postText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_post);
        postText = (EditText) findViewById(R.id.textPost);;
        getSupportActionBar().setTitle("Upload Post");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.post_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.uploadOption)
        {
            Intent i = new Intent();
            i.putExtra(EXTRA_TEXT,postText.getText().toString());
            setResult(RESULT_OK,i);
            finish();
            return true;
        }
        return false;
    }
}