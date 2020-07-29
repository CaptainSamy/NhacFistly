package com.example.nhac_fistly.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.nhac_fistly.Adapter.AlbumAdapter;
import com.example.nhac_fistly.Adapter.TatCaAlbumAdapter;
import com.example.nhac_fistly.Model.Album;
import com.example.nhac_fistly.R;
import com.example.nhac_fistly.Service.APIService;
import com.example.nhac_fistly.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachtatcaAlbumActivity extends AppCompatActivity {
    Toolbar toolbaralbum;
    RecyclerView recyclerViewAllalbum;
    TatCaAlbumAdapter tatCaAlbumAdapter;
    private static final int NUM_COLUMNS = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachtatca_album);
        init();
        GetData();
    }

    private void GetData() {
        final ProgressDialog loading = new ProgressDialog(DanhsachtatcaAlbumActivity.this);
        loading.setMessage("Đang tải...");
        loading.show();
        Dataservice dataservice = APIService.getService();
        Call<List<Album>> callback = dataservice.GetAlbum();
        callback.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                ArrayList<Album> albumArrayList = (ArrayList<Album>) response.body();
                tatCaAlbumAdapter = new TatCaAlbumAdapter(DanhsachtatcaAlbumActivity.this, albumArrayList);
                StaggeredGridLayoutManager staggeredGridLayoutManager = new
                        StaggeredGridLayoutManager(NUM_COLUMNS,LinearLayoutManager.VERTICAL);
                recyclerViewAllalbum.setLayoutManager(staggeredGridLayoutManager);
                recyclerViewAllalbum.setAdapter(tatCaAlbumAdapter);
                loading.dismiss();
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {
                Toast.makeText(DanhsachtatcaAlbumActivity.this, "Không có mạng!",Toast.LENGTH_LONG).show();
                call.cancel();
            }
        });
    }

    private void init() {
        toolbaralbum = findViewById(R.id.toolbaralbum);
        recyclerViewAllalbum = findViewById(R.id.recyclerviewAllalbum);
        setSupportActionBar(toolbaralbum);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tất cả Album");
        toolbaralbum.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
