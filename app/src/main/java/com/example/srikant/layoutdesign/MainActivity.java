package com.example.srikant.layoutdesign;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PostClickListeners{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<PostModel> list = new ArrayList<>();
        int i=0;
        while(i<10){
            PostModel p1 = new PostModel();
            p1.setAnsContent(getString(R.string.ansContent));
            p1.setAnsHeading(getString(R.string.ansHeading));
            p1.setAskedAnwered(getString(R.string.askedAnd));
            p1.setPersonName(getString(R.string.personName));
            p1.setPostUrl("https://google.com");
            p1.setQuestion(getString(R.string.question));
            p1.setPersonAddress(getString(R.string.address));
            list.add(p1);
            i++;
        }
        RecyclerView postRecycler = findViewById(R.id.postRecycler);
        PostAdapter postAdapter = new PostAdapter(this,list);
        postRecycler.setLayoutManager(new LinearLayoutManager(this));
        postRecycler.setAdapter(postAdapter);
    }

    @Override
    public void onAnswerClick(String postUrl) {
        Intent urlIntent = new Intent();
        urlIntent.setAction(Intent.ACTION_VIEW);
        urlIntent.setData(Uri.parse(postUrl));
        urlIntent.addCategory(Intent.CATEGORY_DEFAULT);
        urlIntent.addCategory(Intent.CATEGORY_BROWSABLE);
        startActivity(urlIntent);
    }

    @Override
    public void onProfileClick(String profileUrl) {
        ProfileFragment pf = new ProfileFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,pf).addToBackStack("Profile").commit();
    }

    @Override
    public void onAddFriendClick() {
        Toast.makeText(this,"Friend Added",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onQuestionCLick(String postUrl) {
        Intent urlIntent = new Intent();
        urlIntent.setAction(Intent.ACTION_VIEW);
        urlIntent.setData(Uri.parse(postUrl));
        urlIntent.addCategory(Intent.CATEGORY_DEFAULT);
        urlIntent.addCategory(Intent.CATEGORY_BROWSABLE);
        startActivity(urlIntent);
    }
}
