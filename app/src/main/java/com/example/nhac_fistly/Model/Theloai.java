package com.example.nhac_fistly.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Theloai implements Serializable {

@SerializedName("id")
@Expose
private String id;
@SerializedName("idChude")
@Expose
private String idChude;
@SerializedName("ThenTheLoai")
@Expose
private String thenTheLoai;
@SerializedName("HinhTheLoai")
@Expose
private String hinhTheLoai;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getIdChude() {
return idChude;
}

public void setIdChude(String idChude) {
this.idChude = idChude;
}

public String getThenTheLoai() {
return thenTheLoai;
}

public void setThenTheLoai(String thenTheLoai) {
this.thenTheLoai = thenTheLoai;
}

public String getHinhTheLoai() {
return hinhTheLoai;
}

public void setHinhTheLoai(String hinhTheLoai) {
this.hinhTheLoai = hinhTheLoai;
}

}