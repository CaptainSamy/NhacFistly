package com.example.nhac_fistly.Activity;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.nhac_fistly.Adapter.BaihatAdapterQC;
import com.example.nhac_fistly.Model.Album;
import com.example.nhac_fistly.Model.Baihat;
import com.example.nhac_fistly.Model.Chude;
import com.example.nhac_fistly.Model.Playlist;
import com.example.nhac_fistly.Model.Quangcao;
import com.example.nhac_fistly.Model.Theloai;
import com.example.nhac_fistly.R;
import com.example.nhac_fistly.Service.APIService;
import com.example.nhac_fistly.Service.Dataservice;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachbaihatActivity extends AppCompatActivity {
    CoordinatorLayout coordinatorLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    RecyclerView recyclerViewdanhsachbaihat;
    FloatingActionButton floatingActionButton;
    Quangcao quangcao;
    Playlist playlist;
    Chude chude;
    Album album;
    Theloai theloai;
    ImageView imgdanhsachcakhuc;
    ArrayList<Baihat> mangbaihat;
    BaihatAdapterQC baihatAdapterQC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachbaihat);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        DataIntent();
        AnhXa();
        inits();
        if (quangcao != null && !quangcao.getTenBaiHat().equals("")) {
            setValueInView(quangcao.getTenBaiHat(), quangcao.getHinhanhQuangCao());
            GetData();
        }
        if (playlist != null && !playlist.getTenPlayList().equals("")){
            setValueInView(playlist.getTenPlayList(), playlist.getHinhNenPlayList());
            GetData();
        }
        if (album != null && !album.getTenAlbum().equals("")){
            setValueInView(album.getTenAlbum(), album.getHinhAlbum());
            GetData();
        }
        if (chude != null && !chude.getTenChuDe().equals("")){
            setValueInView(chude.getTenChuDe(), chude.getHinhChuDe());
            GetData();
        }
        if (theloai != null && !theloai.getThenTheLoai().equals("")){
            setValueInView(theloai.getThenTheLoai(), theloai.getHinhTheLoai());
            GetData();
        }
    }
    private void setValueInView(String ten , String hinh) {
        collapsingToolbarLayout.setTitle(ten);
        try {
            URL url = new URL(hinh);
            Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(),bitmap);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                collapsingToolbarLayout.setBackground(bitmapDrawable);
            }
        }catch (MalformedURLException e){
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        Picasso.with(this).load(hinh).into(imgdanhsachcakhuc);
    }
    private void GetData() {
        final ProgressDialog loading = new ProgressDialog(DanhsachbaihatActivity.this);
        loading.setMessage("Đang tải...");
        loading.show();
        Dataservice dataservice = APIService.getService();
        Call<List<Baihat>> callback = dataservice.GetBaihat();
        callback.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                mangbaihat = (ArrayList<Baihat>) response.body();
                baihatAdapterQC = new BaihatAdapterQC(DanhsachbaihatActivity.this, mangbaihat);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(DanhsachbaihatActivity.this);
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewdanhsachbaihat.setLayoutManager(linearLayoutManager);
                recyclerViewdanhsachbaihat.setAdapter(baihatAdapterQC);
                eventClick();
                loading.dismiss();
            }

            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {
                Toast.makeText(DanhsachbaihatActivity.this, "Không có mạng!",Toast.LENGTH_LONG).show();
                call.cancel();
            }
        });

    }
    private void inits() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        floatingActionButton.setEnabled(false);
    }

    private void AnhXa() {
        coordinatorLayout = findViewById(R.id.coordinatorlayout);
        collapsingToolbarLayout = findViewById(R.id.collapsingtoobar);
        toolbar = findViewById(R.id.toolbardanhsachbaihat);
        recyclerViewdanhsachbaihat = findViewById(R.id.recyclerviewdanhsachbaihat);
        floatingActionButton = findViewById(R.id.floatingactionbutton);
        imgdanhsachcakhuc = findViewById(R.id.imageviewdanhsachcakhuc);
    }

    private void DataIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("banner")) {
                quangcao = (Quangcao) intent.getSerializableExtra("banner");
            }
            if (intent.hasExtra("itemplaylist")){
                playlist = (Playlist) intent.getSerializableExtra("itemplaylist");
            }
            if (intent.hasExtra("itemalbum")){
                album = (Album) intent.getSerializableExtra("itemalbum");
            }
            if (intent.hasExtra("itemchude")){
                chude = (Chude) intent.getSerializableExtra("itemchude");
            }
            if (intent.hasExtra("itemtheloai")){
                theloai = (Theloai) intent.getSerializableExtra("itemtheloai");
            }
        }
    }

    private void eventClick(){
        floatingActionButton.setEnabled(true);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DanhsachbaihatActivity.this, PlayNhacActivity.class);
                intent.putExtra("cacbaihat", mangbaihat);
                startActivity(intent);
            }
        });
    }
}
