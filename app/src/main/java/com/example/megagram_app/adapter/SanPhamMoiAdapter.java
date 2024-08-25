package com.example.megagram_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.megagram_app.R;
import com.example.megagram_app.model.SanPhamMoi;

import java.text.DecimalFormat;
import java.time.temporal.Temporal;
import java.util.List;

public class SanPhamMoiAdapter extends RecyclerView.Adapter<SanPhamMoiAdapter.MyViewHolder> {
    Context context;
    List<SanPhamMoi> array;

    public SanPhamMoiAdapter(Context context, List<SanPhamMoi> array) {
        this.context = context;
        this.array = array;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sp_moi,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SanPhamMoi sanPhamMoi= array.get(position);
        holder.txtten.setText(sanPhamMoi.getTensp());
        // Gía
//        DecimalFormat decimalFormat= new DecimalFormat("###,###,###");
//        holder.txtgia.setText("Giá: "+decimalFormat.format(Double.parseDouble(sanPhamMoi.getGiasp()))+"Đ");
        holder.txtgia.setText(sanPhamMoi.getGiasp());
        Glide.with(context)
                .load(sanPhamMoi.getHinhanh()) // sanPhamMoi.getHinhanh() nên trả về một URL hoặc đường dẫn hình ảnh hợp lệ
                .into(holder.imghinhanh); // Đây là chỗ bạn sử dụng 'into' để đặt hình ảnh vào ImageView



    }

    @Override
    public int getItemCount() {
        return array.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtgia,txtten;
        ImageView imghinhanh;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtgia=itemView.findViewById(R.id.itemsp_gia);
            txtten=itemView.findViewById(R.id.itemsp_ten);
            imghinhanh=itemView.findViewById(R.id.itemsp_image);

        }
    }
}
