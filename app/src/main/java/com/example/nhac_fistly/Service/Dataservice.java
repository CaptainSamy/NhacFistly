package com.example.nhac_fistly.Service;

import com.example.nhac_fistly.Model.Album;
import com.example.nhac_fistly.Model.Baihat;
import com.example.nhac_fistly.Model.Chude;
import com.example.nhac_fistly.Model.Playlist;
import com.example.nhac_fistly.Model.Quangcao;
import com.example.nhac_fistly.Model.Theloai;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Dataservice {
    @GET("Quangcao_Get.php")
    Call<List<Quangcao>> GetDataBanner();

    @GET("Playlist_Get.php")
    Call<List<Playlist>> GetPlaylist();

    @GET("Theloai_Get.php")
    Call<List<Theloai>> GetTheloai();

    @GET("Chude_Get.php")
    Call<List<Chude>> GetChude();

    @GET("Album_Get.php")
    Call<List<Album>> GetAlbum();

    @GET("Baihat_Get.php")
    Call<List<Baihat>> GetBaihat();

}
