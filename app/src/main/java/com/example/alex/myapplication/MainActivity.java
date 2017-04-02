package com.example.alex.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity {
    @BindView(R.id.image) protected ImageView imageView;
    @BindView(R.id.text) protected EditText editText;
    @BindView(R.id.button) protected Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Glide.with(this).load("http://goo.gl/gEgYUd").placeholder(R.mipmap.ic_launcher).into(imageView);
        final String defaultLink = "https://www.google.com/search?q=";
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String page = editText.getText().toString();
                if(!TextUtils.isEmpty(page)){
                    Uri uri = Uri.parse(defaultLink+"/"+page);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Please enter page on editText!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
