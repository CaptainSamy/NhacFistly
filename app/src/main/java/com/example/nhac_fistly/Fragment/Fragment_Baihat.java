package com.example.nhac_fistly.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nhac_fistly.Adapter.BaihatAdapter;
import com.example.nhac_fistly.Model.Baihat;
import com.example.nhac_fistly.R;
import com.example.nhac_fistly.Service.APIService;
import com.example.nhac_fistly.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Baihat extends Fragment {
    View view;
    RecyclerView recyclerViewbaihat;
    BaihatAdapter baihatAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_baihat, container, false);
        recyclerViewbaihat = view.findViewById(R.id.recyclerviewbaihat);
        GetData();
        return view;
    }

    private void GetData() {
        final ProgressDialog loading = new ProgressDialog(getActivity());
        loading.setMessage("Đang tải...");
        loading.show();
        Dataservice dataservice = APIService.getService();
        Call<List<Baihat>> callback = dataservice.GetBaihat();
        callback.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                ArrayList<Baihat> baihatArrayList = (ArrayList<Baihat>) response.body();
                baihatAdapter = new BaihatAdapter(getActivity(), baihatArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewbaihat.setLayoutManager(linearLayoutManager);
                recyclerViewbaihat.setAdapter(baihatAdapter);
                loading.dismiss();
            }

            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {
                Toast.makeText(getActivity(), "Không có mạng!",Toast.LENGTH_LONG).show();
                call.cancel();
            }
        });
    }
}
