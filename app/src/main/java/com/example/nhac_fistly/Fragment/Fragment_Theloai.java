package com.example.nhac_fistly.Fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.nhac_fistly.Activity.DanhsachtatcatheloaiActivity;
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

public class Fragment_Theloai extends Fragment {
    View view;
    RecyclerView recyclerViewTheLoai;
    TheloaiAdapter theloaiAdapter;
    TextView txtxemthemTheLoai;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_theloai, container, false);
        recyclerViewTheLoai = view.findViewById(R.id.recyclerviewTheloai);
        txtxemthemTheLoai = view.findViewById(R.id.textviewxemthemtheloai);
        txtxemthemTheLoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DanhsachtatcatheloaiActivity.class);
                startActivity(intent);
            }
        });
        GetData();
        return view;
    }

    private void GetData() {
        final ProgressDialog loading = new ProgressDialog(getActivity());
        loading.setMessage("Đang tải...");
        loading.show();
        Dataservice dataservice = APIService.getService();
        Call<List<Theloai>> callback = dataservice.GetTheloai();
        callback.enqueue(new Callback<List<Theloai>>() {
            @Override
            public void onResponse(Call<List<Theloai>> call, Response<List<Theloai>> response) {
                ArrayList<Theloai> theloaiArrayList = (ArrayList<Theloai>) response.body();
                theloaiAdapter = new TheloaiAdapter(getActivity(), theloaiArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerViewTheLoai.setLayoutManager(linearLayoutManager);
                recyclerViewTheLoai.setAdapter(theloaiAdapter);
                loading.dismiss();
            }

            @Override
            public void onFailure(Call<List<Theloai>> call, Throwable t) {
                Toast.makeText(getActivity(), "Không có mạng!",Toast.LENGTH_LONG).show();
                call.cancel();
            }
        });
    }
}
