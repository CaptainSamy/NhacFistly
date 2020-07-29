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

import com.example.nhac_fistly.Adapter.TatCaTheloaiAdapter;
import com.example.nhac_fistly.Adapter.TheloaiAdapter;
import com.example.nhac_fistly.Model.Theloai;
import com.example.nhac_fistly.R;
import com.example.nhac_fistly.Service.APIService;
import com.example.nhac_fistly.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachtatcatheloaiActivity extends AppCompatActivity {
    Toolbar toolbartheloaitheochude;
    RecyclerView recyclerViewTatCatheloai;
    TatCaTheloaiAdapter tatCaTheloaiAdapter;
    private static final int NUM_COLUMNS = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachtheloaitheochude);
        init();
        GetData();
    }

    private void GetData() {
        final ProgressDialog loading = new ProgressDialog(DanhsachtatcatheloaiActivity.this);
        loading.setMessage("Đang tải...");
        loading.show();
        Dataservice dataservice = APIService.getService();
        Call<List<Theloai>> callback = dataservice.GetTheloai();
        callback.enqueue(new Callback<List<Theloai>>() {
            @Override
            public void onResponse(Call<List<Theloai>> call, Response<List<Theloai>> response) {
                ArrayList<Theloai> theloaiArrayList = (ArrayList<Theloai>) response.body();
                tatCaTheloaiAdapter = new TatCaTheloaiAdapter(DanhsachtatcatheloaiActivity.this, theloaiArrayList);
                StaggeredGridLayoutManager staggeredGridLayoutManager = new
                        StaggeredGridLayoutManager(NUM_COLUMNS,LinearLayoutManager.VERTICAL);
                recyclerViewTatCatheloai.setLayoutManager(staggeredGridLayoutManager);
                recyclerViewTatCatheloai.setAdapter(tatCaTheloaiAdapter);
                loading.dismiss();
            }

            @Override
            public void onFailure(Call<List<Theloai>> call, Throwable t) {
                Toast.makeText(DanhsachtatcatheloaiActivity.this, "Không có mạng!",Toast.LENGTH_LONG).show();
                call.cancel();
            }
        });
    }

    private void init() {
        toolbartheloaitheochude = findViewById(R.id.toolbartheloaitheochude);
        recyclerViewTatCatheloai = findViewById(R.id.recyclerviewtheloaitheochude);
        setSupportActionBar(toolbartheloaitheochude);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tất Cả Thể Loại");
        toolbartheloaitheochude.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
