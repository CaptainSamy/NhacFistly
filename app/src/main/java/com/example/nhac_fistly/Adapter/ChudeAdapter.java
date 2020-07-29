package com.example.nhac_fistly.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nhac_fistly.Activity.DanhsachbaihatActivity;
import com.example.nhac_fistly.Model.Chude;
import com.example.nhac_fistly.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ChudeAdapter extends RecyclerView.Adapter<ChudeAdapter.ViewHolder> {
    Context context;
    ArrayList<Chude> mangChuDe;

    public ChudeAdapter(Context context, ArrayList<Chude> mangChuDe) {
        this.context = context;
        this.mangChuDe = mangChuDe;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_chude, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Chude chude = mangChuDe.get(position);
        holder.txtTenChuDe.setText(chude.getTenChuDe());
        Picasso.with(context).load(chude.getHinhChuDe()).into(holder.imgHinhChuDe);
    }

    @Override
    public int getItemCount() {
        return mangChuDe.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgHinhChuDe;
        TextView txtTenChuDe;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHinhChuDe = itemView.findViewById(R.id.imageviewchude);
            txtTenChuDe = itemView.findViewById(R.id.textviewtenchude);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DanhsachbaihatActivity.class);
                    intent.putExtra("itemchude", mangChuDe.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
