package com.example.nhac_fistly.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Playlist implements Serializable {

@SerializedName("id")
@Expose
private String id;
@SerializedName("TenPlayList")
@Expose
private String tenPlayList;
@SerializedName("HinhNenPlayList")
@Expose
private String hinhNenPlayList;
@SerializedName("InconPlayList")
@Expose
private String inconPlayList;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getTenPlayList() {
return tenPlayList;
}

public void setTenPlayList(String tenPlayList) {
this.tenPlayList = tenPlayList;
}

public String getHinhNenPlayList() {
return hinhNenPlayList;
}

public void setHinhNenPlayList(String hinhNenPlayList) {
this.hinhNenPlayList = hinhNenPlayList;
}

public String getInconPlayList() {
return inconPlayList;
}

public void setInconPlayList(String inconPlayList) {
this.inconPlayList = inconPlayList;
}

}