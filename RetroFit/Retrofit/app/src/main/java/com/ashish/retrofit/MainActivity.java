package com.ashish.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.shape.OffsetEdgeTreatment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView mrv_posts;
    ProgressBar mpbar;
    LinearLayoutManager linearLayoutManager;
    PostAdaptor postAdaptor;
    List<Posts> postsList = new ArrayList<Posts>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mrv_posts = findViewById(R.id.rv_posts);
        mpbar = findViewById(R.id.pbar);
        linearLayoutManager = new LinearLayoutManager(this);
        mrv_posts.setLayoutManager(linearLayoutManager);
        postAdaptor = new PostAdaptor(postsList);
        mrv_posts.setAdapter(postAdaptor);
        
        fetchPosts();
    }

    private void fetchPosts() {
        mpbar.setVisibility(View.VISIBLE);
        RetrofitClient.getRetrofitClient().getPosts().enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                if(response.isSuccessful() && response.body() != null)
                {
                    postsList.addAll(response.body());
                    postAdaptor.notifyDataSetChanged();
                    mpbar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                mpbar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this,"Error: " + t.getMessage(),  Toast.LENGTH_LONG).show();
            }
        });
    }


}