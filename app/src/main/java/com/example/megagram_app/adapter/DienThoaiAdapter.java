package com.example.megagram_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.megagram_app.R;
import com.example.megagram_app.model.SanPhamMoi;

import java.util.List;

public class DienThoaiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
   Context context;
   List<SanPhamMoi> array;




   private static final int VIEW_TYPE_DATA =0;
   private static final int VIEW_TYPE_LOADING =1;

    public DienThoaiAdapter(Context context, List<SanPhamMoi> array) {
        this.context = context;
        this.array = array;
    }





    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_DATA){
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dienthoai,parent,false);
            return new MyViewHolder(view);
        }else{
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loading,parent,false);
            return new LoadingViewHolder(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        // Neu nhu mang nay get vi tri nao do bang Null thi se xuat ra loai LOADING va nguoc lai la loai DATA
        return array.get(position) == null ? VIEW_TYPE_LOADING:VIEW_TYPE_DATA;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder){
            MyViewHolder myViewHolder =(MyViewHolder) holder;
            SanPhamMoi sanPham= array.get(position);
            myViewHolder.tensp.setText(sanPham.getTensp());
            // Gía
//        DecimalFormat decimalFormat= new DecimalFormat("###,###,###");
//        myViewHolder.giasp.setText("Giá: "+decimalFormat.format(Double.parseDouble(sanPham.getGiasp()))+"Đ");
            myViewHolder.idsp.setText(sanPham.getId()+" ");
            myViewHolder.mota.setText(sanPham.getMota());
            Glide.with(context).load(sanPham.getHinhanh()).into(myViewHolder.hinhanh);
        }else {
            LoadingViewHolder loadingViewHolder = (LoadingViewHolder) holder;
            loadingViewHolder.progressBar.setIndeterminate(true);
        }

    }

    @Override
    public int getItemCount() {
        return array.size();
    }
    // Neu data null thi doan code nay
    public class LoadingViewHolder extends RecyclerView.ViewHolder{
        ProgressBar progressBar;

        public LoadingViewHolder(@NonNull View itemView) {
            super(itemView);
            progressBar=itemView.findViewById(R.id.progressbar);
        }
    }
    // neu du lieu co data thi add nay len de hien thi data
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tensp, giasp, mota,idsp;
        ImageView hinhanh;
            public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tensp=itemView.findViewById(R.id.itemdt_ten);
            giasp=itemView.findViewById(R.id.itemdt_gia);
            mota=itemView.findViewById(R.id.itemdt_mota);
            hinhanh=itemView.findViewById(R.id.itemdt_image);
            idsp=itemView.findViewById(R.id.itemdt_idsp);
        }
    }
}
