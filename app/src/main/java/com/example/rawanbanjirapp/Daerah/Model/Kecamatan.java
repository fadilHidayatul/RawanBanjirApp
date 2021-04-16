package com.example.rawanbanjirapp.Daerah.Model;

import java.util.List;

public class Kecamatan {

    /**
     * success : 1
     * status : 200
     * message : Data Ada
     * DATA : [{"id_kecamatan":"1","nama_kecamatan":"Bungus Teluk Kabung"},{"id_kecamatan":"2","nama_kecamatan":"Koto Tangah"},{"id_kecamatan":"3","nama_kecamatan":"Kuranji"},{"id_kecamatan":"4","nama_kecamatan":"Lubuk Begalung"},{"id_kecamatan":"5","nama_kecamatan":"Nanggalo"},{"id_kecamatan":"6","nama_kecamatan":"Padamg Barat"},{"id_kecamatan":"7","nama_kecamatan":"Padang Selatan"},{"id_kecamatan":"8","nama_kecamatan":"Padang Timur"},{"id_kecamatan":"9","nama_kecamatan":"Padang Utara"},{"id_kecamatan":"10","nama_kecamatan":"Pauh"}]
     */

    private int success;
    private int status;
    private String message;
    private List<DATABean> DATA;

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DATABean> getDATA() {
        return DATA;
    }

    public void setDATA(List<DATABean> DATA) {
        this.DATA = DATA;
    }

    public static class DATABean {
        /**
         * id_kecamatan : 1
         * nama_kecamatan : Bungus Teluk Kabung
         */

        private String id_kecamatan;
        private String nama_kecamatan;

        public String getId_kecamatan() {
            return id_kecamatan;
        }

        public void setId_kecamatan(String id_kecamatan) {
            this.id_kecamatan = id_kecamatan;
        }

        public String getNama_kecamatan() {
            return nama_kecamatan;
        }

        public void setNama_kecamatan(String nama_kecamatan) {
            this.nama_kecamatan = nama_kecamatan;
        }
    }
}
