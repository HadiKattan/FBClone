package com.example.customadapter_miniproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView userListView;
    private ArrayList<User> users;
    private UserAdapter adapter;
    private Button textPost,imagePost;
    private static final int TEXT_POST_REQ_CODE = 1;
    private static final int REQ_IMAGE_CAPTURE = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        userListView = (ListView) findViewById(R.id.userListView);
        users = new ArrayList<>();
        textPost = (Button) findViewById(R.id.uploadPost);
        imagePost = (Button) findViewById(R.id.uploadImage);
        textPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this,UploadPostActivity.class),TEXT_POST_REQ_CODE);
            }
        });
        imagePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                i.setType("image/*");
                startActivityForResult(i,REQ_IMAGE_CAPTURE);
            }
        });
        adapter = new UserAdapter(this,R.layout.user_row,users);
        userListView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==TEXT_POST_REQ_CODE && resultCode==RESULT_OK){
            String text = data.getStringExtra(UploadPostActivity.EXTRA_TEXT);
            users.add(new User("Hadi",text));
            Toast.makeText(this, "Uploaded", Toast.LENGTH_SHORT).show();
            adapter.setUsers(users);
            adapter.notifyDataSetChanged();
        }
        else if(requestCode==REQ_IMAGE_CAPTURE && resultCode==RESULT_OK){
            Uri selectedImage = data.getData();
            Log.d("TAG",selectedImage.toString());
            Toast.makeText(this, "Uploaded", Toast.LENGTH_SHORT).show();
            users.add(new User("Hadi",selectedImage));
            adapter.setUsers(users);
            adapter.notifyDataSetChanged();
        }
    }
}