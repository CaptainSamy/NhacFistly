package com.example.nhac_fistly.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.nhac_fistly.R;

import java.util.ArrayList;


public class Fragment_Thong_Tin_App extends Fragment {
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_thong_tin_app,container,false);
        ListView listView = view.findViewById(R.id.listviewGioithieu);
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("Tên ứng dụng : Nhạc_Fistly");
        stringArrayList.add("Phiên bản: 1.0.0");
        stringArrayList.add("Nhóm viết: NHÓM 1");
        stringArrayList.add("Năm: 2020");
        stringArrayList.add("Nghành học: MOB");
        stringArrayList.add("Khóa học: 14251");
        stringArrayList.add("Môn học: Quản lý dự án với phần mềm Agile");
        stringArrayList.add("Trường: FPT PolyHN");

        final ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, stringArrayList);
        listView.setAdapter(adapter);
        return view;
    }
}
