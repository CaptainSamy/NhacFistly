package com.example.nhac_fistly.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Quangcao implements Serializable {
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("idbaiHat")
        @Expose
        private String idbaiHat;
        @SerializedName("TenBaiHat")
        @Expose
        private String tenBaiHat;
        @SerializedName("HinhBaiHat")
        @Expose
        private String hinhBaiHat;
        @SerializedName("NoiDungQuangCao")
        @Expose
        private String noiDungQuangCao;
        @SerializedName("HinhanhQuangCao")
        @Expose
        private String hinhanhQuangCao;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIdbaiHat() {
            return idbaiHat;
        }

        public void setIdbaiHat(String idbaiHat) {
            this.idbaiHat = idbaiHat;
        }

        public String getTenBaiHat() {
            return tenBaiHat;
        }

        public void setTenBaiHat(String tenBaiHat) {
            this.tenBaiHat = tenBaiHat;
        }

        public String getHinhBaiHat() {
            return hinhBaiHat;
        }

        public void setHinhBaiHat(String hinhBaiHat) {
            this.hinhBaiHat = hinhBaiHat;
        }

        public String getNoiDungQuangCao() {
            return noiDungQuangCao;
        }

        public void setNoiDungQuangCao(String noiDungQuangCao) {
            this.noiDungQuangCao = noiDungQuangCao;
        }

        public String getHinhanhQuangCao() {
            return hinhanhQuangCao;
        }

        public void setHinhanhQuangCao(String hinhanhQuangCao) {
            this.hinhanhQuangCao = hinhanhQuangCao;
        }

    }