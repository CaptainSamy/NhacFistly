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

import com.example.nhac_fistly.Adapter.ChudeAdapter;
import com.example.nhac_fistly.Adapter.TatCaChudeAdapter;
import com.example.nhac_fistly.Model.Chude;
import com.example.nhac_fistly.R;
import com.example.nhac_fistly.Service.APIService;
import com.example.nhac_fistly.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachtatcachudeActivity extends AppCompatActivity {
    Toolbar toolbartatcachude;
    RecyclerView recyclerViewtatcachude;
    TatCaChudeAdapter tatCaChudeAdapter;
    private static final int NUM_COLUMNS = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachtatcachude);
        init();
        GetData();
    }

    private void GetData() {
        final ProgressDialog loading = new ProgressDialog(DanhsachtatcachudeActivity.this);
        loading.setMessage("Đang tải...");
        loading.show();
        Dataservice dataservice = APIService.getService();
        Call<List<Chude>> callback = dataservice.GetChude();
        callback.enqueue(new Callback<List<Chude>>() {
            @Override
            public void onResponse(Call<List<Chude>> call, Response<List<Chude>> response) {
                ArrayList<Chude> chudeArrayList = (ArrayList<Chude>) response.body();
                tatCaChudeAdapter = new TatCaChudeAdapter(DanhsachtatcachudeActivity.this, chudeArrayList);
                StaggeredGridLayoutManager staggeredGridLayoutManager = new
                        StaggeredGridLayoutManager(NUM_COLUMNS,LinearLayoutManager.VERTICAL);
                recyclerViewtatcachude.setLayoutManager(staggeredGridLayoutManager);
                recyclerViewtatcachude.setAdapter(tatCaChudeAdapter);
                loading.dismiss();
            }

            @Override
            public void onFailure(Call<List<Chude>> call, Throwable t) {
                Toast.makeText(DanhsachtatcachudeActivity.this, "Không có mạng!",Toast.LENGTH_LONG).show();
                call.cancel();
            }
        });
    }

    private void init() {
        toolbartatcachude = findViewById(R.id.toolbarallchude);
        recyclerViewtatcachude = findViewById(R.id.recyclerviewAllChude);

        setSupportActionBar(toolbartatcachude);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tất Cả Chủ Đề");
        toolbartatcachude.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
