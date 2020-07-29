package com.example.nhac_fistly.Fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nhac_fistly.Activity.DanhsachbaihatActivity;
import com.example.nhac_fistly.Activity.MainActivity;
import com.example.nhac_fistly.Adapter.BaihatAdapterQC;
import com.example.nhac_fistly.Adapter.SearchBaiHatAdapter;
import com.example.nhac_fistly.Model.Baihat;
import com.example.nhac_fistly.R;
import com.example.nhac_fistly.Service.APIService;
import com.example.nhac_fistly.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Fragment_Tim_Kiem extends Fragment {
    View view;
    RecyclerView recyclerViewsearchbaihat;
    TextView txtkhongcodulieu;
    EditText edtSearchbaihat;
    ImageButton imgbtnSearchbaihat;
    SearchBaiHatAdapter searchBaiHatAdapter;
    ArrayList<Baihat> mangbaihat;
    String txtTim;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tim_kiem, container, false);
        recyclerViewsearchbaihat = view.findViewById(R.id.recyclerviewsearchbaihat);
        txtkhongcodulieu = view.findViewById(R.id.textviewkhongcodulieu);
        edtSearchbaihat = view.findViewById(R.id.edittextSearchbaihat);
        imgbtnSearchbaihat = view.findViewById(R.id.imagebuttonSearchbaihat);
        imgbtnSearchbaihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtTim = edtSearchbaihat.getText().toString();

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
        Call<List<Baihat>> callback = dataservice.GetBaihat();
        callback.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                mangbaihat = (ArrayList<Baihat>) response.body();
                searchBaiHatAdapter = new SearchBaiHatAdapter(getActivity(), mangbaihat);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewsearchbaihat.setLayoutManager(linearLayoutManager);
                recyclerViewsearchbaihat.setAdapter(searchBaiHatAdapter);
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
