package com.example.megagram_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.megagram_app.R;
import com.example.megagram_app.model.LoaiSp;

import java.util.List;

public class LoaiSpAdapter extends BaseAdapter {

    List<LoaiSp> array;
    Context context;

    public LoaiSpAdapter(Context context, List<LoaiSp> array) {
        this.array = array;
        this.context = context;
    }

    @Override
    public int getCount() {
        return array.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    public class ViewHolder{
        TextView texttensp;
        ImageView imghinhanh;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.item_sanpham, viewGroup, false);
            viewHolder.texttensp = view.findViewById(R.id.item_tensp);
            viewHolder.imghinhanh = view.findViewById(R.id.item_img);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        // Bind data to ViewHolder
        LoaiSp loaiSp = array.get(i);
        viewHolder.texttensp.setText(loaiSp.getTensanpham());

        // Use Glide to load the image
        Glide.with(context)
                .load(loaiSp.getHinhanh())
                .into(viewHolder.imghinhanh);

        return view;
    }
}
