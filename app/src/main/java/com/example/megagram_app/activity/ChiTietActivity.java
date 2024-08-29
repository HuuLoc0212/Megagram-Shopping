package com.example.megagram_app.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.megagram_app.R;
import com.example.megagram_app.model.SanPhamMoi;

import java.text.DecimalFormat;

public class ChiTietActivity extends AppCompatActivity {

    TextView tensp, giasp, mota;
    Button btnThem;
    ImageView imghinhanh;
    Spinner spinner;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chi_tiet);
        initview();
        ActionToolbar();
        initData();
    }

    private void initData() {
        SanPhamMoi sanPhamMoi = (SanPhamMoi) getIntent().getSerializableExtra("chitiet");
        tensp.setText(sanPhamMoi.getTensp());
        mota.setText(sanPhamMoi.getMota());
        Glide.with(getApplicationContext()).load(sanPhamMoi.getHinhanh()).into(imghinhanh);

        // Xử lý chuỗi giá trước khi chuyển đổi
        String giaspString = sanPhamMoi.getGiasp();
        if (giaspString != null) {
            giaspString = giaspString.replace(",", "").replace(" ", "").replace("Đ", "");
            if (giaspString.matches("[0-9]+(\\.[0-9]*)?")) {
                double gia = Double.parseDouble(giaspString);
                DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                giasp.setText("Giá: " + decimalFormat.format(gia) + "Đ");
            } else {
                giasp.setText("Giá: không hợp lệ");
            }
        } else {
            giasp.setText("Giá: không có");
        }
        // Chọn số spinner
        Integer[] so = new Integer[]{1,2,3,4,5};
        ArrayAdapter<Integer> adapterspin = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,so);
        spinner.setAdapter(adapterspin);
    }


    private void initview() {
        tensp=findViewById(R.id.txtTensp);
        giasp=findViewById(R.id.txtGiasp);
        mota=findViewById(R.id.txtmotachitiet);
        spinner = findViewById(R.id.spinner);
        imghinhanh=findViewById(R.id.imgchitiet);
        toolbar=findViewById(R.id.toolbar);
    }
    private void ActionToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}