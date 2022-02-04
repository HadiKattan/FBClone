package com.example.customadapter_miniproject;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class UserAdapter extends ArrayAdapter<User> {
    private Context context;
    private int res;
    private ArrayList<User> users;

    public UserAdapter(@NonNull Context context, int res, @NonNull ArrayList<User> users) {
        super(context, res, users);
        this.context = context;
        this.res = res;
        this.users=users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = LayoutInflater.from(context).inflate(res,parent,false);
        TextView name = row.findViewById(R.id.userName);
        TextView post = row.findViewById(R.id.userPost);
        ImageView imageView = row.findViewById(R.id.uploadedImage);
        User user = users.get(position);
        name.setText(user.getName());
        if(user.getImage()!=null){
            post.setVisibility(View.GONE);
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageURI(user.getImage());
        }
        else {
            imageView.setVisibility(View.GONE);
            post.setVisibility(View.VISIBLE);
            post.setText(user.getText());
        }
        return row;
    }
}
