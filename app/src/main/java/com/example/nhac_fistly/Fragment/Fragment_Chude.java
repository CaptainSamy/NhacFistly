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

import com.example.nhac_fistly.Activity.DanhsachtatcachudeActivity;
import com.example.nhac_fistly.Adapter.ChudeAdapter;
import com.example.nhac_fistly.Model.Chude;
import com.example.nhac_fistly.R;
import com.example.nhac_fistly.Service.APIService;
import com.example.nhac_fistly.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Chude extends Fragment {
    View view;
    RecyclerView recyclerViewChuDe;
    ChudeAdapter chudeAdapter;
    TextView txtxemthemChuDe;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chude, container, false);
        recyclerViewChuDe = view.findViewById(R.id.recyclerviewChude);
        txtxemthemChuDe = view.findViewById(R.id.textviewxemthemchude);
        txtxemthemChuDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DanhsachtatcachudeActivity.class);
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
        Call<List<Chude>> callback = dataservice.GetChude();
        callback.enqueue(new Callback<List<Chude>>() {
            @Override
            public void onResponse(Call<List<Chude>> call, Response<List<Chude>> response) {
                ArrayList<Chude> chudeArrayList = (ArrayList<Chude>) response.body();
                chudeAdapter = new ChudeAdapter(getActivity(), chudeArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerViewChuDe.setLayoutManager(linearLayoutManager);
                recyclerViewChuDe.setAdapter(chudeAdapter);
                loading.dismiss();
            }

            @Override
            public void onFailure(Call<List<Chude>> call, Throwable t) {
                Toast.makeText(getActivity(), "Không có mạng!",Toast.LENGTH_LONG).show();
                call.cancel();
            }
        });
    }
}
