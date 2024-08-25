package com.example.megagram_app.retrofit;

import com.example.megagram_app.model.LoaiSpModel;
import com.example.megagram_app.model.SanPhamMoiModel;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface ApiBanHang {
    @GET("getloaisp.php")
    Observable<LoaiSpModel> getLoaiSp();

    @GET("getspmoi.php")
    Observable<SanPhamMoiModel> getSpMoi();
}
