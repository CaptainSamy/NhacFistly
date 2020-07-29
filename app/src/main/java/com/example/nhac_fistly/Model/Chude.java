package com.example.nhac_fistly.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Chude implements Serializable {

@SerializedName("id")
@Expose
private String id;
@SerializedName("TenChuDe")
@Expose
private String tenChuDe;
@SerializedName("HinhChuDe")
@Expose
private String hinhChuDe;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getTenChuDe() {
return tenChuDe;
}

public void setTenChuDe(String tenChuDe) {
this.tenChuDe = tenChuDe;
}

public String getHinhChuDe() {
return hinhChuDe;
}

public void setHinhChuDe(String hinhChuDe) {
this.hinhChuDe = hinhChuDe;
}

}