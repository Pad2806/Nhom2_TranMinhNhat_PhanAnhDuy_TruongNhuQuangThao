package com.ktck124.lop124LTDD04.nhom2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class AuthorAdapter extends RecyclerView.Adapter<AuthorAdapter.TacGiaViewHolder> {
    private List<TacGia> tacGiaList;
//    public AuthorAdapter(FragmentManager supportFragmentManager, Lifecycle lifecycle) {
//        this.tacGiaList = tacGiaList != null ? tacGiaList : new ArrayList<>();
//    }
    public AuthorAdapter(List<TacGia> tacGiaList) {
        this.tacGiaList = tacGiaList;
    }
    @NonNull
    @Override
    public TacGiaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_author, parent, false);
        return new TacGiaViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull TacGiaViewHolder holder, int position) {
        TacGia tacGia = tacGiaList.get(position);
        Log.d("AuthorAdapter", "Hình ảnh: " + tacGia.getHinhAnh());
        Log.d("AuthorAdapter", "Tên tác giả: " + tacGia.getTenTacGia());
        Log.d("AuthorAdapter", "Số tác phẩm: " + tacGia.getSoLuongTP());
        String imageUrl = tacGia.getHinhAnh();
        if (imageUrl != null) {
            imageUrl = imageUrl.replace("https://drive.google.com/file/d/", "https://drive.google.com/uc?export=view&id=");
            Glide.with(holder.itemView.getContext()).load(imageUrl).into(holder.anhTG);
        } else holder.anhTG.setImageResource(R.drawable.img);
        holder.tenTG.setText(tacGia.getTenTacGia());
        holder.slTP.setText(tacGia.getSoLuongTP());
    }
    @Override
    public int getItemCount() {return tacGiaList.size();}
    public static class TacGiaViewHolder extends RecyclerView.ViewHolder {
        TextView tenTG, slTP;
        ImageView anhTG;
        public TacGiaViewHolder(View itemView) {
            super(itemView);
            tenTG = itemView.findViewById(R.id.tenTacGia);
            slTP = itemView.findViewById(R.id.soTacPham);
            anhTG = itemView.findViewById(R.id.hinhAnh);
        }
    }
}