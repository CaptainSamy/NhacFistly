package com.example.nhac_fistly.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Album implements Serializable {

@SerializedName("id")
@Expose
private String id;
@SerializedName("TenAlbum")
@Expose
private String tenAlbum;
@SerializedName("TenCaSiAlbum")
@Expose
private String tenCaSiAlbum;
@SerializedName("HinhAlbum")
@Expose
private String hinhAlbum;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getTenAlbum() {
return tenAlbum;
}

public void setTenAlbum(String tenAlbum) {
this.tenAlbum = tenAlbum;
}

public String getTenCaSiAlbum() {
return tenCaSiAlbum;
}

public void setTenCaSiAlbum(String tenCaSiAlbum) {
this.tenCaSiAlbum = tenCaSiAlbum;
}

public String getHinhAlbum() {
return hinhAlbum;
}

public void setHinhAlbum(String hinhAlbum) {
this.hinhAlbum = hinhAlbum;
}

}